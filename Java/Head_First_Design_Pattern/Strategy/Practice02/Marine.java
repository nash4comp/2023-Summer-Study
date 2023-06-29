package Head_First_Design_Pattern.Strategy.Practice02;

public class Marine extends Terran {
    public Marine() {}

    @Override
    public void saySomething() {
        System.out.println("I'm marine. You wanna piece of me, boy?");
    }

    @Override
    public void move() {
        System.out.println("We gotta move!");
    }
}
