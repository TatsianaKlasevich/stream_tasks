package com.klasevich.homework.stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @ParameterizedTest
    @MethodSource("getArgumentsForCalcSumOfCanceledTransOnNonEmptyAccounts")
    void calcSumOfCanceledTransOnNonEmptyAccountsTest(List<Account> accounts, long expected) {
        long actual = Task7.calcSumOfCanceledTransOnNonEmptyAccounts(accounts);
        assertEquals(actual, expected);
    }

    static Stream<Arguments> getArgumentsForCalcSumOfCanceledTransOnNonEmptyAccounts() {
        Transaction transaction1 = new Transaction(State.CANCELED, 1000L);
        Transaction transaction2 = new Transaction(State.FINISHED, 8000L);
        Transaction transaction3 = new Transaction(State.CANCELED, 10000L);
        Account account1 = new Account(0L, List.of(transaction1));
        Account account2 = new Account(8000L, List.of(transaction2, transaction3));

        Transaction transaction4 = new Transaction(State.FINISHED, 1000L);
        Transaction transaction5 = new Transaction(State.CANCELED, 15000L);
        Transaction transaction6 = new Transaction(State.FINISHED, 8000L);
        Transaction transaction7 = new Transaction(State.CANCELED, 10000L);
        Account account3 = new Account(6000L, List.of(transaction4, transaction5));
        Account account4 = new Account(8000L, List.of(transaction6, transaction7));


        return Stream.of(
                Arguments.of(List.of(account1, account2), 10000L),
                Arguments.of(List.of(account3, account4), 25000L)
        );
    }
}