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

    /**
     * Generates a variable name similar to the input,
     * that is not a free variable in this term.
     * */
    public String generateFreshVariable(@NotNull String var){
        return genFresh(freeVariables(), var);
    }

    private String genFresh(@NotNull HashSet<String> fv, @NotNull String var){
        if(!fv.contains(var)){
            return var;
        }else{
            return genFresh(fv, var + "'");
        }
    }

    /**
     * NOT to be confused with substitute, this method replaces all instances of `oldVar` with `newVar`
     * without ensuring beta-equivalence.
     * */
    public abstract Term replaceVariables(@NotNull String oldVar, @NotNull String newVar);

}
