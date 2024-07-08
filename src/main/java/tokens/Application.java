package tokens;

import org.jetbrains.annotations.NotNull;

public class Application extends Term{

    private final Term leftTerm;
    private final Term rightTerm;

    public Application(@NotNull Term left, @NotNull Term right){
        this.leftTerm  = left;
        this.rightTerm = right;
    }

    @Override
    public String parseString() {
        return null;
    }

    @Override
    public boolean equals(@NotNull Term t) {
        if(!(t instanceof Application)) return false;
        return ((Application) t).getLeftTerm().equals(leftTerm) && ((Application) t).getRightTerm().equals(rightTerm);
    }

    public Term getLeftTerm() {
        return leftTerm;
    }

    public Term getRightTerm() {
        return rightTerm;
    }
}
