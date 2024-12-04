package assignment3;

public class Director extends Manager {
    // Attributes
    private String department;
    private final static int BONUS = 5000;

    // Constructor
    public Director(String id, String name, double grossSalary, String Degree, String Department) {
        super(id, name, grossSalary, Degree);
        this.grossSalary = Util.truncate(grossSalary + BONUS);
        this.department = Department;
    }

    // Getters
    public String getDepartment() {
        return department;
    }

    // Setters
    public void setDepartment(String newDepartment) {
        department = newDepartment;
    }

    // Get Net Salary
    @Override
    public double getNetSalary() {
        double netSalary = 0;
        if (this.grossSalary < 30000) {
            netSalary = Util.truncate(getGrossSalary() - (getGrossSalary() * GROSS_SALARY_TAX));
        } else if (this.grossSalary >= 30000 && this.grossSalary <= 50000) {
            netSalary = Util.truncate(getGrossSalary() - (getGrossSalary() * 0.8));
        } else if (this.grossSalary > 50000) {
            netSalary = Util.truncate(30000 * 0.2 + (getGrossSalary() - 30000) * 0.4);
        }
        return netSalary;
    }

    // toString method to print the object in a specific format
    public String toString() {
        return super.toString() + "Dept:" + getDepartment();
    }
}
