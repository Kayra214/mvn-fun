package com.mycompany.app;

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
                System.out.println(
                    String.format(" - n=%s -> %s%s", arg, List.of(), " (isPrime)"));
            });
    }

    @Override
    public List<Long> factorize(Long n) {
        return List.of();
    }
}