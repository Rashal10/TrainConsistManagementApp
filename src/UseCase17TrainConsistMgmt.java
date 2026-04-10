import java.util.Arrays;

public class UseCase17TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("Original Bogie Names:");

        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        System.out.println(Arrays.toString(bogies));

        // Using built-in sorting
        Arrays.sort(bogies);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogies));

        System.out.println("\nUC17 sorting completed...");
    }
}