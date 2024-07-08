package tokens;

import org.jetbrains.annotations.NotNull;

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

    public String getName() {
        return name;
    }
}
