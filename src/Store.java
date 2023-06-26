import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Store {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");

        System.out.println("Pierre's Tool Rental Store");

        while (true) {
            System.out.println("\nPress 1 to rent a tool");
            System.out.println("Press q to quit");

            System.out.print("Select option> ");
            String option = scanner.next().toUpperCase();
            if (option.equals("Q")) {
                System.out.println("Program is exiting successfully...");
                break;
            }
            else if (!option.equals("1")) {
                System.out.println("Enter a valid option!!!");
                continue;
            }

            System.out.print("\nEnter tool code: ");
            String toolCode = scanner.next().toUpperCase();
            System.out.print("Enter rental day count: ");
            int rentalDays = scanner.nextInt();
            if (rentalDays < 1) {
                System.out.println("Rental days must be 1 or greater!");
                continue;
            }
            System.out.print("Enter discount percent: ");
            double discountPercent = scanner.nextDouble();
            if (discountPercent < 0 || discountPercent > 100) {
                System.out.println("Discount percent must be between 0 and 100!");
                continue;
            }
            System.out.print("Enter check out date (mm/dd/yy): ");
            Date checkoutDate;
            try {
                checkoutDate = formatter.parse(scanner.next());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            System.out.print("\nDo you want to checkout?(Y/n)");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("Y")) {
                Checkout checkout = new Checkout();
                checkout.doCheckOut(toolCode,rentalDays,discountPercent,checkoutDate);
            }
        }
    }
}
