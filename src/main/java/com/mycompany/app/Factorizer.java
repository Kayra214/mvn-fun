package com.mycompany.app;

import java.util.List;

/**
 * Interface of a singleton component that factorizes numbers
 * into prime factors.
 */
public interface Factorizer {

    /**
     * Method accepts numbers as {@code args} and outputs lines with the
     * number {@code n}, its factors and an indicator whether {@code n} is a
     * prime number.
     *
     * @param args numbers to factorize
     */
    public void run(String[] args);

    /**
     * Method accepts a number {@code n} and returns its factors.
     *
     * @param n number to factorize
     * @return factors
     */
    public List<Long> factorize(Long n);

    /**
     * Return reference to singleton instance of hidden implementation class
     * that implements the {@link Factorizer} interface.
     *
     * @return reference to instance that implements the {@link Factorizer} interface
     */
    static Factorizer getInstance() {
        return FactorizerImpl.getInstance();
    }
}