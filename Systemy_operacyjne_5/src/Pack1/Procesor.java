package Pack1;

import java.util.ArrayList;

public class Procesor {
	private int usage;
	private int barrier = 30;	// bariera 70% wykorzystania procesora
	ArrayList<Proces> procesy = new ArrayList<Proces>();
	public Procesor() {
		this.usage = 0;
	}
	
	public Procesor(Procesor p1) {
		this.usage = p1.getUsage();
	}

	public int getUsage() {
		return usage;
	}

	public void setUsage(int usage) {
		this.usage = usage;
	}

	public int getBarrier() {
		return barrier;
	}

	public void setBarrier(int barrier) {
		this.barrier = barrier;
	}
	public void addProces(Proces p1) {
		procesy.add(p1);
	//	System.out.println("Procesor przed dodaniem" + this.getUsage());
	//	System.out.println("Proces ktory dodajemy " + p1.getUsage());
		setUsage(getUsage() + p1.getUsage());
	//	System.out.println("Procesor po dodaniu" + this.getUsage());
	}
	public void nextCzas() {	// pchniecie o jedna jednostke czasu
		for(int i = 0; i < procesy.size(); i++) {
			procesy.get(i).setTime(procesy.get(i).getTime() - 1);
	//		System.out.println(procesy.get(i).getTime());
			if(procesy.get(i).getTime() == 0) {		// jak proces sie skonczyl to go wyrzucamy
	//			System.out.println("Usuwamy");
	//			System.out.println("Procesor przed usunieciem " + this.getUsage());
	//			System.out.println("Proces ktory usuwamy " + procesy.get(i).getUsage());
				
				setUsage(getUsage() - procesy.get(i).getUsage()); 
	//			System.out.println("Procesor po usunieciu " + this.getUsage());
				procesy.remove(i);
			}
		}
	}
	// jeszcze trzebA ZMIENIAC USAGE JAK USUWAMY PROCES
	public int obciazenie_proc() {
		int suma = 0;
		for(int i = 0; i < procesy.size(); i++) {
			suma += procesy.get(i).getUsage();
		}
		if(procesy.size() > 0)
			return suma/procesy.size();
		else 
			return 0;
	}
	
	public void zamiana(Procesor p1) {
		/*System.out.println(p1.getUsage());
		for(int i = 0; i < p1.procesy.size(); i++) {
			System.out.print(p1.procesy.get(i));
		}*/
		
	//	System.out.println();
		if(!p1.procesy.isEmpty()) {
		
			Proces pp = new Proces(p1.procesy.get(0));
			p1.procesy.remove(0);
		//	System.out.println("zamiana");
	//		System.out.println(p1.getUsage());
			this.procesy.add(pp);
			if(!p1.procesy.isEmpty()) {
				pp = p1.procesy.get(0);
				this.procesy.add(pp);
			}
		}
		
	}
}
