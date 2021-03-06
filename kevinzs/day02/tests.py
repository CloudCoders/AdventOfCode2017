import day02
import unittest

def getInput(file):
    input = open(file)
    lines = input.readlines()
    for i in range(len(lines)):
        lines[i] = list(lines[i].strip().split())
    input.close()
    return lines

class Day02Tests(unittest.TestCase):

    def test_part_one(self):
        self.assertEqual(day02.solver(getInput("example.txt")), 18)
        self.assertEqual(day02.solver(getInput("input.txt")), 32020)

    def test_part_two(self):
        self.assertEqual(day02.solver2(getInput("example2.txt")), 9)
        self.assertEqual(day02.solver2(getInput("input.txt")), 236)

if __name__ == '__main__':
    unittest.main()