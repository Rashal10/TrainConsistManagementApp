import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase16TrainConsistMgmtTest {

    // Reuse sorting method
    static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ✅ 1. Basic Sorting
    @Test
    void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        bubbleSort(arr);

        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    // ✅ 2. Already Sorted
    @Test
    void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        bubbleSort(arr);

        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    // ✅ 3. Duplicate Values
    @Test
    void testSort_DuplicateValues() {
        int[] arr = {72, 56, 56, 24};
        bubbleSort(arr);

        assertArrayEquals(new int[]{24, 56, 56, 72}, arr);
    }

    // ✅ 4. Single Element
    @Test
    void testSort_SingleElementArray() {
        int[] arr = {50};
        bubbleSort(arr);

        assertArrayEquals(new int[]{50}, arr);
    }

    // ✅ 5. All Equal Values
    @Test
    void testSort_AllEqualValues() {
        int[] arr = {40, 40, 40};
        bubbleSort(arr);

        assertArrayEquals(new int[]{40, 40, 40}, arr);
    }
}