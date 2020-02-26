package Pack1;

import java.util.Comparator;


public class Process {
	
	
	private int number;
	private int process_length;
	private int moment_of;
	private int time_waiting;
	private int time_remain;
	
	public Process(int number, int moment_of, int process_length, int time_remain, int time_waiting) {
		this.number = number;
		this.process_length = process_length;
		this.moment_of = moment_of;
		this.time_waiting = 0;	// poczatkowy czas oczekiwania jest rowny 0
		this.time_remain = time_remain;		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getProcess_length() {
		return process_length;
	}

	public void setProcess_length(int process_length) {
		this.process_length = process_length;
	}

	public int getMoment_of() {
		return moment_of;
	}

	public void setMoment_of(int moment_of) {
		this.moment_of = moment_of;
	}

	public int getTime_waiting() {
		return time_waiting;
	}

	public void setTime_waiting(int time_waiting) {
		this.time_waiting = time_waiting;
	}

	public int getTime_remain() {
		return time_remain;
	}

	public void setTime_remain(int time_remain) {
		this.time_remain = time_remain;
	}
	
	public String toString() {
        return number + " " + moment_of + " " + process_length + " " + time_remain + " " + time_waiting;
	}
	
	
	public static class myComparators {
		public static Comparator<Process> Moment_of_Comparator = new Comparator <Process>() {
			
			public int compare(Process p1, Process p2) {
				return p1.moment_of - p2.moment_of;
			}
			
		};
		public static Comparator <Process> Time_remain_Comparator = new Comparator <Process>() {
			
			public int compare (Process p1, Process p2) {
				return p1.time_remain - p2.time_remain;
			}
		};
		
		public static Comparator <Process> Number_Comparator = new Comparator <Process>() {
			public int compare(Process p1, Process p2) {
				int score = p1.number - p2.number;
				
				if(score != 0)
					return score;
				else
					return p2.moment_of - p2.moment_of;
			}
		};
		
	}
	
}
