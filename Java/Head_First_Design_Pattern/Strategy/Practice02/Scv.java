package Head_First_Design_Pattern.Strategy.Practice02;

public class Scv extends Terran {
    @Override
    public void saySomething() {
        System.out.println("I'm SCV. SCV good to go, sir.");
    }

    @Override
    public void move() {
        System.out.println("Affirmative.");
    }
    
    public void build() {
        System.out.println("Job's finished.");
    }
    
    public void repair() {
        System.out.println("Reporting for duty.");
    }

}
