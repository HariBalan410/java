import java.util.ArrayList;
import java.util.Scanner;

public class City {
    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== CITY MENU =====");
            System.out.println("1. Append City");
            System.out.println("2. Insert City");
            System.out.println("3. Search City");
            System.out.println("4. Display Cities");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter city to append: ");
                    String city = sc.nextLine();
                    cities.add(city);
                    System.out.println("City added successfully.");
                    break;

                case 2:
                    System.out.print("Enter index to insert: ");
                    int index = sc.nextInt();
                    sc.nextLine();

                    if (index >= 0 && index <= cities.size()) {
                        System.out.print("Enter city to insert: ");
                        String newCity = sc.nextLine();
                        cities.add(index, newCity);
                        System.out.println("City inserted successfully.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 3:
                    System.out.print("Enter city to search: ");
                    String searchCity = sc.nextLine();

                    if (cities.contains(searchCity)) {
                        System.out.println(searchCity + " found.");
                    } else {
                        System.out.println(searchCity + " not found.");
                    }
                    break;

                case 4:
                    if (cities.isEmpty()) {
                        System.out.println("No cities available.");
                    } else {
                        System.out.println("Cities List:");
                        for (int i = 0; i < cities.size(); i++) {
                            System.out.println(i + " : " + cities.get(i));
                        }
                    }
                    break;

                case 5:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}