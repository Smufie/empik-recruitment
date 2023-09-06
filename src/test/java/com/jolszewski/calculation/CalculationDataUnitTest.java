package com.jolszewski.calculation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculationDataUnitTest {

    @Test
    void shouldCalculateResult() {
        assertEquals(2.0, new CalculationData(6, 0).getResult());
        assertEquals(4.0, new CalculationData(3, 0).getResult());
        assertEquals(5.0, new CalculationData(6, 3).getResult());
        assertEquals(4.0, new CalculationData(12, 6).getResult());
    }

    @Test
    void shouldThrowCannotMakeCalculationsException() {
        assertThrows(CannotMakeCalculationsException.class, () -> new CalculationData(0, 0).getResult());
        assertThrows(CannotMakeCalculationsException.class, () -> new CalculationData(0, 10).getResult());
    }
}
