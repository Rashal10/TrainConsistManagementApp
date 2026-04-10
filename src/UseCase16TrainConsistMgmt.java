public class UseCase16TrainConsistMgmt {

    // Method to perform Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Utility to print array
    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Original Capacities:");
        int[] capacities = {72, 56, 24, 70, 60};
        printArray(capacities);

        bubbleSort(capacities);

        System.out.println("\nSorted Capacities (Ascending):");
        printArray(capacities);

        System.out.println("\nUC16 sorting completed...");
    }
}