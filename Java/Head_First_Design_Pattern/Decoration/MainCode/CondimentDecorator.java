package Head_First_Design_Pattern.Decoration.MainCode;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
    
}
