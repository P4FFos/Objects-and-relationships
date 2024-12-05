package assignment3;

public class Manager extends Employee {
    // Attributes
    private String degree;

    // Constructor
    public Manager(String employeeId, String name, double grossSalary, String degree) {
        super(employeeId, name, grossSalary);
        this.degree = degree;
    }

    // Getters
    public String getDegree() {
        return this.degree;
    }

    // Setters
    public void setDegree(String newDegree) {
        this.degree = newDegree;
        this.getGrossSalary();
    }

    // Calculate gross salary
    @Override
    public double getGrossSalary() {
        double grossSalaryWithBonus = 0;
        switch (getDegree()) {
            case "BSc":
                grossSalaryWithBonus = (this.grossSalary * 1.1);
                break;
            case "MSc":
                grossSalaryWithBonus = (this.grossSalary * 1.2);
                break;
            case "PhD":
                grossSalaryWithBonus = (this.grossSalary * 1.35);
                break;
            default:
                System.out.println("Invalid Degree");
                break;
        }
        return Util.truncate(grossSalaryWithBonus);
    }

    @Override
    public String toString() {
        return String.format("%s %s's gross salary is %.2f SEK per month.", this.degree, this.getName(), this.getGrossSalary());
    }
}

