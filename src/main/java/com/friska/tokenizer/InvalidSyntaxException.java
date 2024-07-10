package com.friska.tokenizer;

public class InvalidSyntaxException extends TokenizerException{
    public InvalidSyntaxException(String msg) {
        super("Expression has invalid syntax. " + msg);
    }
}
