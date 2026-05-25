public class ReplaceNonPerfectSquare {

    public static boolean isPerfectSquare(int number) {
        int squareroot = (int) Math.sqrt(number);

        return number == squareroot * squareroot;
    }

    public static int[] replaceNonPerfectSquareInArray(int[] array) {
        int[] newArray = new int[array.length];

        for (int index = 0; index < array.length; index++) {
            if (isPerfectSquare(array[index]))
                newArray[index] = array[index];

            else
                newArray[index] = -1;
        }

        return newArray;
    }
}