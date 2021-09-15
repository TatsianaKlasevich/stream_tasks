package com.klasevich.homework.stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @ParameterizedTest
    @MethodSource("getArgumentsForCalcNumberOfEmployees")
    void calcNumberOfEmployeesTest(List<Department> departments, long threshold, long expected) {
        long actual = Task6.calcNumberOfEmployees(departments, threshold);
        assertEquals(actual, expected);
    }

    static Stream<Arguments> getArgumentsForCalcNumberOfEmployees() {
        Employees employees1 = new Employees("William", 20000);
        Employees employees2 = new Employees("Sophia", 10000);
        Employees employees3 = new Employees("John", 50000);
        Department department1 = new Department("dep-1", "111-1", List.of(employees1, employees2));
        Department department2 = new Department("dep-2", "222-1", List.of(employees3));

        Employees employees4 = new Employees("William", 20000);
        Employees employees5 = new Employees("Sophia", 40000);
        Employees employees6 = new Employees("John", 50000);
        Employees employees7 = new Employees("Jasmina", 10000);
        Department department3 = new Department("dep-1", "111-1", List.of(employees4, employees5));
        Department department4 = new Department("dep-2", "111-2", List.of(employees6, employees7));

        return Stream.of(
                Arguments.of(List.of(department1, department2), 20000, 1),
                Arguments.of(List.of(department3, department4), 15000, 3)
        );
    }
}