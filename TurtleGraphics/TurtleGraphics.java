public class TurtleGraphics {

    private int[][] floor = new int[20][20];

    private boolean penUp = true;

    private int direction = 1;

    private String positionString = "right";

    private int currentRowCount = 0;

    private int currentColumnCount = 0;

    public void setPenUp() {
        penUp = true;
    }

    public void setPenDown() {
        penUp = false;
    }

    public void turnRight() {
        positionString = "right";

        if (direction == 4)
            direction = 1;
        else
            direction++;

        System.out.println(direction);
    }

    public void turnLeft() {
        positionString = "left";

        if (direction == 1)
            direction = 4;
        else
            direction--;

        System.out.println(direction);
    }

    public void moveForward(int steps) {

        if (penUp) {
            // The pen is up my nigga
        }
        else {
            switch(positionString) {
                case "right":
                    if (direction == 1) {

                        for (int index = 0; index < steps && currentColumnCount < 20; index++) {
                            floor[currentRowCount][currentColumnCount++] = 1;
                        }

                        currentColumnCount--;
                    } else if (direction == 2) {

                        for (int index = 0; index < steps && currentRowCount < 20; index++) {
                            floor[currentRowCount++][currentColumnCount] = 1;
                        }

                        currentRowCount--;
                    } else if (direction == 3) {
                        System.out.println(currentRowCount);

                        for (int index = 0; index < steps && currentRowCount > 0; index++) {
                            floor[currentRowCount--][currentColumnCount] = 1;
                        }

                        currentRowCount++;
                    } else {

                        for (int index = 0; index < steps && currentColumnCount > 0; index++) {
                            floor[currentRowCount][currentColumnCount--] = 1;
                        }

                        currentColumnCount++;
                    }

                    break;

                case "left":
                    System.out.println("Left nigggeeeerrrrrr");
                    break;
            }
        }
    }

    public void displayFloor() {

        for (int row = 0; row < floor.length; row++) {

            for (int columnData : floor[row]) {

                System.out.print(columnData + " ");
            }

            System.out.println();
        }
    }
}