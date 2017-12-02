import AoCReader

if __name__ == "__main__":

    sequence = AoCReader.get_input("01")

    part1 = 0
    part2 = 0

    size = len(sequence)
    displacement = size/2

    for i in range(size):
        if sequence[i] == sequence[(i+1)%size]:
            part1 += int(sequence[i])

        if sequence[i] == sequence[(i+displacement)%size]:
            part2 += int(sequence[i])

    print("Solution for part 1:", part1)
    print("Solution for part 2:", part2)

