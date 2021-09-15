package com.klasevich.homework.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Create a stream that will detect bad words in a text according to a bad words list.
 * All words in the text are divided by whitespaces
 * (always only one whitespace between two words).
 * <p>
 * After calling collect(Collectors.toList()) the stream must return the list of bad words which were found in the text. The result should be dictionary ordered
 * (in lexicographical order, i.e. sorted) and bad words shouldn't repeat.
 * <p>
 * Important. You need return a prepared stream from the template method,
 * not a list of bad words. Pay attention to the method template. Do not change it!
 */
public class Task2 {
    private static final String TEXT_DELIMITER = " ";

    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return Arrays.stream(text.split(TEXT_DELIMITER))
                .filter(badWords::contains)
                .sorted()
                .distinct();
    }
}
