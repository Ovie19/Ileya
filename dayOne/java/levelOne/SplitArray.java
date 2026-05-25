public class SplitArray {

    public static int[][] splitArray(int[] array) {
        int evenCount = 0;

        for (int element : array)
            if (element % 2 == 0)
                evenCount++;

        int[] evenArray = new int[evenCount];
        int[] oddArray = new int[array.length - evenCount];

        int oddIndex = 0;
        int evenIndex = 0;

        for (int element: array) {
            if (element % 2 == 0)
                evenArray[evenIndex++] = element;
            else
                oddArray[oddIndex++] = element;
        }

        int[][] splitArray = new int[2][];

        splitArray[0] = oddArray;
        splitArray[1] = evenArray;

        return splitArray;
    }
}
