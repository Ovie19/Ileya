from unittest import TestCase

from student_grade import *

class TestStudentGrade(TestCase):

    def setUp(self):
        student_quiz_results = [[67, 21, 49], [98, 62, 56], [93, 34, 27], [78, 83, 66]]

        set_student_quiz_results(student_quiz_results)

    def test_that_I_pass_array_of_students_quiz_it_returns_the_total_scores_of_all_students(self):

        expected = get_total_scores()

        actual = [137, 216, 154, 227]

        self.assertListEqual(expected, actual)

    def test_that_I_pass_array_of_students_quiz_it_returns_their_position(self):

        expected = get_student_position()

        actual = [4, 2, 3, 1]

        self.assertListEqual(expected, actual)

    def test_that_I_get_the_correct_summary_of_a_subject(self):

        expected = get_summary_for_subject(2)

        actual = """Subject 3
Highest scoring student is: Student 4 scoring 66
Lowest scoring student is: Student 3 scoring 27
Total score is: 198
Average score is: 49.50
Number of passes: 2
Number of fails: 2"""

        self.assertEqual(expected, actual)

    def test_that_I_get_the_correct_summary_of_a_subject_difficulty(self):

        expected = get_difficulty_summary_for_all_subject()

        actual = "The hardest subject is Subject 2 with 2 failures\nThe easiest subject is Subject 1 with 4 passes"

        self.assertEqual(expected, actual)

    def test_that_I_get_the_correct_summary_of_overall_subject(self):

        expected = get_summary_for_overall_score()

        actual = "The overall Highest score is scored by Student 2 in subject 1 scoring 98\nThe overall Lowest score is scored by Student 1 in subject 2 scoring 21"

        self.assertEqual(expected, actual)

    def test_that_I_get_the_correct_class_summary(self):

        expected = get_class_summary()

        actual = [[4, 227], [1, 137]]

        self.assertListEqual(expected, actual)

    def test_that_I_get_the_correct_total_class_score(self):

        expected = get_total_subject_scores()

        actual = 734

        self.assertEqual(expected, actual)