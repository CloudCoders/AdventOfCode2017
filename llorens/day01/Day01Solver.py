def solve_part1(sequence):

    part1 = 0
    size = int(len(sequence))

    for i in range(size-1):
        if sequence[i] == sequence[(i+1) % size]:
            part1 += int(sequence[i])

    if sequence[0] == sequence[-1]:
        part1 += int(sequence[0])

    return part1


def solve_part2(sequence):

    part2 = 0
    size = len(sequence)
    displacement = int(size/2)

    for i in range(displacement):
        if sequence[i] == sequence[i+displacement]:
            part2 += int(sequence[i])

    for i in range(displacement, size):
        if sequence[i] == sequence[(i+displacement) % size]:
            part2 += int(sequence[i])

    return part2

