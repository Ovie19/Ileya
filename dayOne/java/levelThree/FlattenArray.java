public class FlattenArray {

    public static int getElementsCount(int[][] array) {
        int total = 0;

        for (int[] element : array) {
            total += element.length;
        }

        return total;
    }

    public static int[] flatten(int[][] array) {

        int elementCount = getElementsCount(array);

        int[] flattenedArray = new int[elementCount];
        int flattenedArrayIndex = 0;

        for (int index = 0; index < array.length; index++)
            for (int innerIndex = 0; innerIndex < array[index].length; innerIndex++)
                flattenedArray[flattenedArrayIndex++] = array[index][innerIndex];

        return flattenedArray;
    }
}