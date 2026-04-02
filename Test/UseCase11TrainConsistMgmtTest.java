import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    private boolean isTrainValid(String trainId) {
        return Pattern.compile("TRN-\\d{4}").matcher(trainId).matches();
    }

    private boolean isCargoValid(String cargo) {
        return Pattern.compile("PET-[A-Z]{2}").matcher(cargo).matches();
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isTrainValid("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isTrainValid("TRAIN12"));
        assertFalse(isTrainValid("TRN12A"));
        assertFalse(isTrainValid("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isCargoValid("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isCargoValid("PET-ab"));
        assertFalse(isCargoValid("PET123"));
        assertFalse(isCargoValid("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isTrainValid("TRN-123"));
        assertFalse(isTrainValid("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isCargoValid("PET-aB"));
        assertFalse(isCargoValid("PET-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isTrainValid(""));
        assertFalse(isCargoValid(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isTrainValid("TRN-1234XYZ"));
        assertFalse(isCargoValid("PET-ABCD"));
    }
}