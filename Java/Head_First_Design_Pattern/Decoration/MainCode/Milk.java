package Head_First_Design_Pattern.Decoration.MainCode;

public class Milk extends CondimentDecorator {
    private final double MILK_COST = 0.1;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    public double cost() {
        return beverage.cost() + MILK_COST;
    }

}
