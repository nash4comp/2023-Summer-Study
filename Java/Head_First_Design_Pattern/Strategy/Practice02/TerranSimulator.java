package Head_First_Design_Pattern.Strategy.Practice02;

public class TerranSimulator {
    public static void main(String[] args) {
        Terran marine = new Marine();
        Terran firebat = new Firebat();
        Terran medic = new Medic();
        Terran scv = new Scv();
        Terran tank = new Tank();

        marine.saySomething();
        marine.setAttackMethod(new GunBehavior());
        marine.move();
        marine.attack();

        System.out.println("---");
        
        firebat.saySomething();
        firebat.setAttackMethod(new FlamethrowerBehavior());
        firebat.move();
        firebat.attack();
        System.out.println("---");
        
        medic.saySomething();
        medic.setAttackMethod(new FlamethrowerBehavior());
        medic.move();
        System.out.println("---");
        // medic.heal();
        
        scv.saySomething();
        scv.setAttackMethod(new WelderBehavior());
        scv.move();
        scv.attack();
        System.out.println("---");

        tank.saySomething();
        tank.setAttackMethod(new CannonBehavior());
        tank.move();
        tank.attack();
    }

}
