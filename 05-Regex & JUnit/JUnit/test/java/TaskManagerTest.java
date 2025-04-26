import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    @Timeout(2) // fails if method runs longer than 2 seconds
    public void testLongRunningTaskTimeout() {
        TaskManager.longRunningTask(); // This will fail due to 3s sleep
    }
}
