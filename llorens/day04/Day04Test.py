import day04.Day04Solver as Solver
import AoCReader as Reader
import unittest


class TestDay04(unittest.TestCase):

    def test_part_01(self):
        self.assertEqual(Solver.solve_part_1("aa bb cc dd ee"), 1, "Simple valid sentence test")
        self.assertEqual(Solver.solve_part_1("aa bb cc dd aa"), 0, "Simple invalid sentence test")
        self.assertEqual(Solver.solve_part_1("aa bb cc dd aaa"), 1, "Simple valid sentence test 2")
        self.assertEqual(Solver.solve_part_1("aa bb cc dd ee\naa bb cc dd aa"), 1, "Mixted sentences test")
        self.assertEqual(Solver.solve_part_1(Reader.get_input("04")), 477, "AoC input test")

    def test_part_02(self):
        self.assertEqual(Solver.solve_part_2("abcde fghij"), 1, "Simple valid sentence test")
        self.assertEqual(Solver.solve_part_2("abcde xyz ecdab"), 0, "Simple invalid sentence test")
        self.assertEqual(Solver.solve_part_2("a ab abc abd abf abj\niiii oiii ooii oooi oooo\noiii ioii iioi iiio"), 2,\
                         "Simple mexted sentences test")
        self.assertEqual(Solver.solve_part_2(Reader.get_input("04")), 167, "AoC input test")

if __name__ == "__main__":
    unittest.main()