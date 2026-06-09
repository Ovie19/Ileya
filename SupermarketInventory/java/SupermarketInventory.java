public class SupermarketInventory {

    public static int getBestDayForProduct(int[][] productDetails, int productNumber) {

        int highestUnit = productDetails[productNumber][0];
        int highestUnitIndex = 0;

        for (int index = 0; index < productDetails[productNumber].length; index++) {

            int unit = productDetails[productNumber][index];

            if (unit > highestUnit) {

                highestUnit = unit;

                highestUnitIndex = index;
            }
        }

        return highestUnitIndex + 1;
    }

    public static int[] getBestSellingProduct(int[][] productDetails) {

        int[] bestSellingProduct = new int[2];

        int highestTotalUnit = Integer.MIN_VALUE;

        int highestUnitIndex = 0;

        for (int index = 0; index < productDetails.length; index++) {

            int totalUnit = 0;

            for (int innerIndex = 0; innerIndex < productDetails[0].length; innerIndex++) {

                totalUnit += productDetails[index][innerIndex];
            }

            if (totalUnit > highestTotalUnit) {

                highestTotalUnit = totalUnit;

                highestUnitIndex = index;
            }
        }

        bestSellingProduct[0] = highestUnitIndex + 1;

        bestSellingProduct[1] = highestTotalUnit;

        return bestSellingProduct;
    }

    public static int[] getLowestSellingProduct(int[][] productDetails) {

        int[] lowestSellingProduct = new int[2];

        int lowestTotalUnit = Integer.MAX_VALUE;

        int lowestUnitIndex = 0;

        for (int index = 0; index < productDetails.length; index++) {

            int totalUnit = 0;

            for (int innerIndex = 0; innerIndex < productDetails[0].length; innerIndex++) {

                totalUnit += productDetails[index][innerIndex];
            }

            if (totalUnit < lowestTotalUnit) {

                lowestTotalUnit = totalUnit;

                lowestUnitIndex = index;
            }
        }

        lowestSellingProduct[0] = lowestUnitIndex + 1;

        lowestSellingProduct[1] = lowestTotalUnit;

        return lowestSellingProduct;
    }

    public static int getOverallUnitSold(int[][] productDetails) {

        int totalUnit = 0;

        for (int index = 0; index < productDetails.length; index++) {

            for (int unit : productDetails[index]) {

                totalUnit += unit;
            }

        }

        return totalUnit;
    }

    public static void displaySalesSummary(int[][] productDetails) {

        System.out.println("\n========== STORE SALES SUMMARY ==========\n");

        System.out.printf("%-12s", "PRODUCT");

        for (int index = 0; index < productDetails[0].length; index++) {

            System.out.printf("DAY%-5d", index + 1);

        }

        System.out.printf("%-8s%s%n", "TOTAL", "BEST DAY");

        System.out.println("-------------------------------------------------------");

        for (int productIndex = 0; productIndex < productDetails.length; productIndex++) {

            System.out.printf("Product %-4d", productIndex + 1);

            int totalUnit = 0;

            for (int daysIndex = 0; daysIndex < productDetails[0].length; daysIndex++) {

                int unit = productDetails[productIndex][daysIndex];

                totalUnit += unit;

                System.out.printf("%-8d", unit);

            }

            int productBestDay = getBestDayForProduct(productDetails, productIndex);

            System.out.printf("%-8dDay %d%n", totalUnit, productBestDay);

        }

        System.out.println("-------------------------------------------------------\n");

        int[] bestSellingProduct = getBestSellingProduct(productDetails);

        int[] lowestSellingProduct = getLowestSellingProduct(productDetails);

        int overallUnitSold = getOverallUnitSold(productDetails);

        System.out.printf("""
        Best-selling product: Product %d (%d units)
        Lowest-selling product: Product %d (%d units)
        Overall units sold: %d
        """,
        bestSellingProduct[0],
        bestSellingProduct[1],
        lowestSellingProduct[0],
        lowestSellingProduct[1],
        overallUnitSold
        );

    }
}