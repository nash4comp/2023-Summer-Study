package Head_First_Design_Pattern.Decoration.MainCode;

public class HouseBlend extends Beverage {
    private final double HOUSEBLEND_COST = 0.89;

    public HouseBlend() {
        description = "House blend coffee";
    }

    public double cost() {
        return HOUSEBLEND_COST;
    }
    
}
