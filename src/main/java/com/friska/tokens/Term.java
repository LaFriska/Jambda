package com.friska.tokens;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public abstract class Term {

    /**
     * Parses the term object into a λ-calculus expression.
     * */
    public abstract String parseString();

    /**
     * Checks if two terms are equivalent. This function does NOT compute its β-equivalence.
     * */
    public abstract boolean equals(@NotNull Term t);

    public abstract HashSet<String> freeVariables();

    @Override
    public String toString() {
        return parseString();
    }
}
