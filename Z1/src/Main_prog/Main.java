package Main_prog;
import Dlugopis.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dlugopis1 [] tab1 = new Dlugopis1[5];
		for(int i = 0; i < 5; i++) {
			tab1[i] = new Dlugopis1();
			tab1[i].getWlasciciel();
			
			System.out.println(tab1[i].getStan());
		}
		
		
	}

}
