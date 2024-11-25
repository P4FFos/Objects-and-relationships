import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private List<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    // Register an employee
    public void registerEmployee(String id, String name, double grossSalary) {
        Employee employee = new Employee(id, name, grossSalary);
        employees.add(employee);
    }

    // Find an employee by ID
    private Employee findEmployeeById(String employeeID) {
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeID)) {
                return employee;
            }
        }
        return null;
    }

    // Remove an employee by ID
    public String removeEmployee(String employeeID) {
        Employee foundEmployee = findEmployeeById(employeeID);
        employees.remove(foundEmployee);
        return String.format("Employee %s was successfully removed.", employeeID);
    }

    // Update employee name
    public boolean updateEmployeeName(String id, String newName) {
        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee != null) {
            foundEmployee.setName(newName);
            return true;
        }
        return false;
    }

    // Update employee gross salary
    public boolean updateEmployeeSalary(String id, double newGrossSalary) {
        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee != null) {
            foundEmployee.setGrossSalary(newGrossSalary);
            return true;
        }
        return false;
    }

    // Print all employees registered
    public void printRegisteredEmployees() {
        System.out.println("All registered employees:\n");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    // Print employees sorted by gross salary
    public void printEmployeesSortedByGrossSalary() {
        Collections.sort(employees);
        System.out.println("Employees sorted by gross salary (ascending order):" + "\n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}