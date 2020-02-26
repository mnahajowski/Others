package Pack1;

public class Score {
	private String word;
	private int value;
	
	public Score(String word, int value) {
		this.word = word;
		this.value = value;
	}
	
	public String toString() {
		return this.word + " " + this.value;
	}
}
