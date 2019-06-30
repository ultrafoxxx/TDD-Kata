import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUpTests(){
        calculator = new Calculator();
    }

    @Test
    public void checkForEmptyString(){

        String argument = "";
        int expectedOutcome = 0;

        int result = calculator.add(argument);

        Assert.assertEquals(expectedOutcome, result);

    }

    @Test
    public void checkForOneNumber(){
        String argument = "2";
        int expectedOutcome = 2;

        int result = calculator.add(argument);

        Assert.assertEquals(expectedOutcome, result);
    }

    @Test
    public void checkForTwoNumbers(){
        String argument = "2,5";
        int expectedOutcome = 7;

        int result = calculator.add(argument);

        Assert.assertEquals(expectedOutcome, result);
    }

    @Test
    public void checkForThreeNumbers(){
        String argument = "2,5,7";
        int expectedOutcome = 14;

        int result = calculator.add(argument);

        Assert.assertEquals(expectedOutcome, result);
    }

    @Test
    public void checkForThreeNumbersWithEnter(){
        String argument = "2\n5\n7";
        int expectedOutcome = 14;

        int result = calculator.add(argument);

        Assert.assertEquals(expectedOutcome, result);
    }

    @Test
    public void checkForThreeNumbersWithEnterAndComa(){
        String argument = "2,5\n7";
        int expectedOutcome = 14;

        int result = calculator.add(argument);

        Assert.assertEquals(expectedOutcome, result);
    }

    @Test
    public void checkForThreeNumbersWithSemicolon(){
        String argument = "//;\n2;5;7";
        int expectedOutcome = 14;

        int result = calculator.add(argument);

        Assert.assertEquals(expectedOutcome, result);
    }

    @Test
    public void checkForThreeNumbersWithColon(){
        String argument = "//:\n2:5:7";
        int expectedOutcome = 14;

        int result = calculator.add(argument);

        Assert.assertEquals(expectedOutcome, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkForNegativeNumbersException(){
        String argument = "//:\n2:-5:-7";

        calculator.add(argument);

    }


}
