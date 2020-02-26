package Figury;

public class Rysunki {
	

	public static void main(String [] args)  {
		
		Figura [] tab = new Figura[20];
		int n = 10;
		
		tab[0] = new Prostokat();
		tab[1] = new Okrag();
		tab[2] = new Prostokat("P1", 2, 2);
		tab[3] = new Okrag("O1", 3, 2, 2);
		tab[4] = new Prostokat("P2", 3, 2);
		tab[5] = new Okrag("O2", 2, 5, 5);
		tab[6] = new Prostokat("P3", 1, 5);
		tab[7] = new Okrag("O3", 3, 7, 2);
		tab[8] = new Prostokat("P4", 1, 6);
		tab[9] = new Okrag("O4", 4, 5, 3);
		
		double maxim = tab[0].Pole();
		String nazwa = tab[0].getNazwa();
		int indeks = 0;
		
		for(int i = 1; i < n; i++) {
			if(tab[i].Pole() > maxim) {
				maxim = tab[i].Pole();
				nazwa = tab[i].getNazwa();
				indeks = i;
			}
		}
		
		System.out.println("Max pole : " + maxim + " " + nazwa + " numer pozycji : " + indeks + " " + tab[indeks].getClass());
		System.out.println("\n\n");
		
		for(int i = 0; i < n; i++) {
			System.out.println(tab[i].toString());
		}
		
		System.out.println("\n\n");
		
		for(int i = 0; i < n; i++) {
			if(tab[i] instanceof Okrag)
				System.out.println(tab[i].toString());
		}
		
		System.out.println("\n\n");
		
		
		for(int i = 0; i < n; i++) {
			if(tab[i] instanceof Prostokat)
				System.out.println(tab[i].toString());
		}
		
		System.out.println("\n\n");
		
		int counter = 0;
		
		for(int i = 0; i < n; i++) {
			if(tab[i] instanceof Prostokat)
				if(((Prostokat)tab[i]).jestKwadratem())
					counter++;
		}
		
		System.out.println("Liczba kwadratow : " + counter);
		System.out.println("\n\n");
		
		int a = 1, b = 1;
		int counter2 = 0;
		
		for(int i = 0; i < n; i++) {
			if(tab[i] instanceof Okrag)
				if(((Okrag)tab[i]).nalezy(a, b))
					counter2++;
		}
		System.out.println("Ten punkt nalezy do " + counter2);
		System.out.println("\n\n");
	}
}
