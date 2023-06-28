package Chap07;

class Product {
    int price;
    int bonusPoint;

    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}

class Tv extends Product {
    Tv() {
        super(100);
    }
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    public String toString() {
        return "Computer";
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;

    void buy(Product p) {
        if(money < p.price) {
            System.out.println("Not enough money to buy the product.");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println("You bought " + p + ".");
    }
}


public class PolyArgumentTest {
    public static void main(String[] args){
        Buyer b = new Buyer();
        System.out.println("Current budget is $" + b.money);
        System.out.println("Current bonus point is "+b.bonusPoint);
        b.buy(new Tv());
        b.buy(new Computer());
        System.out.println("Current budget is $" + b.money);
        System.out.println("Current bonus point is "+b.bonusPoint);
    }
    
}
