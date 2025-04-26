import java.util.*;
import java.util.stream.Collectors;

public class FraudDetectionApp {

    static class Transaction {
        private String transactionId;
        private String policyNumber;
        private double amount;
        private String transactionDate;
        private boolean isFraudulent;

        public Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
            this.transactionId = transactionId;
            this.policyNumber = policyNumber;
            this.amount = amount;
            this.transactionDate = transactionDate;
            this.isFraudulent = isFraudulent;
        }

        public String getTransactionId() { return transactionId; }
        public String getPolicyNumber() { return policyNumber; }
        public double getAmount() { return amount; }
        public String getTransactionDate() { return transactionDate; }
        public boolean isFraudulent() { return isFraudulent; }
    }

    static class FraudReport {
        private String policyNumber;
        private long fraudCount;
        private double totalFraudAmount;

        public FraudReport(String policyNumber, long fraudCount, double totalFraudAmount) {
            this.policyNumber = policyNumber;
            this.fraudCount = fraudCount;
            this.totalFraudAmount = totalFraudAmount;
        }

        @Override
        public String toString() {
            return "Policy: " + policyNumber +
                    ", Fraud Count: " + fraudCount +
                    ", Total Fraud: $" + totalFraudAmount;
        }
    }

    public static List<FraudReport> detectFraud(List<Transaction> transactions) {
        Map<String, List<Transaction>> grouped = transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        return grouped.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Transaction> fraudTxns = entry.getValue();
                    long count = fraudTxns.size();
                    double total = fraudTxns.stream().mapToDouble(Transaction::getAmount).sum();
                    return new FraudReport(policy, count, total);
                })
                .filter(report -> report.fraudCount > 5 || report.totalFraudAmount > 50000)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P1001", 15000, "2024-01-01", true),
                new Transaction("T002", "P1001", 12000, "2024-01-02", true),
                new Transaction("T003", "P1001", 18000, "2024-01-03", true),
                new Transaction("T004", "P1001", 16000, "2024-01-04", true),
                new Transaction("T005", "P1001", 14000, "2024-01-05", true),
                new Transaction("T006", "P1001", 17000, "2024-01-06", true),
                new Transaction("T007", "P1002", 9000, "2024-01-01", true),
                new Transaction("T008", "P1002", 11000, "2024-01-02", true),
                new Transaction("T009", "P1003", 30000, "2024-01-03", false),
                new Transaction("T010", "P1004", 51000, "2024-01-04", true)
        );

        List<FraudReport> alerts = detectFraud(transactions);
        alerts.forEach(System.out::println);
    }
}
