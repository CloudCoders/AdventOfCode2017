import day01
import unittest

class Day01Tests(unittest.TestCase):

	def test_part_one(self):
		self.assertEqual(day01.solver("1122"), 3)
		self.assertEqual(day01.solver("1111"), 4)
		self.assertEqual(day01.solver("1234"), 0)
		self.assertEqual(day01.solver("91212129"), 9)

		input = open('input.txt')
		self.assertEqual(day01.solver(input.read().strip()), 1251)
		input.close()

	def test_part_two(self):
		self.assertEqual(day01.solver2("1212"), 6)
		self.assertEqual(day01.solver2("1221"), 0)
		self.assertEqual(day01.solver2("123425"), 4)
		self.assertEqual(day01.solver2("123123"), 12)
		self.assertEqual(day01.solver2("12131415"), 4)

		input = open('input.txt')
		self.assertEqual(day01.solver2(input.read().strip()), 1244)
		input.close()


if __name__ == '__main__':
    unittest.main()