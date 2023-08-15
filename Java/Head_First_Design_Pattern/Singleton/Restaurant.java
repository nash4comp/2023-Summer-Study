package Head_First_Design_Pattern.Singleton;

public enum Restaurant {
    RESTAURANT_INSTANCE;

    public String getRestaurantName() {
        return "Delicious Restaurant";
    }

    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.RESTAURANT_INSTANCE;
        System.out.println(restaurant.getRestaurantName());
    }

}
