package Lista;
import Osoby.*;
import java.util.ArrayList;
import java.io.*;
public class Przychodnia {

	static ArrayList <Osoba> p1 = new ArrayList();
	
	public static void main(String[] args) {
		p1.add(new Lekarz());
		p1.add(new Pracownik());
		p1.add(new Dyrektor());
		p1.add(new Lekarz("1456", "chirurg", 2256, 12));
		p1.add(new Lekarz("1486", "stomatolog", 2296, 62));
//		p1.add(new Lekarz("1459", "technik", 224, 82));
		p1.add(new Lekarz("1451", "kardiochirurg", 228, 14));
		p1.add(new Pracownik("123", "portier", 200, 50));
		p1.add(new Pracownik("124", "losowy", 4850, 10));
		p1.add(new Pracownik("128", "salowy", 202, 8));
		
		for(Osoba x : p1) {
			System.out.println(x.toString());
			if(x instanceof Lekarz)
				((Lekarz) x).wyswietlLiczbePacjentow();
			else if(x instanceof Pracownik)
				((Pracownik) x).wyswietlNadgodziny();
				
		}
		System.out.println("=================");
		System.out.println(p1.size());
		System.out.println("=================");
		
		
		Dyrektor d1 = new Dyrektor("12", "d1", 2000, 50, 5000);
		p1.add(2, d1);
		
		
		for(Osoba x : p1) {
			System.out.println(x.toString());
			if(x instanceof Lekarz)
				System.out.println(((Lekarz) x).wyswietlLiczbePacjentow());
			else if(x instanceof Pracownik)
				((Pracownik) x).wyswietlNadgodziny();
				
		}
		
		System.out.println("=================");
		int suma = 0;
		for(Osoba x : p1) {
			if(x instanceof Pracownik)
				if(((Pracownik) x).jestPortierem())
					suma++;
		}
		System.out.println(suma);
		System.out.println("=================");
		
		System.out.println(p1.size());
		Lekarz l1 = new Lekarz("14514", "chirurg", 2256, 12);
		p1.add(l1);
		if(p1.contains(l1))
			p1.remove(l1);
		
		
		int suma1 = 0, suma2 = 0;
		
		for(Osoba x : p1) {
			if(x instanceof Lekarz)
				suma1++;
			else if(x instanceof Pracownik)
				suma2++;
		}
		
		System.out.println(suma1 + " " + suma2);
		
		try {
			PrintWriter zapis = new PrintWriter("plik.txt");
			for (Osoba x : p1)
				if(x instanceof Lekarz) {
					zapis.println(x.toString());
					zapis.println(((Lekarz) x).wyswietlLiczbePacjentow());
					
				}
			zapis.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	
}
