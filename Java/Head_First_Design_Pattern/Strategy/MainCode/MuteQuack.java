package Head_First_Design_Pattern.Strategy.MainCode;

public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< silent~ >>");
    }
}
