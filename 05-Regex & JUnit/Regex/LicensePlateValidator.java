public class LicensePlateValidator {

    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {
        String[] testPlates = {
                "AB1234",
                "A12345",
                "XY9876",
                "ab1234",
                "ABC123",
                "AB123",
                "ZZ9999"
        };

        for (String plate : testPlates) {
            System.out.printf("%-10s → %s%n", plate, isValidLicensePlate(plate) ? "Valid" : "Invalid");
        }
    }
}
