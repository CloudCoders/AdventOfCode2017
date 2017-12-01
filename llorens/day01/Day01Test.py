import unittest
import day01.Day01Solver as solver
import AoCReader


class TestDay01(unittest.TestCase):

    def test_solver_part_1(self):
        self.assertEqual(solver.solve_part1("1122"), 3)
        self.assertEqual(solver.solve_part1("1111"), 4)
        self.assertEqual(solver.solve_part1("1234"), 0)
        self.assertEqual(solver.solve_part1("91212129"), 9)
        self.assertEqual(solver.solve_part1(AoCReader.get_input("01")), 1175)

    def test_solver_part_2(self):
        self.assertEqual(solver.solve_part2("1212"), 6)
        self.assertEqual(solver.solve_part2("1221"), 0)
        self.assertEqual(solver.solve_part2("123425"), 4)
        self.assertEqual(solver.solve_part2("123123"), 12)
        self.assertEqual(solver.solve_part2("12131415"), 4)
        self.assertEqual(solver.solve_part2(AoCReader.get_input("01")), 1166)




if __name__ == "__main__":
    unittest.main()
