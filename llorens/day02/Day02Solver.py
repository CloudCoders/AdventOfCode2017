import re


def clean_sequence(sequence):
    return re.sub("\t", " ", sequence)


def solve_part_1(sequence):

    sequence = clean_sequence(sequence)
    count = 0

    for line in sequence.splitlines():
        number_list = line.split()
        number_list = [x for x in map(int, number_list)]
        min_number = number_list[0]
        max_number = number_list[0]
        for i in range(1, len(number_list)):
            if number_list[i] < min_number:
                min_number = number_list[i]
            elif number_list[i] > max_number:
                max_number = number_list[i]

        count += max_number-min_number

    return count


def solve_part_2(sequence):

    sequence = clean_sequence(sequence)
    count = 0

    for line in sequence.splitlines():

        numbers_list = line.strip().split(" ")
        numbers_list = [x for x in map(int, numbers_list)]

        for number in numbers_list:
            for number2 in numbers_list:
                if number != number2 and number2 % number == 0:
                    count += number2/number
                    break

    return count
