number_of_students = int(input("Enter number of students: "))

number_of_quizzes = int(input("Enter number of quizzes: "))

student_scores = []

count = 0

while count < number_of_students:

    print(f"Student {count + 1}")

    student_quizzes = []

    for index in range(number_of_quizzes):

        score = int(input(f"Score for Quiz {index + 1}: "))

        while score < 0 or score > 100:

            print("Invalid score!!!")

            score = int(input(f"Score for Quiz {index + 1}: "))

        student_quizzes.append(score)

    student_scores.append(student_quizzes)

    count += 1

    print()

print("====== QUIZ GRADE REPORT ======")

for index in range(number_of_students):

    print(f"Student {index + 1} ", end="")

    total = 0

    for score_index in range(number_of_quizzes):

        print(f"{student_scores[index][score_index]:>4}", end="")

        total += student_scores[index][score_index]

    score_average = total / number_of_quizzes

    print(f"{score_average:>7}")


best_quiz_index = 0

best_quiz = 0

print("Quiz averages: ", end="  ")

for score_index in range(number_of_quizzes):

    total = 0

    for index in range(number_of_students):

        total += student_scores[index][score_index]

    quiz_average = total / number_of_students

    print(f"QZ{score_index + 1}: {quiz_average}", end="  ")

    if quiz_average > best_quiz:

        best_quiz = quiz_average

        best_quiz_index = score_index

print(f"\nBest quiz: Quiz {best_quiz_index + 1} (avg {best_quiz})")
