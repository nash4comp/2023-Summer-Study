package Head_First_Design_Pattern.Strategy.Practice02;

public class Tank extends Terran {
    @Override
    public void saySomething() {
        System.out.println("I'm tank. Ready to roll out!");
    }

    @Override
    public void move() {
        System.out.println("Move it!");
    }
    
    public void modeChange() {
        System.out.println("Proceeding!");
    }

}
