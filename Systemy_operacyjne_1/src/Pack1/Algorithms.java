package Pack1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collections;
public class Algorithms {

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
				fulltimeWaiting += fulltimeEnd - myProcesses.get(i).getMoment_of();
				fulltimeEnd += myProcesses.get(i).getProcess_length();
			}
		}
		
		return fulltimeWaiting/myProcesses.size();
	}
	
	public double SJF(ArrayList <Process> processes) {
		int fulltimeWaiting = 0;
		double current = 0;
		
		ArrayList <Process> myProcesses = new ArrayList<Process>();
		ArrayList <Process> ProcessesInQueue = new ArrayList <Process>();
		
		for(int i = 0; i < processes.size(); i++) {
			myProcesses.add(new Process (processes.get(i).getNumber(), processes.get(i).getMoment_of(),
					processes.get(i).getProcess_length(), processes.get(i).getProcess_length(), 0));
		}
		
		Collections.sort(myProcesses, Process.myComparators.Moment_of_Comparator);
		
		while(current != 1000000) {
			for(int i = 0; i < myProcesses.size(); i++) {
				if(current == myProcesses.get(i).getMoment_of())
					ProcessesInQueue.add(new Process(0, 0, 0, myProcesses.get(i).getTime_remain(),0));
			}
			
			if(ProcessesInQueue.size() == 0)
				Collections.sort(ProcessesInQueue, Process.myComparators.Time_remain_Comparator);
			else if(ProcessesInQueue.get(0).getTime_remain() == 0) {
				fulltimeWaiting += ProcessesInQueue.get(0).getTime_waiting();
				ProcessesInQueue.remove(0);
				Collections.sort(ProcessesInQueue, Process.myComparators.Time_remain_Comparator);
			}
			current++;
						
			if(ProcessesInQueue.size() != 0) {
				ProcessesInQueue.get(0).setTime_remain(ProcessesInQueue.get(0).getTime_remain() - 1);
				
				for(int j = 1; j < ProcessesInQueue.size(); j++) {
					ProcessesInQueue.get(j).setTime_waiting(ProcessesInQueue.get(j).getTime_waiting() + 1);
				}
			}
		}
		return fulltimeWaiting/myProcesses.size();
	}
	
	public double SJFwygl(ArrayList <Process> processes) {
		double fulltimeWaiting = 0;
		int current = 0;
//		int counter = 0;
		

		ArrayList <Process> myProcesses = new ArrayList<Process>();
		ArrayList <Process> ProcessesInQueue = new ArrayList <Process>();
		
		for(int i = 0; i < processes.size(); i++) {
			myProcesses.add(new Process (processes.get(i).getNumber(), processes.get(i).getMoment_of(),
					processes.get(i).getProcess_length(), processes.get(i).getProcess_length(), 0));
		}
		
		Collections.sort(myProcesses, Process.myComparators.Moment_of_Comparator);
		
		while(current != 1000000) {
			for(int i = 0; i < myProcesses.size(); i++) {
				if(current == myProcesses.get(i).getMoment_of()) {
					
				
//					ProcessesInQueue.add(new Process(0, 0, 0, myProcesses.get(i).getTime_remain(),0));
			
					if(ProcessesInQueue.size() != 0 && ProcessesInQueue.get(0).getTime_remain() <
							myProcesses.get(i).getTime_remain()) {
//							counter++;
					}
					ProcessesInQueue.add(new Process(0, 0, 0, myProcesses.get(i).getTime_remain(),0));
					Collections.sort(ProcessesInQueue, Process.myComparators.Time_remain_Comparator);
						
			
				}
			}
			current++;
		
			if(ProcessesInQueue.size() != 0) {
				ProcessesInQueue.get(0).setTime_remain(ProcessesInQueue.get(0).getTime_remain() - 1);
			
				for(int j = 1; j < ProcessesInQueue.size(); j++) {
					ProcessesInQueue.get(j).setTime_waiting(ProcessesInQueue.get(j).getTime_waiting() + 1);
				}
				if(ProcessesInQueue.get(0).getTime_remain() == 0) {
					fulltimeWaiting += ProcessesInQueue.get(0).getTime_waiting();
					ProcessesInQueue.remove(0);
				}
			}
		}
		return fulltimeWaiting / myProcesses.size();
	}
	
	public double ROT(int k, ArrayList <Process> processes) {
		double fulltimeWaiting = 0;
		int current = 0;
		int kwanty = 0;
		
		ArrayList <Process> myProcesses = new ArrayList<Process>();
		ArrayList <Process> ProcessesInQueue = new ArrayList <Process>();
		
		for(int i = 0; i < processes.size(); i++) {
			myProcesses.add(new Process (processes.get(i).getNumber(), processes.get(i).getMoment_of(),
					processes.get(i).getProcess_length(), processes.get(i).getProcess_length(), 0));
		}
		
		Collections.sort(myProcesses, Process.myComparators.Moment_of_Comparator);
		
		while(current != 1000000) {
			
			for(int i = 0; i < myProcesses.size(); i++) {
				if(current == myProcesses.get(i).getMoment_of())
					ProcessesInQueue.add(new Process(0, myProcesses.get(i).getMoment_of(), 0, myProcesses.get(i).getTime_remain(),0));
			}
			
			if(ProcessesInQueue.size() != 0 && kwanty <=0) {
				if(ProcessesInQueue.get(0).getTime_remain() == 0) {
					fulltimeWaiting += (ProcessesInQueue.get(0).getTime_waiting());
					ProcessesInQueue.remove(0);
					Collections.sort(ProcessesInQueue, Process.myComparators.Number_Comparator);
					
					if(ProcessesInQueue.size() != 0) {
						ProcessesInQueue.get(0).setNumber(ProcessesInQueue.get(0).getNumber() + 1);
						if(ProcessesInQueue.get(0).getTime_remain() >= k) {
							kwanty = k;
						}
						else {
							kwanty = ProcessesInQueue.get(0).getTime_remain();
						}
						
					}
				}
			
				else {
					if(ProcessesInQueue.size() == 1) {
						ProcessesInQueue.get(0).setNumber(ProcessesInQueue.get(0).getNumber() + 1);
					}
					else {
						ProcessesInQueue.add(ProcessesInQueue.get(0));
						ProcessesInQueue.remove(0);
						Collections.sort(ProcessesInQueue, Process.myComparators.Number_Comparator);
						ProcessesInQueue.get(0).setNumber(ProcessesInQueue.get(0).getNumber()+1);
					}
					if(ProcessesInQueue.get(0).getTime_remain() >= k) {
						kwanty = k;
					}
					else {
						kwanty = ProcessesInQueue.get(0).getTime_remain();
					}
				}
			}
			
			if(ProcessesInQueue.size() != 0) {
				ProcessesInQueue.get(0).setTime_remain(ProcessesInQueue.get(0).getTime_remain()-1);
				
				for(int j = 1; j < ProcessesInQueue.size(); j++) {
					ProcessesInQueue.get(j).setTime_waiting(ProcessesInQueue.get(j).getTime_waiting() + 1);
				}
			}
			current++;
			kwanty--;
				
		}
		return fulltimeWaiting / myProcesses.size();
	
	}
		
}
