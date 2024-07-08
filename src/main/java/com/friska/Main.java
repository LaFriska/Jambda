package com.friska;

import com.friska.tokens.Application;
import com.friska.tokens.Lambda;
import com.friska.tokens.Variable;

public class Main {
    public static void main(String[] args){
        System.out.println(new Lambda("x", new Lambda("y", new Application(new Application(new Lambda("u", "v"), "y"), new Application("x", "y")))));

    }
}
