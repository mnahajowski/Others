package Pack1;
import java.util.ArrayList;
public class Score {

	public Score(int liczba_ref, int przedzial, ArrayList arr) {
		
		ArrayList <Strona> Referencje = new ArrayList<>();
		//int a, b;
		
		//b = (int)Math.random() * przedzial;
		for(int i = 1; i < liczba_ref; i++) {
		//	a = b;
			//b = (int)(Math.random() * przedzial);
		
			int a  =(int)(Math.random() * przedzial);
			/*if(i%2 == 0) {
				Referencje.add(new Strona(a, true, 0));
				System.out.println(a);
			}
			else {
				Referencje.add(new Strona(b, true, 0));
				
				System.out.println(b);
			}*/
			
			Referencje.add(new Strona(a, true, 0));
		}
		
		
		for(int i = 0; i < arr.size(); i++) {
			Algorytmy a1 = new Algorytmy((int)arr.get(i), Referencje);
			System.out.println("\nRozmiar ramki: " + (int)arr.get(i));
           System.out.println("FIFO: " + a1.FIFO() + " RAND: " + a1.RAND()+ " LRU: " + a1.LRU()+ " OPT: " + a1.OPT()+ " ALRU: " + a1.ALRU());
            	
		}
	}
}
