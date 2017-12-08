import re
from collections import defaultdict
import math

def solve_part_1(raw_input):
    lines = raw_input.splitlines()
    state = defaultdict(lambda: 0)

    for line in lines:
        parse = re.search("^([a-z]+) (inc|dec) (-\d+|\d+) if ([a-z]+) ([!<>=]+) (-\d+|\d+)",line)
        var = parse.group(1)
        op = parse.group(2)
        num = int(parse.group(3))
        var_conditional = parse.group(4)
        op_condition = parse.group(5)
        num_conditional = int(parse.group(6))

        condition = False

        if op_condition == ">":
            if state[var_conditional] > num_conditional:
                condition = True

        elif op_condition == "<":
            if state[var_conditional] < num_conditional:
                condition = True

        elif op_condition == "==":
            if state[var_conditional] == num_conditional:
                condition = True

        elif op_condition == ">=":
            if state[var_conditional] >= num_conditional:
                condition = True

        elif op_condition == "<=":
            if state[var_conditional] <= num_conditional:
                condition = True

        else:
            if state[var_conditional] != num_conditional:
                condition = True

        if condition:
            if op == "inc":
                state[var] += num
            else:
                state[var] -= num

    maximum = -math.inf

    for value in state.values():
        if value > maximum:
            maximum = value

    return maximum



def solve_part_2(raw_input):
    lines = raw_input.splitlines()
    state = defaultdict(lambda: 0)
    maximum = 0

    for line in lines:
        parse = re.search("^([a-z]+) (inc|dec) (-\d+|\d+) if ([a-z]+) ([!<>=]+) (-\d+|\d+)",line)
        var = parse.group(1)
        op = parse.group(2)
        num = int(parse.group(3))
        var_conditional = parse.group(4)
        op_condition = parse.group(5)
        num_conditional = int(parse.group(6))

        condition = False

        if op_condition == ">":
            if state[var_conditional] > num_conditional:
                condition = True

        elif op_condition == "<":
            if state[var_conditional] < num_conditional:
                condition = True

        elif op_condition == "==":
            if state[var_conditional] == num_conditional:
                condition = True

        elif op_condition == ">=":
            if state[var_conditional] >= num_conditional:
                condition = True

        elif op_condition == "<=":
            if state[var_conditional] <= num_conditional:
                condition = True

        else:
            if state[var_conditional] != num_conditional:
                condition = True

        if condition:
            if op == "inc":
                state[var] += num
                if state[var] > maximum:
                    maximum = state[var]
            else:
                state[var] -= num
                if state[var] > maximum:
                    maximum = state[var]

    return maximum