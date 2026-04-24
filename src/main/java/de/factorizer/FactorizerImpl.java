package de.factorizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class FactorizerImpl implements Factorizer {

    private static FactorizerImpl instance;

    private FactorizerImpl() {
    }

    public static Factorizer getInstance() {
        if (instance == null) {
            instance = new FactorizerImpl();
        }
        return instance;
    }

    @Override
    public void run(String[] args) {
        Stream.of(args)
            .forEach(arg -> {
                try {
                    Long n = Long.parseLong(arg);
                    List<Long> factors = factorize(n);
                    String isPrime = factors.size() == 1 && factors.get(0).equals(n)
                        ? " (isPrime)"
                        : "";

                    System.out.println(
                        String.format(" - n=%s -> %s%s", arg, factors, isPrime));
                } catch (NumberFormatException ex) {
                    System.out.println(
                        String.format(" - n=%s -> %s%s", arg, List.of(), " (isPrime)"));
                }
            });
    }

    @Override
    public List<Long> factorize(Long n) {
        List<Long> factors = new ArrayList<>();

        if (n == null || n < 0) {
            throw new IllegalArgumentException("negative argument");
        }
        if (n < 2) {
            return factors;
        }
        while (n % 2 == 0) {
            factors.add(2L);
            n = n / 2;
        }

        long divisor = 3L;
        while (divisor * divisor <= n) {
            while (n % divisor == 0) {
                factors.add(divisor);
                n = n / divisor;
            }
            divisor += 2;
        }

        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }
}