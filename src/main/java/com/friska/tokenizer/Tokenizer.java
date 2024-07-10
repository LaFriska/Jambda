package com.friska.tokenizer;

import com.friska.Util;
import com.friska.tokens.Term;
import com.friska.tokens.Variable;
import org.jetbrains.annotations.NotNull;

import static com.friska.Util.*;

public class Tokenizer {

    /**
     * Given an input Lambda expression, reads it and structures it as nested Lambda terms.
     * */
    public static Term tokenize(@NotNull String exp){
        exp = toLambda(exp);
        return null;
    }

    /**
     * Converts all backslashes to a Lambda.
     * */
    private static String toLambda(@NotNull String exp) {
        return exp.replace('\\', Util.LAM);
    }

    /**
     * Checks if a Lambda expression is a single variable.
     * */
    private static boolean isVariable(@NotNull String exp){
        return !matchChars(exp, Variable.FORBIDDEN);
    }

}
