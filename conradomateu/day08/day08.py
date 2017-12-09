import operator


def parse(op):
    dict[op[0]] = ops[op[1]](dict[op[0]], int(op[2]))


def parser(exp):
    return ops[exp[1]](dict[exp[0]], int(exp[2]))


def execute(op, exp):
    if parser(exp):
        parse(op)


def initDictVars(arr):
    vars = set([x.split(' ')[0] for x in arr])
    for var in vars:
        dict[var] = 0


def sol(input):
    initDictVars(input)
    list = [x.split(" if ") for x in input]
    l = [val for sublist in list for val in sublist]
    oddIndexes = [index for index, x in enumerate(l) if index % 2 == 1]
    for i in oddIndexes:
        execute(l[i - 1].split(" "), l[i].split(" "))
    return max(dict.values())


ops = {
    "inc": operator.add,
    "dec": operator.sub,
    ">": operator.gt,
    "<": operator.lt,
    "==": operator.eq,
    "!=": operator.ne,
    ">=": operator.ge,
    "<=": operator.le}


dict = {}
