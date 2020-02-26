package Main_prog;

public class Konwerter {
	private static final double przelicznik =4.29;
	
	static double toEuro(double liczba) {
		liczba /= przelicznik;
		return liczba;
	}
	
	static double toZloty(double liczba) {
		liczba *= przelicznik;
		return liczba;
	}
}
