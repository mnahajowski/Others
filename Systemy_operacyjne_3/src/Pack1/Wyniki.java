package Pack1;
import java.util.ArrayList;
import java.util.Scanner;

public class Wyniki {

	public static void main(String [] args) {
		
		ArrayList ramki = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ile referencji");
		int a = sc.nextInt();
		
		System.out.println("Jaki zakres");
		int b = sc.nextInt();
		
		System.out.println("Ile roznych rozmiarow ramek");
		int c = sc.nextInt();
		//c to liczba roznych rozmiarow ramek
		//b to indeks ramki
		//p to kolejne podawane roziary ramki
		for(int i = 0; i < c; i++) {
			int j = i + 1;
			System.out.println("Rozmiar ramki " + j + " : ");
			int p = sc.nextInt();
			ramki.add(p);
		}
		
		Score s = new Score(a,b, ramki);
	}
}
