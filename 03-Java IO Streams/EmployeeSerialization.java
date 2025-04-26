import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class implements Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Ensure version compatibility during deserialization

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Method to display employee information
    public void displayEmployeeInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class EmployeeSerialization {

    // Method to serialize employee list to a file
    public static void serializeEmployees(List<Employee> employees, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees); // Serialize the list of employees
            System.out.println("Employee list serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize employee list from a file
    public static List<Employee> deserializeEmployees(String filename) {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            employees = (List<Employee>) ois.readObject(); // Deserialize the list of employees
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }

    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "Engineering", 75000));
        employees.add(new Employee(2, "Jane Smith", "Marketing", 65000));
        employees.add(new Employee(3, "David Brown", "Finance", 80000));

        // Serialize the employee list to a file
        String filename = "employees.ser";
        serializeEmployees(employees, filename);

        // Deserialize the employee list from the file
        List<Employee> deserializedEmployees = deserializeEmployees(filename);

        // Display deserialized employees
        if (deserializedEmployees != null) {
            System.out.println("\nDeserialized Employee List:");
            for (Employee emp : deserializedEmployees) {
                emp.displayEmployeeInfo();
            }
        }
    }
}
