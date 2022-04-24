package com.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTests {
    @Test
    void addingTwoAndThreeGivesFive() {
        assertEquals(5, 2 + 3);
    }
}
