class FakeConnection {
    private boolean open = false;

    public void open() {
        open = true;
        System.out.println("Connection opened.");
    }

    public void execute(String command) throws Exception {
        if (!open) {
            throw new IllegalStateException("Cannot execute: connection is not open.");
        }
        if ("fail".equalsIgnoreCase(command)) {
            throw new Exception("Execution failed due to bad command.");
        }
        System.out.println("Executed command: " + command);
    }

    public void close() {
        if (open) {
            open = false;
            System.out.println("Connection closed.");
        }
    }
}

public class ConnectionManager {

    public static void manageConnection(String command) {
        FakeConnection conn = new FakeConnection();
        try {
            conn.open();
            conn.execute(command);
        } catch (Exception e) {
            System.err.println("Error during operation: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public static void main(String[] args) {
        manageConnection("SELECT * FROM users");
        manageConnection("fail");
    }
}
