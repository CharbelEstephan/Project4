package p1;
//Based off of the CarSim class made by Dovolis
public class ShopperSim {
	//public var
	static PQ agenda = new PQ();
	static Checker checker; //Checkout lane
	
	//Methods
	public static void main(String args[]) {
		Stat.updateQueueStats();
	}
}
