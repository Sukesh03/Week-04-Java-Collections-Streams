public class SSNValidator {

    public static boolean isValidSSN(String ssn) {
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }

    public static void main(String[] args) {
        String ssn1 = "123-45-6789";
        String ssn2 = "123456789";

        System.out.println(isValidSSN(ssn1) ? "\"" + ssn1 + "\" is valid" : "\"" + ssn1 + "\" is invalid");
        System.out.println(isValidSSN(ssn2) ? "\"" + ssn2 + "\" is valid" : "\"" + ssn2 + "\" is invalid");
    }
}
