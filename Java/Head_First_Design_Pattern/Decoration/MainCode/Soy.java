package Head_First_Design_Pattern.Decoration.MainCode;

public class Soy extends CondimentDecorator {
    private final double SOY_COST = 0.15;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        return beverage.cost() + SOY_COST;
    }

}
