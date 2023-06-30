package Head_First_Design_Pattern.Decoration.MainCode;

public class Whip extends CondimentDecorator {
    private final double WHIP_COST = 0.1;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    public double cost() {
        return beverage.cost() + WHIP_COST;
    }

}
