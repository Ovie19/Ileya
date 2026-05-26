from unittest import TestCase

from move_zeros import move_zeros_in_list

class TestMoveZeros(TestCase):

    def test_that_I_pass_an_array_it_moves_all_zeros_to_the_back_of_the_array(self):

        array = [5, 0, 3, 0, 2, 0]

        expected = [5, 3, 2, 0, 0, 0]

        move_zeros_in_list(array)

        self.assertListEqual(expected, array);


        arrayTwo = [0, 0, 0, 0, 0, 1]

        expected = [1, 0, 0, 0, 0, 0]

        move_zeros_in_list(arrayTwo)

        self.assertListEqual(expected, arrayTwo);