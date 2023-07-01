package Head_First_Design_Pattern.Factory.MainCode;

import java.util.*;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<String>();

    void prepare() {
        System.out.println("Preparing: " + name);
        System.out.println("Making dough...");
        System.out.println("Spreading the sauce...");
        System.out.println("Adding the toppings...");
        for (String topping : toppings) {
            System.out.println(" " + topping);
        }
    }

    void bake() {
        System.out.println("Bake at 175 degrees Celsius for 25 minutes.");
    }

    void cut() {
        System.out.println("Cut the pizza diagonally.");
    }

    void box() {
        System.out.println("Put the pizza in the box.");
    }

    public String getName() {
        return name;
    }

}
