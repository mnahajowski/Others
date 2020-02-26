package Pack1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Algorithms {
	final int SIZE_OF_DISK = 200;
	
	ArrayList<Process> timeQueue = new ArrayList<Process>();
	ArrayList<Process> normalqueue = new ArrayList<Process>();
	
	public Algorithms(ArrayList<Process> normalqueue, ArrayList <Process> timeQueue) {
        this.timeQueue = timeQueue;
        this.normalqueue = normalqueue;
	}
	/*
	public int FIFO_EDF() {
		
	int blocks = 0;
    int currentBlock = 0;
    int currentTime = 0;
    int rejected = 0;
    ArrayList<Process> Processes = new ArrayList<Process>();
    ArrayList<Process> priorityProcesses = new ArrayList<Process>();
    ArrayList<Process> waitingProcesses = new ArrayList<Process>();
    ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
    
    for (Process aProcess : normalqueue) {
        Processes.add(new Process(aProcess));
    }
    for (Process aProcess : timeQueue) {
        priorityProcesses.add(new Process(aProcess));
    }
   // System.out.println("prorityProcesses" + priorityProcesses);
    do {
        
        for (int i = 0; i < Processes.size(); i++)

        {
            if (currentTime == (Processes.get(i)).getArrive()) {

                waitingProcesses.add(Processes.get(i));
 //               System.out.println("waiting" + waitingProcesses);

            }
        }
        for (int i = 0; i < priorityProcesses.size(); i++)

        {
            if (currentTime == (priorityProcesses.get(i)).getArrive()) {

                waitingPriorityProcesses.add(priorityProcesses.get(i));
 //               System.out.println("waitingPrority" + waitingPriorityProcesses);

            }
        }
        if (waitingPriorityProcesses.size() != 0) {
     //       System.out.println("Priority: " + waitingPriorityProcesses);
            
            if (waitingPriorityProcesses.get(0).cylinder == currentBlock) {
       //         System.out.println("---------------------------------------------Priority done" + waitingPriorityProcesses.get(0));
                waitingPriorityProcesses.remove(0);
            }
            
            Collections.sort(waitingPriorityProcesses, Process.timeComparator);
            if (waitingPriorityProcesses.size() != 0 && currentBlock == waitingPriorityProcesses.get(0).cylinder) {
               
                if (waitingPriorityProcesses.get(0).time < Math.abs(waitingPriorityProcesses.get(0).cylinder - currentBlock)) {
         //           System.out.println("rejection");
                    rejected++;
                }
            }
            if (waitingPriorityProcesses.size() != 0) {
                
                if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
                    currentBlock++;
                }
                
                else {
                    currentBlock--;
                }
                blocks++;
                
                for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
                    waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
                }
            }
        }
        
        else if (waitingProcesses.size() != 0) {
           // System.out.println("Normalne: " + waitingProcesses);
            
            if (currentBlock == waitingProcesses.get(0).cylinder) {
             //   System.out.println("Normal Process has been done: " + waitingProcesses.get(0));
                waitingProcesses.remove(0);
            }
            
            if (waitingProcesses.size() != 0) {
                Collections.sort(waitingProcesses, Process.arriveComparator);
                if (waitingProcesses.get(0).cylinder > currentBlock) {
                    currentBlock++;
                } else {
                    currentBlock--;
                }
                blocks++;


            }

        }
         currentTime++;
        if (waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
            System.out.println("Currenttime: " + currentTime);
            System.out.println("Currentblock: " + currentBlock);
            System.out.println("Blocks: " + blocks);
        } else {
            System.out.println("No processes to be done");
        }


    }
    while (currentTime != 100000);
    
    return blocks;
	}
	*/
	public int FIFO_EDF() {
        int blocks = 0; 
        int currentBlock = 0;
        int currentTime = 0;
        int rejected = 0;
        ArrayList<Process> Processes = new ArrayList<Process>();
        ArrayList<Process> priorityProcesses = new ArrayList<Process>();
        ArrayList<Process> waitingProcesses = new ArrayList<Process>();
        ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
        for (Process aProcess : normalqueue) {
            Processes.add(new Process(aProcess));
        }
        for (Process aProcess : timeQueue) {
            priorityProcesses.add(new Process(aProcess));
        }
 //       System.out.println("prorityProcesses" + priorityProcesses);
        do {
            /**
             */
            for (int i = 0; i < Processes.size(); i++)

            {
                if (currentTime == (Processes.get(i)).getArrive()) {

                    waitingProcesses.add(Processes.get(i));

                }
            }
            for (int i = 0; i < priorityProcesses.size(); i++)

            {
                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

                    waitingPriorityProcesses.add(priorityProcesses.get(i));

                }
            }
            if (waitingPriorityProcesses.size() != 0) {
                /**
                 */
                if (waitingPriorityProcesses.get(0).cylinder == currentBlock) {
                    waitingPriorityProcesses.remove(0);
                }
                /**
                 */
                Collections.sort(waitingPriorityProcesses, Process.timeComparator);
                if (waitingPriorityProcesses.size() != 0 && currentBlock == waitingPriorityProcesses.get(0).cylinder) {
                    
                    if (waitingPriorityProcesses.get(0).time < Math.abs(waitingPriorityProcesses.get(0).cylinder - currentBlock)) {
                        rejected++;
                    }
                }
                if (waitingPriorityProcesses.size() != 0) {
                   
                    if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
                        currentBlock++;
                    }
                    
                    else {
                        currentBlock--;
                    }
                    blocks++;
                    
                    for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
                        waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
                    }
                }
            }
            /**
             */
            else if (waitingProcesses.size() != 0) {
                /**
                 */
                if (currentBlock == waitingProcesses.get(0).cylinder) {
                    waitingProcesses.remove(0);
                }
                /**
                 */
                if (waitingProcesses.size() != 0) {
                    Collections.sort(waitingProcesses, Process.arriveComparator);
                    if (waitingProcesses.get(0).cylinder > currentBlock) {
                        currentBlock++;
                    } else {
                        currentBlock--;
                    }
                    blocks++;


                }

            }
             currentTime++;
            if (waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
                System.out.println("Currenttime: " + currentTime);
                System.out.println("Currentblock: " + currentBlock);
                System.out.println("Blocks: " + blocks);
            } else {
                System.out.println("Waiting for a Process");
            }


        }
        while (currentTime != 10000);
        
        return blocks;
    }
	public int FIFO_FD_SCAN() {
        int blocks = 0;
        int currentBlock = 0;
        int currentTime = 0;
        int rejected = 0;
        ArrayList<Process> Processes = new ArrayList<Process>();
        ArrayList<Process> priorityProcesses = new ArrayList<Process>();
        ArrayList<Process> waitingProcesses = new ArrayList<Process>();
        ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
        for (Process aProcess : normalqueue) {
            Processes.add(new Process(aProcess));
        }
        for (Process aProcess : timeQueue) {
            priorityProcesses.add(new Process(aProcess));
        }
        do {
            /**
             */
            for (int i = 0; i < Processes.size(); i++)

            {
                if (currentTime == (Processes.get(i)).getArrive()) {

                    waitingProcesses.add(Processes.get(i));

                }
            }
            for (int i = 0; i < priorityProcesses.size(); i++)

            {
                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

                    waitingPriorityProcesses.add(priorityProcesses.get(i));

                }
            }
            if (waitingPriorityProcesses.size() != 0) {
                /**
                 */
                for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
                    waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
                    /**
                     */
                    if (currentBlock == waitingPriorityProcesses.get(i).cylinder) {
                        waitingPriorityProcesses.remove(i);
                    }
                }
                /**
                 */
                if (waitingPriorityProcesses.size() > 0) {
                    if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
                        currentBlock++;
                    }
                    
                    else {
                        currentBlock--;
                    }
                    blocks++;
                }
            }

        /**
         */

            else if (waitingProcesses.size() != 0) {
                /**
                 */
                if (currentBlock == waitingProcesses.get(0).cylinder) {
                    waitingProcesses.remove(0);
                }
                /**
                 */
                if (waitingProcesses.size() != 0) {
                    Collections.sort(waitingProcesses, Process.arriveComparator);
                    if (waitingProcesses.get(0).cylinder > currentBlock) {
                        currentBlock++;
                    } else {
                        currentBlock--;
                    }
                    blocks++;
                }

            }
             currentTime++;
            if (waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
                System.out.println("Currenttime: " + currentTime);
                System.out.println("Currentblock: " + currentBlock);
                System.out.println("Blocks: " + blocks);
            } else {
                System.out.println("Waiting for a Process");
            }


        }
        while (currentTime != 100000);
        return blocks;
    }
	/*
	public int FIFO_FD_SCAN() {
		
		int blocks = 0;
		int currentBlock = 0;
		int currentTime = 0;
		int rejected = 0;
		
		ArrayList<Process> Processes = new ArrayList<Process>();
	    ArrayList<Process> priorityProcesses = new ArrayList<Process>();
	    ArrayList<Process> waitingProcesses = new ArrayList<Process>();
	    ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
		
	    for(Process P1 : normalqueue) {
	    	Processes.add(new Process(P1));
	    	
	    }
	    
	    for(Process P2 : timeQueue) {
	    	priorityProcesses.add(new Process(P2));
	    }
	    
	    
	    
	    do {
	    	
	    	for (int i = 0; i < Processes.size(); i++)

            {
                if (currentTime == (Processes.get(i)).getArrive()) {

                    waitingProcesses.add(Processes.get(i));
  //                  System.out.println("waiting" + waitingProcesses);

                }
            }
            for (int i = 0; i < priorityProcesses.size(); i++)

            {
                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

                    waitingPriorityProcesses.add(priorityProcesses.get(i));
 //                   System.out.println("waitingPrority" + waitingPriorityProcesses);

                }
            }
            if (waitingPriorityProcesses.size() != 0) {
               
                for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
                	waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);

                    if (currentBlock == waitingPriorityProcesses.get(i).cylinder) {
            //            System.out.println("--------------------Removed on the way" + waitingPriorityProcesses.get(i));
                        waitingPriorityProcesses.remove(i);
                    }
	    	
	    
	    	
                }
                if(waitingPriorityProcesses.size() > 0) {
                	if(waitingPriorityProcesses.get(0).getCylinder() > currentBlock)
                		currentBlock++;
                	else
                		currentBlock--;
                	
                	blocks++;
                }
            }
            else if(waitingProcesses.size() != 0) {
            	if(currentBlock == waitingProcesses.get(0).getCylinder())
            		waitingProcesses.remove(0);
            	
            	if(waitingProcesses.size() != 0) {
            		Collections.sort(waitingProcesses, Process.arriveComparator);
            		if(waitingPriorityProcesses.get(0).getCylinder() > currentBlock)
            			currentBlock++;
            		else
            			currentBlock--;
            		blocks++;
            	}
            }
            
            currentTime++;
	   
	    
		    if(waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
		    	System.out.println(currentTime);
		    	System.out.println(currentBlock);
		    	System.out.println(blocks);
		    } else {
		    	System.out.println("No processes to be done");
		    }
	    } while(currentTime != 10000);
		return blocks;
	}*/
	public int SSTF_EDF() {
        int blocks = 0;
        int currentBlock = 0;
        int currentTime = 0;
        int rejected = 0;
        ArrayList<Process> Processes = new ArrayList<Process>();
        ArrayList<Process> priorityProcesses = new ArrayList<Process>();
        ArrayList<Process> waitingProcesses = new ArrayList<Process>();
        ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
        for (Process aProcess : normalqueue) {
            Processes.add(new Process(aProcess));
        }
        for (Process aProcess : timeQueue) {
            priorityProcesses.add(new Process(aProcess));
        }
        do {
            
            for (int i = 0; i < Processes.size(); i++)

            {
                if (currentTime == (Processes.get(i)).getArrive()) {

                    waitingProcesses.add(Processes.get(i));

                }
            }
            for (int i = 0; i < priorityProcesses.size(); i++)

            {
                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

                    waitingPriorityProcesses.add(priorityProcesses.get(i));

                }
            }
            if (waitingPriorityProcesses.size() != 0) {
                
                if (waitingPriorityProcesses.get(0).cylinder == currentBlock) {
                    waitingPriorityProcesses.remove(0);

                }
                
                Collections.sort(waitingPriorityProcesses, Process.timeComparator);
                if (waitingPriorityProcesses.size() != 0 && currentBlock == waitingPriorityProcesses.get(0).cylinder) {

                    /**
                     */
                    if (waitingPriorityProcesses.get(0).time < Math.abs(waitingPriorityProcesses.get(0).cylinder - currentBlock)) {
                        rejected++;
                    }
                }


                if (waitingPriorityProcesses.size() != 0) {
                    
                    if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
                        currentBlock++;
                    }
                    
                    else {
                        currentBlock--;
                    }
                    blocks++;

                    for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
                        waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
                        }
                }
            } else if (waitingProcesses.size() != 0)
            {
                
                if (currentBlock == waitingProcesses.get(0).cylinder) {
                    waitingProcesses.remove(0);
                }
                
                if (waitingProcesses.size() != 0) {
                    Process.compareWithCurrentBlock(currentBlock, waitingProcesses);
                    if (waitingProcesses.get(0).cylinder > currentBlock) {
                        currentBlock++;
                    }
                    else {
                        currentBlock--;
                    }
                    blocks++;
                }

            }
            currentTime++;
            if (waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
                System.out.println("Currenttime: " + currentTime);
                System.out.println("Currentblock: " + currentBlock);
                System.out.println("Blocks: " + blocks);
            } else {
                System.out.println("Waiting for a Process");
            }


        }
        while (currentTime != 100000);
        return blocks;
    }
	/*
		public int SSTF_EDF() {
			int blocks = 0;
			int currentBlock = 0;
			int currentTime = 0;
			int rejected = 0;
			
			ArrayList<Process> Processes = new ArrayList<Process>();
		    ArrayList<Process> priorityProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
			
		    for(Process P1 : normalqueue) {
		    	Processes.add(new Process(P1));
		    	
		    }
		    
		    for(Process P2 : timeQueue) {
		    	priorityProcesses.add(new Process(P2));
		    }
		    do {
		    	for (int i = 0; i < Processes.size(); i++)

	            {
	                if (currentTime == (Processes.get(i)).getArrive()) {

	                    waitingProcesses.add(Processes.get(i));

	                }
	            }
	            for (int i = 0; i < priorityProcesses.size(); i++)

	            {
	                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

	                    waitingPriorityProcesses.add(priorityProcesses.get(i));

	                }
	            }
	            
	            if(waitingPriorityProcesses.size() != 0) {
	            	if (waitingPriorityProcesses.get(0).cylinder == currentBlock) {
	          //          System.out.println("---------------------------------------------Prorytet wykonany" + waitingPriorityProcesses.get(0));
	                    waitingPriorityProcesses.remove(0);

	                }
	                
	                Collections.sort(waitingPriorityProcesses, Process.timeComparator);
	                if (waitingPriorityProcesses.size() != 0 && currentBlock == waitingPriorityProcesses.get(0).cylinder) {

	                    
	                    if (waitingPriorityProcesses.get(0).time < Math.abs(waitingPriorityProcesses.get(0).cylinder - currentBlock)) {
	            //            System.out.println("rejection");
	                        rejected++;
	                    }
	                }
	                
	                if (waitingPriorityProcesses.size() != 0) {
	                    /**
	                     * when pointer is moving forwards
	                     
	                    if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
	                        currentBlock++;
	                    }
	                    /**
	                     * when pointer is moving backwards
	                     
	                    else {
	                        currentBlock--;
	                    }
	                    blocks++;

	                    /**
	                     * time is descanding with time
	                     
	                    for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
	                        waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
	                        }
	            }
	            else if(waitingProcesses.size() != 0) {
	            //	System.out.println("Normal Processes: " + waitingProcesses);
	                /**
	                 * removing Process that has been done
	                 
	                if (currentBlock == waitingProcesses.get(0).cylinder) {
	              //      System.out.println("-----------------------------------------------Normal Process has been done: " + waitingProcesses.get(0));
	                    waitingProcesses.remove(0);
	                }
	                /**
	                 *  other Processes sorted by arrive time
	                 
	                if (waitingProcesses.size() != 0) {
	                    Process.compareWithCurrentBlock(currentBlock, waitingProcesses);
	                    if (waitingProcesses.get(0).cylinder > currentBlock) {
	                        currentBlock++;
	                    }
	                    else {
	                        currentBlock--;
	                    }
	                    blocks++;
	                }
	            }
	            
	            currentTime++;
	            
	            if(waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
			    	System.out.println(currentTime);
			    	System.out.println(currentBlock);
			    	System.out.println(blocks);
			    } else {
			    	System.out.println("No processes to be done");
			    }
		    	
		    }
		    }
	        while(currentTime != 100000);
		    
		    return blocks;
		    
		}
		*/
	
	public int SSTF_FD_SCAN() {
        int blocks = 0;
        int currentBlock = 0;
        int currentTime = 0;
        int rejected = 0;
        ArrayList<Process> Processes = new ArrayList<Process>();
        ArrayList<Process> priorityProcesses = new ArrayList<Process>();
        ArrayList<Process> waitingProcesses = new ArrayList<Process>();
        ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
        for (Process aProcess : normalqueue) {
            Processes.add(new Process(aProcess));
        }
        for (Process aProcess : timeQueue) {
            priorityProcesses.add(new Process(aProcess));
        }
         do {
            /**
             */
            for (int i = 0; i < Processes.size(); i++)

            {
                if (currentTime == (Processes.get(i)).getArrive()) {

                    waitingProcesses.add(Processes.get(i));
   
                }
            }
            for (int i = 0; i < priorityProcesses.size(); i++)

            {
                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

                    waitingPriorityProcesses.add(priorityProcesses.get(i));
   
                }
            }
            if (waitingPriorityProcesses.size() != 0) {
  
                
                if (waitingPriorityProcesses.get(0).cylinder == currentBlock) {
  
                    waitingPriorityProcesses.remove(0);

                }
                
                Collections.sort(waitingPriorityProcesses, Process.timeComparator);
                if (waitingPriorityProcesses.size() != 0 && currentBlock == waitingPriorityProcesses.get(0).cylinder) {

                    
                    if (waitingPriorityProcesses.get(0).time < Math.abs(waitingPriorityProcesses.get(0).cylinder - currentBlock)) {
                        rejected++;
                    }
                }


                if (waitingPriorityProcesses.size() != 0) {
                    
                    for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
                        waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
                        
                        if (currentBlock == waitingPriorityProcesses.get(i).cylinder) {
                            waitingPriorityProcesses.remove(i);
                        }
                    }
                    if (waitingPriorityProcesses.size() > 0) {
                        
                        if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
                            currentBlock++;
                        }
                        
                        else {
                            currentBlock--;
                        }
                        blocks++;
                    }
                }
            } else if (waitingProcesses.size() != 0)
            {

                if (currentBlock == waitingProcesses.get(0).cylinder) {
                    waitingProcesses.remove(0);
                }
                
                if (waitingProcesses.size() != 0) {
                    Process.compareWithCurrentBlock(currentBlock, waitingProcesses);
                    if (waitingProcesses.get(0).cylinder > currentBlock) {
                        currentBlock++;
                    }
                    else {
                        currentBlock--;
                    }
                    blocks++;
                }

            }
            currentTime++;
            if (waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
                System.out.println("Currenttime: " + currentTime);
                System.out.println("Currentblock: " + currentBlock);
                System.out.println("Blocks: " + blocks);
            } else {
                System.out.println("Waiting for a Process");
            }


        }
        while (currentTime != 100000);
        return blocks;
    }
	/*
		public int SSTF_FD_SCAN() {
			int blocks = 0;
			int currentBlock = 0;
			int currentTime = 0;
			int rejected = 0;
			
			ArrayList<Process> Processes = new ArrayList<Process>();
		    ArrayList<Process> priorityProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
			
		    for(Process P1 : normalqueue) {
		    	Processes.add(new Process(P1));
		    	
		    }
		    
		    for(Process P2 : timeQueue) {
		    	priorityProcesses.add(new Process(P2));
		    }
		    
		    do {
		    	for (int i = 0; i < Processes.size(); i++)

	            {
	                if (currentTime == (Processes.get(i)).getArrive()) {

	                    waitingProcesses.add(Processes.get(i));

	                }
	            }
	            for (int i = 0; i < priorityProcesses.size(); i++)

	            {
	                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

	                    waitingPriorityProcesses.add(priorityProcesses.get(i));

	                }
	            }
	            
	            if(waitingPriorityProcesses.size() != 0) {
	          //  	System.out.println("Priority: " + waitingPriorityProcesses);
	               
	                if (waitingPriorityProcesses.get(0).cylinder == currentBlock) {
	            //        System.out.println("---------------------------------------------Prorytet wykonany" + waitingPriorityProcesses.get(0));
	                    waitingPriorityProcesses.remove(0);

	                }
	                
	                Collections.sort(waitingPriorityProcesses, Process.timeComparator);
	                if (waitingPriorityProcesses.size() != 0 && currentBlock == waitingPriorityProcesses.get(0).cylinder) {

	                    
	                    if (waitingPriorityProcesses.get(0).time < Math.abs(waitingPriorityProcesses.get(0).cylinder - currentBlock)) {
	              //          System.out.println("rejection");
	                        rejected++;
	                    }
	                }


	                if (waitingPriorityProcesses.size() != 0) {
	                    int i = 0; i < waitingPriorityProcesses.size(); i++) {
	                        waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
	                         {
	                //            System.out.println("--------------------Removed on the way" + waitingPriorityProcesses.get(i));
	                            waitingPriorityProcesses.remove(i);
	                        }
	                    }
	                    if (waitingPriorityProcesses.size() > 0) {
	                        
	                        if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
	                            currentBlock++;
	                        }
	                        
	                        else {
	                            currentBlock--;
	                        }
	                        blocks++;
	                    }
	                }
	            }
	            else if(waitingProcesses.size() != 0) {
	            	
	            }
	            
	            currentTime++;
	            
	            if(waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
			    	System.out.println(currentTime);
			    	System.out.println(currentBlock);
			    	System.out.println(blocks);
			    } else {
			    	System.out.println("No processes to be done");
			    }
		    	
		    }while(currentTime != 100000);
		    
		    
		    
		    return blocks;
		}
		*/
		public int SCAN_EDF() {
			int blocks = 0;
			int currentBlock = 0;
			int currentTime = 0;
			int rejected = 0;
			
			ArrayList<Process> Processes = new ArrayList<Process>();
		    ArrayList<Process> priorityProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
			
		    boolean forward = true;
		    
		    for(Process P1 : normalqueue) {
		    	Processes.add(new Process(P1));
		    	
		    }
		    
		    for(Process P2 : timeQueue) {
		    	priorityProcesses.add(new Process(P2));
		    }
		    
		    do {
		    	for (int i = 0; i < Processes.size(); i++)

	            {
	                if (currentTime == (Processes.get(i)).getArrive()) {

	                    waitingProcesses.add(Processes.get(i));

	                }
	            }
	            for (int i = 0; i < priorityProcesses.size(); i++)

	            {
	                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

	                    waitingPriorityProcesses.add(priorityProcesses.get(i));

	                }
	            }
	            
	            if(waitingPriorityProcesses.size() != 0) {
	            	if(waitingPriorityProcesses.get(0).getCylinder() == currentBlock)
	            		waitingPriorityProcesses.remove(0);
	            	
	            	Collections.sort(waitingPriorityProcesses, Process.timeComparator);
	            	
	            	if (waitingPriorityProcesses.size() != 0 && currentBlock == waitingPriorityProcesses.get(0).cylinder) {
	                    
	                    if (waitingPriorityProcesses.get(0).time < Math.abs(waitingPriorityProcesses.get(0).cylinder - currentBlock)) {
	                  //      System.out.println("rejection");
	                        rejected++;
	                    }
	                }
	                if (waitingPriorityProcesses.size() != 0) {
	                   
	                    if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
	                        currentBlock++;
	                    }
	                    
	                    else {
	                        currentBlock--;
	                    }
	                    blocks++;
	                    
	                    for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
	                        waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
	                    }
	                }
	            }
	            else if(waitingProcesses.size() != 0) {
	                  /**
	                   * if pointer reaches task cylinder number its being removed
	                   */
	                  for(int i = 0; i < waitingProcesses.size(); i++)
	                  {
	                      if (currentBlock == waitingProcesses.get(i).cylinder) {
	                          waitingProcesses.remove(i);
	                      }
	                  }

	                  /**
	                   * processing other tasks from normal queue, Scannig
	                   */
	                  if (waitingProcesses.size() != 0) {
	                       if (forward) {
	                          currentBlock++;
	                      } else {
	                          currentBlock--;
	                      }
	                      if (currentBlock == SIZE_OF_DISK) {
	                          forward = false;
	                      }
	                      if (currentBlock == 0) {
	                          forward = true;
	                      }
	                      blocks++;
	                  }
	            }
	            currentTime++;
	            
	            if(waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
	            	System.out.println("Currenttime: " + currentTime);
	                System.out.println("Currentblock: " + currentBlock);
	                System.out.println("Blocks: " + blocks);
			    } else {
			    	System.out.println("No processes to be done");
			    }
		    	
		    }while(currentTime != 100000);
		    
		    
		    return blocks;
		    
		}
		
		public int SCAN_FD_SCAN() {
			int blocks = 0;
			int currentBlock = 0;
			int currentTime = 0;
			int rejected = 0;
			
			ArrayList<Process> Processes = new ArrayList<Process>();
		    ArrayList<Process> priorityProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
			
		    boolean forward = true;
		    
		    for(Process P1 : normalqueue) {
		    	Processes.add(new Process(P1));
		    	
		    }
		    
		    for(Process P2 : timeQueue) {
		    	priorityProcesses.add(new Process(P2));
		    }
		    
		    do {
		    	for (int i = 0; i < Processes.size(); i++)

	            {
	                if (currentTime == (Processes.get(i)).getArrive()) {

	                    waitingProcesses.add(Processes.get(i));

	                }
	            }
	            for (int i = 0; i < priorityProcesses.size(); i++)

	            {
	                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

	                    waitingPriorityProcesses.add(priorityProcesses.get(i));

	                }
	            }
	            
	            if (waitingPriorityProcesses.size() != 0) {
	          //      System.out.println("Priority: " + waitingPriorityProcesses);
	                
	                if (waitingPriorityProcesses.get(0).cylinder == currentBlock) {
	            //        System.out.println("---------------------------------------------Priority done" + waitingPriorityProcesses.get(0));
	                    waitingPriorityProcesses.remove(0);
	                }
	                
	                Collections.sort(waitingPriorityProcesses, Process.timeComparator);
	                if (waitingPriorityProcesses.size() != 0 && currentBlock == waitingPriorityProcesses.get(0).cylinder) {
	                    
	                    if (waitingPriorityProcesses.get(0).time < Math.abs(waitingPriorityProcesses.get(0).cylinder - currentBlock)) {
	              //          System.out.println("rejection");
	                        rejected++;
	                    }
	                }
	                if (waitingPriorityProcesses.size() != 0) {
	                    
	                    for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
	                        waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
	                        
	                        if (currentBlock == waitingPriorityProcesses.get(i).cylinder) {
	                
	                            waitingPriorityProcesses.remove(i);
	                        }
	                    }
	                    
	                    if (waitingPriorityProcesses.size() > 0) {
	                        if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
	                            currentBlock++;
	                        }
	                        
	                        else {
	                            currentBlock--;
	                        }
	                        blocks++;
	                    }
	                }
	            }
	            else if (waitingProcesses.size() != 0) {	                /**
	                 * if pointer reaches task cylinder number its being removed
	                 */
	                for(int i = 0; i < waitingProcesses.size(); i++)
	                {
	                    if (currentBlock == waitingProcesses.get(i).cylinder) {
	                        waitingProcesses.remove(i);
	                    }
	                }

	                /**
	                 * processing other tasks from normal queue, Scannig
	                 */
	                if (waitingProcesses.size() != 0) {
	                    if (forward) {
	                        currentBlock++;
	                    } else {
	                        currentBlock--;
	                    }
	                    if (currentBlock == SIZE_OF_DISK) {
	                        forward = false;
	                    }
	                    if (currentBlock == 0) {
	                        forward = true;
	                    }
	                    blocks++;
	                }
	            }
	            
	            currentTime++;
	            
	            if(waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
	            	System.out.println("Currenttime: " + currentTime);
	                System.out.println("Currentblock: " + currentBlock);
	                System.out.println("Blocks: " + blocks);
			    } else {
			    	System.out.println("No processes to be done");
			    }
		    	
		    }while(currentTime != 100000);
		    
		    return blocks;
		}
		
		public int C_SCAN_EDF() {
			int blocks = 0;
			int currentBlock = 0;
			int currentTime = 0;
			int rejected = 0;
			
			ArrayList<Process> Processes = new ArrayList<Process>();
		    ArrayList<Process> priorityProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
			
		    for(Process P1 : normalqueue) {
		    	Processes.add(new Process(P1));
		    	
		    }
		    
		    for(Process P2 : timeQueue) {
		    	priorityProcesses.add(new Process(P2));
		    }
		    
		    do {
		    	for (int i = 0; i < Processes.size(); i++)

	            {
	                if (currentTime == (Processes.get(i)).getArrive()) {

	                    waitingProcesses.add(Processes.get(i));

	                }
	            }
	            for (int i = 0; i < priorityProcesses.size(); i++)

	            {
	                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

	                    waitingPriorityProcesses.add(priorityProcesses.get(i));

	                }
	            }
	            
	            if(waitingPriorityProcesses.size() != 0) {
	                /**
	                 */
	                if (waitingPriorityProcesses.get(0).cylinder == currentBlock) {
	                    waitingPriorityProcesses.remove(0);
	                }
	                /**
	                 */
	                Collections.sort(waitingPriorityProcesses, Process.timeComparator);
	                if (waitingPriorityProcesses.size() != 0 && currentBlock == waitingPriorityProcesses.get(0).cylinder) {
	                    /**
\	                     */
	                    if (waitingPriorityProcesses.get(0).time < Math.abs(waitingPriorityProcesses.get(0).cylinder - currentBlock)) {
	                        rejected++;
	                    }
	                }
	                if (waitingPriorityProcesses.size() != 0) {
	                    /**
	                     * jezeli jedziemy do przodu
	                     */
	                    if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
	                        currentBlock++;
	                    }
	                    /**
	                     * jezeli jedziemy do tylu
	                     */
	                    else {
	                        currentBlock--;
	                    }
	                    blocks++;
	                    for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
	                        waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
	                    }
	                }
	            }
	            else if(waitingProcesses.size() != 0) {
	          //  	System.out.println("Normmalne: " + waitingProcesses);
	                /**
	                 * if pointer reaches Process cylinder number its being removed
	                 */
	                for(int i = 0; i < waitingProcesses.size(); i++)
	                {
	                    if (currentBlock == waitingProcesses.get(i).cylinder) {
	                        waitingProcesses.remove(i);
	                    }
	                }

	                /**
	                 * processing other Processes from normal queue, Scannig
	                 */
	                if (waitingProcesses.size() != 0) {
	                       if (currentBlock == SIZE_OF_DISK) {
	                        currentBlock = 0;
	                    }
	                    currentBlock++;
	                    blocks++;
	                }
	            }
	            
	            currentTime++;
	            
	            if(waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
	            	System.out.println("Currenttime: " + currentTime);
	                System.out.println("Currentblock: " + currentBlock);
	                System.out.println("Blocks: " + blocks);
			    } else {
			    	System.out.println("No processes to be done");
			    }
		    	
		    }while(currentTime != 100000);
		    
		    return blocks;
		    
		}
		
		public int C_SCAN_FD_SCAN() {
			int blocks = 0;
			int currentBlock = 0;
			int currentTime = 0;
			int rejected = 0;
			
			ArrayList<Process> Processes = new ArrayList<Process>();
		    ArrayList<Process> priorityProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingProcesses = new ArrayList<Process>();
		    ArrayList<Process> waitingPriorityProcesses = new ArrayList<Process>();
			
		    for(Process P1 : normalqueue) {
		    	Processes.add(new Process(P1));
		    	
		    }
		    
		    for(Process P2 : timeQueue) {
		    	priorityProcesses.add(new Process(P2));
		    }
		    
		    
		    do {
		    	for (int i = 0; i < Processes.size(); i++)

	            {
	                if (currentTime == (Processes.get(i)).getArrive()) {

	                    waitingProcesses.add(Processes.get(i));

	                }
	            }
	            for (int i = 0; i < priorityProcesses.size(); i++)

	            {
	                if (currentTime == (priorityProcesses.get(i)).getArrive()) {

	                    waitingPriorityProcesses.add(priorityProcesses.get(i));

	                }
	            }
	            
	            if(waitingPriorityProcesses.size() != 0) {
	            	{
	              //      System.out.println("Priority: " + waitingPriorityProcesses);
	                    /**
	                     * if pointer reaches Process cylinder number its being removed
	                     */
	                    if (waitingPriorityProcesses.get(0).cylinder == currentBlock) {
	                //        System.out.println("---------------------------------------------Priority done" + waitingPriorityProcesses.get(0));
	                        waitingPriorityProcesses.remove(0);
	                    }
	                    /**
	                     * when new Process has come or last Process has been done
	                     */
	                    Collections.sort(waitingPriorityProcesses, Process.timeComparator);
	                    if (waitingPriorityProcesses.size() != 0 && currentBlock == waitingPriorityProcesses.get(0).cylinder) {
	                        /**
	                         * if pointer wont meet time is rejected
	                         */
	                        if (waitingPriorityProcesses.get(0).time < Math.abs(waitingPriorityProcesses.get(0).cylinder - currentBlock)) {
	                  //          System.out.println("rejection");
	                            rejected++;
	                        }
	                    }
	                    if (waitingPriorityProcesses.size() != 0) {
	                        
	                        for (int i = 0; i < waitingPriorityProcesses.size(); i++) {
	                            waitingPriorityProcesses.get(i).setTime(waitingPriorityProcesses.get(i).time - 1);
	                            /**
	                             * doing Process along the way of pointer
	                             */
	                            if (currentBlock == waitingPriorityProcesses.get(i).cylinder) {
	                    //            System.out.println("--------------------Removed on the way" + waitingPriorityProcesses.get(i));
	                                waitingPriorityProcesses.remove(i);
	                            }
	                        }
	                        /**
	                         * if pointer is moving forwards
	                         */
	                        if (waitingPriorityProcesses.size() > 0) {
	                            if (waitingPriorityProcesses.get(0).cylinder > currentBlock) {
	                                currentBlock++;
	                            }
	                            /**
	                             * if pointer is moving backwards
	                             */
	                            else {
	                                currentBlock--;
	                            }
	                            blocks++;
	                        }
	                    }
	            	}
	            }
	            else if(waitingProcesses.size() != 0) {
	    //        	System.out.println("Normalne: " + waitingProcesses);
	                
	                for(int i = 0; i < waitingProcesses.size(); i++)
	                {
	                    if (currentBlock == waitingProcesses.get(i).cylinder) {
	      //                  System.out.println("-----------------------------------------------Normal Process has been done: " + waitingProcesses.get(i));
	                        waitingProcesses.remove(i);
	                    }
	                }

	                
	                if (waitingProcesses.size() != 0) {

	                    if (currentBlock == SIZE_OF_DISK) {
	                        currentBlock = 0;
	                    }
	                    currentBlock++;
	                    blocks++;
	                }
	            }
	            
	            currentTime++;
	            
	            if(waitingPriorityProcesses.size() != 0 || waitingProcesses.size() != 0) {
	            	System.out.println("Currenttime: " + currentTime);
	                System.out.println("Currentblock: " + currentBlock);
	                System.out.println("Blocks: " + blocks);			    } else {
	//		    	System.out.println("No processes to be done");
			    }
		    	
		    }while(currentTime != 100000);
		    return blocks;
		    
		}

}
