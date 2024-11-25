import java.util.ArrayList;
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
    public boolean removeEmployee(String id) {
        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee != null) {
            employees.remove(foundEmployee);
            return true;
        }
        return false;
    }

    // Update an employee's name
    public boolean updateEmployeeName(String id, String newName) {
        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee != null) {
            foundEmployee.setName(newName);
            return true;
        }
        return false;
    }

    // Update an employee's gross salary
    public boolean updateEmployeeSalary(String id, double newGrossSalary) {
        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee != null) {
            foundEmployee.setGrossSalary(newGrossSalary);
            return true;
        }
        return false;
    }
}