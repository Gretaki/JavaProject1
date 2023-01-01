import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgramTest {

    @Test
    void testRunProgramQuitsWithXInserted() throws IOException {
        Scanner sc = new Scanner("""
            x
            """);
        Program.runProgram(sc);
    }

    @Test
    void testRunProgramQuitsWithIncomeInserted() throws IOException {
        Scanner sc = new Scanner("""
            1
            2
            2010-01-01
            salary
            someIncomeType
            yes
            -
            3
            x
            """);
        Budget budget = Program.runProgram(sc);

        assertEquals(1, budget.getIncomes().size());
    }

    @Test
    void testRunProgramQuitsWithExpenseInserted() throws IOException {
        Scanner sc = new Scanner("""
            2
            2
            2010-01-01 10:00
            car
            card
            someExpenseType
            -
            4
            x
            """);
        Budget budget = Program.runProgram(sc);

        assertEquals(1, budget.getExpenses().size());
    }

    @Test
    void testRunProgramReturnsCorrectBalance() throws IOException {
        Scanner sc = new Scanner("""
            1\n2.5\n2010-01-01\nsalary\nsomeIncomeType\nyes\n-
            2\n3\n2010-01-01 10:00\ncar\ncard\n\n-
            5
            x
            """);
        Budget budget = Program.runProgram(sc);

        assertEquals(-0.5, budget.balance());
    }

    @Test
    void testRunProgramReadsFromFile() throws IOException {
        Scanner sc = new Scanner("""
            10
            Example.csv
            x
            """);
        Budget budget = Program.runProgram(sc);

        assertEquals(2, budget.getExpenses().size() + budget.getIncomes().size());
    }
}
