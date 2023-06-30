package Head_First_Design_Pattern.Decoration.MainCode;

public class Mocha extends CondimentDecorator{
    private final double MOCHA_COST = .20;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return beverage.cost() + MOCHA_COST;
    }
    
}
