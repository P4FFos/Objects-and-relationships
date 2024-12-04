public class Employee implements Comparable<Employee> {
    private String id;
    private String name;
    protected double grossSalary;
    protected static final double GROSS_SALARY_TAX = 0.1;

    public Employee(String id, String name, double grossSalary) {
        this.id = id;
        this.name = name;
        this.grossSalary = Util.truncate(grossSalary);
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getNetSalary() {
        double netSalary = getGrossSalary() - (getGrossSalary() * GROSS_SALARY_TAX);
        return netSalary;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    //String representations
    @Override
    public String toString() {
        return String.format("%s's gross salary is %f SEK per month", this.name, this.grossSalary);
    }

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
