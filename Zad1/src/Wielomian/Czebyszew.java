package Wielomian;
public class Czebyszew{
	  private int n;
	  private int x;

	  public Czebyszew(int n1, int x1)
	  {
	    n = n1;
	    x = x1;
	  }
  public static int oblicz(int n1, int x1)
	  {
	      int score = 0;
	      if(n1 == 0)
	        System.out.println(1);
	      else if(n1 == 1)
	        System.out.println(x1);
	      else
	      {
	        int t_2 = 1, t_1 = x1;
	        for(int n_x = 2; n_x <= n1; n_x++)
	        {
	          score = 2*t_1*x1 - t_2;
	          t_2 = t_1;
	          t_1 = score;
	        }
	        
	      }
	      return score;
	  }

	}
