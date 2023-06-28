package Head_First_Design_Pattern.Strategy.Practice01;

public class FighterSimulator {
    public static void main(String[] args) {
        Character king = new King();
        Character queen = new Queen();
        Character knight = new Knight();
        Character troll = new Troll();

        king.saySomething();
        king.setWeapon(new SwordBehavior());
        king.fight();

        queen.saySomething();
        queen.setWeapon(new BowAndArrowBehavior());
        queen.fight();

        knight.saySomething();
        knight.setWeapon(new KnifeBehavior());
        knight.fight();

        troll.saySomething();
        troll.setWeapon(new AxeBehavior());
        troll.fight();
    }

}
