package Head_First_Design_Pattern.Strategy.Practice02;

public class CannonBehavior implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("Destination?");
    }
    
}
