import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (" + severity + ")";
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {
        // Create a priority queue where patients with higher severity are given higher priority
        PriorityQueue<Patient> pq = new PriorityQueue<>((a, b) -> b.severity - a.severity);

        // Adding patients with severity levels
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        System.out.println("Patient order based on severity:");

        // Treat patients by removing from the queue (highest severity first)
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
