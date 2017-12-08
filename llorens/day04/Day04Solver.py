from collections import defaultdict


def solve_part_1(raw_data):

    lines = raw_data.splitlines()
    count = 0

    for line in lines:
        in_sentence = defaultdict(lambda: False)
        valid = True
        for word in line.split(" "):
            if in_sentence[word]:
                valid = False
                break
            else:
                in_sentence[word] = True
        if valid:
            count += 1

    return count


def solve_part_2(raw_data):

    lines = raw_data.splitlines()
    count = 0

    for line in lines:
        in_sentence = defaultdict(lambda: False)
        valid = True
        for word in line.split(" "):
            word = str(sorted(word))
            if in_sentence[word]:
                valid = False
                break
            else:
                in_sentence[word] = True
        if valid:
            count += 1

    return count
