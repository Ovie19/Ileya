public class MergeSortArray {

    public static int[] mergeArray(int[] arrayOne, int[] arrayTwo) {
        int length = arrayOne.length + arrayTwo.length;
        int[] mergedArray = new int[length];
        int count = 0;

        for (int element : arrayOne)
            mergedArray[count++] = element;

        for (int element : arrayTwo)
            mergedArray[count++] = element;


        for (int index = 0; index < length; index++) {
            int currentIndex = index;

            for (int innerIndex = index + 1; innerIndex < length; innerIndex++) {
                if (mergedArray[innerIndex] < mergedArray[currentIndex])
                    currentIndex = innerIndex;
            }

            if (index != currentIndex) {
                int temporaryValue = mergedArray[index];
                mergedArray[index] = mergedArray[currentIndex];
                mergedArray[currentIndex] = temporaryValue;
            }
        }

        return mergedArray;
    }
}