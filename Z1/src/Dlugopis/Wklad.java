package Dlugopis;
import java.util.Random;
public class Wklad {
	private int kolor;
	
	public Wklad() {
		Random gen = new Random();
		this.kolor = gen.nextInt(4)+1;
	}
	
	public Wklad(int kolor) {
		this.kolor = kolor;
	}
	
	public int getStan() {
		return kolor;
	}
	
}
