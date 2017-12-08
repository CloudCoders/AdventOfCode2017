class DirectedGraph:
    def __init__(self, vertices=set()):
        self.vertices = vertices

        self.edges = dict()
        for vertex in vertices:
            self.edges[vertex] = set()

    def get_vertices(self):
        return self.vertices

    def add_vertex(self, v):
        self.vertices.add(v)
        self.edges[v] = set()

    def get_edges(self):
        return self.edges

    def add_edge(self, v_origin, v_destination, weight=0):
        self.edges[v_origin].add((v_destination, weight))
        pass

    def get_outward_vertices(self, vi):
        res = set()
        for edge in self.edges[vi]:
            res.add(edge[0])
        return res

    def get_inwards_vertices(self, i):
        res = set()
        for vertex in self.vertices:
            for edge in self.edges[vertex]:
                if edge[0] == i:
                    res.add(vertex)
        return res
