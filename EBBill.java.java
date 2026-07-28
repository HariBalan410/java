import java.util.Scanner;

public class EBBill {

    String consumerNo;
    String consumerName;
    String connectionType;
    int previousReading;
    int currentReading;

    void getDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Consumer Number: ");
        consumerNo = sc.nextLine();

        System.out.print("Enter Consumer Name: ");
        consumerName = sc.nextLine();

        System.out.print("Enter Previous Reading: ");
        previousReading = sc.nextInt();

        System.out.print("Enter Current Reading: ");
        currentReading = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Connection Type (domestic/commercial): ");
        connectionType = sc.nextLine().toLowerCase();
    }

    double calculateBill() {

        int units = currentReading - previousReading;
        double bill = 0;

        if (units < 0) {
            System.out.println("Invalid Meter Reading!");
            return 0;
        }

        if (connectionType.equals("domestic")) {

            if (units <= 100)
                bill = 0;
            else if (units <= 200)
                bill = (units - 100) * 2;
            else if (units <= 500)
                bill = (100 * 2) + (units - 200) * 4;
            else
                bill = (100 * 2) + (300 * 4) + (units - 500) * 6;

        } else if (connectionType.equals("commercial")) {

            if (units <= 100)
                bill = units * 2;
            else if (units <= 200)
                bill = (100 * 2) + (units - 100) * 4;
            else if (units <= 500)
                bill = (100 * 2) + (100 * 4) + (units - 200) * 6;
            else
                bill = (100 * 2) + (100 * 4) + (300 * 6) + (units - 500) * 7;

        } else {
            System.out.println("Invalid Connection Type!");
        }

        return bill;
    }

    void displayBill() {

        System.out.println("\n******** ELECTRICITY BILL ********");
        System.out.println("Consumer Number : " + consumerNo);
        System.out.println("Consumer Name   : " + consumerName);
        System.out.println("Units Consumed  : " + (currentReading - previousReading));
        System.out.println("Connection Type : " + connectionType);
        System.out.println("Total Bill      : Rs. " + calculateBill());
    }

    public static void main(String[] args) {

        EBBill bill = new EBBill();

        bill.getDetails();
        bill.displayBill();
    }
}