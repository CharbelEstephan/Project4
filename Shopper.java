package p1;
public class Shopper {

    // constructor

    public Shopper(double t, double CartItem) {
        arrivalTime = t;
        cart = CartItem;
        Checker.enter(this);
        if (!Checker.isBusy())
          new Checker().run();  // wake-up washer if idle
    }

    public double getArrivalTime() {
        return arrivalTime;
    }
  
    public double getCart() {
        return cart;
    }

    // private variables
         
    private double arrivalTime;
    private double cart;

}  // Car class
