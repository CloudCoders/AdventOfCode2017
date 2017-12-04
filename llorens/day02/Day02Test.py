import unittest
import day02.Day02Solver as Solver
import AoCReader as Reader


class TestDay02(unittest.TestCase):

    def test_part_1(self):
        self.assertEqual(Solver.solve_part_1("5 1 9 5"), 8, "Single row test 1")
        self.assertEqual(Solver.solve_part_1("5 1 9 5 \n 7 5 3\n 2 4 6 8"), 18, "Multiple row test 1")
        self.assertEqual(Solver.solve_part_1(Reader.get_input("02")), 45351, "Part 1 of day 02 of AoC")

    def test_part_2(self):
        self.assertEqual(Solver.solve_part_2("5 9 2 8"), 4, "Single row test 1")
        self.assertEqual(Solver.solve_part_2("9 4 7 3"), 3, "Single row test 2")
        self.assertEqual(Solver.solve_part_2("3 8 6 5"), 2, "Single row test 3")
        self.assertEqual(Solver.solve_part_2("5 9 2 8 \n9 4 7 3 \n3 8 6 5"), 9, "Multiple row test 1")
        self.assertEqual(Solver.solve_part_2(Reader.get_input("02")), 275, "Part 2 of day 02 of AoC")


if __name__ == "__main__":
    unittest.main()
