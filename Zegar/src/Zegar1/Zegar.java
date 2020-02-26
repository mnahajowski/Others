package Zegar1;

public class Zegar {
  private int godz;
  private int min;
  private int sek;
  private static int ile;

  public Zegar() {
    this.godz = 12;
    this.min = 0;
    this.sek = 0;
  }

  public Zegar(int godz, int min, int sek)
  {
    this.godz = godz;
    this.min = min;
    this.sek = sek;
  }

  public int getGodz(){
    return godz;
  }

  public int getMin(){
    return min;
  }

  public int getSek() {
    return sek;
  }

  public void setGodz(int godz) {
    this.godz = godz;
  }

  public void setMin (int min)
  {
    this.min = min;
  }

  public void setSek (int sek)
  {
    this.sek = sek;
  }

  public String toString()
  {
    String napis;
/*System.out.println(godz);
    System.out.println(min);
    System.out.println(sek);*/
    if(godz < 10)
      napis = "0" + godz + ":";
    else
      napis = godz + ":";
    if(min < 10)
      napis += "0" + min + ":";
    else
      napis += min;
    if(sek < 10)
      napis += "0" + sek;
    else
      napis += sek;

    System.out.println(napis);
    return napis;
  }

  public boolean equals(int godz, int min, int sek)
  {
    if(this.godz == godz && this.min == min && this.sek == sek)
      return true;
    else
      return false;
  }

  public void plusGodz()
  {
    if(this.godz < 23)
      this.godz += 1;
    else
      this.godz = 0;
  }

  public void minusGodz()
  {
    if(this.godz < 1)
      this.godz = 23;
    else
      this.godz -= 1;
  }

  public void plusSek()
  {
    if(this.sek < 59)
      this.sek += 1;
    else if(this.min < 59)
    {
      this.min += 1;
      this.sek = 0;
    }
    else if(this.min == 59 && this.godz == 23)
    {
      this.godz = 0;
      this.min = 0;
      this.sek = 0;
    }
    else if(this.min == 59 && this.godz < 23)
    {
      this.min = 0;
      this.sek = 0;
    }
  }
/* cos nie dziala
  public void plusSek(int n)
  {
    if(this.sek + n%60 < 59)
      this.sek += n%60;
    else if(this.min + n/60 < 59)
    {
      this.min += n/60;
      this.sek += n%60;
    }
    else if(this.min + n/60 > 59 && this.godz + n/3600 > 23)
    {
      this.godz = 0;
      this.min = 0;
      this.sek = 0;
    }
    else if(this.min == 59 && this.godz < 23)
    {
      this.min = 0;
      this.sek = 0;
    }
  }
*/
  public int compare (int godz, int min, int sek)
  {
    int test;
    if(godz > this.godz)
      test = -1;
    else if(godz < this.godz)
      test = 1;
    else
    {
      if(min > this.min)
        test = -1;
      else if(min < this.min)
        test = 1;
      else
      {
        if(sek > this.sek)
          test = -1;
        else if(sek < this.sek)
          test = 1;
        else
          test = 0;
      }
    }

    if(test == -1)
      System.out.println("Nasza godzina jest wczesniejsza");
    else if(test == 1)
      System.out.println("Nasza godzina jest pozniejsza");
    else
      System.out.println("Obie godziny są takie same");

    return test;
  }
}
