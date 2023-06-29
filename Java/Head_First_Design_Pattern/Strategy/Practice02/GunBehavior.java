package Head_First_Design_Pattern.Strategy.Practice02;

public class GunBehavior implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("Gimme something to shoot!");
    }

}
