// material from DIT033 2023, University of Gothenburg and Chalmers University of Technology
// reused for DIT044 2024, University of Gothenburg and Chalmers University of Technology

package employeetests;

import assignment3.Company;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Epic1US7and8Test {

    private static final String EOL = System.lineSeparator();
    private Company facade;

    @BeforeAll
    public static void setupSystem(){
        Locale.setDefault(Locale.US);
    }

    @BeforeEach
    public void setupFacade(){
        facade = new Company();

        try{
            // 2 employees, 2 directors, 1 manager, 3 interns
            // G: Gross salary; N: Net salary
            facade.createEmployee("Emp1", "Elektra", 35000.50, "MSc", "Business");       // G: 47000.60; N: 37600.48
            facade.createEmployee("Emp2", "Blanca", 45000.00, "PhD", "Human Resources"); // G: 65750.00; N: 45450.00
            facade.createEmployee("Emp3", "Pray Tell", 25000.25, "BSc");                 // G: 27500.27; N: 24750.24
            facade.createEmployee("Emp4", "Lulu", 20000.00, 9);                          // G: 21000.00; N: 21000.00
            facade.createEmployee("Emp5", "Angel", 28500.10, 7);                         // G: 28500.10; N: 28500.10
            facade.createEmployee("Emp6", "Candy", 35000.50, 4);                         // G:     0.00; N:     0.00
            facade.createEmployee("Emp7", "Ricky", 23500.00);                            // G: 23500.00; N: 21150.00
            facade.createEmployee("Emp8", "Damon", 22100.00);                            // G: 22100.00; N: 19890.00
        }catch(Exception e){
            assertFalse(true); // Forces an error in the test. The creation should work without problems.
        }
    }

    @Test
    public void shouldGetTotalNetSalary() throws Exception {
        double expectedTotal = 198340.82;
        assertEquals(expectedTotal, facade.getTotalNetSalary());
    }

    @Test
    public void shouldGetSortedEmployees() throws Exception {
        String expectedPrint = "Employees sorted by gross salary (ascending order):" + EOL +
                "Candy's gross salary is 0.00 SEK per month. GPA: 4"      + EOL +
                "Lulu's gross salary is 21000.00 SEK per month. GPA: 9"   + EOL +
                "Damon's gross salary is 22100.00 SEK per month."         + EOL +
                "Ricky's gross salary is 23500.00 SEK per month."         + EOL +
                "BSc Pray Tell's gross salary is 27500.27 SEK per month." + EOL +
                "Angel's gross salary is 28500.10 SEK per month. GPA: 7"  + EOL +
                "MSc Elektra's gross salary is 47000.60 SEK per month. Dept: Business" + EOL +
                "PhD Blanca's gross salary is 65750.00 SEK per month. Dept: Human Resources" + EOL;

        assertEquals(expectedPrint, facade.printSortedEmployees());
    }
}
