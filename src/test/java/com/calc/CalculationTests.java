package com.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTests {
    @Test
    void addingTwoAndThreeGivesFive() {
        int sum = Calculation.add(2, 3);
        assertEquals(5, sum);
    }
}
