package Root;

import java.util.ArrayList;
import java.util.Collections;

public class Company {
    // ArrayList of employees
    private ArrayList<Employee> employees;

    // Constructor
    public Company() {
        this.employees = new ArrayList<>();
    }

    // Register an employee
    public void registerEmployee(String id, String name, double grossSalary) {
        Employee employee = EmployeeFactory.createEmployee(id, name, grossSalary);
        employees.add(employee);
    }

    // Register an intern
    public void registerIntern(String id, String name, double grossSalary, int gpa) {
        Employee employee = EmployeeFactory.createIntern(id, name, grossSalary, gpa);
        employees.add(employee);
    }

    // Register a manager
    public void registerManager(String id, String name, double grossSalary, String degree) {
        Employee employee = EmployeeFactory.createManager(id, name, grossSalary, degree);
        employees.add(employee);
    }

    // Register a director
    public void registerDirector(String id, String name, double grossSalary, String degree, String department) {
        Employee employee = EmployeeFactory.createDirector(id, name, grossSalary, degree, department);
        employees.add(employee);
    }

    // Find an employee by ID
    private Employee findEmployeeById(String employeeID) throws EmployeeNotFound {
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeID)) {
                return employee;
            } 
        }
        throw new EmployeeNotFound("Root " + employeeID + " was not registered yet.");
    }

    // Remove an employee by ID
    public String removeEmployee(String employeeID) {
        try {
            Employee foundEmployee = findEmployeeById(employeeID);
            employees.remove(foundEmployee);
            return String.format("Employee.Employee %s was successfully removed.", employeeID);
            
        } catch (EmployeeNotFound e) {
            return String.format("Error: " + e.getMessage());
        }
    }

    // Update employee name
    public boolean updateEmployeeName(String id, String newName) {
        try {
            Employee foundEmployee = findEmployeeById(id);
            foundEmployee.setName(newName);
            return true;
        } catch (EmployeeNotFound e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    // Update employee gross salary
    public boolean updateEmployeeSalary(String id, double newGrossSalary) {
        try {
            Employee foundEmployee = findEmployeeById(id);
            foundEmployee.setGrossSalary(newGrossSalary);
            return true;
        } catch (EmployeeNotFound e) {
            System.err.println("Error: " + e.getMessage());
            return false;
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
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    // Update director department
    public boolean updateDirectorDepartment(String id, String newDepartment) {
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
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    // Update intern GPA
    public boolean updateInternGpa(String id, double newGpa) {
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
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    // Print all employees registered
    public void printRegisteredEmployees() {
        System.out.println("All registered employees:\n");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    // Print employees sorted by gross salary
    public void sortByGrossSalary() {
        Collections.sort(employees);
        System.out.println("Employees sorted by gross salary (ascending order):" + "\n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Print sum of net salaries
    public void printSumNetSalaries() {
        double sumNetSalaries = 0;
        for (Employee employee : employees) {
            sumNetSalaries += employee.getNetSalary(); }
            System.out.println("Employees sum net salaries: " + sumNetSalaries);
    }

    // Print employees amount per degree
    public void printEmployeesPerDegree() {
        int BScAmount = 0;
        int MScAmount = 0;
        int PhdAmount = 0;
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                String degree = ((Manager) employee).getDegree();
                if (degree.equals("BSc")) {
                    BScAmount++;
                } else if (degree.equals("MSc")) {
                    MScAmount++;
                } else if (degree.equals("PhD")) {
                    PhdAmount++;
                }
            }
        }
        if (BScAmount > 0) {
            System.out.println("BSc: => " + BScAmount);
        } else if (MScAmount > 0) {
            System.out.println("MSc: => " + MScAmount);
        } else if (PhdAmount > 0) {
            System.out.println("Phd: => " + PhdAmount);
        }
    }
}

