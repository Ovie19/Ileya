
from unittest import TestCase

from supermarket_inventory import SupermarketInventory

class TestSupermarketInventory(TestCase):

    def setUp(self):

        product_details = [[120, 95], [45, 60], [200, 175]]

        self.supermarket_inventory = SupermarketInventory(product_details)

    def test_that_we_pass_an_array_and_a_product_number_it_returns_the_best_day(self):

        product_number = 0

        expected = 1

        actual = self.supermarket_inventory.get_best_day(product_number)

        self.assertEqual(expected, actual)


        product_number = 1

        expected = 2

        actual = self.supermarket_inventory.get_best_day(product_number)

        self.assertEqual(expected, actual)


    def test_that_we_pass_an_array_it_returns_best_selling_product_details(self):

        expected = [3, 375]

        actual = self.supermarket_inventory.get_best_selling_product_details()

        self.assertListEqual(expected, actual)


    def test_that_we_pass_an_array_it_returns_lowest_selling_product_details(self):

        expected = [2, 105]

        actual = self.supermarket_inventory.get_lowest_selling_product_details()

        self.assertListEqual(expected, actual)


    def test_that_we_pass_an_array_it_returns_the_overall_total_units(self):

        expected = 695

        actual = self.supermarket_inventory.get_overall_total_units()

        self.assertEqual(expected, actual)
