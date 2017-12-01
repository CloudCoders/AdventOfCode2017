def solve_part1(sequence):

    return sum(int(sequence[i]) for i in range(len(sequence)) if sequence[i] == sequence[(i+1) % len(sequence)])


def solve_part2(sequence):

    return sum(int(sequence[i]) for i in range(len(sequence)) if sequence[i] == sequence[(i+int(len(sequence)/2)) %\
                                                                                         len(sequence)])


