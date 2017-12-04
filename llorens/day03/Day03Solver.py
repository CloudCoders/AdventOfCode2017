def calculate_number(matrix_indexes, x, y):
    res = 0
    for i in range(-1, 2):
        for j in range(-1, 2):
            try:
                res += matrix_indexes[(x+i, y+j)]
            except:
                res += 0

    return  res


def solve_part_01(target_num):
    matrix = {1: (0, 0)}
    x = 0
    y = 0
    num = 1
    for i in range(1, 1000, 2):

        if num >= target_num:
            return abs(matrix[target_num][0]) + abs(matrix[target_num][1])

        for desp_x in range(1, i + 1):
            x += 1
            num += 1
            matrix[num] = (x, y)

        for desp_y in range(1, i + 1):
            y += 1
            num += 1
            matrix[num] = (x, y)

        for desp_x in range(1, i + 2):
            x -= 1
            num += 1
            matrix[num] = (x, y)

        for desp_y in range(1, i + 2):
            y -= 1
            num += 1
            matrix[num] = (x, y)


def solve_part_02(target_num):
    matrix_numbers = {1: (0, 0)}
    matrix_indexes = {(0, 0): 1}
    x = 0
    y = 0
    num = 1
    for i in range(1, 1000, 2):

        for desp_x in range(1, i + 1):
            x += 1
            num = calculate_number(matrix_indexes, x, y)
            matrix_numbers[num] = (x, y)
            matrix_indexes[(x, y)] = num

            if num > target_num:
                return num

        for desp_y in range(1, i + 1):
            y += 1
            num = calculate_number(matrix_indexes, x, y)
            matrix_numbers[num] = (x, y)
            matrix_indexes[(x, y)] = num

            if num > target_num:
                return num

        for desp_x in range(1, i + 2):
            x -= 1
            num = calculate_number(matrix_indexes, x, y)
            matrix_numbers[num] = (x, y)
            matrix_indexes[(x, y)] = num

            if num > target_num:
                return num

        for desp_y in range(1, i + 2):
            y -= 1
            num = calculate_number(matrix_indexes, x, y)
            matrix_numbers[num] = (x, y)
            matrix_indexes[(x, y)] = num

            if num > target_num:
                return num
