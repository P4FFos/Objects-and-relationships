package assignment3;

public class Intern extends Employee {
    // Attributes
    private int gpa;

    // Constructor
    public Intern(String id, String name, double grossSalary, int gpa) {
        super(id, name, grossSalary);
        this.gpa = gpa;
    }

    // Getters
    public int getGpa() {
        return this.gpa;
    }

    // Setters
    public void setGpa(int newGpa) {
        this.gpa = newGpa;
        getGrossSalary();
    }

    // Calculate gross salary
    @Override
    public double getGrossSalary() {
        double totalGrossSalary = 0;
        if (this.gpa <= 5) {
            totalGrossSalary = 0;
        } else if (5 < this.gpa && this.gpa < 8) {
            totalGrossSalary = this.grossSalary;
        } else if (8 <= this.gpa && this.gpa <= 10) {
            totalGrossSalary = this.grossSalary + 1000;
        } else {
            System.out.println("Invalid GPA");
        }
        return Util.truncate(totalGrossSalary);
    }

    // Get Net Salary
    @Override
    public double getNetSalary() {
        double netSalary = getGrossSalary();
        return netSalary;
    }

    // toString method to print the object in a specific format
    public String toString() {
        return super.toString() + " GPA: " + getGpa();
    }
}
