package com.friska.tokens;

import com.friska.InvalidVariableException;
import com.friska.Util;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class Variable extends Term{

    /**
     * A list of forbidden characters
     * */
    public static HashSet<Character> ILLEGALS = new HashSet<>();

    static{
        ILLEGALS.add('(');
        ILLEGALS.add(')');
        ILLEGALS.add(' ');
        ILLEGALS.add(Util.LAM);
        ILLEGALS.add('\\');
        ILLEGALS.add('\n');
        ILLEGALS.add('\r');
        ILLEGALS.add('.');
    }

    private String name;

    public Variable(@NotNull String name){
        if(Util.matchChars(name, ILLEGALS)) throw new InvalidVariableException("Variable name contains illegal characters.");
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
