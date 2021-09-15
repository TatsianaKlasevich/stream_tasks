package com.klasevich.homework.stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @ParameterizedTest
    @MethodSource("getArgumentsForCreatingBadWordsDetectingStream")
    void createBadWordsDetectingStreamTest(String text, List<String> expected) {
        List<String> badWords = List.of("have", "humans", "and", "of");

        List<String> actual = Task2.createBadWordsDetectingStream(text, badWords)
                .collect(Collectors.toList());

        assertEquals(actual, expected);
    }

    static Stream<Arguments> getArgumentsForCreatingBadWordsDetectingStream() {
        List<String> stream1 = List.of("have", "humans");
        List<String> stream2 = List.of("and", "have", "humans", "of");
        List<String> stream3 = List.of("and", "of");

        return Stream.of(
                Arguments.of("It goes without humans saying that humans have pretty remarkable bodies", stream1),
                Arguments.of("humans and have overcome predators disease and all and sorts of other obstacles over thousands of years", stream2),
                Arguments.of("the spherical body part that of contains the brain and rests at the top of the human body", stream3)
        );
    }
}