public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Employee em1 = new Employee("ID1", "Bob", 69420);

        System.out.println(em1.toString());
        System.out.println(em1.getNetSalary());
        System.out.println(Util.truncate(em1.getNetSalary()));
    }
}