package com.friska.tokenizer;

import com.friska.Util;
import com.friska.tokens.Lambda;
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
        if(exp.charAt(0) == LAM) return handleLambda(exp); //Expression starts with Lambda
        else if(isVariable(exp)) return new Variable(exp); //Base case: expression is a single variable
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
        return !matchChars(exp, Variable.ILLEGALS);
    }

    /**
     * Settles the case where the first character is a Lambda.
     * */
    private static Term handleLambda(@NotNull String exp){
        exp = exp.substring(1); //Removes the lambda
        String inputVar = exp.split("\\.")[0];
        if(!isVariable(inputVar)) throw new InvalidSyntaxException("Input field of Lambda term: \"" + inputVar + "\" is not a variable.");
        String body = exp.substring(exp.indexOf(".") + 1);
        if(body.isEmpty()) throw new InvalidSyntaxException("Lambda term has no body.");
        return new Lambda(inputVar, tokenize(body));
    }

}
