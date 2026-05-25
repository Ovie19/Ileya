public class TwoSum {

    public static int[] getTwoSum(int[] numbers, int target) {
        int[] newNumbers = new int[2];

        for (int index = 0; index < numbers.length; index++) {

            for (int innerIndex = index + 1; innerIndex < numbers.length; innerIndex++) {

                if (numbers[index] + numbers[innerIndex] == target) {
                    newNumbers[0] = index;
                    newNumbers[1] = innerIndex;

                    return newNumbers;
                }
            }
        }

        return newNumbers;
    }
}
