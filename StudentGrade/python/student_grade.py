student_quiz_results = []

def set_student_quiz_results(scores):
    global student_quiz_results
    student_quiz_results = scores

def get_total_scores():
    student_total_scores = []

    for student_quiz_result in student_quiz_results:
        total = 0

        for score in student_quiz_result:
            total += score

        student_total_scores.append(total)

    return student_total_scores

def get_student_position():

    position = []

    student_total_scores = get_total_scores()

    sorted_student_total_scores = sorted(student_total_scores, reverse=True)

    for total_score in student_total_scores:

        index = sorted_student_total_scores.index(total_score)

        position.append(index + 1)

    return position


def get_summary_for_subject(subject_number):

    best_student_number = 0
    best_student_score = student_quiz_results[0][subject_number]

    worst_student_number = 0
    worst_student_score = student_quiz_results[0][subject_number]

    total_score = 0
    fail_count = 0
    pass_count = 0

    number_of_students = len(student_quiz_results)

    for student_index in range(number_of_students):

        score = student_quiz_results[student_index][subject_number]

        total_score += score

        if score < 50:
            fail_count += 1
        else:
            pass_count += 1

        if score > best_student_score:
            best_student_score = score
            best_student_number = student_index

        if score < worst_student_score:
            worst_student_score = score
            worst_student_number = student_index

    average = total_score / number_of_students

    return f"""Subject {subject_number + 1}
Highest scoring student is: Student {best_student_number + 1} scoring {best_student_score}
Lowest scoring student is: Student {worst_student_number + 1} scoring {worst_student_score}
Total score is: {total_score}
Average score is: {average:.2f}
Number of passes: {pass_count}
Number of fails: {fail_count}""";


def get_difficulty_summary_for_all_subject():
    hardest_subject_index = 0
    highest_fail_count = 0

    easiest_subject_index = 0
    highest_pass_count = 0

    number_of_students = len(student_quiz_results)

    number_of_subjects = len(student_quiz_results[0])

    for subject_index in range(number_of_subjects):

        fail_count = 0

        pass_count = 0

        for student_index in range(number_of_students):

            score = student_quiz_results[student_index][subject_index]

            if score < 50:
                fail_count += 1
            else:
                pass_count += 1

        if fail_count > highest_fail_count:

            highest_fail_count = fail_count

            hardest_subject_index = subject_index

        if pass_count > highest_pass_count:

            highest_pass_count = pass_count

            easiest_subject_index = subject_index

    return f"The hardest subject is Subject {hardest_subject_index + 1} with {highest_fail_count} failures\nThe easiest subject is Subject {easiest_subject_index + 1} with {highest_pass_count} passes"

def get_summary_for_overall_score():

    best_student_number = 0
    best_subject_number = 0
    best_student_score = student_quiz_results[0][0]

    worst_student_number = 0
    worst_subject_number = 0
    worst_student_score = student_quiz_results[0][0]

    number_of_students = len(student_quiz_results)

    number_of_subjects = len(student_quiz_results[0])

    for student_index in range(number_of_students):

        for subject_index in range(number_of_subjects):

            score = student_quiz_results[student_index][subject_index]

            if score > best_student_score:

                best_student_score = score

                best_student_number = student_index

                best_subject_number = subject_index

            if score < worst_student_score:

                worst_student_score = score

                worst_student_number = student_index

                worst_subject_number = subject_index

    return f"The overall Highest score is scored by Student {best_student_number + 1} in subject {best_subject_number + 1} scoring {best_student_score}\nThe overall Lowest score is scored by Student {worst_student_number + 1} in subject {worst_subject_number + 1} scoring {worst_student_score}"

def get_class_summary():

    student_total_scores = get_total_scores()

    number_of_students = len(student_quiz_results)

    position = get_student_position()

    worst_position = max(position)

    best_student_index = position.index(1)

    worst_student_index = position.index(worst_position)

    best_student_score = student_total_scores[best_student_index]

    worst_student_score = student_total_scores[worst_student_index]

    return [[best_student_index + 1, best_student_score], [worst_student_index + 1, worst_student_score]]


def get_total_subject_scores():

    student_total_scores = get_total_scores()

    total_score = 0

    for score in student_total_scores:

        total_score += score

    return total_score

def display_student_result_table():

    position = get_student_position()

    number_of_students = len(student_quiz_results)

    number_of_subjects = len(student_quiz_results[0])

    print("*" * 60)

    print(f"{'STUDENT':<12}", end="")

    for index in range(number_of_subjects):
        print(f"{f'SUB{index + 1}':>6}", end="")

    print(f"{'TOT':>6}{'AVE':>6}{'POS':>8}")

    print("*" * 60)

    for index in range(number_of_students):
        print(f"{f'Student {index + 1}':<10}", end="")

        total = 0

        for score_index in range(number_of_subjects):
            score = student_quiz_results[index][score_index]
            print(f"{score:>6}", end="")
            total += score

        score_average = total / number_of_subjects

        print(f"{total:>8}{score_average:>8.2f}{position[index]:>4}")

    print("*" * 60)

def display_subject_summary():

    number_of_subjects = len(student_quiz_results[0])

    print("*" * 60)

    print("SUBJECT SUMMARY")

    for subject_number in range(number_of_subjects):

        subject_summary = get_summary_for_subject(subject_number)

        print(subject_summary, end="\n\n")

    difficult_summary = get_difficulty_summary_for_all_subject()

    overall_score_summary = get_summary_for_overall_score()

    print(difficult_summary)

    print(overall_score_summary)

    print("*" * 60)

def display_class_summary():

    class_summary = get_class_summary()

    class_total_score = get_total_subject_scores()

    average = class_total_score / len(student_quiz_results)

    print("CLASS SUMMARY")

    print("*" * 60)

    print(f"Best Graduating Student is: Student {class_summary[0][0]} scoring {class_summary[0][1]}")

    print("*" * 60)

    print()

    print("!" * 60)

    print(f"Worst Graduating Student is: Student {class_summary[1][0]} scoring {class_summary[1][1]}")

    print("!" * 60)

    print()

    print("*" * 60)

    print(f"Class total score is: {class_total_score}")

    print(f"Class Average score is: {average:.2f}")

    print("*" * 60)
