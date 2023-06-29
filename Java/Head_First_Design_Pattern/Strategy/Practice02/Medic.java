package Head_First_Design_Pattern.Strategy.Practice02;

public class Medic extends Terran {
    @Override
    public void saySomething() {
        System.out.println("I'm medic. Prepped and ready.");
    }

    @Override
    public void move() {
        System.out.println("Right away.");
    }
    
    public void heal() {
        System.out.println("Need medical attention?");
    }

}
