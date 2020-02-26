package Bankowo;

public class Klient {
	private int numerKonta;
	private String nazwisko;
	private double saldo;
	
	public Klient() {
		this.numerKonta = 1;
		this.nazwisko = "a";
		this.saldo = 0.0;
	}

	public Klient(int numerKonta, String nazwisko, double saldo) {
		this.numerKonta = numerKonta;
		this.nazwisko = nazwisko;
		this.saldo = saldo;
	}
	
	public int getNumerKonta() {
		return numerKonta;
	}
	public void setNumerKonta(int numerKonta) {
		this.numerKonta = numerKonta;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return this.getNumerKonta() + " " + this.getNazwisko() + " " + this.getSaldo();
	}
	
}
