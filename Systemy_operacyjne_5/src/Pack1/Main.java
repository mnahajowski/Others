package Pack1;
public class Main 
{
	public static void main(String [] args) {
	
		Strategy s1 = new Strategy(50, 200, 20, 40);
	//	s1.strategia1();
		System.out.println("Strategia 1");
		System.out.println(s1.strategia1() + "\n");
		System.out.println("Strategia 2");
		System.out.println(s1.strategia2() + "\n");
		System.out.println("Strategia 3");
		System.out.println(s1.strategia3() + "\n");
	}
}
