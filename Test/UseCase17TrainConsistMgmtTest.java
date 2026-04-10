import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class UseCase17TrainConsistMgmtTest {

    // Utility method
    void sort(String[] arr) {
        Arrays.sort(arr);
    }

    // ✅ 1. Basic Alphabetical Sorting
    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper","AC Chair","First Class","General","Luxury"};
        sort(arr);

        assertArrayEquals(
                new String[]{"AC Chair","First Class","General","Luxury","Sleeper"},
                arr
        );
    }

    // ✅ 2. Unsorted Input
    @Test
    void testSort_UnsortedInput() {
        String[] arr = {"Luxury","General","Sleeper","AC Chair"};
        sort(arr);

        assertArrayEquals(
                new String[]{"AC Chair","General","Luxury","Sleeper"},
                arr
        );
    }

    // ✅ 3. Already Sorted
    @Test
    void testSort_AlreadySortedArray() {
        String[] arr = {"AC Chair","First Class","General"};
        sort(arr);

        assertArrayEquals(
                new String[]{"AC Chair","First Class","General"},
                arr
        );
    }

    // ✅ 4. Duplicate Values
    @Test
    void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper","AC Chair","Sleeper","General"};
        sort(arr);

        assertArrayEquals(
                new String[]{"AC Chair","General","Sleeper","Sleeper"},
                arr
        );
    }

    // ✅ 5. Single Element
    @Test
    void testSort_SingleElementArray() {
        String[] arr = {"Sleeper"};
        sort(arr);

        assertArrayEquals(
                new String[]{"Sleeper"},
                arr
        );
    }
}