package com.klasevich.homework.stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @ParameterizedTest
    @MethodSource("getArgumentsForFindSumOfOddNumbersInRange")
    void sumOfOddNumbersInRangeTest(long start, long end, long expected) {
        long actual = Task5.sumOfOddNumbersInRange(start, end);
        assertEquals(actual, expected);
    }

    static Stream<Arguments> getArgumentsForFindSumOfOddNumbersInRange() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(7, 9, 16),
                Arguments.of(21, 30, 125)
        );
    }
}