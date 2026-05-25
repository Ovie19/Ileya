public class MoveZeros {

    public static void moveZerosToBackOfArray(int[] array) {

        int nonZeroIndex = 0;

        for (int index = 0; index < array.length; index++) {
            if (array[index] != 0) {
                int temporaryValue = array[index];
                array[index] = array[nonZeroIndex];
                array[nonZeroIndex++] = temporaryValue;
            }
        }
    }
}