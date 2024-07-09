package com.friska.tokens;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class Variable extends Term{

    private final String name;

    public Variable(@NotNull String name){
        this.name = name;
    }

    @Override
    public String parseString() {
        return name;
    }

    @Override
    public boolean equals(@NotNull Term t) {
        if(!(t instanceof Variable)) return false;
        else return ((Variable) t).getName().equals(name);
    }

    @Override
    public HashSet<String> freeVariables() {
        HashSet<String> s = new HashSet<>();
        s.add(parseString());
        return s;
    }

    public String getName() {
        return name;
    }
}
