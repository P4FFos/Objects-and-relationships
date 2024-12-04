public class Manager extends Employee {
    private static String Degree;

    public Manager(String id, String name, double grossSalary, String Degree) {
        super(id, name, grossSalary);
        Manager.Degree = Degree;
        getGrossSalary();
    }

    public static String getDegree() {
        return Degree;
    }
    public void setDegree(String degree) {
        Degree = Degree;
        getGrossSalary();
    }

    @Override
    public double getGrossSalary() {
        if (Degree == "BSc") {
            super.setGrossSalary(getGrossSalary() + getGrossSalary() * 0.1);
        } else if (Degree == "MSc") {
            super.setGrossSalary(getGrossSalary() + getGrossSalary() * 0.2);
        } else if (Degree == "PhD") {
            super.setGrossSalary(getGrossSalary() + getGrossSalary() * 0.35);
        } else {
            System.out.println("Invalid Degree");
        }
        return 0;
    }
}

