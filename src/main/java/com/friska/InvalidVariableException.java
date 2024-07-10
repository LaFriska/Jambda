package com.friska;

import org.jetbrains.annotations.NotNull;

public class InvalidVariableException extends RuntimeException{
    public InvalidVariableException(@NotNull String msg){
        super(msg);
    }
}