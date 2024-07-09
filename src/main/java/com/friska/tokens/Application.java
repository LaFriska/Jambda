package com.friska.tokens;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

import static com.friska.Util.*;

public class Application extends Term{

    private final Term leftTerm;
    private final Term rightTerm;

    public Application(@NotNull Term left, @NotNull Term right){
        this.leftTerm  = left;
        this.rightTerm = right;
    }

    public Application(@NotNull String var1, @NotNull Term right) {
        this(new Variable(var1), right);
    }

    public Application(@NotNull Term left, @NotNull String var2) {
        this(left, new Variable(var2));
    }

    public Application(@NotNull String var1, @NotNull String var2) {
        this(new Variable(var1), new Variable(var2));
    }

    @Override
    public String parseString() {
        String leftString;
        String rightString;
        if(leftTerm instanceof Lambda) leftString = wrap(leftTerm.parseString());
        else leftString = leftTerm.parseString();
        if(rightTerm instanceof Lambda) rightString = wrap(rightTerm.parseString());
        else if(rightTerm instanceof Application) rightString = wrap(rightTerm.parseString());
        else rightString = rightTerm.parseString();
        return leftString + ' ' + rightString;
    }

    @Override
    public boolean equals(@NotNull Term t) {
        if(!(t instanceof Application)) return false;
        return ((Application) t).getLeftTerm().equals(leftTerm) && ((Application) t).getRightTerm().equals(rightTerm);
    }

    @Override
    public HashSet<String> freeVariables() {
        HashSet<String> s = new HashSet<>(leftTerm.freeVariables());
        s.addAll(rightTerm.freeVariables());
        return s;
    }

    public Term getLeftTerm() {
        return leftTerm;
    }

    public Term getRightTerm() {
        return rightTerm;
    }
}
