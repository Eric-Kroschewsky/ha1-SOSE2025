package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    
    //1. Grüner Test 
    @Test
    @DisplayName("should remove dot zero when displaying result")
    void testRemoveDotZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    } 

    //1. Roter Test - gefixter Fehler
    @Test
    @DisplayName("should calculate correctly when using more than one binary operator")
    void testSubtractTwice() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(6);
        calc.pressEqualsKey();

        String expected = "-6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    } 
    
    //2. Roter Test - gefixter Fehler
    @Test
    @DisplayName("should display large number in exponential format")
    void testShowLargeNumberAsExponential() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "1.02e+9";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    } 

}

