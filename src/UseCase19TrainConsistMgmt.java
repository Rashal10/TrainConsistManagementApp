import java.util.Arrays;

public class UseCase19TrainConsistMgmt {

    // Binary Search Method
    static boolean binarySearch(String[] arr, String key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare = arr[mid].compareTo(key);

            if (compare == 0) {
                return true; // found
            }
            else if (compare < 0) {
                low = mid + 1; // search right
            }
            else {
                high = mid - 1; // search left
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("=====================================");

        // Sorted bogie IDs
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        System.out.println("\nSorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        String searchKey = "BG309";

        boolean found = binarySearch(bogieIds, searchKey);

        if (found) {
            System.out.println("\nBogie " + searchKey + " found using Binary Search.");
        } else {
            System.out.println("\nBogie NOT found.");
        }

        System.out.println("\nUC19 search completed...");
    }
}