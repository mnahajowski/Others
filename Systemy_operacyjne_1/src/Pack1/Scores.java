package Pack1;

import java.util.ArrayList;
import java.util.Random;

public class Scores {

	Algorithms al = new Algorithms();
	
	public ArrayList <Score> average (int kwanty, int counter) {
		
		ArrayList <Score> result = new ArrayList <Score>();
		ArrayList <Process> myProcesses = new ArrayList <Process>();
		
		double FCFSscore = 0;
		double SJFscore = 0;
		double SJFwyglscore = 0;
		double ROTscore = 0;
		counter = 1;
            
		for(int j = 0; j < counter; j++) {
			for (int i = 0; i < 40; i++) {
				
	            Random gen = new Random();
	            int a = gen.nextInt(20);
	            int b = 1 + gen.nextInt(20); // time needs to me more than 0
	            
	            //myProcesses.add(new Process(i, a, b, b, 0));
	            Process p1 = new Process(1, a, b, b, 0);
	            myProcesses.add(p1);
	            System.out.println(p1.getMoment_of() + " " + p1.getTime_remain());
			}
			
            FCFSscore += al.FCFS(myProcesses);
            SJFscore += al.SJF(myProcesses);
            SJFwyglscore += al.SJFwygl(myProcesses);
            ROTscore += al.ROT(kwanty, myProcesses);
            
            
            
            System.out.println("FCFS: " + al.FCFS(myProcesses) + " " + "SJF: " + al.SJF(myProcesses)
            + " " + " SJFwygl: " +al.SJFwygl(myProcesses)+ " " + "ROT: " + al.ROT(kwanty, myProcesses) );
            //jeszce wypisac wyniki w poszczegolnych
            //jeszcze rot
            myProcesses.clear();
        }
		
		result.add(new Score ("FCFS", FCFSscore/counter));
		result.add(new Score ("SJF", SJFscore/counter));
		result.add(new Score ("SJFwygl", SJFwyglscore/counter));
		result.add(new Score ("ROT", ROTscore/counter));
		
		return result;
		
	}
	
}
