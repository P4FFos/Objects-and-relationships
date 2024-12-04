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
        if (id.isEmpty()) {
            throw new Exception("ID cannot be blank.");
        } else if (name.isBlank()) {
            throw new Exception("Name cannot be blank.");
        } else if (grossSalary < 0){
            throw new Exception("Salary must be greater than zero.");
        }
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
        if (id.isEmpty()) {
            throw new Exception("ID cannot be blank.");
        } else if (name.isBlank()) {
            throw new Exception("Name cannot be blank.");
        } else if (grossSalary < 0){
            throw new Exception("Salary must be greater than zero.");
        } else if (gpa < 0) {
            throw new Exception("-5 outside range. Must be between 0-10.");
        }
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
        if (id.isEmpty()) {
            throw new Exception("ID cannot be blank.");
        } else if (name.isBlank()) {
            throw new Exception("Name cannot be blank.");
        } else if (grossSalary < 0){
            throw new Exception("Salary must be greater than zero.");
        } else if ((!"MSc".equals(degree)) && (!"PhD".equals(degree)) && (!"BSc".equals(degree))) {
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
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
        if (id.isEmpty()) {
            throw new Exception("ID cannot be blank.");
        } else if (name.isBlank()) {
            throw new Exception("Name cannot be blank.");
        } else if (grossSalary < 0){
            throw new Exception("Salary must be greater than zero.");
        } else if ((!"MSc".equals(degree)) && (!"PhD".equals(degree)) && (!"BSc".equals(degree))) {
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        } else if ((!"Business".equals(department)) && (!"Human Resources".equals(department)) && (!"Technical".equals(department))) {
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }
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
        Employee foundEmployee = findEmployeeById(employeeID);
        employees.remove(foundEmployee);
        return String.format("Employee %s was successfully removed.", employeeID);
    }

    // Update employee name
    public String updateEmployeeName(String id, String newName) throws Exception{
        String message = "";
        if (newName.isEmpty()) {
            throw new Exception("Name cannot be blank.");
        }
        Employee foundEmployee = findEmployeeById(id);
        foundEmployee.setName(newName);
        message = "Employee " + id + " was updated successfully";
        return message;
    }

    // Update employee gross salary
    public String updateGrossSalary(String id, double newGrossSalary) throws Exception{
        String message = "";
        if (newGrossSalary <= 0) {
            throw new Exception("Salary must be greater than zero.");
        }
        Employee foundEmployee = findEmployeeById(id);
        foundEmployee.setGrossSalary(newGrossSalary);
        message = "Employee " + id + " was updated successfully";

        return message;
    }

    // Update manager degree
    public String updateManagerDegree(String id, String newDegree) throws Exception{
        String message = "";
        if (id.isEmpty()) {
            throw new Exception("ID cannot be blank.");
        } else if ((!"MSc".equals(newDegree)) && (!"PhD".equals(newDegree)) && (!"BSc".equals(newDegree))) {
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee instanceof Manager) {
            ((Manager) foundEmployee).setDegree(newDegree);
            message = "Employee " + id + " was updated successfully";
        } else {
            System.out.println(String.format("Employee.Employee %s is not a Employee.Employee.Manager", id));
        }
        return message;
    }

    // Update director department
    public String updateDirectorDept(String id, String newDepartment) throws Exception{
        String message = "";
        if (id.isEmpty()) {
            throw new Exception("ID cannot be blank.");
        } else if ((!"Business".equals(newDepartment)) && (!"Human Resources".equals(newDepartment)) && (!"Technical".equals(newDepartment))) {
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }
        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee instanceof Director) {
            ((Director) foundEmployee).setDepartment(newDepartment);
            message = "Employee " + id + " was updated successfully";
        } else {
            System.out.println(String.format("Employee.Employee %s is not a Employee.Director", id));
        }

        return message;
    }

    // Update intern GPA
    public String updateInternGPA(String id, int newGpa) throws Exception{
        String message = "";
        if (id.isEmpty()) {
            throw new Exception("ID cannot be blank.");
        }  else if (newGpa > 10) {
            throw new Exception("15 outside range. Must be between 0-10.");
        }
        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee instanceof Intern) {
            ((Intern) foundEmployee).setGpa(newGpa);
            message = "Employee " + id + " was updated successfully";
        } else {
            System.out.println(String.format("Employee.Employee %s is not an Employee.Employee.Intern", id));
        }
        return message;
    }

    public String promoteToManager(String id, String degree) throws Exception {
        Employee employee = findEmployeeById(id);
        String name = employee.getName();
        double grossSalary = employee.grossSalary;
        employees.remove(employee);
        employee = EmployeeFactory.createManager(id, name, grossSalary, degree);
        employees.add(employee);
        return String.format("%s promoted successfully to Manager.", id);
    }

    public String promoteToDirector(String id, String degree, String department) throws Exception {
        Employee employee = findEmployeeById(id);
        String name = employee.getName();
        double grossSalary = employee.grossSalary;
        employees.remove(employee);
        employee = EmployeeFactory.createDirector(id, name, grossSalary, degree, department);
        employees.add(employee);
        return String.format("%s promoted successfully to Director.", id);
    }

    public String promoteToIntern(String id, int gpa) throws Exception {
        Employee employee = findEmployeeById(id);
        String name = employee.getName();
        double grossSalary = employee.grossSalary;
        employees.remove(employee);
        employee = EmployeeFactory.createIntern(id, name, grossSalary, gpa);
        employees.add(employee);
        return String.format("%s promoted successfully to Intern.", id);
    }

    public String printEmployee(String id) throws Exception {
        Employee foundEmployee = findEmployeeById(id);
        return foundEmployee.toString();
    }

    public double getNetSalary(String id) throws Exception {
        Employee foundEmployee = findEmployeeById(id);
        return Util.truncate(foundEmployee.getNetSalary());
    }

    // Print all employees registered
    public String printAllEmployees() throws Exception {
        String message = "All registered employees:" + System.lineSeparator();
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                message += employee.toString() + System.lineSeparator();
            }
        } else {
            throw new Exception("No employees registered yet.");
        }
        return message;
    }

    // Print employees sorted by gross salary
    public String printSortedEmployees() throws Exception {
        String message = "Employees sorted by gross salary (ascending order):" + System.lineSeparator();
        Collections.sort(employees);
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                message += employee.toString() + System.lineSeparator();
            }
        } else {
            throw new Exception("No employees registered yet.");
        }
        return message;
    }

    // Print sum of net salaries
    public double getTotalNetSalary() throws Exception {
        double sumNetSalaries = 0;
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                sumNetSalaries += employee.getNetSalary();
            }
        } else {
            throw new Exception("No employees registered yet.");
        }
        return Util.truncate(sumNetSalaries);
    }

    // Print employees amount per degree
    public Map<String, Integer> mapEachDegree() throws Exception {
        HashMap<String, Integer> degreeMap = new HashMap<>();
        if (!employees.isEmpty()) {
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
        } else {
            throw new Exception ("No employees registered yet.");
        }
        return degreeMap;
    }
}

