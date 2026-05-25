import java.util.Arrays;
import java.util.ArrayList;

public class DuplicateArrayElement {

    public static int[] getDuplicateElements(int[] array) {
        ArrayList<Integer> duplicateElements = new ArrayList<>();

        Arrays.sort(array);

        for (int index = 0; index < array.length - 1; index++) {
            if (array[index] == array[index + 1]) {
                if (!duplicateElements.contains(array[index]))
                    duplicateElements.add(array[index]);
            }
        }

        int[] duplicateElementsArray = new int[duplicateElements.size()];
        int index = 0;

        for (int element : duplicateElements)
            duplicateElementsArray[index++] = element;

        return duplicateElementsArray;
    }
}