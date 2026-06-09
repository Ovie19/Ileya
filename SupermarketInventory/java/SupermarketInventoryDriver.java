import java.util.Scanner;

public class SupermarketInventoryDriver {

    public static void main(String[] args) {

        Scanner inputCollector = new Scanner(System.in);

        int numberOfProducts;

        do {

            System.out.print("Enter number of products: ");

            numberOfProducts = inputCollector.nextInt();

            if (numberOfProducts <= 0)

                System.out.println("Invalid input");

        } while (numberOfProducts <= 0);

        int numberOfDaysToTrack;

        do {

            System.out.print("Enter number of days to track: ");

            numberOfDaysToTrack = inputCollector.nextInt();

            if (numberOfDaysToTrack <= 0)

                System.out.println("Invalid input");

        } while (numberOfDaysToTrack <= 0);

        int[][] productDetails = new int[numberOfProducts][numberOfDaysToTrack];

        for (int productIndex = 0; productIndex < numberOfProducts; productIndex++) {

            System.out.printf("%n--- Product %d ---%n", productIndex + 1);

            for (int daysIndex = 0; daysIndex < numberOfDaysToTrack; daysIndex++) {

                int unitSold;

                do {
                    System.out.printf("Enter unit sold on Day %d: ", daysIndex + 1);

                    unitSold = inputCollector.nextInt();

                    if (unitSold < 0)

                        System.out.println("Invalid input");

                } while(unitSold < 0);

                productDetails[productIndex][daysIndex] = unitSold;
            }
        }

        SupermarketInventory.displaySalesSummary(productDetails);

    }

}
