from student_grade import *

student_quiz_results = []

number_of_students = 0
while number_of_students <= 0:
    number_of_students = int(input("How many students do you have?\n"))

    if number_of_students <= 0:
        print("Invalid input")

number_of_subjects = 0
while number_of_subjects <= 0:
    number_of_subjects = int(input("How many subjects do they offer?\n"))

    if number_of_subjects <= 0:
        print("Invalid input")

print("Saving >>>>>>>>>>>>>>>>>>>>>>>>>")
print("Saved successfully\n")

for student_index in range(number_of_students):

    student_result = []


    for subject_index in range(number_of_subjects):

        print(f"Entering score for student {student_index + 1}")

        score = int(input(f"Enter score for subject {subject_index + 1}: "))

        while score < 0 or score > 100:

            print("Invalid score!!!")

            score = int(input(f"Enter score for subject {subject_index + 1}: "))

        student_result.append(score)

        print("Saving >>>>>>>>>>>>>>>>>>>>>>>>>")
        print("Saved successfully\n")

    student_quiz_results.append(student_result)

set_student_quiz_results(student_quiz_results)

display_student_result_table()

print()

display_subject_summary()

print()

display_class_summary()
