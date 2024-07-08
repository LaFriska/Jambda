package com.friska.tokens;

import org.jetbrains.annotations.NotNull;

public abstract class Term {

    public abstract String parseString();

    /**
     * Checks if two terms are equivalent. This function does NOT compute its β-equivalence.
     * */
    public abstract boolean equals(@NotNull Term t);

    @Override
    public String toString() {
        return parseString();
    }
}
