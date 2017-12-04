from functools import reduce

def solve_part1(sequence):

    return reduce(lambda count, a: count+a, (int(sequence[i]) for i in range(len(sequence)) if sequence[i] == sequence[(i+1) % len(sequence)]), 0)


def solve_part2(sequence):

    return sum(int(sequence[i]) for i in range(int(len(sequence)/2)) if sequence[i] == sequence[(i+int(len(sequence)/2))])*2


