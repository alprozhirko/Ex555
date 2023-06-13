import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PasswordCheckerTests {
    PasswordChecker passwordChecker;

    @BeforeEach
    public void beforeEachTest() {
        passwordChecker = new PasswordChecker();
    }

    @AfterEach
    public void afterEachTest() {
        passwordChecker = null;
    }

    @Test
    public void setMinLengthTest() {
//      arrange
        int MinLength = -5;
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
//      act
        Executable executable = () -> passwordChecker.setMinLength(MinLength);
//      assert
        Assertions.assertThrows(expected, executable);

    }

    @ParameterizedTest
    @MethodSource("setMaxRepeatsParam")   //      arrange
    public void setMaxRepeatsTest(Class<IllegalArgumentException> expected, int maxRepeats) {
//      act
        Executable executable = () -> passwordChecker.setMaxRepeats(maxRepeats);
//      assert
        Assertions.assertThrows(expected, executable);
    }

    public static Stream<Arguments> setMaxRepeatsParam() {
        return Stream.of(
                Arguments.of(IllegalArgumentException.class, 0),
                Arguments.of(IllegalArgumentException.class, -2)
        );
    }

    @ParameterizedTest
    @MethodSource("verifyTestParam")   //      arrange
    public void verifyTest(String password) {
//      act
        boolean expected = passwordChecker.verify(password);
//      assert
        Assertions.assertTrue(expected);
    }

    public static Stream<Arguments> verifyTestParam() {
        return Stream.of(
                Arguments.of("password"),
                Arguments.of("zxcvbk"),
                Arguments.of("123456")
        );
    }
}