import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase18TrainConsistMgmtTest {

    // Reuse search method
    boolean linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    // ✅ 1. Bogie Found
    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(linearSearch(arr, "BG309"));
    }

    // ✅ 2. Bogie Not Found
    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(linearSearch(arr, "BG999"));
    }

    // ✅ 3. First Element Match
    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(linearSearch(arr, "BG101"));
    }

    // ✅ 4. Last Element Match
    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(linearSearch(arr, "BG550"));
    }

    // ✅ 5. Single Element Array
    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};

        assertTrue(linearSearch(arr, "BG101"));
    }
}