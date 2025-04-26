public class CreditCardValidator {

    public static boolean isValidCreditCard(String cardNumber) {
        return cardNumber.matches("^[4-5]\\d{15}$");
    }

    public static void main(String[] args) {
        String[] testCards = {
                "4123456789012345",
                "5123456789012345",
                "6123456789012345",
                "41234567890123",
                "51234567890123456"
        };

        for (String card : testCards) {
            System.out.printf("%-20s → %s%n", card, isValidCreditCard(card) ? "Valid" : "Invalid");
        }
    }
}
