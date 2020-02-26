package Main_prog;
import java.util.Scanner;

import Bankowo.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b1 = new Bank(2);
		b1.wypelnij();
		Scanner scan2 = new Scanner(System.in);
		System.out.println(b1.find(scan2.nextInt(), 0));
		
		
		System.out.println("\nPrzed modyfikacja");
		b1.show(0);
		
		b1.update(0);
		System.out.println("\nPo modyfikacji");
		b1.show(0);
		
		System.out.println("\nChoinka");
		b1.choinka(4);
		
		
	}

}
