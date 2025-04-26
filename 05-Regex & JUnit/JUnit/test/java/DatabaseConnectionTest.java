import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    @BeforeEach
    public void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    public void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    public void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected(), "Connection should be established before the test.");
    }

    @Test
    public void testConnectionStillEstablishedInAnotherTest() {
        assertTrue(dbConnection.isConnected(), "Connection should be re-established for each test.");
    }

    @Test
    public void testDisconnectManually() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Connection should be closed.");
    }
}
