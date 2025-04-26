import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Salary: $" + salary;
    }
}

public class SortPersonListApp {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Alice", 30, 50000),
                new Person("Bob", 24, 55000),
                new Person("Charlie", 35, 60000),
                new Person("David", 28, 65000)
        );

        List<Person> sortedByAge = persons.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .collect(Collectors.toList());

        System.out.println("Sorted by Age:");
        sortedByAge.forEach(System.out::println);
    }
}
