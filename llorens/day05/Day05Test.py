import AoCReader as Reader
import unittest
import day05.Day05Solver as Solver


class TestDay05(unittest.TestCase):

    def test_part_1(self):

        self.assertEqual(Solver.solve_part_1("0\n3\n0\n1\n-3"), 5, "AoC base example test")
        self.assertEqual(Solver.solve_part_1(Reader.get_input("05")), 396086, "Day 05 imput test")

    def test_part2(self):
        self.assertEqual(Solver.solve_part_2_2("0\n3\n0\n1\n-3"), 10, "AoC base example test")
        self.assertEqual(Solver.solve_part_2_2(Reader.get_input("05")), 28675390, "Day 05 input test")


if __name__ == "__main__":
    unittest.main()