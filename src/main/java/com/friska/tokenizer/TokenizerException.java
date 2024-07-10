package com.friska.tokenizer;

public class TokenizerException extends RuntimeException{

    public TokenizerException(String msg){
        super("An exception occurred tokenizing a Lambda calculus expression. " + msg);
    }

}
