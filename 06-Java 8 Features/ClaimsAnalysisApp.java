import java.util.*;
import java.util.stream.Collectors;

public class ClaimsAnalysisApp {

    static class Claim {
        private String claimId;
        private String policyNumber;
        private double claimAmount;
        private String claimDate;
        private String status;

        public Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;
            this.claimDate = claimDate;
            this.status = status;
        }

        public String getClaimId() { return claimId; }
        public String getPolicyNumber() { return policyNumber; }
        public double getClaimAmount() { return claimAmount; }
        public String getClaimDate() { return claimDate; }
        public String getStatus() { return status; }
    }

    static class ClaimSummary {
        private String policyNumber;
        private double totalAmount;
        private double averageAmount;

        public ClaimSummary(String policyNumber, double totalAmount, double averageAmount) {
            this.policyNumber = policyNumber;
            this.totalAmount = totalAmount;
            this.averageAmount = averageAmount;
        }

        @Override
        public String toString() {
            return "Policy: " + policyNumber + ", Total: " + totalAmount + ", Avg: " + averageAmount;
        }
    }

    public static List<ClaimSummary> analyzeClaims(List<Claim> claims) {
        Map<String, List<Claim>> groupedClaims = claims.stream()
                .filter(c -> c.getStatus().equalsIgnoreCase("Approved") && c.getClaimAmount() > 5000)
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        List<ClaimSummary> summaries = groupedClaims.entrySet().stream()
                .map(entry -> {
                    String policyNumber = entry.getKey();
                    List<Claim> claimList = entry.getValue();
                    double total = claimList.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double avg = total / claimList.size();
                    return new ClaimSummary(policyNumber, total, avg);
                })
                .sorted(Comparator.comparingDouble((ClaimSummary cs) -> cs.totalAmount).reversed())
                .limit(3)
                .collect(Collectors.toList());

        return summaries;
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "P1001", 12000, "2024-01-10", "Approved"),
                new Claim("C002", "P1002", 8000, "2024-01-12", "Rejected"),
                new Claim("C003", "P1003", 6000, "2024-01-15", "Approved"),
                new Claim("C004", "P1001", 15000, "2024-01-18", "Approved"),
                new Claim("C005", "P1004", 3000, "2024-01-20", "Approved"),
                new Claim("C006", "P1003", 10000, "2024-01-22", "Approved"),
                new Claim("C007", "P1005", 20000, "2024-01-25", "Approved"),
                new Claim("C008", "P1005", 10000, "2024-01-28", "Approved")
        );

        List<ClaimSummary> topPolicies = analyzeClaims(claims);
        topPolicies.forEach(System.out::println);
    }
}
