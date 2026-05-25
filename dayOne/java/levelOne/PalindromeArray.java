public class PalindromeArray {

    public static boolean checkIfPalindrome(int[] array) {

        int left = 0;
        int right = array.length - 1;

        while(left < right) {
            if (array[left] != array[right])
                return false;

            left++;
            right--;
        }

        return true;
    }
}
