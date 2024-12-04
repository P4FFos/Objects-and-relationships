public class Intern extends Employee {
    private double Gpa;

    public Intern(String id, String name, double grossSalary, double Gpa) {
        super(id, name, grossSalary);
        this.Gpa = Gpa;
        getGrossSalary();
    }

    public double getGpa() {
        return Gpa;
    }
    public void setGpa(double Gpa) {
        this.Gpa = Gpa;
        getGrossSalary();
    }

    @Override
    public double getGrossSalary() {
        if (this.Gpa <= 5) {
            super.setGrossSalary(0);
        } else if (5 < this.Gpa && this.Gpa  < 8) {
            //Doesn't change the gross salary
        } else if (8 <= this.Gpa && this.Gpa <= 10) {
            super.setGrossSalary(getGrossSalary() + 1000);
        } else {
            System.out.println("Invalid GPA");
        }
        return 0;
    }

    public String toString() {
        return super.toString() + "GPA: " + getGpa();
    }

    @Override
    public double getNetSalary() {
        double netSalary = getGrossSalary();
        return Util.truncate(netSalary);
    }
}
