package Head_First_Design_Pattern.Decoration.MainCode;

public class DarkRoast extends Beverage {
    private final double DARKROAST_COST = 0.99;

    public DarkRoast() {
        description = "Dark roast";
    }

    public double cost() {
        return DARKROAST_COST;
    }

}
