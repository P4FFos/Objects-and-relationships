package assignment3;

public class Intern extends Employee {
    // Attributes
    private double gpa;

    // Constructor
    public Intern(String id, String name, double grossSalary, double gpa) {
        super(id, name, grossSalary);
        this.gpa = gpa;
        getGrossSalary();
    }

    // Getters
    public double getGpa() {
        return gpa;
    }

    // Setters
    public void setGpa(double newGpa) {
        this.gpa = newGpa;
        getGrossSalary();
    }

    // Calculate gross salary
    @Override
    public double getGrossSalary() {
        if (this.gpa <= 5) {
            super.setGrossSalary(0);
        } else if (5 < this.gpa && this.gpa  < 8) {
            super.setGrossSalary(getGrossSalary());
        } else if (8 <= this.gpa && this.gpa <= 10) {
            super.setGrossSalary(getGrossSalary() + 1000);
        } else {
            System.out.println("Invalid GPA");
        }
        return 0;
    }

    // Get Net Salary
    @Override
    public double getNetSalary() {
        double netSalary = getGrossSalary();
        return Util.truncate(netSalary);
    }

    // toString method to print the object in a specific format
    public String toString() {
        return super.toString() + "GPA: " + getGpa();
    }
}
