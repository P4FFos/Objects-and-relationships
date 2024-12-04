package assignment3;

public class EmployeeNotFound extends Exception {
    public EmployeeNotFound(String errorMessage) {
        super(errorMessage);
    }
}