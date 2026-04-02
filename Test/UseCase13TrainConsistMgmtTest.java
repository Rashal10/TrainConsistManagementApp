import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> loopFilter(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    private List<Bogie> streamFilter(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 50));
        list.add(new Bogie("B", 70));

        List<Bogie> result = loopFilter(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 50));
        list.add(new Bogie("B", 70));

        List<Bogie> result = streamFilter(list);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 50));
        list.add(new Bogie("B", 70));
        list.add(new Bogie("C", 80));

        List<Bogie> loop = loopFilter(list);
        List<Bogie> stream = streamFilter(list);

        assertEquals(loop.size(), stream.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 70));

        long start = System.nanoTime();
        loopFilter(list);
        long end = System.nanoTime();

        assertTrue(end - start > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("T" + i, i % 100));
        }

        List<Bogie> result = streamFilter(list);

        assertNotNull(result);
    }
}