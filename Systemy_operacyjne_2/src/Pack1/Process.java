package Pack1;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;


public class Process {

	int arrive;
	int cylinder;
	int time;
	int done;
	

	public Process(int arrive, int cylinder) {
		this.arrive = arrive;
		this.cylinder = cylinder;
	}
	
	public Process(int arrive, int cylinder, int time) {
		this.arrive = arrive;
		this.cylinder = cylinder;
		this.time = time;
	}
	
	public Process (Process P) {
		this.arrive = P.arrive;
		this.cylinder = P.cylinder;
		this.time = P.time;
		this.done = P.done;
	}
	
	
	public int getArrive() {
		return arrive;
	}

	public void setArrive(int arrive) {
		this.arrive = arrive;
	}

	public int getCylinder() {
		return cylinder;
	}

	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}
	
	public static void compareCylinderWithCurrentBlock(final int currentBlock, ArrayList a)
    {
          Comparator<Process> closestProcessComparator= new Comparator<Process>()
          {

            public int compare(Process o1, Process o2)
            {
                return Math.abs(o1.cylinder - currentBlock) - Math.abs(o2.cylinder - currentBlock);
            }
         };
        Collections.sort(a,closestProcessComparator );
    }
	
	  public static void compareWithCurrentBlockForwards(final int currentBlock, ArrayList a) {


	        Comparator<Process> closestProcessComparator1 = new Comparator<Process>()
	        {


	            public int compare(Process o1, Process o2) {


	                if (o1.cylinder - currentBlock > 0) {
	                    if (o2.cylinder - currentBlock > 0) {

	                        return (o1.cylinder - currentBlock) - (o2.cylinder - currentBlock);
	                    }
	                    return -1;
	                } else if (o1.cylinder - currentBlock > 0) {
	                    return 1;
	                } else
	                    return 0;
	            }
            
	        };
	            Collections.sort(a, closestProcessComparator1);

	    }
	  
	  public static void compareWithCurrentBlockBackwards(final int currentBlock, ArrayList a) {


	        Comparator<Process> closestProcessComparator1 = new Comparator<Process>()
	        {


	            public int compare(Process o1, Process o2) {


	                if (o1.cylinder - currentBlock < 0) {
	                    if (o2.cylinder - currentBlock < 0) {

	                        return Math.abs(o1.cylinder - currentBlock) - Math.abs(o2.cylinder - currentBlock);
	                    }
	                    return -1;
	                } else if (o1.cylinder - currentBlock < 0) {
	                    return 1;
	                } else
	                    return 0;
	            }

	        };
	        Collections.sort(a, closestProcessComparator1);

	    }
	  
	  public static void compareWithCurrentBlock(final int currentBlock, ArrayList a)
	    {
	        Comparator<Process> closestProcessComparator= new Comparator<Process>()
	        {

	            public int compare(Process o1, Process o2)
	            {

	                return Math.abs(o1.cylinder - currentBlock) - Math.abs(o2.cylinder - currentBlock);
	            }
	        };
	        Collections.sort(a,closestProcessComparator );
	    }
	
		
	  public static  Comparator<Process> closestProcessComparator = new Comparator<Process>() {

	        public int compare(Process o1, Process o2) {
	            return o1.cylinder - o2.cylinder;
	        }
	    };
	    
	    
	   public static Comparator<Process> timeArrivalComparator = new Comparator<Process>() {
	        @Override
	        public int compare(Process o1, Process o2) {
	            int result =  o1.time - o2.time;
	            if(result != 0)
	                return  result;
	            else
	            {
	                return o1.arrive - o2.arrive;
	            }
	        }
	    };
	    
	    
		public static Comparator<Process> arriveComparator = new Comparator<Process> (){
			@Override
			public int compare(Process p1, Process p2) {
				return p1.arrive - p2.arrive;
			}
		};
		
		public static Comparator <Process> timeComparator = new Comparator<Process> () {
			@Override
			public int compare(Process p1, Process p2) {
				return p1.time - p2.time;
			}
		};
}
