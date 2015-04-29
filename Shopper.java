package p1;
public class Shopper {

    // constructor

    public Shopper(double t, int CartItem) {
        arrivalTime = 30;
        cartNum = CartItem;
        Checker.enter(this);
        if (!Checker.isBusy())
          new Checker().run();  // wake-up washer if idle
    }

    public double getArrivalTime() {
        return arrivalTime;
    }
  
    public int getCart() {
        return cartNum;
    }

    // private variables
         
    private double arrivalTime = 30;
    private int[] cart;
    private int cartNum;

}  // Shopper class
