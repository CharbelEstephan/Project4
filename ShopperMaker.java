package p1;
//Got structure from the lecture CarMaker
//This is similar to how the CarMaker class was implemented as described in lecture. ShopperMaker will create reschedule itself (using the agenda), create a Shopper, decide how many groceries the Shopper will have and 
//place the Shopper in a queue in front of a Checker.
public class ShopperMaker implements Event {
	private int i;
	private int[] sD;
		//Constructor
	public ShopperMaker(int inval, int[] servDist){
		i = inval;
		sD = new int[servDist.length];
		System.arraycopy(servDist, 0, sD, 0, servDist.length);
	}
	//methods
	
	private int intRandomInt(int low, int high){
		return (int) Math.floor((high - low) * Math.random() + low + 0.5);
	}
	private double selectServiceTime(){
		return sD[intRandomInt(0, sD.length - 1)];
	}
	public void run(){
		ShopperSim.agenda.add(new ShopperMaker(i, sD), intRandomInt(0, 2*i));
		Shopper newShopper = new Shopper(ShopperSim.agenda.getCurrentTime(),selectServiceTime());
	}
}
