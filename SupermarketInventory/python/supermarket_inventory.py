
import sys

class SupermarketInventory:

    def __init__(self, product_details):

        self.product_details = product_details


    def get_best_day(self, product_number):

        highest_unit = 0

        highest_unit_index = 0

        index = 1

        for unit in self.product_details[product_number]:

            if unit > highest_unit:

                highest_unit = unit

                highest_unit_index = index

            index += 1

        return highest_unit_index


    def get_best_selling_product_details(self):

        highest_total_unit = -sys.maxsize - 1

        highest_total_unit_index = 0

        for index in range(len(self.product_details)):

            total_unit = 0

            for unit in self.product_details[index]:

                total_unit += unit

            if total_unit > highest_total_unit:

                highest_total_unit = total_unit

                highest_total_unit_index = index + 1

        return [highest_total_unit_index, highest_total_unit]


    def get_lowest_selling_product_details(self):

        lowest_total_unit = sys.maxsize

        lowest_total_unit_index = 0

        for index in range(len(self.product_details)):

            total_unit = 0

            for unit in self.product_details[index]:

                total_unit += unit

            if total_unit < lowest_total_unit:

                lowest_total_unit = total_unit

                lowest_total_unit_index = index + 1

        return [lowest_total_unit_index, lowest_total_unit]

    def get_overall_total_units(self):

        total_unit = 0

        for index in range(len(self.product_details)):

            for unit in self.product_details[index]:

                total_unit += unit

        return total_unit

# math.inf