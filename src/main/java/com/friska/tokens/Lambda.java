package com.friska.tokens;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

import static com.friska.Util.*;
public class Lambda extends Term{

    public final Variable input;
    public final Term body;

    public Lambda(@NotNull Variable input, @NotNull Term body){
        this.input = input;
        this.body = body;
    }

    public Lambda(@NotNull String var, @NotNull Term body){
        this(new Variable(var), body);
    }

    public Lambda(@NotNull Variable input, @NotNull String var){
        this(input, new Variable(var));
    }

    public Lambda(@NotNull String inputVar, @NotNull String var){
        this(new Variable(inputVar), new Variable(var));
    }

    @Override
    public String parseString() {
        return LAM + input.parseString() + "." + body.parseString();
    }

    @Override
    public boolean equals(@NotNull Term t) {
        if(!(t instanceof Lambda)) return false;
        else return ((Lambda) t).getBody().equals(body) && ((Lambda) t).getInput().equals(input);
    }

    @Override
    public HashSet<String> freeVariables() {
        HashSet<String> s = new HashSet<>(body.freeVariables());
        s.remove(input.parseString());
        return s;
    }

    public Variable getInput() {
        return input;
    }

    public Term getBody() {
        return body;
    }
}
