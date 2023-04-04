package org.example;

import java.util.Arrays;
import java.util.List;

public class PopcornCooker {
    private final List<String> types = Arrays.asList("sw", "sa", "ca");
    private int corns;
    public PopcornCooker(int c) {
        corns = c;
    }
    public String makePopcorn(final String type) {
        if (!types.contains(type)) {
            throw new IllegalArgumentException("Wrong type");
        }
        if (corns == 0) {
            return null;
        }
        --corns;
        if (type.equals("sa")) {
            return "Salted popcorn";
        } else if (type.equals("sw")) {
            return "Sweet popcorn";
        } else {
            return "Caramel popcorn";
        }
    }
}
