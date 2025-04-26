import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Policy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    Policy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return policyNumber + " | " + holderName + " | $" + premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public double getPremiumAmount() { return premiumAmount; }
}

public class InsuranceApp {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
                new Policy("P001", "Alice Smith", 1500),
                new Policy("P002", "Bob Johnson", 950),
                new Policy("P003", "Carol Smith", 2100),
                new Policy("P004", "David Lee", 1750),
                new Policy("P005", "Evelyn King", 1100),
                new Policy("P006", "Frank White", 3000),
                new Policy("P007", "George Black", 1250),
                new Policy("P008", "Hannah Green", 800)
        );

        // 1. Filter Policies by Premium > 1200
        List<Policy> filtered = policies.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .collect(Collectors.toList());

        // 2. Sort Policies by Holder Name
        List<Policy> sortedByName = policies.stream()
                .sorted(Comparator.comparing(Policy::getHolderName))
                .collect(Collectors.toList());

        // 3. Compute Total Premium
        double totalPremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .sum();

        // 4. Print Policy Details
        policies.forEach(p -> System.out.println(p.toString()));

        // 5. Filter Premium between 1000 and 2000
        List<Policy> inRange = policies.stream()
                .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
                .collect(Collectors.toList());

        // 6. Find Policy with Highest Premium
        Optional<Policy> maxPremiumPolicy = policies.stream()
                .max(Comparator.comparingDouble(Policy::getPremiumAmount));

        // 7. Group by Holder Name Initial
        Map<Character, List<Policy>> groupedByInitial = policies.stream()
                .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));

        // 8. Compute Average Premium
        double averagePremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .average()
                .orElse(0.0);

        // 9. Sort by Premium Ascending and Print
        policies.stream()
                .sorted(Comparator.comparingDouble(Policy::getPremiumAmount))
                .forEach(p -> System.out.println(p.toString()));

        // 10. Check if any Premium > 2000
        boolean anyHighPremium = policies.stream()
                .anyMatch(p -> p.getPremiumAmount() > 2000);

        // 11. Count Policies by Premium Range
        Map<String, Long> rangeCount = policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    double amt = p.getPremiumAmount();
                    if (amt <= 1000) return "$0-$1,000";
                    else if (amt <= 2000) return "$1,001-$2,000";
                    else return ">$2,000";
                }, Collectors.counting()));

        // 12. Extract Unique Holder Names
        List<String> uniqueNames = policies.stream()
                .map(Policy::getHolderName)
                .distinct()
                .collect(Collectors.toList());

        // 13. Find Policies with Holder Name containing "Smith"
        List<Policy> smithPolicies = policies.stream()
                .filter(p -> p.getHolderName().contains("Smith"))
                .collect(Collectors.toList());

        // 14. Map of Policy Numbers to Premium Amounts
        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(Policy::getPolicyNumber, Policy::getPremiumAmount));
    }
}
