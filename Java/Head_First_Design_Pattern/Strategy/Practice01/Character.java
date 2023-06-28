package Head_First_Design_Pattern.Strategy.Practice01;

public abstract class Character {
    WeaponBehavior weaponBehavior;

    public Character() {
    }

    public void setWeapon(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public void saySomething() {
        System.out.println("Hello, I'm a fighter.");
    }

    public void fight() {
        weaponBehavior.useWeapon();
    }
}
