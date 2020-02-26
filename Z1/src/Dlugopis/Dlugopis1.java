package Dlugopis;
import Uczen1.*;
public class Dlugopis1 {
	private Wklad w1 = null;
	private boolean maWlasciciela= false;
	
	public Dlugopis1() {
		this.w1 = new Wklad();
	}
	
	public Dlugopis1(int x) {
		this.w1 = new Wklad(x);
	}
	
	
	public Wklad getWklad() {
		return this.w1;
	}
	
	public boolean getmaWlasciela() {
		return maWlasciciela;
	}
	public String getStan() {
		return "kolor=" + getWklad().getStan() + getmaWlasciela() + " "+  Uczen.dajWlasciciela();
	}
	
	public void setmaWlasciciela() {
		maWlasciciela = true;
	}
	public void Wlasciciel(Dlugopis1 d1) {
		Uczen.maDlugopis(d1);
	}
	
	public void getWlasciciel() {
		Uczen.dajWlasciciela();
	}
	
	
}
