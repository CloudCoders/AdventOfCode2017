import AoCReader as Reader
import unittest
import day06.Day06Solver as Solver


class TestDay06(unittest.TestCase):

    def test_part_1(self):
        self.assertEqual(Solver.solve_part_1("0\t2\t7\t0"), 5, "AoC example test")
        self.assertEqual(Solver.solve_part_1(Reader.get_input("06")), 11137, "AoC Input test")


    def test_part_2(self):
        self.assertEqual(Solver.solve_part_2("0\t2\t7\t0"), 4, "AoC example test")
        self.assertEqual(Solver.solve_part_2(Reader.get_input("06")), 1037, "AoC Input test")

if __name__ == "__main__":
    unittest.main()