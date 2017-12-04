def solver(input):
    res = 0
    for row in input:
        min_value = min(int(x) for x in row)
        max_value = max(int(x) for x in row)
        res += max_value - min_value
    return res

def solver2(input):
    res = 0
    for row in input:
        for x in range(len(row)):
            for y in range(x+1, len(row)):
                if int(row[x]) % int(row[y]) == 0:
                    res += int(row[x]) / int(row[y])
                    continue
                elif int(row[y]) % int(row[x]) == 0:
                    res += int(row[y]) / int(row[x])
                    continue
    return res