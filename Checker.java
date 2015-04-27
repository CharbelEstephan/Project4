package p1;
public class Checker implements Event{
	private double servTime;
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
}
