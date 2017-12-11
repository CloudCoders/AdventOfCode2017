def is_valid_char(j, sequence):
    valid = True

    for i in range(j-1, -1, -1):
        if sequence[i] == "!":
            if valid:
                valid = False
            else:
                valid = True
        else:
            return valid


def clean_stream(sequence):

    num_valid_chars = 0
    i = 0
    while i < len(sequence):
        if sequence[i] == '<':

            j = i+1
            while j < len(sequence):
                if sequence[j] == '>' and is_valid_char(j, sequence):
                    sequence = sequence[:i] + sequence[j+1:]
                    break
                else:
                    if sequence[j] != '!' and is_valid_char(j, sequence):
                        num_valid_chars += 1
                j += 1

        i += 1

    return sequence, num_valid_chars


def assign_score(sequence, n):
    score = n

    open_brackets_count = 0
    begin_nested_brackets = -1

    for i in range(1,len(sequence)):

        if sequence[i] == '{':
            if open_brackets_count == 0:
                begin_nested_brackets = i
            open_brackets_count += 1

        if sequence[i] == '}':
            open_brackets_count -= 1
            if open_brackets_count == 0:
                score += assign_score(sequence[begin_nested_brackets: i+1], n+1)

    return score


def solve_part_01(raw_data):

    cleaned_stream = clean_stream(raw_data)[0]
    return assign_score(cleaned_stream, 1)


def solve_part_02(raw_data):

    return clean_stream(raw_data)[1]

