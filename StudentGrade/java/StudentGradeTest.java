import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentGradeTest {

    StudentGrade studentGrade;

    @BeforeEach
    void setUp() {
        int[][] studentsQuizResults = {{67, 21, 49}, {98, 62, 56}, {93, 34, 27}, {78, 83, 66}};
        studentGrade = new StudentGrade(studentsQuizResults);
    }

    @Test
    public void testThatIPassStudentResultsItReurnsStudentTotalScore() {

        int[] expected = {137, 216, 154, 227};

        int[] actual = studentGrade.getStudentTotalScore();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatIPassStudentResultsItReurnsStudentPosition() {

        int[] expected = {4, 2, 3, 1};

        int[] actual = studentGrade.getPosition();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatIGetTheCorrectSummaryOfAParticularSubject() {

        String expected = """
        Subject 3
        Highest scoring student is: Student 4 scoring 66
        Lowest scoring student is: Student 3 scoring 27
        Total score is: 198
        Average score is: 49.50
        Number of passes: 2
        Number of fails: 2
        """;

        String actual = studentGrade.getSummaryForSubject(2);

        assertEquals(expected, actual);
    }

    @Test
    public void testThatIGetTheCorrectDifficultyDetails() {

        int[][] expected = {{2, 2}, {1, 4}};

        int[][] actual = studentGrade.getSubjectDifficultyDetails();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatIGetTheCorrectOverallScoreDetails() {

        int[][] expected = {{2, 1, 98}, {1, 2, 21}};

        int[][] actual = studentGrade.getOverallScoreDetails();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatIGetTheCorrectClassSummaryDetails() {

        int[][] expected = {{4, 227}, {1, 137}};

        int[][] actual = studentGrade.getClassSummaryDetails();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatIGetTheClassTotalScore() {

        int expected = 734;

        int actual = studentGrade.getClassTotalScore();

        assertEquals(expected, actual);
    }
}