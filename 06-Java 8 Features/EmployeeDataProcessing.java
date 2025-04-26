import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDataProcessing {

    // Inner Employee class
    static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return name + " (" + department + ") - $" + salary;
        }
    }

    // Method to process employee data
    public static Map<String, Double> processEmployees(List<Employee> employees) {
        // Step 1 & 2: Filter and sort
        List<Employee> filteredSorted = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Engineering") && e.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        // Step 3 & 4: Group by department and calculate average salary
        return filteredSorted.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    // Main method for testing
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 85000),
                new Employee(2, "Bob", "Engineering", 95000),
                new Employee(3, "Carol", "HR", 60000),
                new Employee(4, "Dave", "Engineering", 75000),
                new Employee(5, "Eve", "Engineering", 90000),
                new Employee(6, "Frank", "Marketing", 88000)
        );

        Map<String, Double> averageSalaries = processEmployees(employees);

        System.out.println("Average salary per department (after filtering):");
        averageSalaries.forEach((dept, avg) ->
                System.out.println(dept + " → $" + avg));
    }
}
