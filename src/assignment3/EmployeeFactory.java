package assignment3;

public class EmployeeFactory {
    // Factory method to create an employee
    public static Employee createEmployee(String employeeId, String name, double grossSalary){
        return new Employee(employeeId, name, grossSalary);
    }

    // Factory method to create intern
    public static Employee createIntern(String employeeId, String name, double grossSalary, int gpa){
        return new Intern(employeeId, name, grossSalary, gpa);
    }

    // Factory method to create manager
    public static Employee createManager(String employeeId, String name, double grossSalary, String degree){
        return new Manager(employeeId, name, grossSalary, degree);
    }

    // Factory method to create director
    public static Employee createDirector(String employeeId, String name, double grossSalary, String degree, String department){
        return new Director(employeeId, name, grossSalary, degree, department);
    }
}
