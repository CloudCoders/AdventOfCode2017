import day10.Day10Solver as Solver
import unittest
import AoCReader as Reader


class TestDay10(unittest.TestCase):

    def test_reversing_sequences(self):
        self.assertEqual(Solver.reverse([0, 1, 2, 3, 4], 0, 3), [2, 1, 0, 3, 4], "Simple test 1")
        self.assertEqual(Solver.reverse([2, 1, 0, 3, 4], 3, 4), [4, 3, 0, 1, 2], "Circular list test 1")
        self.assertEqual(Solver.reverse([4, 3, 0, 1, 2], 1, 5), [3, 4, 2, 1, 0], "Max length test")

    def test_part_1(self):
        self.assertEqual(Solver.solve_part_1("3, 4, 1, 5", [0, 1, 2, 3, 4]), 12, "AoC example test")
        self.assertEqual(Solver.solve_part_1(Reader.get_input("10")), 11413, "AoC input test")

    def test_decoder_to_ascii(self):
        self.assertEqual(Solver.decode_to_ascii("1,2,3"), [49, 44, 50, 44, 51], 'Simple decoding test 1')

    def test_add_suffix(self):
        self.assertEqual(Solver.add_suffix([]), [17, 31, 73, 47, 23], 'Add suffix to a empty list')
        self.assertEqual(Solver.add_suffix([49, 44, 50, 44, 51]), [49, 44, 50, 44, 51, 17, 31, 73, 47, 23], 'Add '
                                                                                                            'suffix '
                                                                                                            'to a '
                                                                                                            'given '
                                                                                                            'list')

    def test_hex_encoder(self):
        self.assertEqual(Solver.encode_in_hex([64, 7, 255]), '4007ff')

    def test_part_2(self):
        self.assertEqual(Solver.solve_part_2(Reader.get_input("10")), 11413, "AoC input test")


if __name__ == '__main__':
    unittest.main()
