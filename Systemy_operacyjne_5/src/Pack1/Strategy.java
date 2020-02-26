package Pack1;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;

import java.util.Collections;

public class Strategy {
	ArrayList<Proces> timeQueue = new ArrayList<Proces>();
	ArrayList<Procesor> procesors = new ArrayList<Procesor>();
	// trzeba jeszcze wypelnic arrayliste procesow czyli time queue
	public Strategy(int numb_procesors, int numb_procesow, int zakres_czasu_dzialania, int moment_arrival) {
		for(int i = 0; i < numb_procesors; i++) {
			procesors.add(new Procesor());
		}
		for(int i = 0; i < numb_procesow; i++) {
			int a  =1 +(int)(Math.random() * zakres_czasu_dzialania);
//			System.out.println(a);
			Random gen = new Random();
			int b = 1 + gen.nextInt(moment_arrival);
	//		System.out.println(b);
			// maksymalne uzycie procesora przez 1 proces to 20%
			int c = 1 + gen.nextInt(20);
			timeQueue.add(new Proces(b, c, a));
		}
	}

	public double strategia1() {
		int currentTime = 0;
		ArrayList<Proces> arrivalQueue = new ArrayList<Proces>();
		ArrayList<Procesor> procesory = new ArrayList<Procesor>();
		ArrayList <Integer> obciazenia = new ArrayList <Integer>();
		int counter_of_asking = 0;
		int counter_of_moves = 0;
		
		int z = 20;		// ilosc mozliwych zapytan do innych procesorow
		int b = 0;		// licznik do ilosci juz wykonanych zapytan
		for(Proces a: timeQueue) {
			arrivalQueue.add(new Proces(a));
		}
		
		for(Procesor a: procesors) {
			procesory.add(new Procesor(a));
		}
		Collections.sort(arrivalQueue, Proces.arriveComparator);
		Random gen = new Random();
		int index, index2;
//		System.out.println(currentTime);
	/*
    	for(int i = 0; i < arrivalQueue.size(); i++) {
			System.out.println(arrivalQueue.get(i).getArrive());
		}*/
    	int suma = 0;
		while(arrivalQueue.size() != 0) {
			
			/* robimy obciazenie*/
			for(int i = 0; i < procesory.size(); i++) {
				suma += procesory.get(i).obciazenie_proc();
	//			System.out.println("Procesor : " + i + "obciazenia" + procesory.get(i).obciazenie_proc());
			}
	//		System.out.println("Suma11: " + suma);
			obciazenia.add(suma/procesory.size());
			/****************************************************************/
			if(currentTime == arrivalQueue.get(0).getArrive()) {
				
				index = gen.nextInt(procesory.size());
				
				while(b < z) {		// trzeba bedzie wyjsc z tego breakiem jesli uda sie gdzies wstawic
					index2 = gen.nextInt(procesory.size());
					counter_of_asking++;
					if(procesory.get(index2).getUsage() <= procesory.get(index2).getBarrier()) {	// jest mniejsze obciazenie czyli dodajemy
						
						
						counter_of_moves++;
						procesory.get(index2).addProces(arrivalQueue.get(0));
						arrivalQueue.remove(0);
						break;
					}
					b++;
				}
				if(b == z) {		// jezeli nie znalezlismy lepszego to wykonujemy na tym ktory znalezlismy jako pierwszy
					procesory.get(index).addProces(arrivalQueue.get(0));
					arrivalQueue.remove(0);
				}
				b = 0;
				
				
			} else {
				currentTime++;
	//			System.out.println(arrivalQueue.size());
				for(int i = 0; i < procesory.size(); i++) {
					procesory.get(i).nextCzas();
	 			//System.out.print(procesory.get(i).getUsage() + " ");
				}
				//System.out.println();
				
	//			System.out.println(currentTime);
			}
			suma = 0;
//			System.out.println("Koniec");
			
			//System.out.println(currentTime);
		}
		currentTime++;
//		System.out.println(currentTime);
		//			System.out.println(arrivalQueue.size());
		suma = 0;
		for(int i = 0; i < procesory.size(); i++) {
			suma += procesory.get(i).obciazenie_proc();
		}
//		System.out.println("Suma na koncu: " + suma);
		obciazenia.add(suma/procesory.size());
		
		while (suma != 0) {
			suma = 0;
			for(int i = 0; i < procesory.size(); i++) {
				
				currentTime++;
				procesory.get(i).nextCzas();
			}
			for(int i = 0; i < procesory.size(); i++) {
				suma += procesory.get(i).obciazenie_proc();
			}
//			System.out.println(suma);
			obciazenia.add(suma/procesory.size());
			
			
			
	//		System.out.println();
		}
//		System.out.println(currentTime);
		
		double suma2 = 0.0;
		for(int i = 0; i < obciazenia.size(); i++) {
			suma2 += (double)obciazenia.get(i);
		}
		double srednia = suma2/obciazenia.size();
		double wynik = 0;
		for(int i = 0; i < obciazenia.size(); i++) {
			wynik += ((double)obciazenia.get(i) - srednia)*((double)obciazenia.get(i) - srednia);
		}
		double odchylenie = Math.sqrt((wynik/obciazenia.size()));
		
		System.out.println("Odchylenie : " + odchylenie);
		System.out.println("Liczba zapytan: " + counter_of_asking);
		System.out.println("Liczba przeniesien : " + counter_of_moves);
		return suma2/obciazenia.size();
		
		
	}

	
	public double strategia2() {
		int currentTime = 0;
		int counter_of_asking = 0;
		int counter_of_moves = 0;
		ArrayList<Proces> arrivalQueue = new ArrayList<Proces>();
		ArrayList<Procesor> procesory = new ArrayList<Procesor>();
		ArrayList <Integer> obciazenia = new ArrayList <Integer>();
		
		for(Proces a: timeQueue) {
			arrivalQueue.add(new Proces(a));
		}
		
		for(Procesor a: procesors) {
			procesory.add(new Procesor(a));
		}
		Collections.sort(arrivalQueue, Proces.arriveComparator);
		Random gen = new Random();
		int index, index2;
//		System.out.println(currentTime);
	/*
    	for(int i = 0; i < arrivalQueue.size(); i++) {
			System.out.println(arrivalQueue.get(i).getArrive());
		}*/
    	int suma = 0;
		while(arrivalQueue.size() != 0) {
			
			/* robimy obciazenie*/
			for(int i = 0; i < procesory.size(); i++) {
				suma += procesory.get(i).obciazenie_proc();
			}
	//		System.out.println("Suma11: " + suma);
			obciazenia.add(suma/procesory.size());
	//		System.out.println("jestem");
			/****************************************************************/
			if(currentTime == arrivalQueue.get(0).getArrive()) {
				/*
				index = gen.nextInt(procesory.size());
				
				while(b < z) {		// trzeba bedzie wyjsc z tego breakiem jesli uda sie gdzies wstawic
					index2 = gen.nextInt(procesory.size());
					if(procesory.get(index2).getUsage() <= procesory.get(index2).getBarrier()) {	// jest mniejsze obciazenie czyli dodajemy
						procesory.get(index2).addProces(arrivalQueue.get(0));
						arrivalQueue.remove(0);
						break;
					}
					b++;
				}
				
				if(b == z) {		// jezeli nie znalezlismy lepszego to wykonujemy na tym ktory znalezlismy jako pierwszy
					procesory.get(index).addProces(arrivalQueue.get(0));
					arrivalQueue.remove(0);
				}
				
				b = 0;*/
				index = gen.nextInt(procesory.size());

				if(procesory.get(index).getUsage() <= procesory.get(index).getBarrier()) {
					procesory.get(index).addProces(arrivalQueue.get(0));
					arrivalQueue.remove(0);
	//				System.out.println(procesory.get(index).getUsage());
				}
				else {
					while(true) {
						index2 = gen.nextInt(procesory.size());
						counter_of_asking++;
						if(procesory.get(index2).getUsage() <= procesory.get(index2).getBarrier()) {	// jest mniejsze obciazenie czyli dodajemy
							procesory.get(index2).addProces(arrivalQueue.get(0));
							arrivalQueue.remove(0);
							counter_of_moves++;
	//						System.out.println("jestem");
							break;
						}
					}
//					System.out.println("jestem");
				}
			
			} else {
				currentTime++;
	//			System.out.println(arrivalQueue.size());
				for(int i = 0; i < procesory.size(); i++) {
					procesory.get(i).nextCzas();
				}
	//			System.out.println(currentTime);
			}
			suma = 0;
//			System.out.println("Koniec");
			
			//System.out.println(currentTime);
		}
		currentTime++;
//		System.out.println(currentTime);
		//			System.out.println(arrivalQueue.size());
		suma = 0;
		for(int i = 0; i < procesory.size(); i++) {
			suma += procesory.get(i).obciazenie_proc();
		}
//		System.out.println("Suma na koncu: " + suma);
		obciazenia.add(suma/procesory.size());
		
		while (suma != 0) {
			suma = 0;
			for(int i = 0; i < procesory.size(); i++) {
				
				currentTime++;
				procesory.get(i).nextCzas();
			}
			for(int i = 0; i < procesory.size(); i++) {
				suma += procesory.get(i).obciazenie_proc();
			}
//			System.out.println(suma);
			/*
			obciazenia.add(suma/procesory.size());
			for(int i = 0; i < procesory.size(); i++) {
				System.out.print(procesory.get(i).getUsage() + " ");
			}
			System.out.println();*/
		}
//		System.out.println(currentTime);
		
		double suma2 = 0.0;
		for(int i = 0; i < obciazenia.size(); i++) {
			suma2 += (double)obciazenia.get(i);
		}
		
		double srednia = suma2/obciazenia.size();
		double wynik = 0;
		for(int i = 0; i < obciazenia.size(); i++) {
			wynik += ((double)obciazenia.get(i) - srednia)*((double)obciazenia.get(i) - srednia);
		}
		double odchylenie = Math.sqrt((wynik/obciazenia.size()));
		
		System.out.println("Odchylenie : " + odchylenie);
		
		System.out.println("Liczba zapytan: " + counter_of_asking);
		System.out.println("Liczba przeniesien : " + counter_of_moves);
		return suma2/obciazenia.size();
		
	}
	
	public double strategia3() {
		int currentTime = 0;
		ArrayList<Proces> arrivalQueue = new ArrayList<Proces>();
		ArrayList<Procesor> procesory = new ArrayList<Procesor>();
		ArrayList <Integer> obciazenia = new ArrayList <Integer>();
		int counter_of_asking = 0;
		int counter_of_moves = 0;
		
		for(Proces a: timeQueue) {
			arrivalQueue.add(new Proces(a));
		}
		
		for(Procesor a: procesors) {
			procesory.add(new Procesor(a));
		}
		Collections.sort(arrivalQueue, Proces.arriveComparator);
		Random gen = new Random();
		int index, index2;
//		System.out.println(currentTime);
	/*
    	for(int i = 0; i < arrivalQueue.size(); i++) {
			System.out.println(arrivalQueue.get(i).getArrive());
		}*/
    	int suma = 0;
		while(arrivalQueue.size() != 0) {
			
			/* robimy obciazenie*/
			for(int i = 0; i < procesory.size(); i++) {
				suma += procesory.get(i).obciazenie_proc();
			}
	//		System.out.println("Suma11: " + suma);
			obciazenia.add(suma/procesory.size());
	//		System.out.println("jestem");
			/****************************************************************/
			if(currentTime == arrivalQueue.get(0).getArrive()) {
				/*
				index = gen.nextInt(procesory.size());
				
				while(b < z) {		// trzeba bedzie wyjsc z tego breakiem jesli uda sie gdzies wstawic
					index2 = gen.nextInt(procesory.size());
					if(procesory.get(index2).getUsage() <= procesory.get(index2).getBarrier()) {	// jest mniejsze obciazenie czyli dodajemy
						procesory.get(index2).addProces(arrivalQueue.get(0));
						arrivalQueue.remove(0);
						break;
					}
					b++;
				}
				
				if(b == z) {		// jezeli nie znalezlismy lepszego to wykonujemy na tym ktory znalezlismy jako pierwszy
					procesory.get(index).addProces(arrivalQueue.get(0));
					arrivalQueue.remove(0);
				}
				
				b = 0;*/
				index = gen.nextInt(procesory.size());
				if(procesory.get(index).getUsage() <= procesory.get(index).getBarrier()) {
					procesory.get(index).addProces(arrivalQueue.get(0));
					arrivalQueue.remove(0);
				}
				else {
					while(true) {
						
						index2 = gen.nextInt(procesory.size());
						counter_of_asking++;
						if(procesory.get(index2).getUsage() <= procesory.get(index2).getBarrier()) {	// jest mniejsze obciazenie czyli dodajemy
							procesory.get(index2).addProces(arrivalQueue.get(0));
							arrivalQueue.remove(0);
							counter_of_moves++;
	//						System.out.println("jestem");
							break;
						}
					}
//					System.out.println("jestem");
				}
			
			} else {
				currentTime++;
	//			System.out.println(arrivalQueue.size());
				for(int i = 0; i < procesory.size(); i++) {
					procesory.get(i).nextCzas();
				}
	//			System.out.println(currentTime);
			}
//			System.out.println("Koniec");
			
			//System.out.println(currentTime);
			
			
			for(int i = 0; i < procesory.size(); i++) {
				if(procesory.get(i).getUsage() < procesory.get(i).getBarrier()) {
					index2 = gen.nextInt(procesory.size());
	//				System.out.println(procesory.get(index2).getUsage());
					if(procesory.get(index2).getUsage() >= procesory.get(index2).getBarrier()) {
						procesory.get(i).zamiana(procesory.get(index2));
						counter_of_moves++;
					}
				}
			}
			suma = 0;
			
		}
		currentTime++;
//		System.out.println(currentTime);
		//			System.out.println(arrivalQueue.size());
		suma = 0;
		for(int i = 0; i < procesory.size(); i++) {
			suma += procesory.get(i).obciazenie_proc();
		}
//		System.out.println("Suma na koncu: " + suma);
		obciazenia.add(suma/procesory.size());
		
		
		for(int i = 0; i < procesory.size(); i++) {
			if(procesory.get(i).getUsage() < procesory.get(i).getBarrier()) {
				index2 = gen.nextInt(procesory.size());
				if(procesory.get(index2).getUsage() >= procesory.get(index2).getBarrier()) {
					procesory.get(i).zamiana(procesory.get(index2));
				}
			}
		}
		
		while (suma != 0) {
	//		System.out.println("jestem");
			suma = 0;
			for(int i = 0; i < procesory.size(); i++) {
				
				currentTime++;
				procesory.get(i).nextCzas();
			}
			for(int i = 0; i < procesory.size(); i++) {
				suma += procesory.get(i).obciazenie_proc();
//				System.out.println("Procesor : " + i + "obciazenia" + procesory.get(i).obciazenie_proc());
				if(currentTime > 60)
					suma = 0;
			}
//			System.out.println(suma);
			obciazenia.add(suma/procesory.size());
			
			for(int i = 0; i < procesory.size(); i++) {
				if(procesory.get(i).getUsage() < procesory.get(i).getBarrier()) {
					index2 = gen.nextInt(procesory.size());
					if(procesory.get(index2).getUsage() >= procesory.get(index2).getBarrier()) {
						procesory.get(i).zamiana(procesory.get(index2));
					}
				}
			}
		}
//		System.out.println(currentTime);
		
		double suma2 = 0.0;
		for(int i = 0; i < obciazenia.size(); i++) {
			suma2 += (double)obciazenia.get(i);
		}
		double srednia = suma2/obciazenia.size();
		double wynik = 0;
		
		for(int i = 0; i < obciazenia.size(); i++) {
			wynik += ((double)obciazenia.get(i) - srednia)*((double)obciazenia.get(i) - srednia);
		}
		double odchylenie = Math.sqrt((wynik/obciazenia.size()));
		
		System.out.println("Odchylenie : " + odchylenie);
		
		System.out.println("Liczba zapytan: " + counter_of_asking);
		System.out.println("Liczba przeniesien : " + counter_of_moves);
		
		return suma2/obciazenia.size();
		
	}

}
