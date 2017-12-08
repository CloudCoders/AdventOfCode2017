def get_input(day,mock = False):
    if not mock:
        return open("../day"+day+"/input.txt").read()
    else:
        return open("../day" + day + "/mock_input.txt").read()