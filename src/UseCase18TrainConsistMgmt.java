public class UseCase18TrainConsistMgmt {

    // Linear Search Method
    static boolean linearSearch(String[] bogieIds, String key) {

        for (int i = 0; i < bogieIds.length; i++) {

            if (bogieIds[i].equals(key)) {
                return true; // found
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        String searchKey = "BG309";

        System.out.println("Searching for Bogie ID: " + searchKey);

        boolean found = linearSearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie found in the consist.");
        } else {
            System.out.println("Bogie NOT found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}