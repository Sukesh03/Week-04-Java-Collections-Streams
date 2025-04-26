import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class InsurancePolicyManagementSystem {

    // Method to store unique policies in different sets
    public static void storePolicies() {
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

        // Adding policies
        Policy p1 = new Policy("P123", "John Doe", LocalDate.of(2023, 5, 30), "Health", 1200.0);
        Policy p2 = new Policy("P124", "Jane Smith", LocalDate.of(2023, 6, 15), "Auto", 1500.0);
        Policy p3 = new Policy("P125", "Mike Johnson", LocalDate.of(2023, 5, 10), "Home", 800.0);
        Policy p4 = new Policy("P126", "Anna Brown", LocalDate.of(2023, 7, 1), "Health", 1300.0);

        hashSet.add(p1);
        linkedHashSet.add(p2);
        treeSet.add(p3);
        hashSet.add(p4);
        linkedHashSet.add(p1);
        treeSet.add(p2);

        // Displaying policies
        System.out.println("HashSet (Quick lookup): " + hashSet);
        System.out.println("LinkedHashSet (Insertion order): " + linkedHashSet);
        System.out.println("TreeSet (Sorted by expiry date): " + treeSet);
    }

    // Method to retrieve all policies
    public static void retrieveAllPolicies(Set<Policy> set) {
        System.out.println("All Policies:");
        for (Policy policy : set) {
            System.out.println(policy);
        }
    }

    // Method to retrieve policies expiring soon (within the next 30 days)
    public static void retrieveExpiringSoon(Set<Policy> set) {
        LocalDate today = LocalDate.now();
        System.out.println("Policies expiring soon (within 30 days):");
        for (Policy policy : set) {
            if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                System.out.println(policy);
            }
        }
    }

    // Method to retrieve policies with a specific coverage type
    public static void retrieveByCoverageType(Set<Policy> set, String coverageType) {
        System.out.println("Policies with coverage type " + coverageType + ":");
        for (Policy policy : set) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    // Method to find duplicate policies based on policy number
    public static void findDuplicatePolicies(Set<Policy> set) {
        Set<String> seenPolicyNumbers = new HashSet<>();
        System.out.println("Duplicate Policies:");
        for (Policy policy : set) {
            if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    // Method to compare performance of HashSet, LinkedHashSet, TreeSet
    public static void comparePerformance() {
        int n = 100000;  // Number of policies to test
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

        // Performance test for HashSet
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashSet.add(new Policy("P" + i, "Policyholder " + i, LocalDate.of(2023, 5, i % 30 + 1), "Health", 1000.0));
        }
        long endTime = System.nanoTime();
        System.out.println("HashSet (Adding): " + (endTime - startTime) + " nanoseconds");

        // Performance test for LinkedHashSet
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedHashSet.add(new Policy("P" + i, "Policyholder " + i, LocalDate.of(2023, 5, i % 30 + 1), "Auto", 1200.0));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet (Adding): " + (endTime - startTime) + " nanoseconds");

        // Performance test for TreeSet
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeSet.add(new Policy("P" + i, "Policyholder " + i, LocalDate.of(2023, 5, i % 30 + 1), "Home", 1300.0));
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet (Adding): " + (endTime - startTime) + " nanoseconds");

        // Additional tests for remove and search can be added similarly
    }

    public static void main(String[] args) {
        // Store policies in different sets
        storePolicies();

        // Retrieve all policies
        Set<Policy> set1 = new HashSet<>();
        set1.add(new Policy("P123", "John Doe", LocalDate.of(2023, 5, 30), "Health", 1200.0));
        retrieveAllPolicies(set1);

        // Retrieve policies expiring soon
        retrieveExpiringSoon(set1);

        // Retrieve policies with a specific coverage type
        retrieveByCoverageType(set1, "Health");

        // Find duplicate policies based on policy number
        findDuplicatePolicies(set1);

        // Compare performance of HashSet, LinkedHashSet, and TreeSet
        comparePerformance();
    }
}
