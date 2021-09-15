package com.klasevich.homework.stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @ParameterizedTest
    @MethodSource("getArgumentsForCreatingFilteringStream")
    void createFilteringStreamTest(IntStream evenStream, IntStream oddStream, List<Integer> expected) {
        List<Integer> actual = Task3.createFilteringStream(evenStream, oddStream)
                .boxed()
                .collect(Collectors.toList());

        assertEquals(actual, expected);
    }

    static Stream<Arguments> getArgumentsForCreatingFilteringStream() {
        return Stream.of(
                Arguments.of(IntStream.of(2, 4), IntStream.of(1, 3), List.of()),
                Arguments.of(IntStream.of(30, 60, 90), IntStream.of(1, 13, 75, 11, 21), List.of(75, 90))
        );
    }
}