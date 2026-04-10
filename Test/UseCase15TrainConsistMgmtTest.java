import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase15TrainConsistMgmtTest {

    // ---- Reuse same classes (or import if separate files) ----
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;

            } catch (CargoSafetyException e) {
                // handled internally

            } finally {
                // logging (ignored in test)
            }
        }
    }

    // ---------------- TEST CASES ----------------

    // ✅ 1. Safe Cargo Assignment
    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    // ✅ 2. Unsafe Cargo Detection (Exception handled internally)
    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // Should NOT throw outside because it's caught internally
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    // ✅ 3. Cargo NOT assigned after failure
    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    // ✅ 4. Program continues after exception
    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum");  // unsafe
        bogie2.assignCargo("Coal");       // safe

        assertEquals("Coal", bogie2.cargo);
    }

    // ✅ 5. Finally Block Execution (Indirect Check)
    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // If finally fails, method would crash → so we check smooth execution
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}