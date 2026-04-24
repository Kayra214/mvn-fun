package com.mycompany.app;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class FactorizerTests {

    /**
     * Object under test: reference to singleton instance of hidden implementation class.
     */
    private final Factorizer factorizer = Factorizer.getInstance();

    private List<Long> expected, actual;
    private long n;

    @Test
    @Order(100)
    void test100_factorize_case_n_is_0() {
        n = 0L;
        actual = factorizer.factorize(n);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Order(101)
    void test101_factorize_case_n_is_1() {
        n = 1L;
        actual = factorizer.factorize(n);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Order(102)
    void test102_factorize_case_n_is_2() {
        n = 2L;
        expected = List.of(2L);
        actual = factorizer.factorize(n);
        assertIterableEquals(expected, actual);
    }

    @Test
    @Order(103)
    void test103_factorize_case_n_is_3() {
        n = 3L;
        expected = List.of(3L);
        actual = factorizer.factorize(n);
        assertIterableEquals(expected, actual);
    }

    @Test
    @Order(104)
    void test104_factorize_case_n_is_4() {
        n = 4L;
        expected = List.of(2L, 2L);
        actual = factorizer.factorize(n);
        assertIterableEquals(expected, actual);
    }

    @Test
    @Order(127)
    void test127_factorize_case_n_is_27() {
        n = 27L;
        expected = List.of(3L, 3L, 3L);
        actual = factorizer.factorize(n);
        assertIterableEquals(expected, actual);
    }

    @Test
    @Order(200)
    void test200_factorize_other_regular_cases() {
        assertIterableEquals(List.of(), factorizer.factorize(1L));
        assertIterableEquals(List.of(2L), factorizer.factorize(2L));
        assertIterableEquals(List.of(3L), factorizer.factorize(3L));
        assertIterableEquals(List.of(2L, 2L), factorizer.factorize(4L));
        assertIterableEquals(List.of(3L, 3L, 3L), factorizer.factorize(27L));
        assertIterableEquals(
            List.of(2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L),
            factorizer.factorize(65536L)
        );
        assertIterableEquals(List.of(7L, 23L, 59L, 1153L), factorizer.factorize(10952347L));
        assertIterableEquals(List.of(100000039L), factorizer.factorize(100000039L));
    }

    @Test
    @Order(300)
    void test300_factorize_corner_cases() {
        assertTrue(factorizer.factorize(0L).isEmpty());
        assertIterableEquals(
    List.of(2L, 3L, 3L, 7L, 11L, 31L, 151L, 331L),
    factorizer.factorize(2147483646L)
);
        assertIterableEquals(List.of(2147483647L), factorizer.factorize(2147483647L));
    }

    @Test
    @Order(400)
    void test400_factorize_exception_cases() {
        Stream.of(-1L, -10L, -2147483648L)
            .forEach(n -> {
                IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> factorizer.factorize(n)
                );

                assertEquals("negative argument", exception.getMessage());
            });
    }
}
