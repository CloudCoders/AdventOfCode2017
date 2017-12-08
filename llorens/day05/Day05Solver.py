def solve_part_1(sequence):

    sequence = sequence.splitlines()

    pos = 0
    jumps = 0

    while 0 <= pos < len(sequence):
        jumps += 1
        displacement = int(sequence[pos])
        sequence[pos] = int(sequence[pos]) +1
        pos += displacement

    return jumps


def solve_part_2_1(sequence):

    sequence = sequence.splitlines()
    sequence.reverse()
    size = len(sequence)

    array = dict()
    for i in range(size):
        array[i] = int(sequence.pop())

    pos = 0
    jumps = 0

    while 0 <= pos < size:
        jumps += 1
        offset = array[pos]

        if offset >= 3:
            array[pos] = array[pos] - 1
        else:
            array[pos] = array[pos] + 1

        pos += offset

    return jumps


def solve_part_2_2(sequence):

    sequence = sequence.splitlines()
    size = len(sequence)

    for i in range(size):
        sequence[i] = int(sequence[i])

    pos = 0
    jumps = 0

    while 0 <= pos < size:
        jumps += 1
        offset = sequence[pos]

        if offset >= 3:
            sequence[pos] = sequence[pos] - 1
        else:
            sequence[pos] = sequence[pos] + 1

        pos += offset

    return jumps
