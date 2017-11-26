package fr.imt.inference.type;

public class BooleanType extends TypeLiteral {

    @Override
    public boolean isTypeVariable() {
        return false;
    }

    @Override
    public boolean isArrow() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BooleanType;
    }

    @Override
    public String toString() {
        return "Bool";
    }

}
