package io.qala.randomized;

import org.apache.commons.lang3.RandomUtils;

public class Randomize {
    private final int from;
    private int to = Integer.MAX_VALUE - 1;

    private Randomize(int from) {
        this.from = from;
    }

    public static Randomize from(int from) {
        return new Randomize(from);
    }

    public Randomize to(int to) {
        this.to = to;
        return this;
    }

    public int integer() {
        return RandomUtils.nextInt(from, to+1);
    }
}
