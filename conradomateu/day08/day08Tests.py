import unittest
import conradomateu.day08.day08 as solver


class MyTestCase(unittest.TestCase):

    def test_parse_operation(self):
        solver.dict["c"] = 8
        self.assertEqual(solver.parser(["c", "dec", "5"]),3)

    def test_parse_expression(self):
        solver.dict["c"] = 5
        self.assertTrue(solver.parser(["c", "==", "5"]))

    def test_parser_should_be_equals_solution(self):
        solver.dict = {}
        sol = solver.sol(['b inc 5 if a > 1', 'a inc 1 if b < 5', 'c dec -10 if a >= 1', 'c inc -20 if c == 10'])
        self.assertEqual(sol, 1)
    def test_parser_should_solve_AoC_solution(self):
        solver.dict = {}
        input = [x.replace("\n", "") for x in open("input.txt").readlines()]
        self.assertEqual(solver.sol(input),4567)



if __name__ == '__main__':
    unittest.main()
