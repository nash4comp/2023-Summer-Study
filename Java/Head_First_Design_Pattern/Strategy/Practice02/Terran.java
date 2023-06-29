package Head_First_Design_Pattern.Strategy.Practice02;

abstract public class Terran {
    AttackBehavior attackBehavior;

    public Terran() {}

    public void setAttackMethod(AttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    public abstract void saySomething();
    public abstract void move();

    public void attack() {
        attackBehavior.attack();
    }
}
