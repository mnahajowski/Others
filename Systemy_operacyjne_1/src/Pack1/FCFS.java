package Pack1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collections;
public class FCFS {

	public double FCFS(ArrayList<Process> processes) {
		ArrayList <Process> myProcesses = new ArrayList<Process>(processes.size());
		
		double fulltimeWaiting = 0;
		int fulltimeEnd;
		
		for(int i = 0; i < processes.size(); i++) {
			myProcesses.add(new Process (processes.get(i).getNumber(), processes.get(i).getMoment_of(),
					processes.get(i).getProcess_length(), processes.get(i).getProcess_length(), 0));
		}
		
		Collections.sort(myProcesses, Process.myComparators.Moment_of_Comparator);
		
		fulltimeEnd = myProcesses.get(0).getProcess_length();
		
		for(int i = 1; i < myProcesses.size(); i++) {
			if(fulltimeEnd <= myProcesses.get(i).getMoment_of()) {
				fulltimeEnd = myProcesses.get(i).getMoment_of() + myProcesses.get(i).getProcess_length();
			}
			else {
				fulltimeWaiting += fulltimeWaiting - myProcesses.get(i).getMoment_of();
				fulltimeEnd += myProcesses.get(i).getProcess_length();
			}
		}
		
		return fulltimeWaiting/myProcesses.size();
	}
}
