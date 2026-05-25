import java.util.ArrayList;

public class PerfectSquareArray {

    public static boolean isPerfectSquare(int number) {
        int squareroot = (int) Math.sqrt(number);

        return number == squareroot * squareroot;
    }

    public static int[] getPerfectSquareInArray(int[] array) {
        ArrayList<Integer> perfectSquareList = new ArrayList<>();

        for (int element : array)
            if (isPerfectSquare(element))
                perfectSquareList.add(element);


        int[] perfectSquareArray = new int[perfectSquareList.size()];
        int index = 0;

        for (int element : perfectSquareList)
            perfectSquareArray[index++] = element;

        return perfectSquareArray;
    }
}