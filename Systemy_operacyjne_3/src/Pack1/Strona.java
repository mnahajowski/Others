package Pack1;

import java.util.Comparator;

public class Strona {

	private int number;
	private boolean bit;
	private int nr_ref;
	//nr_ref to odwolanie
	//bit testuje czy odwolanie mialo miejsce

	
	public Strona(int number, boolean bit, int nr_ref) {
		this.number = number;
		this.bit = bit;
		this.nr_ref = nr_ref;
	}

	public Strona(Strona s1) {
		this.number = s1.getNumber();
		this.nr_ref = s1.getNr_ref();
		this.bit = s1.bit;
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNr_ref() {
		return nr_ref;
	}

	public void setNr_ref(int nr_ref) {
		this.nr_ref = nr_ref;
	}

	public boolean isBit() {
		return bit;
	}

	public void setBit(boolean bit) {
		this.bit = bit;
	}
	
	
	public String toString() {
		return number + " ";
	}
	
	public static Comparator <Strona> nr_ref_Comparator = new Comparator<Strona>() {
		public int compare (Strona s1, Strona s2) {
			return s1.getNr_ref() - s2.getNr_ref();
		}
	};
}
