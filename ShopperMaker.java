package p1;
//Got structure from the lecture CarMaker
//This is similar to how the CarMaker class was implemented as described in lecture. ShopperMaker will create reschedule itself (using the agenda), create a Shopper, decide how many groceries the Shopper will have and 
//place the Shopper in a queue in front of a Checker.
public class ShopperMaker implements Event {
    private int[] randomitemdistribution = {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,
    11,12,13,14,15,16,17,18,19,20,11,12,13,14,15,16,17,18,19,20,11,12,13,14,15,16,17,18,19,20,11,12,13,14,15,16,17,18,19,20,
    21,22,23,24,25,26,27,28,29,30,21,22,23,24,25,26,27,28,29,30,21,22,23,24,25,26,27,28,29,30,21,22,23,24,25,26,27,28,29,30,21,22,23,24,25,26,27,28,29,30,
    31,32,33,34,35,36,37,38,39,40,31,32,33,34,35,36,37,38,39,40,31,32,33,34,35,36,37,38,39,40,31,32,33,34,35,36,37,38,39,40,
    41,42,43,44,45,46,47,48,49,50,41,42,43,44,45,46,47,48,49,50,41,42,43,44,45,46,47,48,49,50,41,42,43,44,45,46,47,48,49,50,
    51,52,53,54,55,56,57,58,59,60,51,52,53,54,55,56,57,58,59,60,51,52,53,54,55,56,57,58,59,60,
    61,62,63,64,65,66,67,68,69,70,61,62,63,64,65,66,67,68,69,70,61,62,63,64,65,66,67,68,69,70,
    71,72,73,74,75,76,77,78,79,80,71,72,73,74,75,76,77,78,79,80,
    81,82,83,84,85,86,87,88,89,90,
    91,92,93,94,95,96,97,98,99,100};
    
    private double[] randomtimedistribution = {52.5,52.5,45.0,45.0,45.0,36.0,36.0,36.0,36.0,30.0,30.0,
    24.0,24.0,24.0,24.0,15.0,15.0,15.0,7.5,7.5};
    
    private int interval;
    private int[] ArrivDist;
    
    public ShopperMaker(int i, int[] AD){
    	interval = i;
        ArrivDist = new int[AD.length];
        System.arraycopy(AD, 0, AD, 0, AD.length);
    }
    public int intCartItem(){
    	return randomitemdistribution[(int)(Math.random() * 300)];
    }
    public double selectArrivalTime(){
    	return randomtimedistribution[(int) (Math.random() * 20)];
    }
    public void run() {
        ShopperSim.agenda.add(new ShopperMaker(interval, ArrivDist), selectArrivalTime());
        Shopper newCustomer = new Shopper(selectArrivalTime(), 
                             intCartItem());
    }
}


