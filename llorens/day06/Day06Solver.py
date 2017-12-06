def solve_part_1(sequence):

    sequence = sequence.split("\t")
    historic = [sequence[:]]
    block_redistribution = 0
    sequence_size = len(sequence)

    for i in range(sequence_size):
        sequence[i] = int(sequence[i])


    while True:


        maximum = -1
        index = -1
        for i in range(sequence_size):
            if sequence[i] > maximum:
                maximum = sequence[i]
                index = i

        sequence[index] = 0

        increase = int(maximum/sequence_size)
        res = maximum % sequence_size

        for i in range(1, sequence_size+1):
            if i <= res:
                sequence[(index + i) % sequence_size] += increase + 1
            else:
                sequence[(index + i) % sequence_size] += increase

        if sequence in historic:
            return len(historic)
        else:
            historic.append(sequence[:])

def solve_part_2(sequence):

    sequence = sequence.split("\t")
    historic = [sequence[:]]
    block_redistribution = 0
    sequence_size = len(sequence)

    for i in range(sequence_size):
        sequence[i] = int(sequence[i])


    while True:


        maximum = -1
        index = -1
        for i in range(sequence_size):
            if sequence[i] > maximum:
                maximum = sequence[i]
                index = i

        sequence[index] = 0

        increase = int(maximum/sequence_size)
        res = maximum % sequence_size

        for i in range(1, sequence_size+1):
            if i <= res:
                sequence[(index + i) % sequence_size] += increase + 1
            else:
                sequence[(index + i) % sequence_size] += increase

        if sequence in historic:
            return len(historic) - historic.index(sequence)
        else:
            historic.append(sequence[:])