package Head_First_Design_Pattern.Strategy.MainCode;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I cannot fly.");
    }
}
