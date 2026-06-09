import java.util.Scanner;

public class TurtleGraphicsDriver {

    public static void main(String[] args) {

        Scanner inputCollector = new Scanner(System.in);

        TurtleGraphics turtleGraphics = new TurtleGraphics();

        int option;

        do {

            System.out.println("""
            1. Pen up
            2. Pen down
            3. Turn right
            4. Turn left
            5. Move forward
            6. Display board
            9. Exit""");

            System.out.print("Enter option: ");

            option = inputCollector.nextInt();

            switch(option) {

                case 1:
                    turtleGraphics.setPenUp();
                    System.out.println("Pen is now up");
                    break;

                case 2:
                    turtleGraphics.setPenDown();
                    System.out.println("Pen is now down");
                    break;

                case 3:
                    turtleGraphics.turnRight();
                    System.out.println("Direction has changed to the right");
                    break;

                case 4:
                    turtleGraphics.turnLeft();
                    System.out.println("Direction has changed to the left");
                    break;

                case 5:
                    System.out.print("Enter number of steps: ");
                    int numberOfSteps = inputCollector.nextInt();
                    turtleGraphics.moveForward(numberOfSteps);
                    System.out.println("Move successful");
                    break;

                case 6:
                    turtleGraphics.displayFloor();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input");
            }

            System.out.println();

        } while (option != 9);
    }
}