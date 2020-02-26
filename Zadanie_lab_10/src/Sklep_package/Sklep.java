package Sklep_package;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

import Item.*;
public class Sklep {

	private ArrayList<Towar> t1;
	
	
	public Sklep() {
		t1 = new ArrayList<Towar>();
	}
	public void create() {
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			Towar t2 = new Towar();
			t2.setKod(scan.nextInt());
			t2.setNazwa(scan.next());
			t2.setCena(scan.nextDouble());
			t1.add(t2);
		}
		scan.close();
		
	}
	public void show() {
		for(Towar t : t1) {
			System.out.println(t.toString());
		}
	}
	
	public void zapis_txt() {
		try {
			PrintWriter zapis = new PrintWriter("plik_tekst1.txt");
			for(Towar t : t1)
				zapis.println(t.toString());
			zapis.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Test() throws MojWyjatek {
		for(Towar t : t1) {
			if(t.getCena() > 100.0) throw new MojWyjatek("MojWyjatek dotyczy podanej wartosci");
		}
	}
	public void hsh() {
		HashSet<Towar> Sklepik = new HashSet<Towar>();
		Towar t3;
		for(Towar t : t1) {
			t3 = t;
			Sklepik.add(t3);
		}
		System.out.println(Sklepik);
		try {
			PrintWriter zapis = new PrintWriter("plik_tekst2.txt");
			for(Towar t : Sklepik) {
				zapis.println(t);
			}
			zapis.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sklep s1 = new Sklep();
		s1.create();
		s1.show();
		s1.zapis_txt();
		try {
			s1.Test();
		} catch (MojWyjatek e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		s1.hsh();
		
		
	}

}

class MojWyjatek extends Exception {
	public MojWyjatek(String s) {
		super(s);
	}
	
	public void printStackTrace() {
		super.printStackTrace();
		System.out.println("Towar jest za drogi!");
	}
	
	public String getMessage() {
		return super.getMessage() + "To jest mój komunikat";
	}
}
