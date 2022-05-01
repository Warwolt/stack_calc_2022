package com.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

public class StackCalculatorTests {
    @Test
    void evaluatingEmptyStackGivesZero() {
        Stack<String> input = new Stack<>();
        int result = StackCalculator.evaluate(input);
        assertEquals(0, result);
    }

    // 1 + 2
    @Test
    void twoTermSumCanBeEvaluated() {
        Stack<String> input = Stack.fromList(Arrays.asList("+", "1", "2"));
        int result = StackCalculator.evaluate(input);
        assertEquals(3, result);
    }

    // (1 + 2) + 3
    @Test
    void leftAssociativeThreeTermSumCanBeEvaluated() {
        Stack<String> input = Stack.fromList(Arrays.asList("+", "+", "1", "2", "3"));
        int result = StackCalculator.evaluate(input);
        assertEquals(6, result);
    }

    // 1 + (2 + 3)
    @Test
    void rightAssociativeThreeTermSumCanBeEvaluated() {
        Stack<String> input = Stack.fromList(Arrays.asList("+", "1", "+", "2", "3"));
        int result = StackCalculator.evaluate(input);
        assertEquals(6, result);
    }

    @Test
    void missingOperandsForAddition_ThrowsIllegalArgumentException() {
        Stack<String> input = Stack.fromList(Arrays.asList("+"));
        assertThrows(IllegalArgumentException.class, () -> StackCalculator.evaluate(input));
    }

    @Test
    void missingRightOperandForAddition_ThrowsIllegalArgumentException() {
        Stack<String> input = Stack.fromList(Arrays.asList("+", "1"));
        assertThrows(IllegalArgumentException.class, () -> StackCalculator.evaluate(input));
    }
}
