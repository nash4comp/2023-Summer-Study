package Head_First_Design_Pattern.Decoration.MainCode;

public class Decaf extends Beverage {
    private final double DECAF_COST = 1.05;

    public Decaf() {
        description = "Decaf";
    }

    public double cost() {
        return DECAF_COST;
    }

}
