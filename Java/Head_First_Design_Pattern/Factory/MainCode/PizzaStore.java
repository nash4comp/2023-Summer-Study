package Head_First_Design_Pattern.Factory.MainCode;

public abstract class PizzaStore {
    SimplePizzaFactory factory;

    public Pizza orderPizza(String type) {
        Pizza pizza;
        // pizza = factory.createPizza(type);
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
