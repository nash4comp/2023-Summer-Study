package Head_First_Design_Pattern.Strategy.Practice02;

public class WelderBehavior implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("Orders received.");
    }
}
