import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    Calculator calculator;

    @BeforeEach
    public void beforeEachTest() {
        calculator = new Calculator();
    }

    @AfterEach
    public void afterEachTest() {
        calculator = null;
    }

    @Test
    public void testMultiply() {
        int expected = 2, x = 1, y = 2;
        int result = calculator.multiply.apply(x, y);
        Assertions.assertEquals(expected, result);
    }
}
