package Root;

public class EmployeeFactory {
    public static Employee createEmployee(String id, String name, double grossSalary){
        return new Employee(id, name, grossSalary);
    }

    public static Employee createIntern(String id, String name, double grossSalary, int gpa){
        return new Intern(id, name, grossSalary, gpa);
    }

    public static Employee createManager(String id, String name, double grossSalary, String degree){
        return new Manager(id, name, grossSalary, degree);
    }

    public static Employee createDirector(String id, String name, double grossSalary, String degree, String department){
        return new Director(id, name, grossSalary, degree, department);
    }
}
