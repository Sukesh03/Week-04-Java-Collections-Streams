import java.util.*;
import java.text.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Policyholder: " + policyholderName + ", ExpiryDate: " + expiryDate + ", CoverageType: " + coverageType + ", PremiumAmount: " + premiumAmount;
    }
}

public class InsurancePolicyManager {
    // HashMap for quick lookups by policy number
    private Map<String, Policy> hashMap = new HashMap<>();

    // LinkedHashMap to preserve the order of insertion
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();

    // TreeMap to store policies sorted by expiry date
    private Map<String, Policy> treeMap = new TreeMap<>(Comparator.comparing(p -> hashMap.get(p).expiryDate));

    // Store a new policy
    public void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);
        treeMap.put(policy.policyNumber, policy);
    }

    // Retrieve policy by its number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    // List policies expiring within the next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Policy policy : hashMap.values()) {
            long daysUntilExpiry = ChronoUnit.DAYS.between(today, policy.expiryDate);
            if (daysUntilExpiry > 0 && daysUntilExpiry <= 30) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    // List policies for a specific policyholder
    public List<Policy> getPoliciesByPolicyholder(String policyholderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : hashMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        hashMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
        linkedHashMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
        treeMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
    }

    // Print all policies (for testing purposes)
    public void printAllPolicies() {
        System.out.println("All Policies:");
        for (Policy policy : hashMap.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) throws ParseException {
        InsurancePolicyManager system = new InsurancePolicyManager();

        // Sample policies
        Policy p1 = new Policy("P001", "Alice", LocalDate.of(2023, 5, 15), "Health", 500.0);
        Policy p2 = new Policy("P002", "Bob", LocalDate.of(2023, 6, 10), "Auto", 150.0);
        Policy p3 = new Policy("P003", "Alice", LocalDate.of(2023, 4, 1), "Home", 200.0);
        Policy p4 = new Policy("P004", "Charlie", LocalDate.of(2023, 5, 5), "Health", 300.0);

        // Add policies to the system
        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);
        system.addPolicy(p4);

        // Print all policies
        system.printAllPolicies();

        // Retrieve a specific policy by number
        System.out.println("\nPolicy P002: " + system.getPolicyByNumber("P002"));

        // List policies expiring soon (within 30 days)
        System.out.println("\nPolicies expiring soon: ");
        List<Policy> expiringPolicies = system.getPoliciesExpiringSoon();
        for (Policy policy : expiringPolicies) {
            System.out.println(policy);
        }

        // List all policies for a specific policyholder (Alice)
        System.out.println("\nPolicies for Alice: ");
        List<Policy> alicePolicies = system.getPoliciesByPolicyholder("Alice");
        for (Policy policy : alicePolicies) {
            System.out.println(policy);
        }

        // Remove expired policies
        system.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired ones:");
        system.printAllPolicies();
    }
}
