import java.util.*;
import java.util.stream.Collectors;

public class PolicyRiskAssessmentApp {

    static class PolicyHolder {
        private String holderId;
        private String name;
        private int age;
        private String policyType;
        private double premiumAmount;

        public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
            this.holderId = holderId;
            this.name = name;
            this.age = age;
            this.policyType = policyType;
            this.premiumAmount = premiumAmount;
        }

        public String getHolderId() { return holderId; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getPolicyType() { return policyType; }
        public double getPremiumAmount() { return premiumAmount; }
    }

    static class RiskAssessment {
        private String holderId;
        private String name;
        private double riskScore;

        public RiskAssessment(String holderId, String name, double riskScore) {
            this.holderId = holderId;
            this.name = name;
            this.riskScore = riskScore;
        }

        public double getRiskScore() { return riskScore; }

        @Override
        public String toString() {
            return holderId + " | " + name + " | Risk Score: " + riskScore;
        }
    }

    public static Map<String, List<RiskAssessment>> assessRisk(List<PolicyHolder> holders) {
        List<RiskAssessment> assessments = holders.stream()
                .filter(h -> h.getPolicyType().equalsIgnoreCase("Life") && h.getAge() > 60)
                .map(h -> new RiskAssessment(h.getHolderId(), h.getName(), h.getPremiumAmount() / h.getAge()))
                .sorted(Comparator.comparingDouble(RiskAssessment::getRiskScore).reversed())
                .collect(Collectors.toList());

        Map<String, List<RiskAssessment>> categorized = assessments.stream()
                .collect(Collectors.groupingBy(r -> r.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));

        return categorized;
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H001", "Alice", 65, "Life", 40000),
                new PolicyHolder("H002", "Bob", 62, "Health", 30000),
                new PolicyHolder("H003", "Charlie", 70, "Life", 35000),
                new PolicyHolder("H004", "David", 75, "Life", 20000),
                new PolicyHolder("H005", "Eva", 80, "Life", 10000),
                new PolicyHolder("H006", "Frank", 61, "Life", 32000)
        );

        Map<String, List<RiskAssessment>> result = assessRisk(holders);

        result.forEach((category, list) -> {
            System.out.println(category + ":");
            list.forEach(System.out::println);
            System.out.println();
        });
    }
}
