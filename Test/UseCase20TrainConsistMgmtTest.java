import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase20TrainConsistMgmtTest {

    boolean searchBogie(String[] bogieIds, String key) {

        if (bogieIds.length == 0) {
            throw new IllegalStateException(
                    "No bogies available in train. Cannot perform search."
            );
        }

        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(key)) {
                return true;
            }
        }

        return false;
    }

    // ✅ 1. Exception when empty
    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};

        assertThrows(IllegalStateException.class, () -> {
            searchBogie(arr, "BG101");
        });
    }

    // ✅ 2. Search allowed when data exists
    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101","BG205"};

        assertDoesNotThrow(() -> {
            searchBogie(arr, "BG101");
        });
    }

    // ✅ 3. Bogie found after validation
    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        assertTrue(searchBogie(arr, "BG205"));
    }

    // ✅ 4. Bogie not found after validation
    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        assertFalse(searchBogie(arr, "BG999"));
    }

    // ✅ 5. Single element case
    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};

        assertTrue(searchBogie(arr, "BG101"));
    }
}