import java.util.Scanner;

public class MBTIPersonalityTest {


    public static void main(String[] args) {

        Scanner inputCollector = new Scanner(System.in);

        int questionCount = 0;
        String personality = "";
        char[] questionResponses = new char[20];

        System.out.println("What is your name?");
        String name = inputCollector.nextLine();
        System.out.println();

        while (questionCount < questionResponses.length) {
            printQuestion(questionCount);

            char questionResponse = ' ';

            while (
                Character.toUpperCase(questionResponse) != 'A' &&
                Character.toUpperCase(questionResponse) != 'B'
            ) {
                questionResponse = inputCollector.next().charAt(0);

                if (Character.toUpperCase(questionResponse) != 'A' &&
                     Character.toUpperCase(questionResponse) != 'B')
                     System.out.println("Expected A or B as Response");
            }

            questionResponses[questionCount] = Character.toUpperCase(questionResponse);

            System.out.println();
            questionCount++;
        }

        System.out.println("\nHello " + name + " You selected");
        for (int index = 0; index < 4; index++) {
            int responseACount = 0;
            int responseBCount = 0;

            for (int innerIndex = index; innerIndex < questionResponses.length; innerIndex += 4) {

                if (questionResponses[innerIndex] == 'A') {
                    System.out.println("A. " + optionA[innerIndex]);
                    responseACount++;
                } else {
                    System.out.println("B. " + optionB[innerIndex]);
                    responseBCount++;
                }
            }

            switch (index) {
                case 0:
                    if (responseACount > responseBCount)
                        personality += "E";
                    else
                        personality += "I";
                    break;
                case 1:
                    if (responseACount > responseBCount)
                        personality += "S";
                    else
                        personality += "N";
                    break;
                case 2:
                    if (responseACount > responseBCount)
                        personality += "T";
                    else
                        personality += "F";
                    break;
                case 3:
                    if (responseACount > responseBCount)
                        personality += "J";
                    else
                        personality += "P";
                    break;
            }

            System.out.println("Number of A selected: " + responseACount);
            System.out.println("Number of B selected: " + responseBCount);
            System.out.println();
        }

        System.out.println("Personaity " + personality);
    }

    public static void printQuestion(int questionNumber) {
        System.out.println("A. " + optionA[questionNumber]);
        System.out.println("B. " + optionB[questionNumber]);
    }


    static String[] optionA = {
        "expend energy, enjoy groups",
        "Interpret literally",
        "logical, thinking, questioning",
        "organized, orderly",
        "more outgoing, think out loud",
        "practical, realistic, experimental",
        "candid, straight forward, frank",
        "plan, schedule",
        "Seek many tasks, public activities, interaction with others",
        "standard, usual, conventional",
        "firm, tend to criticize, hold the line",
        "regulated, structured",
        "external, communicative, express yourself",
        "focus on here-and-now",
        "tough-minded, just",
        "preparation, plan ahead",
        "active, initiate",
        "facts, things, what is",
        "matter of fact, issue-oriented",
        "control, govern",
    };

    static String[] optionB = {
        "conserve energy, enjoy one-on-one",
        "look for meaning and possibilities",
        "empathetic, feeling, accommodating",
        "flexible, adaptable",
        "more reserved, think to yourself",
        "imaginative, innovative, theoretical",
        "tactful, kind, encouraging",
        "unplanned, spontaneous",
        "seek private, solitary activities with quiet to concentrate",
        "different, novel, unique",
        "gentle, tend to appreciate, conciliate",
        "easy-going, live and let live",
        "internal, reticent, keep to yourself",
        "look to the future, global perspective, big picture",
        "tender-hearted, merciful",
        "go with the flow, adapt as you go",
        "reflective, deliberate",
        "ideas, dreams, \"what could be\", philosophical",
        "sensitive, people-oriented, compassionate",
        "latitude, freedom"
    };
}
