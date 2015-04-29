package p1;
public class Checker implements Event{
	private double servTime;
	private static boolean busy;
	//Constructors
	
	public Checker() {
		servTime = 0;
	}
	public Checker(double s){
		servTime = s;
	}
	//variables
	static Q1 waitline = new Q1();
	
	//Methods
	public static void enter(Shopper shop){
		waitline.add(shop);
	}
	public static boolean isBusy() {
        return busy;
	}
	public void run() {

        Shopper customer;

        if (busy) {  // this instance invoked because a wash finished
          Stat.updateServiceTimeStats(servTime);
          Stat.updateBusyTimeStats(ShopperSim.agenda.getCurrentTime());
        }
        else  // this instance invoked because a new car arrived at idle wash
          Stat.updateIdleTimeStats(ShopperSim.agenda.getCurrentTime());

        if (waitline.length() == 0) {
          busy = false;  // do nothing until notified of a new car arrival
        }
        else {
          busy = true;  // start on next car in queue
          customer = (Shopper) waitline.remove();
          Stat.updateQueueStats(ShopperSim.agenda.getCurrentTime(),
                                waitline.length());
          Stat.updateWaitTimeStats(ShopperSim.agenda.getCurrentTime(),
                                   customer.getArrivalTime());
          servTime = customer.getServiceTime();
          ShopperSim.agenda.add(new Checker(servTime), 
                            servTime);
        }

    } 
}
