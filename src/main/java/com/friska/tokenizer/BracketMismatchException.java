package com.friska.tokenizer;

import org.jetbrains.annotations.NotNull;

public class BracketMismatchException extends InvalidSyntaxException{
    public BracketMismatchException(String msg, @NotNull String exp) {
        super("Found mismatched brackets in the expression \"" + exp + "\". " + msg);
    }
}
