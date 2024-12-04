package assignment3;

public class Director extends Manager {
    // Attributes
    private String department;
    private final static int BONUS = 5000;

    // Constructor
    public Director(String id, String name, double grossSalary, String Degree, String Department) {
        super(id, name, grossSalary, Degree);
        this.department = Department;
    }

    // Getters
    public String getDepartment() {
        return this.department;
    }

    public String getDegree() {
        return super.getDegree();
    }

    // Setters
    public void setDepartment(String newDepartment) {
        this.department = newDepartment;
    }

    @Override
    public double getGrossSalary() {
        double grossSalaryWithBonus = 0;
        switch (getDegree()) {
            case "BSc":
                grossSalaryWithBonus = (this.grossSalary * 1.1) + BONUS;
                break;
            case "MSc":
                grossSalaryWithBonus = (this.grossSalary * 1.2) + BONUS;
                break;
            case "PhD":
                grossSalaryWithBonus = (this.grossSalary * 1.35) + BONUS;
                break;
            default:
                System.out.println("Invalid Degree");
                break;
        }
        return Util.truncate(grossSalaryWithBonus);
    }

    // Get Net Salary
    @Override
    public double getNetSalary() {
        double netSalary = 0;
        if (getGrossSalary() < 30000) {
            netSalary = getGrossSalary() - (this.getGrossSalary() * super.GROSS_SALARY_TAX);
        } else if (getGrossSalary() >= 30000 && getGrossSalary() <= 50000) {
            netSalary = getGrossSalary() - (getGrossSalary() * 0.2);
        } else if (getGrossSalary() > 50000) {
            netSalary = getGrossSalary() - (30000 * 0.2 + (getGrossSalary() - 30000) * 0.4);
        }
        return netSalary;
    }

    // toString method to print the object in a specific format
    @Override
    public String toString() {
        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", this.getDegree(), this.getName(), this.getGrossSalary(), this.getDepartment());
        //PhD Ricky's gross salary is 36725.00 SEK per month. Dept: Human Resources
    }
}
