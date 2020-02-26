package Pack1;
import java.util.ArrayList;
import java.util.Random;


public class Scores {
	int cykle;
    int Processes;
    int priorityProcent;

    public Scores(int cykle, int Processes, int priorityProcent){
        this.priorityProcent = priorityProcent;
        this.cykle = cykle;
        this.Processes = Processes;
    }
    public ArrayList<Score> averageScores() {

        ArrayList<Score> lista = new ArrayList<Score>();
        ArrayList<Process> randomProcesss = new ArrayList<Process>();
        ArrayList<Process> randomTimeProcesss = new ArrayList<Process>();
        
        
        int sum_FIFO_EDF = 0;
        int sum_FIFO_FD = 0;
        int sum_SSTF_EDF = 0;
        int sum_SSTF_FD = 0;
        int sum_SCAN_EDF = 0;
        int sum_SCAN_FD = 0;
        int sum_C_SCAN_EDF = 0;
        int sum_C_SCAN_FD = 0;
        
        
        for (int j = 0; j < cykle; j++) {

            for (int i = 0; i <Processes*(100 - priorityProcent)/100; i++) {
                Random r = new Random();
                int d =1+ r.nextInt(1000);
                int m = 1 + r.nextInt(199);
                randomProcesss.add(new Process(d, m));
                }

            for (int i = 0; i < Processes*priorityProcent/100; i++) {
                Random r = new Random();
                int d = 1+ r.nextInt(1000);
                int m = 1 + r.nextInt(199);
                int k = 300 + r.nextInt(100);
                randomTimeProcesss.add(new Process(d, m, k));
            }
            Algorithms pr = new Algorithms(randomProcesss, randomTimeProcesss);
            sum_FIFO_EDF  += pr.FIFO_EDF();
            sum_FIFO_FD  += pr.FIFO_FD_SCAN();
            sum_SSTF_EDF  += pr.SSTF_EDF();
            sum_SSTF_FD  += pr.SSTF_FD_SCAN();
            sum_SCAN_EDF  += pr.SCAN_EDF();
            sum_SCAN_FD  += pr.SCAN_FD_SCAN();
            sum_C_SCAN_EDF  += pr.C_SCAN_EDF();
            sum_C_SCAN_FD  += pr.C_SCAN_FD_SCAN();
            randomProcesss.clear();
            randomTimeProcesss.clear();

        }

        lista.add(new Score("FIFO_EDF", sum_FIFO_EDF ));
        lista.add(new Score("FIFO_FD_SCAN", sum_FIFO_FD ));
        lista.add(new Score("SSTF_EDF", sum_SSTF_EDF ));
        lista.add(new Score("SSTF_FD_SCAN", sum_SSTF_FD ));
        lista.add(new Score("SCAN_EDF", sum_SCAN_EDF ));
        lista.add(new Score("SCAN_FD_SCAN", sum_SCAN_FD ));
        lista.add(new Score("C_SCAN_EDF", sum_C_SCAN_EDF ));
        lista.add(new Score("C_SCAN_FD_SCAN", sum_C_SCAN_FD ));

        return lista;
    }
}
