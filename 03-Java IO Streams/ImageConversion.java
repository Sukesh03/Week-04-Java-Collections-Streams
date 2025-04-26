import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageConversion {

    // Method to convert image to byte array
    public static byte[] convertImageToByteArray(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath()); // Read all bytes from the image file
        return imageBytes;
    }

    // Method to convert byte array back to an image
    public static void convertByteArrayToImage(byte[] imageBytes, String outputImagePath) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byteArrayOutputStream.write(imageBytes); // Write byte array to the output stream
            try (FileOutputStream fileOutputStream = new FileOutputStream(outputImagePath)) {
                byteArrayOutputStream.writeTo(fileOutputStream); // Write byte array to the output image file
            }
        }
    }

    // Method to compare two byte arrays (original and converted)
    public static boolean compareImages(byte[] originalBytes, byte[] newBytes) {
        if (originalBytes.length != newBytes.length) {
            return false; // Images are not identical if byte arrays are of different lengths
        }

        for (int i = 0; i < originalBytes.length; i++) {
            if (originalBytes[i] != newBytes[i]) {
                return false; // Images are not identical if any byte differs
            }
        }
        return true; // Images are identical if byte arrays match
    }

    public static void main(String[] args) {
        String inputImagePath = "input_image.jpg";  // Replace with your input image path
        String outputImagePath = "output_image.jpg"; // Replace with desired output image path

        try {
            // Convert image to byte array
            byte[] originalImageBytes = convertImageToByteArray(inputImagePath);

            // Convert byte array back to an image file
            convertByteArrayToImage(originalImageBytes, outputImagePath);

            // Convert the new image to byte array to compare
            byte[] newImageBytes = convertImageToByteArray(outputImagePath);

            // Compare the original and new image files
            if (compareImages(originalImageBytes, newImageBytes)) {
                System.out.println("The new image is identical to the original.");
            } else {
                System.out.println("The new image is not identical to the original.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
