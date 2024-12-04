package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Company {
    // ArrayList of employees
    private ArrayList<Employee> employees;

    // Constructor
    public Company() {
        this.employees = new ArrayList<>();
    }

    // Register an employee
    public String createEmployee(String id, String name, double grossSalary) throws Exception {
        if (checkIfEmployeeExists(id)) {
            throw new Exception("Cannot register. ID " + id + " is already registered.");
        } else {
            Employee employee = EmployeeFactory.createEmployee(id, name, grossSalary);
            employees.add(employee);
            return String.format("Employee " + id + " was registered successfully.");
        }
    }

    // Register an intern
    public String createEmployee(String id, String name, double grossSalary, int gpa) throws Exception {
        if (checkIfEmployeeExists(id)) {
            throw new Exception("Cannot register. ID " + id + " is already registered.");
        } else {
            Employee employee = EmployeeFactory.createIntern(id, name, grossSalary, gpa);
            employees.add(employee);
            return String.format("Employee " + id + " was registered successfully.");
        }
    }

    // Register a manager
    public String createEmployee(String id, String name, double grossSalary, String degree) throws Exception {
        if (checkIfEmployeeExists(id)) {
            throw new Exception("Cannot register. ID " + id + " is already registered.");
        } else {
            Employee employee = EmployeeFactory.createManager(id, name, grossSalary, degree);
            employees.add(employee);
            return String.format("Employee " + id + " was registered successfully.");
        }
    }

    // Register a director
    public String createEmployee(String id, String name, double grossSalary, String degree, String department) throws Exception {
        if (checkIfEmployeeExists(id)) {
            throw new Exception("Cannot register. ID " + id + " is already registered.");
        } else {
            Employee employee = EmployeeFactory.createDirector(id, name, grossSalary, degree, department);
            employees.add(employee);
            return String.format("Employee " + id + " was registered successfully.");
        }
    }

    public boolean checkIfEmployeeExists(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Find an employee by ID
    private Employee findEmployeeById(String employeeID) throws Exception {
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeID)) {
                return employee;
            }
        }
        throw new EmployeeNotFound("Employee " + employeeID + " was not registered yet.");
    }

    // Remove an employee by ID
    public String removeEmployee(String employeeID) throws Exception {
        try {
            Employee foundEmployee = findEmployeeById(employeeID);
            employees.remove(foundEmployee);
            return String.format("Employee.Employee %s was successfully removed.", employeeID);

        } catch (EmployeeNotFound e) {
            return String.format(e.getMessage());
        }
    }

    // Update employee name
    public boolean updateEmployeeName(String id, String newName) {
        try {
            Employee foundEmployee = findEmployeeById(id);
            foundEmployee.setName(newName);
            return true;
        } catch (EmployeeNotFound e) {
            System.err.println(e.getMessage());
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Update employee gross salary
    public boolean updateGrossSalary(String id, double newGrossSalary) {
        try {
            Employee foundEmployee = findEmployeeById(id);
            foundEmployee.setGrossSalary(newGrossSalary);
            return true;
        } catch (EmployeeNotFound e) {
            System.err.println(e.getMessage());
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Update manager degree
    public boolean updateManagerDegree(String id, String newDegree) {
        try {
            Employee foundEmployee = findEmployeeById(id);
            if (foundEmployee instanceof Manager) {
                ((Manager) foundEmployee).setDegree(newDegree);
                System.out.println(String.format("Employee.Employee %s was updated successfully", id));
                return true;
            } else {
                System.out.println(String.format("Employee.Employee %s is not a Employee.Employee.Manager", id));
                return false;
            }
        } catch (EmployeeNotFound e) {
            System.err.println(e.getMessage());
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Update director department
    public boolean updateDirectorDept(String id, String newDepartment) {
        try {
            Employee foundEmployee = findEmployeeById(id);
            if (foundEmployee instanceof Director) {
                ((Director) foundEmployee).setDepartment(newDepartment);
                System.out.println(String.format("Employee.Employee %s was updated successfully", id));
                return true;
            } else {
                System.out.println(String.format("Employee.Employee %s is not a Employee.Director", id));
                return false;
            }

        } catch (EmployeeNotFound e) {
            System.err.println(e.getMessage());
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Update intern GPA
    public boolean updateInternGPA(String id, double newGpa) {
        try {
            Employee foundEmployee = findEmployeeById(id);
            if (foundEmployee instanceof Intern) {
                ((Intern) foundEmployee).setGpa(newGpa);
                System.out.println(String.format("Employee.Employee %s was updated successfully", id));
                return true;
            } else {
                System.out.println(String.format("Employee.Employee %s is not an Employee.Employee.Intern", id));
                return false;
            }

        } catch (EmployeeNotFound e) {
            System.err.println(e.getMessage());
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String promoteToManager(String id, String degree) throws Exception {
        Employee employee = findEmployeeById(id);
        String name = employee.getName();
        double grossSalary = employee.getGrossSalary();
        employee = EmployeeFactory.createManager(id, name, grossSalary, degree);
        return String.format("%s promoted successfully to Manager.", id);
    }

    public String promoteToDirector(String id, String degree, String department) throws Exception {
        Employee employee = findEmployeeById(id);
        String name = employee.getName();
        double grossSalary = employee.getGrossSalary();
        employee = EmployeeFactory.createDirector(id, name, grossSalary, degree, department);
        return String.format("%s promoted successfully to Director.", id);
    }

    public String promoteToIntern(String id, int gpa) throws Exception {
        Employee employee = findEmployeeById(id);
        String name = employee.getName();
        double grossSalary = employee.getGrossSalary();
        employee = EmployeeFactory.createIntern(id, name, grossSalary, gpa);
        return String.format("%s promoted successfully to Manager.", id);
    }

    public String printEmployee(String id) throws Exception {
        Employee foundEmployee = findEmployeeById(id);
        return foundEmployee.toString();
    }

    public double getNetSalary(String id) throws Exception {
        Employee foundEmployee = findEmployeeById(id);
        return foundEmployee.getNetSalary();
    }

    // Print all employees registered
    public String printAllEmployees() throws Exception {
        String message = "";
        System.out.println("All registered employees:\n");
        for (Employee employee : employees) {
            message += employee.toString() + "\n";
        }
        return message;
    }

    // Print employees sorted by gross salary
    public String printSortedEmployees() throws Exception {
        String message = "";
        Collections.sort(employees);
        System.out.println("Employees sorted by gross salary (ascending order):" + "\n");
        for (Employee employee : employees) {
            message += employee.toString() + "\n";
        }
        return message;
    }

    // Print sum of net salaries
    public String getTotalNetSalary() throws Exception {
        double sumNetSalaries = 0;
        for (Employee employee : employees) {
            sumNetSalaries += employee.getNetSalary();
        }
        return String.format("Employees sum net salaries: " + sumNetSalaries);
    }

    // Print employees amount per degree
    public Map<String, Integer> mapEachDegree() throws Exception {
        HashMap<String, Integer> degreeMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                String degree = ((Manager) employee).getDegree();
                if (degreeMap.containsKey(degree)) {
                    degreeMap.put(degree, degreeMap.get(degree) + 1);
                } else {
                    degreeMap.put(degree, 1);
                }
            }
        }

        return degreeMap;
    }
}

