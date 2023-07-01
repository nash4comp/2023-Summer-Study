package Head_First_Design_Pattern.Factory.MainCode;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
            // } else if (item.equals("pepperoni")) {
            // return new NYStylePepperoniPizza();
            // } else if (item.equals("clam")) {
            // return new NYStyleClamPizza();
            // } else if (item.equals("veggie")) {
            // return new NYStyleVeggiePizza();
        } else
            return null;
    }
}
