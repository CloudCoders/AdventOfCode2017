import unittest
import day03.Day03Solver as solver


class TestDay03(unittest.TestCase):

    def test_part_01(self):

        self.assertEqual(solver.solve_part_01(1), 0, "Test 01")
        self.assertEqual(solver.solve_part_01(12), 3, "Test 02")
        self.assertEqual(solver.solve_part_01(23), 2, "Test 03")
        self.assertEqual(solver.solve_part_01(1024), 31, "Test 04")
        self.assertEqual(solver.solve_part_01(277678), 475, "Input test")

    def test_part_02(self):

        self.assertEqual(solver.solve_part_02(1), 2, "Test 01")
        self.assertEqual(solver.solve_part_02(11), 23, "Test 01")
        self.assertEqual(solver.solve_part_02(54), 57,"Test 01")
        self.assertEqual(solver.solve_part_02(277678), 279138, "Test 01")


if __name__ == "__main__":
    unittest.main()