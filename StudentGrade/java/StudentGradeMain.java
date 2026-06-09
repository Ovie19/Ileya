import java.util.Scanner;

public class StudentGradeMain {

    public static void main(String[] args) {

        Scanner inputCollector = new Scanner(System.in);

        System.out.println("How many students do you have?");
        int numberOfStudents;
        do {
            numberOfStudents = inputCollector.nextInt();

            if (numberOfStudents <= 0) {
                System.out.println("Number of students can not be zero or negative!!!");
                System.out.println("How many students do you have?");
            }
        } while (numberOfStudents <= 0);

        System.out.println("How many subjects do they offer?");
        int numberOfSubjects;
        do {
            numberOfSubjects = inputCollector.nextInt();

            if (numberOfSubjects <= 0) {
                System.out.println("Number of quiz taken can not be zero or negative!!!");
                System.out.println("How many subjects do they offer?");
            }
        } while (numberOfSubjects <= 0);

        System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Saved successfully\n");

        int[][] studentsResults = new int[numberOfStudents][numberOfSubjects];

        int studentIndex = 0;

        while (studentIndex < numberOfStudents) {

            for (int subjectIndex = 0; subjectIndex < numberOfSubjects; subjectIndex++) {

                System.out.println("Entering score for student " + (studentIndex + 1));
                System.out.println("Enter score for subject " + (subjectIndex + 1));
                int score;

                do {
                    score = inputCollector.nextInt();

                    if (score < 0 || score > 100) {
                        System.out.println("Invalid score!!!");
                        System.out.println("Enter score for subject " + (subjectIndex + 1));
                    }
                } while (score < 0 || score > 100);

                studentsResults[studentIndex][subjectIndex] = score;

                System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>");
                System.out.println("Saved successfully\n");
            }

            studentIndex++;
        }

        StudentGrade studentGrade = new StudentGrade(studentsResults);

        studentGrade.displayStudentScoreTable();

        studentGrade.displaySubjectSummary();

        studentGrade.displayClassSummary();
    }
}