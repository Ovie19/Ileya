import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupermarketInventoryTest {

    @Test
    public void testThatWePassAnArrayAndAProductNumberIgetTheBestDay() {

        int[][] productDetails = {{120, 95}, {45, 60}, {200, 175}};

        int productNumber = 0;

        int expected = 1;

        int actual = SupermarketInventory.getBestDayForProduct(productDetails, productNumber);

        assertEquals(expected, actual);


        productNumber = 1;

        expected = 2;

        actual = SupermarketInventory.getBestDayForProduct(productDetails, productNumber);

        assertEquals(expected, actual);
    }

    @Test
    public void testThatWePassAnArrayAndWeGetTheBestSellingProductDetails() {

        int[][] productDetails = {{120, 95}, {45, 60}, {200, 175}};

        int[] expected = {3, 375};

        int[] actual = SupermarketInventory.getBestSellingProduct(productDetails);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatWePassAnArrayAndWeGetTheLowestSellingProductDetails() {

        int[][] productDetails = {{120, 95}, {45, 60}, {200, 175}};

        int[] expected = {2, 105};

        int[] actual = SupermarketInventory.getLowestSellingProduct(productDetails);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatWePassAnArrayAndWeGetTheOverallProductUnitsSold() {

        int[][] productDetails = {{120, 95}, {45, 60}, {200, 175}};

        int expected = 695;

        int actual = SupermarketInventory.getOverallUnitSold(productDetails);

        assertEquals(expected, actual);
    }
}
