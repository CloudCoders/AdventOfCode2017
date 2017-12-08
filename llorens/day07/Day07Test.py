import AoCReader as Reader
import unittest
import day07.Day07Solver as Solver


class TestDay07(unittest.TestCase):

    # def test_part_01_example(self):
    #     self.assertEqual(Solver.solve_part_01("pbga (66)\nxhth (57)\nebii (61)\nhavc (66)\nktlj (57)\nfwft (72) -> "
    #                                           "ktlj, cntj, xhth\nqoyq (66)\npadx (45) -> pbga, havc, qoyq\ntknk (41) "
    #                                           "-> ugml, padx, fwft\njptl (61)\nugml (68) -> gyxo, ebii, jptl\ngyxo ("
    #                                           "61)\ncntj (57)"),"tknk","AoC example test")

    # def test_part_01_input(self):
    #     self.assertEqual(Solver.solve_part_01(Reader.get_input("07")), "vvsvez", "AoC input test")

    def test_part_02_input(self):
        self.assertEqual(Solver.solve_part_02(Reader.get_input("07")), 362, "AoC input test")

if __name__ == "__main__":
    unittest.main()