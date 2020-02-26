package Zegar1;

public class Main {

  public static void main(String[] args)
  {
    Zegar zegar1 = new Zegar();
    zegar1.toString();
  //  Zegar zegar2 = new Zegar(5, 15, 58);
    System.out.println(zegar1.equals(12, 0, 0));
    zegar1.compare(12,1,12);
    zegar1.plusGodz();
    zegar1.toString();
    Zegar zegar2 = new Zegar();
    zegar2.minusGodz();
    zegar2.toString();
    Zegar zegar3 = new Zegar();
    zegar3.plusSek();
    zegar3.toString();
    Zegar zegar4 = new Zegar();
    // teraz o n sekund do przodu
    zegar4.toString();
    Zegar zegar5 = new Zegar();
    zegar5.compare(15,7,5);
    
  }
}
