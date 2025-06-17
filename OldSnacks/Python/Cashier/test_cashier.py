import cashier_function
import unittest

class TestCashier(unittest.TestCase):
	
	def setUp(self):
		cashier_function.all_items.clear()

	def test_add_items(self):
		cashier_function.add_item("Parfait", 2, 500)
		expected = [["Parfait", 2, 500, 1000]]
		self.assertEqual(expected, cashier_function.get_all_items())
	def test_sub_total(self):
		cashier_function.add_item("Parfait", 2, 500)
		cashier_function.add_item("Egg", 1, 500)
		cashier_function.add_item("Egg", 1, 500)
		cashier_function.get_sub_total()
		self.assertEqual(2000, cashier_function.get_sub_total())
	def test_discount(self):
		cashier_function.add_item("Parfait", 2, 500)
		cashier_function.add_item("Egg", 1, 500)
		cashier_function.add_item("Egg", 1, 500)
		self.assertEqual(200, cashier_function.get_discount(10))
	def test_discount(self):
		cashier_function.add_item("Parfait", 2, 550)
		cashier_function.add_item("Egg", 2, 2100)		
		self.assertEqual(927.0, cashier_function.get_vat_amount())
	def test_discount(self):
		cashier_function.add_item("Parfait", 2, 550)
		cashier_function.add_item("Egg", 2, 2100)
		print(cashier_function.print_final_invoice("Justice", 8, 7000))		
		self.assertEqual(5_803.5, cashier_function.get_bill_total(8))