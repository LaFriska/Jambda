package com.friska.tokens;

import com.friska.Util;
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

    /**
     * Generates a variable name similar to the input,
     * that is not a free variable in this term.
     * */
    @Deprecated
    public String generateFreshVariable(@NotNull String var){
        return Util.genFresh(freeVariables(), var);
    }


    /**
     * NOT to be confused with substitute, this method replaces all instances of `oldVar` with `newVar`
     * without ensuring beta-equivalence.
     * */
    public abstract Term replaceVariables(@NotNull String oldVar, @NotNull String newVar);

    /**
     * Replaces one variable in a term with another term, while also ensuring bound variable
     * in the first term does not collide with any free variables in the input term.
     * */
    public abstract Term substitute(@NotNull String var, @NotNull Term term);

    public boolean isCombinator(){
        return freeVariables().isEmpty();
    }

}
