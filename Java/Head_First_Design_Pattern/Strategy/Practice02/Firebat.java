package Head_First_Design_Pattern.Strategy.Practice02;

public class Firebat extends Terran {
    public Firebat() {}

    @Override
    public void saySomething() {
        System.out.println("I'm firebat. Need a light?");
    }

    @Override
    public void move() {
        System.out.println("You got my attention.");
    }
    
}
