public class UseCase20TrainConsistMgmt {

    // Search method with validation
    static boolean searchBogie(String[] bogieIds, String key) {

        // ---- FAIL-FAST VALIDATION ----
        if (bogieIds.length == 0) {
            throw new IllegalStateException(
                    "No bogies available in train. Cannot perform search."
            );
        }

        // ---- LINEAR SEARCH ----
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("=====================================");

        // Empty array (edge case)
        String[] bogieIds = {};

        String searchId = "BG101";

        // This will throw exception
        boolean found = searchBogie(bogieIds, searchId);

        if (found) {
            System.out.println("Bogie found.");
        } else {
            System.out.println("Bogie not found.");
        }

        System.out.println("\nUC20 execution completed...");
    }
}