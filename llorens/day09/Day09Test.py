import unittest
import AoCReader as Reader
import day09.Day09Solver as Solver


class TestDay09(unittest.TestCase):

    def test_char_checker(self):

        self.assertEqual(Solver.is_valid_char(3, "<{!>}>"), False, "Basic invalid char test")
        self.assertEqual(Solver.is_valid_char(3, "<!!>"), True, "Basic valid char test")
        self.assertEqual(Solver.is_valid_char(4, "<!!!>>"), False, "Triple negation invalid char test")

    def test_stream_cleaner(self):

        self.assertEqual(Solver.clean_stream('{<>}')[0], '{}', 'Empty garbage test')
        self.assertEqual(Solver.clean_stream('{<random characters>}')[0], '{}', 'Random characters garbage test')
        self.assertEqual(Solver.clean_stream('{<<<<>}')[0], '{}', 'multiple < garbage test')
        self.assertEqual(Solver.clean_stream('{<{!>}>}')[0], '{}', 'Invalid > garbage test')
        self.assertEqual(Solver.clean_stream('{<!!>}')[0], '{}', 'Double negated > garbage test')
        self.assertEqual(Solver.clean_stream('{<!!!>>}')[0], '{}', 'Triple negates invalid > garbage test')
        self.assertEqual(Solver.clean_stream('{<{o"i!a,<{i<a>}')[0], '{}', 'Real example garbage test')
        self.assertEqual(Solver.clean_stream('{{<ab>},{<ab>},{<ab>},{<ab>}}')[0], '{{},{},{},{}}', 'Multiple brackets '
                                                                                                'garbage test')

    def test_score_function(self):

        self.assertEqual(Solver.assign_score('{{{},{},}}', 1), 9)
        self.assertEqual(Solver.assign_score('{{{},{},{{}}}}', 1), 16)

    def test_cleaner_char_counting(self):

        self.assertEqual(Solver.clean_stream('<>')[1], 0)
        self.assertEqual(Solver.clean_stream('<random characters>')[1], 17)
        self.assertEqual(Solver.clean_stream('<<<<>')[1], 3)
        self.assertEqual(Solver.clean_stream('<{!>}>')[1], 2)
        self.assertEqual(Solver.clean_stream('<!!>')[1], 0)
        self.assertEqual(Solver.clean_stream('<!!!>>')[1], 0)
        self.assertEqual(Solver.clean_stream('<{o"i!a,<{i<a>')[1], 10)

    def test_part_01_solver(self):

        self.assertEqual(Solver.solve_part_01('{{<!>},{<!>},{<!>},{<a>}}'), 3, 'Part 1 Test 1')
        self.assertEqual(Solver.solve_part_01('{{<ab>},{<ab>},{<ab>},{<ab>}}'), 9, 'Part 1 Test 2')
        self.assertEqual(Solver.solve_part_01('{{<!!>},{<!!>},{<!!>},{<!!>}}'), 9, 'Part 1 Test 3')
        self.assertEqual(Solver.solve_part_01('{{<a!>},{<a!>},{<a!>},{<ab>}}'), 3, 'Part 1 Test 4')
        self.assertEqual(Solver.solve_part_01(Reader.get_input("09")), 14204, 'Part 1 Input Test')

    def test_part_02(self):

        self.assertEqual(Solver.solve_part_02(Reader.get_input("09")), 6622, 'Part 2 Input Test')


if __name__ == "__main__":
    unittest.main()
