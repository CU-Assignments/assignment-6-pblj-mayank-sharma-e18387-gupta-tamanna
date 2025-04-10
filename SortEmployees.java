import java.util.*;

// Assuming your Employee class looks something like this:
class Employee {
    private String name;
    private int age;
    private double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    // toString method to display employee info
    @Override
    public String toString() {
        return name + " | Age: " + age + " | Salary: ₹" + salary;
    }
}

public class SortEmployees {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ravi", 30, 45000));
        employees.add(new Employee("Anjali", 25, 55000));
        employees.add(new Employee("Manoj", 35, 50000));

        // Sort by Name
        System.out.println("Sorted by Name:");
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        employees.forEach(System.out::println);

        // Sort by Age
        System.out.println("\nSorted by Age:");
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        employees.forEach(System.out::println);

        // Sort by Salary
        System.out.println("\nSorted by Salary:");
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        employees.forEach(System.out::println);
    }
}
