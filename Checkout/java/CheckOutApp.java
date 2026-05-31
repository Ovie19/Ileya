import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CheckOutApp {

    public static void main(String[] args) {

        Scanner inputCollector = new Scanner(System.in);
        List<String> itemList = new ArrayList<>();
        List<Integer> quantityList = new ArrayList<>();
        List<Double> priceList = new ArrayList<>();
        String customerName;
        String cashierName;
        int discount;

        System.out.println("What is the customer's Name");
        customerName = inputCollector.nextLine();

        String option;

        do {
            System.out.println("\nWhat did the user buy?");
            String itemName = inputCollector.nextLine();
            itemList.add(itemName);

            System.out.println("How many pieces?");
            int quantity = inputCollector.nextInt();
            quantityList.add(quantity);

            System.out.println("How much per unit?");
            double price = inputCollector.nextDouble();
            inputCollector.nextLine();
            priceList.add(price);

            System.out.println("Add more Items?");
            option = inputCollector.nextLine();

        } while (!option.trim().equalsIgnoreCase("no"));


        System.out.println("\nWhat is your name?");
        cashierName = inputCollector.nextLine();

        System.out.println("How much discount will he get");
        discount = inputCollector.nextInt();
        System.out.println();

        displayStoreHeader(cashierName, customerName);

        double subTotal = showAllItemsQuantityAndPrice(itemList, quantityList, priceList);

        double totalBillPrice = displaySubTotalDiscountAndVAT(subTotal, discount);

        System.out.printf("%38s:\t\t%.2f%n", "Bill Total", totalBillPrice);
        System.out.println("========================================================");
        System.out.printf("THIS IS NOT A RECEIPT KINDLY PAY %.2f%n", totalBillPrice);
        System.out.println("========================================================");

        System.out.println("\n\n\n ");

        System.out.println("How much did the customer give to you?");
        int amountPaid = inputCollector.nextInt();

        displayStoreHeader(cashierName, customerName);

        showAllItemsQuantityAndPrice(itemList, quantityList, priceList);

        displaySubTotalDiscountAndVAT(subTotal, discount);

        System.out.printf("%38s:\t\t%.2f%n", "Bill Total", totalBillPrice);
        System.out.printf("%38s:\t\t%d%n", "Amount Paid", amountPaid);
        System.out.printf("%38s:\t\t%.2f%n", "Balance", (double) amountPaid - totalBillPrice);
        System.out.println("========================================================");
        System.out.println("\t\tTHANK YOU FOR YOUR PATRONAGE");
        System.out.println("========================================================");
    }

    public static void displayStoreHeader(String cashierName, String customerName) {
        String header = String.format("""
        SEMICOLON STORES
        MAIN BRANCH
        LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
        TEL: 03293828343
        Date: 18-Dec-22 8:48:11 pm
        Cashier: %s
        Customer Name: %s""", cashierName, customerName);

        System.out.println(header);
        System.out.println("========================================================");
        System.out.printf("%15s%5s%18s%15s%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
        System.out.println("--------------------------------------------------------");
    }

    public static double showAllItemsQuantityAndPrice(
        List<String> itemList,
        List<Integer> quantityList,
        List<Double> priceList
    ) {
        double subTotal = 0;

        for (int index = 0; index < itemList.size(); index++) {
            String item = itemList.get(index);
            int quantity = quantityList.get(index);
            double price = priceList.get(index);
            double total = price * quantity;
            subTotal += total;

            System.out.printf("%15s%5d%18.2f%15.2f%n", item, quantity, price, total);
        }

        return subTotal;
    }

    public static double displaySubTotalDiscountAndVAT(double subTotal, int discount) {
        System.out.println("\n--------------------------------------------------------");
        double discountOnPrice = subTotal * discount / 100;
        double vatOnPrice = subTotal * 0.175;
        System.out.printf("%38s:%15.2f%n", "Sub Total", subTotal);
        System.out.printf("%38s:%15.2f%n", "Discount", discountOnPrice);
        System.out.printf("%38s:%15.2f%n", "VAT @ 17.50%", vatOnPrice);
        System.out.println("========================================================");

        return subTotal - discountOnPrice + vatOnPrice;
    }
}
