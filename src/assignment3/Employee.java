package assignment3;

public class Employee implements Comparable<Employee> {
    // Attributes
    private String id;
    private String name;
    protected double grossSalary;
    protected static final double GROSS_SALARY_TAX = 0.1;

    // Constructor
    public Employee(String id, String name, double grossSalary) {
        this.id = id;
        this.name = name;
        this.grossSalary = Util.truncate(grossSalary);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return Util.truncate(grossSalary);
    }

    public double getNetSalary() {
        double netSalary = getGrossSalary() - (getGrossSalary() * GROSS_SALARY_TAX);
        return Util.truncate(netSalary);
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
        return String.format("%s's gross salary is %f SEK per month", this.name, getGrossSalary());
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
