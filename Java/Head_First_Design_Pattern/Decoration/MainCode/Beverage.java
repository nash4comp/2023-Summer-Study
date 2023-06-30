package Head_First_Design_Pattern.Decoration.MainCode;

public abstract class Beverage {
    String description = "No name";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
