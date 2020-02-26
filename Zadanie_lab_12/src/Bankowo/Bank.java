package Bankowo;
import java.util.Scanner;
public class Bank {

	private int n;
	private Klient [] konto;
	
	public Bank(int n) {
		this.n = n;
		this.konto = new Klient[n];
		for(int i = 0; i < konto.length; i++) {
			konto[i] = new Klient();
		}
	}
	
	
	public void show(int n) {
		if(n < konto.length) {
			System.out.println(konto[n].toString());
			show(n+1);
		}
	}
	public void wypelnij() {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < konto.length; i++) {
			konto[i].setNumerKonta(scan.nextInt());
			konto[i].setNazwisko(scan.next());
			konto[i].setSaldo(scan.nextDouble());
		}
	}
	
	public int find(int numer, int i) {
		if(i < konto.length) {
			if(numer == konto[i].getNumerKonta())
				return i;
			else
				find(numer, i+1);
			
		}
		return -1;
	}
	
	public void update(int i) {
		if(i < konto.length) {
			if(konto[i].getSaldo() > 2000)
				konto[i].setSaldo(konto[i].getSaldo() * 1.1);
			else
				konto[i].setSaldo(konto[i].getSaldo() * 1.05);
			update(i+1);
		}
	}
	
	public void choinka(int h) {
		
		for(int i = 0; i < h; i++)
			System.out.print("*");
		System.out.println();
		if(h > 1)
			choinka(h-1);
	}
}
