package com.friska.tokenizer;

import com.friska.tokens.Application;
import com.friska.tokens.Term;
import com.friska.tokens.Variable;

import java.util.ArrayList;

/**
 * An ordered list of sub-terms of a lambda expression, which can then
 * be compiled to a chain of lambda term applications.
 * */
public class TokenList extends ArrayList<String> {


    /**
     * Compiles array list into a chain of applications.
     * */
    public Term getCompiled(){
        if(size() == 0) return null;
        Term base1 = Tokenizer.tokenize(get(0));
        if(size() == 1) return base1;
        Term base2 = Tokenizer.tokenize(get(1));
        Application current = new Application(base1, base2);
        for(int i = 2; i < size(); i++){
            current = new Application(current, Tokenizer.tokenize(get(i)));
        }
        return current;
    }


    /**
     * Prevents empty strings from being added, since the algorithm written in the tokenize method
     * may generate empty strings when multiple spaces are consecutively placed next to each other.
     * <p>
     * Returns false if an attempt to add an empty string is made.
     * */
    @Override
    public boolean add(String s) {
        if(!s.isEmpty()) return super.add(s);
        return false;
    }
}
