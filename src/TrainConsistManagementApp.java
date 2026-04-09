import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {


    public static boolean binarySearchWithValidation(String[] bogieIDs, String key) {

        if (bogieIDs == null || bogieIDs.length == 0) {
            throw new IllegalStateException("Cannot search: No bogies exist in the train consist.");
        }

        Arrays.sort(bogieIDs);

        int low = 0;
        int high = bogieIDs.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = bogieIDs[mid].compareTo(key);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
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

        if (n > 0) {
            System.out.println("Enter bogie IDs:");
            for (int i = 0; i < n; i++) {
                bogieIDs[i] = scanner.nextLine();
            }
        }

        System.out.print("Enter bogie ID to search: ");
        String searchKey = scanner.nextLine();

        try {
            boolean found = binarySearchWithValidation(bogieIDs, searchKey);

            if (found) {
                System.out.println("Bogie ID " + searchKey + " exists in the train consist.");
            } else {
                System.out.println("Bogie ID " + searchKey + " not found in the train consist.");
            }
        } catch (IllegalStateException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        scanner.close();
    }
}