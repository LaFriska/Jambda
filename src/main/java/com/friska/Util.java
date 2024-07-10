package com.friska;

public class Util {

    public static final char LAM = 'λ';

    public static String wrap(String s) {
        return "(" + s + ")";
    }

    public static boolean matchChars(String str, char[] chars){
        for(char c : chars){
            if(str.contains(String.valueOf(c))) return true;
        }
        return false;
    }

}
