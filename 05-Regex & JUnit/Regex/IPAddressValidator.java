public class IPAddressValidator {

    public static boolean isValidIPv4(String ip) {
        return ip.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$") && isValidOctets(ip);
    }

    private static boolean isValidOctets(String ip) {
        String[] octets = ip.split("\\.");
        for (String octet : octets) {
            int value = Integer.parseInt(octet);
            if (value < 0 || value > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testIPs = {
                "192.168.1.1",
                "256.256.256.256",
                "123.456.78.90",
                "172.16.0.0",
                "0.0.0.0",
                "255.255.255.255"
        };

        for (String ip : testIPs) {
            System.out.printf("%-15s → %s%n", ip, isValidIPv4(ip) ? "Valid" : "Invalid");
        }
    }
}
