package Head_First_Design_Pattern.Decoration.MainCode;

public class Espresso extends Beverage {
    private final double ESPRESSO_COST = 1.99;

    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return ESPRESSO_COST;
    }
    
}
