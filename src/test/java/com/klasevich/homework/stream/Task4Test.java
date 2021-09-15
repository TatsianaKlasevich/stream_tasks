package com.klasevich.homework.stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @ParameterizedTest
    @MethodSource("getArgumentsForFindFactorial")
    void testFactorial(long number, long expected) {
        long actual = Task4.factorial(number);
        assertEquals(actual, expected);
    }

    static Stream<Arguments> getArgumentsForFindFactorial() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6)
        );
    }
}