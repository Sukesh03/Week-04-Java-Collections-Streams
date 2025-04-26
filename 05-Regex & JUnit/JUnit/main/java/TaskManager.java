public class TaskManager {

    public static String longRunningTask() {
        try {
            Thread.sleep(3000); // Simulates a long operation (3 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Done";
    }
}
