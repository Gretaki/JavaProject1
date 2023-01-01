import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgramTest {

    @Test
    void testRunProgramQuitsWithXInserted() {
        Scanner sc = new Scanner("""
            x
            """);
        Program.runProgram(sc);
    }

    @Test
    void testRunProgramQuitsWithIncomeInserted() {
        Scanner sc = new Scanner("""
            1
            2
            2010-01-01
            salary
            yes
            -
            3
            x
            """);
        Budget budget = Program.runProgram(sc);
        
        assertEquals(1, budget.getIncomes().length);
    }

    @Test
    void testRunProgramQuitsWithExpenseInserted() {
        Scanner sc = new Scanner("""
            2
            2
            2010-01-01 10:00
            car
            card
            -
            4
            x
            """);
        Budget budget = Program.runProgram(sc);

        assertEquals(1, budget.getExpenses().length);
    }
}
