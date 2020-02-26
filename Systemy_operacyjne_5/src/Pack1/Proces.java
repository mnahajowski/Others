package Pack1;

import java.util.Comparator;

public class Proces {
	int arrive;
	private int usage;
	private int time;
	
	public Proces(int arrive, int usage, int time) {
		this.arrive = arrive;
		this.usage = usage;
		this.time = time;
	}
	
	public Proces(Proces p1) {
		this.arrive = p1.getArrive();
		this.usage = p1.getUsage();
		this.time = p1.getTime();
	}
	
	public int getArrive() {
		return arrive;
	}

	public void setArrive(int arrive) {
		this.arrive = arrive;
	}

	public int getUsage() {
		return usage;
	}

	public void setUsage(int usage) {
		this.usage = usage;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}


	public static Comparator<Proces> arriveComparator = new Comparator<Proces> (){
		@Override
		public int compare(Proces p1, Proces p2) {
			return p1.arrive - p2.arrive;
		}
	};
	
	
}
