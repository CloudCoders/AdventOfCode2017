import DataStructures.Graphs.DirectedGraph as Graph
import re


def solve_part_01(raw_input):

    lines = raw_input.splitlines()
    graph = Graph.DirectedGraph()

    for line in lines:
        graph.add_vertex(line.split(" ")[0])

    for line in lines:
        words = line.split(" ")
        origin = words[0]

        for i in range(3, len(words)-1):
            destination = words[i][:-1]
            graph.add_edge(origin, destination)

        if len(words) > 2:
            graph.add_edge(origin, words[len(words)-1])

    for vertex in graph.get_vertices():
        n_inward = len(graph.get_inwards_vertices(vertex))
        if n_inward == 0:
            return vertex

    return -1


def solve_part_02(raw_input):

    lines = raw_input.splitlines()
    graph = Graph.DirectedGraph()
    weights = dict()
    unbalanced_towers = []

    for line in lines:
        words = line.split(" ")
        vertex = words[0]
        weight = words[1][1:-1]
        graph.add_vertex(vertex)
        weights[vertex] = int(weight)

    for line in lines:
        words = line.split(" ")
        origin = words[0]

        for i in range(3, len(words)-1):
            destination = words[i][:-1]
            graph.add_edge(origin, destination)

        if len(words) > 2:
            graph.add_edge(origin, words[len(words)-1])

    for line in lines:
        words = line.split(" ")
        sub_towers_weights = []
        if len(words) > 2:
            for i in range(3, len(words) - 1):
                destination = words[i][:-1]
                sub_towers_weights.append(get_weight(graph, destination, weights))

            destination = words[len(words)-1]
            sub_towers_weights.append(get_weight(graph, destination, weights))

        if len(set(sub_towers_weights)) > 1:
            unbalanced_towers.append((sub_towers_weights, line))

    for unbalanced_tower in unbalanced_towers:
        wrong_disk = True
        words = unbalanced_tower[1].split(" ")

        for i in range(3, len(words) - 1):
            destination = words[i][:-1]
            for unbalanced_tower_2 in unbalanced_towers:
                if destination == unbalanced_tower_2[1].split(" ")[0]:
                    wrong_disk = False
                    break

        destination = words[len(words) - 1]
        for unbalanced_tower_2 in unbalanced_towers:
            if destination == unbalanced_tower_2[1].split(" ")[0]:
                wrong_disk = False
                break

        if wrong_disk:
            unbalanced_weights = unbalanced_tower[0]
            different_weights = list(set(unbalanced_weights))
            elem1 = different_weights[0]
            elem2 = different_weights[1]
            count_elem1 = 0
            count_elem2 = 0

            for elem in unbalanced_weights:
                if elem == elem1:
                    count_elem1 += 1
                else:
                    count_elem2 += 1

            if count_elem1 == 1:
                index = unbalanced_weights.index(elem1)
                diference = elem2 - elem1
            else:
                index = unbalanced_weights.index(elem2)
                diference = elem1 - elem2

            if index +3 < len(words)-2:
                wrong_node = words[index+3][:-1]
            else:
                wrong_node = words[index+3]
            return weights[wrong_node] + diference
    return -1


def get_weight(graph, vertex, weights):

    res = 0

    outwards_vertex = graph.get_outward_vertices(vertex)
    if len(outwards_vertex) == 0:
        return weights[vertex]
    else:
        res = weights[vertex]
        for out_vertex in outwards_vertex:
            res += int(get_weight(graph, out_vertex, weights))

    return res
