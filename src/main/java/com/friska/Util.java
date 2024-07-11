package com.friska;

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

    public static String removeLeadingSpace(String str){
        if(str.charAt(0) != ' ') return str;
        else return removeLeadingSpace(str.substring(1));
    }

}
