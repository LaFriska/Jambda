package tokens;

import org.jetbrains.annotations.NotNull;

public class Lambda extends Term{

    public final Variable input;
    public final Term body;

    public Lambda(Variable input, Term body){
        this.input = input;
        this.body = body;
    }

    @Override
    public String parseString() {
        return null;
    }

    @Override
    public boolean equals(@NotNull Term t) {
        if(!(t instanceof Lambda)) return false;
        else return ((Lambda) t).getBody().equals(body) && ((Lambda) t).getInput().equals(input);
    }

    public Variable getInput() {
        return input;
    }

    public Term getBody() {
        return body;
    }
}
