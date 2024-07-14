package com.friska;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class Util {

    public static final char LAM = 'λ';

    public static String wrap(String s) {
        return "(" + s + ")";
    }

    public static boolean matchChars(String str, HashSet<Character> chars){
        for(int i = 0; i < str.length(); i++){
            if(chars.contains(str.charAt(i))) return true;
        }
        return false;
    }

    public static String removeSurroundingSpace(String str){
        if(str.isEmpty()) return str;
        int last = str.length()-1;
        int start = 0;
        int end = str.length();
        if(str.charAt(0) != ' ' && str.charAt(last) != ' ') return str;
        if(str.charAt(0) == ' ') start = 1;
        if(str.charAt(last) == ' ') end = last;
        return removeSurroundingSpace(str.substring(start, end));
    }

    /**
     * Given a set of variables, and a variable name, generates a similar variable name that is not in the set.
     * */
    public static String genFresh(@NotNull HashSet<String> fv, @NotNull String var){
        if(!fv.contains(var)) return var;
        else return genFresh(fv, var + "'");
    }

}
