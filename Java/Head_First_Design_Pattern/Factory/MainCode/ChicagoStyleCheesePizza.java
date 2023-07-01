package Head_First_Design_Pattern.Factory.MainCode;

public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago style deep dish cheese pizza";
        dough = "A thick crust dough";
        sauce = "Plum tomato sauce";

        toppings.add("Finely chopped mozzarella cheese");
    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices.");
    }
    
}
