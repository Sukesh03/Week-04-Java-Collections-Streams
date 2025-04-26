import java.io.*;

class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

public class StudentDataHandler {

    // Method to store student details in a binary file
    public static void storeStudentDetails(String filePath) throws IOException {
        // Create DataOutputStream to write primitive data
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            // Write sample student details to the file
            dataOutputStream.writeInt(1);  // Roll number
            dataOutputStream.writeUTF("John Doe");  // Name
            dataOutputStream.writeDouble(3.8);  // GPA

            dataOutputStream.writeInt(2);  // Roll number
            dataOutputStream.writeUTF("Jane Smith");  // Name
            dataOutputStream.writeDouble(3.9);  // GPA

            dataOutputStream.writeInt(3);  // Roll number
            dataOutputStream.writeUTF("Alice Brown");  // Name
            dataOutputStream.writeDouble(3.5);  // GPA

            System.out.println("Student details have been written to the file.");
        }
    }

    // Method to retrieve and display student details from the binary file
    public static void retrieveStudentDetails(String filePath) throws IOException {
        // Create DataInputStream to read primitive data
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {
            while (dataInputStream.available() > 0) {
                // Read student details from the file
                int rollNumber = dataInputStream.readInt();
                String name = dataInputStream.readUTF();
                double gpa = dataInputStream.readDouble();

                // Display the student details
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("GPA: " + gpa);
                System.out.println("---------------------------");
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "students.dat"; // Binary file to store student details

        try {
            // Store student details in the binary file
            storeStudentDetails(filePath);

            // Retrieve and display student details from the binary file
            System.out.println("\nRetrieving student details from the file...");
            retrieveStudentDetails(filePath);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
