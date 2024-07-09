package com.friska.tokens;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class Variable extends Term{

    private String name;

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

    @Override
    public Term replaceVariables(@NotNull String oldVar, @NotNull String newVar) {
        if(this.name.equals(oldVar)) return new Variable(newVar);
        else return this;
    }

    public String getName() {
        return name;
    }

    public void rename(String newName){
        this.name = newName;
    }
}
