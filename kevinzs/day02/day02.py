def solver(input):
    res = 0
    for row in input:
        min_value = min(int(x) for x in row)
        max_value = max(int(x) for x in row)
        res += max_value - min_value
    return res