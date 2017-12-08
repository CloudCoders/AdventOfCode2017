import unittest
import day08.Day08Solver as Solver
import AoCReader as Reader


class TestDay08(unittest.TestCase):

    def test_part_01(self):
        self.assertEqual(Solver.solve_part_1(Reader.get_input("08", True)), 1, "AoC example test")
        self.assertEqual(Solver.solve_part_1(Reader.get_input("08")), 4647, "AoC input test")

    def test_part_02(self):
        self.assertEqual(Solver.solve_part_2(Reader.get_input("08", True)), 10, "AoC example test")
        self.assertEqual(Solver.solve_part_2(Reader.get_input("08")), 5590, "AoC input test")
if __name__ == "__main__":
    unittest.main()