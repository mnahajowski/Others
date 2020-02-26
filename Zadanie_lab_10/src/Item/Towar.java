package Item;
import java.util.HashSet;
public class Towar {

	private int kod;
	private String nazwa;
	private double cena;
	
	public Towar() {
		this.kod = 2;
		this.nazwa = "a";
		this.cena = 10.0;
	}
	
	public Towar(int kod, String nazwa, double cena) {
		this.kod = kod;
		this.nazwa = nazwa;
		this.cena = cena;
	}

	public int getKod() {
		return kod;
	}

	public void setKod(int kod) {
		this.kod = kod;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
	public String toString() {
		return "Kod : " + this.getKod() + " Nazwa : " + this.getNazwa() + " Cena " + this.getCena();
	}
	
	public int hashCode() {
		return (new Integer(this.getKod())).hashCode();
	}
	
	public boolean equals(Object obj) {
		Towar other = (Towar) obj;
		
		if (new Integer(this.getKod()).equals(new Integer(other.getKod()))) return true;
		 else return false;
	}
	
	
}
