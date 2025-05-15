package org.example.booksrote.util;

import java.util.Random;

public class IsbnGenerator {
    private static final Random RANDOM = new Random();

    public static Long generateIsbn() {
        long prefix = 978_000_000_0000L;

        return prefix + RANDOM.nextInt(1_000_000_000);
    }
}
