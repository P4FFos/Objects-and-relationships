package Root;

public class Manager extends Employee {
    // Attributes
    private String degree;

    // Constructor
    public Manager(String id, String name, double grossSalary, String degree) {
        super(id, name, grossSalary);
        this.degree = degree;
        getGrossSalary();
    }

    // Getters
    public String getDegree() {
        return degree;
    }

    // Setters
    public void setDegree(String newDegree) {
        degree = newDegree;
        getGrossSalary();
    }

    // Calculate gross salary
    @Override
    public double getGrossSalary() {
        if (degree.equals("BSc")) {
            super.setGrossSalary(Util.truncate(getGrossSalary() + getGrossSalary() * 0.1));
        } else if (degree.equals("MSc")) {
            super.setGrossSalary(Util.truncate(getGrossSalary() + getGrossSalary() * 0.2));
        } else if (degree.equals("PhD")) {
            super.setGrossSalary(Util.truncate(getGrossSalary() + getGrossSalary() * 0.35));
        } else {
            System.out.println("Invalid Degree");
        }
        return 0;
    }
}

