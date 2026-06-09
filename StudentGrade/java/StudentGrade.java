import java.util.Arrays;

public class StudentGrade {

    int[][] studentsResults;

    int studentCount;

    int subjectCount;

    public StudentGrade(int[][] studentsQuizResults) {

        studentsResults = studentsQuizResults;

        studentCount = studentsQuizResults.length;

        subjectCount = studentsQuizResults[0].length;
    }

    public int[] getStudentTotalScore() {
        int[] studentTotalScore = new int[studentCount];

        for (int studentIndex = 0; studentIndex < studentCount; studentIndex++) {

            int totalScore = 0;

            for (int subjectIndex = 0; subjectIndex < subjectCount; subjectIndex++) {

                totalScore += studentsResults[studentIndex][subjectIndex];
            }

            studentTotalScore[studentIndex] = totalScore;
        }

        return studentTotalScore;
    }

    public int[] getPosition() {
        int[] position = new int[studentCount];

        int[] studentTotalScore = getStudentTotalScore();

        int[] sortedStudentTotalScore = Arrays.copyOf(studentTotalScore, studentCount);

        Arrays.sort(sortedStudentTotalScore);

        for (int index = 0;  index < studentCount; index++) {

            for (int innerIndex = 0; innerIndex < studentCount; innerIndex++) {

                if (studentTotalScore[index] == sortedStudentTotalScore[innerIndex]) {

                    position[index] = studentCount - innerIndex;

                    break;
                }
            }
        }

        return position;
    }

    public String getSummaryForSubject(int subjectNumber) {
        int highestStudent = 0;
        int highestScore = studentsResults[0][subjectNumber];

        int lowestStudent = 0;
        int lowestScore = studentsResults[0][subjectNumber];

        int totalScore = 0;
        double averageScore;

        int passesCount = 0;
        int failCount = 0;

        for (int index = 0; index < studentCount; index++) {
            int score = studentsResults[index][subjectNumber];
            totalScore += score;

            if (score < 50)
                failCount++;
            else
                passesCount++;

            if (score > highestScore) {
                highestScore = score;
                highestStudent = index;
            }

            if (score < lowestScore) {
                lowestScore = score;
                lowestStudent = index;
            }
        }

        averageScore = (double) totalScore / studentCount;

        return String.format("""
            Subject %d
            Highest scoring student is: Student %d scoring %d
            Lowest scoring student is: Student %d scoring %d
            Total score is: %d
            Average score is: %.2f
            Number of passes: %d
            Number of fails: %d
            """,
            ++subjectNumber,
            ++highestStudent, highestScore,
            ++lowestStudent, lowestScore,
            totalScore,
            averageScore,
            passesCount,
            failCount);
    }

    public int[][] getSubjectDifficultyDetails() {
        int[][] subjectDifficultyDetails = new int[2][2];

        int hardestSubjectNumber = 0;
        int highestFailureCount = 0;

        int easiestSubjectNumber = 0;
        int highestSuccessCount = 0;

        for (int subjectIndex = 0; subjectIndex < subjectCount; subjectIndex++) {

            int failCount = 0;

            int passCount = 0;

            for (int studentIndex = 0; studentIndex < studentCount; studentIndex++) {

                int score = studentsResults[studentIndex][subjectIndex];

                if (score < 50)
                    failCount++;
                else
                    passCount++;
            }

            if (failCount > highestFailureCount) {
                highestFailureCount = failCount;
                hardestSubjectNumber = subjectIndex;
            }

            if (passCount > highestSuccessCount) {
                highestSuccessCount = passCount;
                easiestSubjectNumber = subjectIndex;
            }
        }


        subjectDifficultyDetails[0][0] = ++hardestSubjectNumber;
        subjectDifficultyDetails[0][1] = highestFailureCount;

        subjectDifficultyDetails[1][0] = ++easiestSubjectNumber;
        subjectDifficultyDetails[1][1] = highestSuccessCount;

        return subjectDifficultyDetails;
    }

    public int[][] getOverallScoreDetails() {

        int[][] overallScoreDetails = new int[2][3];

        int bestStudentNumber = 0;
        int bestSubjectNumber = 0;
        int bestStudentScore = studentsResults[0][0];

        int worstStudentNumber = 0;
        int worstSubjectNumber = 0;
        int worstStudentScore = studentsResults[0][0];

        for (int studentIndex = 0; studentIndex < studentCount; studentIndex++) {

            for (int subjectIndex = 0; subjectIndex < subjectCount; subjectIndex++) {

                int score = studentsResults[studentIndex][subjectIndex];

                if (score > bestStudentScore) {
                    bestStudentScore = score;
                    bestStudentNumber = studentIndex;
                    bestSubjectNumber = subjectIndex;
                }

                if (score < worstStudentScore) {
                    worstStudentScore = score;
                    worstStudentNumber = studentIndex;
                    worstSubjectNumber = subjectIndex;
                }
            }
        }

        overallScoreDetails[0][0] = ++bestStudentNumber;
        overallScoreDetails[0][1] = ++bestSubjectNumber;
        overallScoreDetails[0][2] = bestStudentScore;

        overallScoreDetails[1][0] = ++worstStudentNumber;
        overallScoreDetails[1][1] = ++worstSubjectNumber;
        overallScoreDetails[1][2] = worstStudentScore;

        return overallScoreDetails;
    }

    public int[][] getClassSummaryDetails() {

        int[][] classSummaryDetails = new int[2][2];

        int[] studentTotalScore = getStudentTotalScore();

        int worstStudentNumber = 0;
        int worstStudentTotalScore = studentTotalScore[0];

        int bestStudentNumber = 0;
        int bestStudentTotalScore = studentTotalScore[0];

        for (int index = 1; index < studentCount; index++) {

            int totalScore = studentTotalScore[index];

            if (totalScore < worstStudentTotalScore) {
                worstStudentTotalScore = totalScore;
                worstStudentNumber = index;
            }

            if (totalScore > bestStudentTotalScore) {
                bestStudentTotalScore = totalScore;
                bestStudentNumber = index;
            }
        }

        classSummaryDetails[0][0] = ++bestStudentNumber;
        classSummaryDetails[0][1] = bestStudentTotalScore;

        classSummaryDetails[1][0] = ++worstStudentNumber;
        classSummaryDetails[1][1] = worstStudentTotalScore;

        return classSummaryDetails;
    }

    public int getClassTotalScore() {

        int classTotalScore = 0;

        int[] studentTotalScore = getStudentTotalScore();

        for (int totalScore : studentTotalScore)
            classTotalScore += totalScore;

        return classTotalScore;
    }

    // studentsResults

    public void displayStudentScoreTable() {
        int[] position = getPosition();

        System.out.println("=====================================================");
        System.out.printf("%-15s", "STUDENT");

        for (int index = 0; index < subjectCount; index++) {
            System.out.printf("SUB%d  ", index + 1);
        }

        System.out.printf("%-5s%-7s%s%n", "TOT", "AVE", "POS");
        System.out.println("=====================================================");

        for (int index = 0; index < studentCount; index++) {
            System.out.printf("Student %-7d", index + 1);

            int scoreTotal = 0;

            for (int subjectIndex = 0; subjectIndex < subjectCount; subjectIndex++) {
                System.out.printf("%-6d", studentsResults[index][subjectIndex]);

                scoreTotal += studentsResults[index][subjectIndex];
            }

            double averageScore = (double) scoreTotal / subjectCount;
            System.out.printf("%-5d%-7.2f%d%n", scoreTotal, averageScore, position[index]);
        }

        System.out.println("=====================================================\n");
    }

    public void displaySubjectSummary() {
        System.out.println("=====================================================");
        System.out.println("SUBJECT SUMMARY");

        for (int index = 0; index < subjectCount; index++) {
            String subjectSummary = getSummaryForSubject(index);
            System.out.println(subjectSummary);
        }

        int[][] subjectDifficultyDetails = getSubjectDifficultyDetails();

        int[][] overallScoreDetails = getOverallScoreDetails();

        String otherSubjectSummary = String.format("""
        The hardest subject is Subject %d with %d failures
        The easiest subject is Subject %d with %d passes
        The overall Highest score is scored by Student %d in subject %d scoring %d
        The overall Lowest score is scored by Student %d in subject %d scoring %d
        """,
        subjectDifficultyDetails[0][0],
        subjectDifficultyDetails[0][1],
        subjectDifficultyDetails[1][0],
        subjectDifficultyDetails[1][1],
        overallScoreDetails[0][0],
        overallScoreDetails[0][1],
        overallScoreDetails[0][2],
        overallScoreDetails[1][0],
        overallScoreDetails[1][1],
        overallScoreDetails[1][2]
        );
        System.out.print(otherSubjectSummary);
        System.out.println("=====================================================\n");
    }

    public void displayClassSummary() {
        int[][] classSummaryDetails = getClassSummaryDetails();
        int classTotalScore = getClassTotalScore();
        double averageScore = (double) classTotalScore / studentCount;

        System.out.println("CLASS SUMMARY");
        System.out.println("=====================================================");
        System.out.printf("Best Graduating Student is: Student %d scoring %d%n",
            classSummaryDetails[0][0], classSummaryDetails[0][1]);
        System.out.println("=====================================================\n");

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.printf("Worst Graduating Student is: Student %d scoring %d%n",
            classSummaryDetails[1][0], classSummaryDetails[1][1]);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");

        System.out.println("=====================================================");
        System.out.println("Class total score is: " + classTotalScore);
        System.out.printf("Class Average score is: %.2f%n", averageScore);
        System.out.println("=====================================================\n");
    }
}