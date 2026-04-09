import java.util.Scanner;

public class TrainConsistManagementApp {

    // Method to perform Linear Search
    public static boolean linearSearch(String[] bogieIDs, String key) {
        for (int i = 0; i < bogieIDs.length; i++) {
            if (bogieIDs[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] bogieIDs = new String[n];

        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIDs[i] = scanner.nextLine();
        }

        System.out.print("Enter bogie ID to search: ");
        String searchKey = scanner.nextLine();


        boolean found = linearSearch(bogieIDs, searchKey);

        if (found) {
            System.out.println("Bogie ID " + searchKey + " exists in the train consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found in the train consist.");
        }

        scanner.close();
    }
}