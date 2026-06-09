import java.util.Scanner;

public class BenjaminQuizGradingSystem {

    public static void main(String[] args) {

        Scanner inputCollector = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = inputCollector.nextInt();

        System.out.print("Enter number of quizzes: ");
        int numberOfQuizTaken = inputCollector.nextInt();

        int[][] studentQuiz = new int[numberOfStudents][numberOfQuizTaken];

        int count = 0;

        while (count < numberOfStudents) {
            System.out.println("\nStudent " + (count + 1));

            for (int index = 0; index < numberOfQuizTaken; index++) {
                System.out.print("Score for Quiz " + (index + 1) + ": ");
                int score;

                do {
                    score = inputCollector.nextInt();

                    if (score < 0 || score > 100) {
                        System.out.println("Invalid score!!!");
                        System.out.print("Score for Quiz " + (index + 1) + ": ");
                    }
                } while (score < 0 || score > 100);

                studentQuiz[count][index] = score;
            }

            count++;
        }

        System.out.println("\n\n======= QUIZ GRADE REPORT =======");
        for (int index = 0; index < numberOfStudents; index++) {
            System.out.printf("Student %d ", index + 1);

            double scoreTotal = 0;

            for (int scoreIndex = 0; scoreIndex < numberOfQuizTaken; scoreIndex++) {
                System.out.printf("%4d ", studentQuiz[index][scoreIndex]);

                scoreTotal += studentQuiz[index][scoreIndex];
            }

            double averageScore = scoreTotal / numberOfQuizTaken;
            System.out.printf("%6.1f%n", averageScore);
        }

        int bestQuizIndex = 0;
        double bestQuiz = 0;

        System.out.print("\nQuiz averages: ");
        for (int scoreIndex = 0; scoreIndex < numberOfQuizTaken; scoreIndex++) {
            double total = 0;

            for (int index = 0; index < numberOfStudents; index++) {
                total += studentQuiz[index][scoreIndex];
            }

            double averageScore = total / numberOfQuizTaken;
            System.out.printf("QZ%d: %.1f  ", scoreIndex + 1 ,averageScore);

            bestQuizIndex = averageScore > bestQuiz ? scoreIndex : bestQuizIndex;
            bestQuiz = averageScore > bestQuiz ? averageScore : bestQuiz;
        }

        System.out.printf("%nBest quiz: Quiz %d (avg %.1f)%n", bestQuizIndex + 1, bestQuiz);
    }
}
