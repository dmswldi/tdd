package com.tdd.ch02;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    void plus(){
        int result = Calculator.plus(1,2);
        assertEquals(3, result);// 기대한 값, 실제 값
        assertEquals(5, Calculator.plus(4, 1));
    }
}
