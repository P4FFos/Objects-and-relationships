public class Director extends Manager {
    private String Department;
    private final int bonus = 5000;

    public Director(String id, String name, double grossSalary, String Degree, String Department) {
        super(id, name, grossSalary, Degree);
        this.grossSalary += 5000;
        this.Department = Department;
    }

    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }

    @Override
    public double getNetSalary() {
        if (this.grossSalary < 30000) {
            double netSalary = getGrossSalary() - (getGrossSalary() * GROSS_SALARY_TAX);
        } else if (this.grossSalary >= 30000 && this.grossSalary <= 50000) {
            double netSalary = getGrossSalary() - (getGrossSalary() * 0.8);
        } else if (this.grossSalary > 50000) {
            double netSalary = 30000 * 0.2 + (getGrossSalary() - 30000) * 0.4;
        }
        return 0;
    }

    public String toString() {
        return super.toString() + "Dept:" + getDepartment();
    }
}
