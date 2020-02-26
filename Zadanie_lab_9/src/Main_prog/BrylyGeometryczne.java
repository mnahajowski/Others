package Main_prog;
import Bryly.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.io.*;
import java.lang.Iterable;
public class BrylyGeometryczne{
	
	private ArrayList<Bryla> b1;
	private BrylaCompare_kolor Comparator1;
	private BrylaCompare_h Comparator2;

	
	public BrylyGeometryczne() {
		b1 = new ArrayList<Bryla>();
	}
	
	public void create() {
		b1.add(new Stozek("s1", 5, 3));
		b1.add(new Stozek("s2", 4, 4));
		b1.add(new Stozek("s3", 3, 5));
		b1.add(new Stozek("s4", 2, 6));
		b1.add(new Stozek("s5", 1, 7));
		b1.add(new Ostroslup("o1", 5, 5, 5));
		b1.add(new Ostroslup("o2", 6, 3, 22));
		b1.add(new Ostroslup("o3", 4, 5, 1));
		b1.add(new Ostroslup("o4", 7, 5, 3));
		b1.add(new Ostroslup("o5", 2, 5, 9));
	}
	
	public void show() {
		for(Bryla b : b1) {
			System.out.println(b.toString());
		}
	}
	
	public void max_Obj() {
		double max_obj = b1.get(0).Objetosc();
		int indeks = 0;
		for(Bryla b : b1) {
			if(b.Objetosc() > max_obj) {
				max_obj = b.Objetosc();
				indeks = b1.indexOf(b);
			}
		}
		System.out.println(b1.get(indeks).toString() + " " + max_obj + " indeks = " + indeks);
	}
	
	public void createComparators() {
		Comparator1 = new BrylaCompare_kolor();
		Comparator2 = new BrylaCompare_h();
	}
	
	public static void main(String[] args) {
		BrylyGeometryczne b1 = new BrylyGeometryczne();
		b1.create();
		b1.show();
		System.out.println("\n \n \n");
		b1.max_Obj();
		System.out.println("\n \n \n");
		b1.createComparators();
		Collections.sort(b1.getBryla(), b1.getComparator1());	
		b1.show();
		System.out.println("\n \n \n");
		Collections.sort(b1.getBryla(), b1.getComparator2());
		b1.show();
		System.out.println("\n \n \n");
	//	b1.zapis();
	//	b1.odczyt();
		b1.zapis_txt();
		
				
	}
	
	public void zapis_txt() {
		try {
			PrintWriter zapis = new PrintWriter("plik_tekst2.txt");
			for(Bryla b : b1)
				zapis.println(b.toString());
			zapis.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void zapis() {
		try{
	         FileOutputStream fos= new FileOutputStream("myfile1.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(b1);
	         oos.close();
	       }catch(IOException e){
	            e.printStackTrace();
	        }
	}
	
	public void odczyt() {
		try {
			FileInputStream strumienPlk = new FileInputStream("myfile1.ser");
			
			ObjectInputStream is = new ObjectInputStream(strumienPlk);
			ArrayList <Ostroslup> a1 = new ArrayList();
			ArrayList <Stozek> a2 = new ArrayList();
			ArrayList <Bryla> a3 = null;

			a3 = (ArrayList<Bryla>)is.readObject();
			for(Object ob1 : a3) {
				if(ob1 instanceof Ostroslup)
					a1.add((Ostroslup)(ob1));
				else
					a2.add((Stozek)(ob1));
			}
			
			for(Bryla a : a1) {
				System.out.println(a.toString());
			}
			System.out.println("\n \n \n");
			
			for(Bryla a : a2) {
				System.out.println(a.toString());
			}
			
			is.close();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class BrylaCompare_h implements  Comparator<Bryla> {
		public int compare(Bryla b1, Bryla b2) {
			if(b1.getH() > b2.getH()) return 1;
			if(b1.getH() < b2.getH()) return -1;
			return 0;				
		}
	}
	
	class BrylaCompare_kolor implements  Comparator<Bryla> {
		public int compare(Bryla b1, Bryla b2) {
			return b1.getKolor().compareTo(b2.getKolor());
		}
	}
	
	public BrylaCompare_kolor getComparator1() {
		return Comparator1;
	}
	public BrylaCompare_h getComparator2() {
		return Comparator2;
	}
	public ArrayList getBryla() {
		return b1;
	}
}
