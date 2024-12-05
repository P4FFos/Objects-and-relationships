package assignment3;

public class Employee implements Comparable<Employee> {
    // Attributes
    private String employeeId;
    private String name;
    protected double grossSalary;
    protected static final double GROSS_SALARY_TAX = 0.1;

    // Constructor
    public Employee(String employeeId, String name, double grossSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.grossSalary = Util.truncate(grossSalary);
    }

    // Getters
    public String getId() {
        return this.employeeId;
    }

    public String getName() {
        return this.name;
    }

    public double getGrossSalary() {
        return this.grossSalary;
    }

    public double getNetSalary() {
        double netSalary = getGrossSalary() - (getGrossSalary() * GROSS_SALARY_TAX);
        return netSalary;
    }

    // Setters
    public void setName(String newName) {
        this.name = newName;
    }

    public void setGrossSalary(double newGrossSalary) {
        this.grossSalary = Util.truncate(newGrossSalary);
    }

    // String representations
    @Override
    public String toString() {
        return String.format("%s's gross salary is %.2f SEK per month.", this.name, this.getGrossSalary());
    }

    // Compare two employees by their gross salary
    @Override
    public int compareTo(Employee anotherEmployee) {
        if (this.getGrossSalary() > anotherEmployee.getGrossSalary()) {
            return 1;
        } else if (this.getGrossSalary() == anotherEmployee.getGrossSalary()) {
            return 0;
        } else {
            return -1;
        }
    }
}
