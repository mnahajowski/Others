package Pack1;

public class Score {
	String proc;
	double av;
	
	public Score(String proc, double av) {
		this.proc = proc;
		this.av = av;
	}
	public String toString() {
		return this.proc + " " + this.av;
	}
}
