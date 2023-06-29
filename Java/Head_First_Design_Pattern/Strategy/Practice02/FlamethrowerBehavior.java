package Head_First_Design_Pattern.Strategy.Practice02;

public class FlamethrowerBehavior implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("Is something burning?");
    }

}
