package gui;

@SuppressWarnings("serial")
public class Wyjatek_Dzielenie_przez0 extends Exception {
	
	public Wyjatek_Dzielenie_przez0()
	{
		super("DZIELLNA NIE MOŻE BYĆ RÓWNA 0");
	}
	
	public void printStackTrace() {
		
		super.printStackTrace();
		
	}

}
