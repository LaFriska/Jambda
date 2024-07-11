package com.friska.tokenizer;

public class UnexpectedCharacterException extends InvalidSyntaxException{
    public UnexpectedCharacterException(char token, String exp) {
        super("Found an unexpected token: \"" + token + "\" in the expression: \"" + exp + "\".");
    }
}
