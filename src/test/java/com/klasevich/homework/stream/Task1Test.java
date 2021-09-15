package com.klasevich.homework.stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @ParameterizedTest
    @MethodSource("getArgumentsForPrimeTest")
    void testIsPrimeNumber(long number, boolean expected) {
        boolean actual = Task1.isPrime(number);
        assertEquals(actual, expected);
    }

    static Stream<Arguments> getArgumentsForPrimeTest() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(4, false),
                Arguments.of(10, false),
                Arguments.of(11, true),
                Arguments.of(17, true),
                Arguments.of(22, false)
        );
    }
}