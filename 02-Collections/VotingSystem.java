import java.util.*;

public class VotingSystem {
    // HashMap to store votes for each candidate
    private Map<String, Integer> votesMap = new HashMap<>();

    // LinkedHashMap to maintain the order of votes (insertion order)
    private Map<String, Integer> linkedVotesMap = new LinkedHashMap<>();

    // TreeMap to display results sorted by candidate name
    private Map<String, Integer> sortedVotesMap = new TreeMap<>();

    // Method to add a vote for a candidate
    public void vote(String candidate) {
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
        linkedVotesMap.put(candidate, linkedVotesMap.getOrDefault(candidate, 0) + 1);
        sortedVotesMap.put(candidate, sortedVotesMap.getOrDefault(candidate, 0) + 1);
    }

    // Method to display results in sorted order
    public void displayResults() {
        System.out.println("Votes in Sorted Order (TreeMap): ");
        for (Map.Entry<String, Integer> entry : sortedVotesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Method to display votes in insertion order (LinkedHashMap)
    public void displayVotesInOrder() {
        System.out.println("Votes in Insertion Order (LinkedHashMap): ");
        for (Map.Entry<String, Integer> entry : linkedVotesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("Charlie");
        system.vote("Bob");
        system.vote("Bob");

        system.displayVotesInOrder();
        system.displayResults();
    }
}
