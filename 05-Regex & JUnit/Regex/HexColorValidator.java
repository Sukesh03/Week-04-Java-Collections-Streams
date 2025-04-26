public class HexColorValidator {

    public static boolean isValidHexColor(String color) {
        return color.matches("^#[0-9a-fA-F]{6}$");
    }

    public static void main(String[] args) {
        String[] testColors = {
                "#FFA500",
                "#ff4500",
                "#123",
                "#GGGGGG",
                "FFA500",
                "#123456"
        };

        for (String color : testColors) {
            System.out.printf("%-10s → %s%n", color, isValidHexColor(color) ? "Valid" : "Invalid");
        }
    }
}
