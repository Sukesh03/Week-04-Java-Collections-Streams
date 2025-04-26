import java.util.*;

enum Department {
    HR, IT, SALES
}

class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByProperty {

    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> departmentMap = new HashMap<>();

        for (Employee employee : employees) {
            departmentMap
                    .computeIfAbsent(employee.department, k -> new ArrayList<>())
                    .add(employee);
        }

        return departmentMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", Department.HR));
        employees.add(new Employee("Bob", Department.IT));
        employees.add(new Employee("Carol", Department.HR));

        Map<Department, List<Employee>> groupedEmployees = groupByDepartment(employees);

        groupedEmployees.forEach((department, empList) -> {
            System.out.println(department + ": " + empList);
        });
    }
}
