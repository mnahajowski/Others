package Pack1;

import java.util.ArrayList;
import java.util.Collections;
public class Algorytmy {

	public int SIZE_OF_RAMKA;
	
	ArrayList<Strona> referencje= new ArrayList<Strona>();
	ArrayList <Strona> ramka = new ArrayList<Strona>();
	
	public int blad_count = 0;
	
	public Algorytmy(int SIZE_OF_RAMKA, ArrayList<Strona> referencje) {
		this.SIZE_OF_RAMKA = SIZE_OF_RAMKA;
		this.referencje = referencje;
	}
	
	public int FIFO() {
		blad_count = 0;
        ArrayList<Strona> Strony1 = new ArrayList<>();
        for(Strona p :referencje)
        {
            Strony1.add(new Strona(p));
        }
        
        Strona n;
        for (int i = 0; i < Strony1.size(); i++) {
            n = Strony1.get(i);
            petla:
            if (ramka.size() < SIZE_OF_RAMKA) {
                for (Strona p : ramka)
                {
                    if (p.getNumber() == n.getNumber())
                    	
                    {
                        break petla;
                    }
                }
                ramka.add(n);
                blad_count++;
            }

            else
            {
                for (Strona p : ramka)
                {
                    if (p.getNumber() == n.getNumber())
                    {
                        break petla;
                    }
                }
                    ramka.remove(0);
                    ramka.add(n);
                    blad_count++;

            }
        }
        ramka.clear();
       return  blad_count;
			}
	
	
	// usuwa tą która najdluzej nie bedzie uzywana
	public int OPT()    {
	        blad_count = 0;
	        ArrayList<Strona> Stronas2 = new ArrayList<>();
	        for(Strona p :referencje)
	        {
	            Stronas2.add(new Strona(p));
	        }
	        Strona n;
	        for (int i = 0; i < Stronas2.size(); i++) {
	            n = Stronas2.get(i);
	            petla:
	            if (ramka.size() < SIZE_OF_RAMKA) {
	                for (Strona p : ramka)
	                {
	                    if (p.getNumber() == n.getNumber())
	                    {
	                        break petla;
	                    }
	                }
	                blad_count++;
	                ramka.add(n);
	            }

	            else
	            {
	                for (Strona p : ramka)
	                {
	                    if (p.getNumber() == n.getNumber())
	                    {
	                        break petla;
	                    }
	                }
	                Strona m = ktora(n,Stronas2, ramka);
	               if(m!=null)
	                {
	                    ramka.remove(m);
	                }
	               // jezeli wgl nie bedzie odwolan do zadnego z tych ktore sa w ramce to wywalamy pierwszy jak w fifo
	                else {
	                    ramka.remove(0);
	                }
	                ramka.add(n);
	                blad_count++;

	            }
	        }
	        ramka.clear();
	        return  blad_count;
	    }	
	
	public int ALRU() {
        blad_count = 0;
        ArrayList<Strona> Strony1 = new ArrayList<>();
        for(Strona p :referencje)
        {
            Strony1.add(new Strona(p));
        }
        Strona n;
        for (int i = 0; i < Strony1.size(); i++) {
            n = Strony1.get(i);
            petla:
            if (ramka.size() < SIZE_OF_RAMKA) {
                for (Strona p : ramka)
                {
                    if (p.getNumber() == n.getNumber())
                    {
                        p.setBit(true);
                        p.setNr_ref(p.getNr_ref()+1);
                        break petla;
                    }
                }
                blad_count++;
                ramka.add(n);
            }

            else
            {
                for (Strona p : ramka)
                {
                    if (p.getNumber() == n.getNumber())
                    {
                        p.setBit(true);
                        p.setNr_ref(p.getNr_ref()+1);
                        break petla;
                    }
                }
               Collections.sort(ramka, Strona.nr_ref_Comparator);
               boolean found = false;
               
               // usuwamy pierwszy napotkany do ktorego nie bylo odniesienia
               petla2:
               do {
                   for (Strona p : ramka) {
                       if (p.isBit() == false) {
                           ramka.remove(p);
                           ramka.add(n);
                           break petla2;
                       } else {
                           p.setBit(false);
                       }
                   }
               }
               while(found == false);
               blad_count++;

            }
        }
        ramka.clear();
        return  blad_count;
    }

	// 100000 30 1 20
	  public int RAND()    {
	        blad_count = 0;
	        ArrayList<Strona> Strony = new ArrayList<>();
	        for(Strona p :referencje)
	        {
	            Strony.add(new Strona(p));
	        }
	        Strona n;
	        for (int i = 0; i < Strony.size(); i++) {
	            n = Strony.get(i);
	            petla:
	            if (ramka.size() < SIZE_OF_RAMKA) {
	                for (Strona p : ramka)
	                {
	                    if (p.getNumber() == n.getNumber())
	                    {
	                        break petla;
	                    }
	                }
	                blad_count++;
	                ramka.add(n);
	            }

	            else
	            {
	                for (Strona p : ramka)
	                {
	                    if (p.getNumber() == n.getNumber())
	                    {
	                        break petla;
	                    }
	                }
	                int r =(int)(Math.random()*SIZE_OF_RAMKA);
	                ramka.set(r, n);
	                blad_count++;

	            }
	        }
	        ramka.clear();
	        return  blad_count;
	    }
	  // usuwamy ta do ktorej ostatnie odwolanie bylo najdalej
	  
	    public int LRU()    {
	        blad_count = 0;
	        ArrayList<Strona> Strony = new ArrayList<>();
	        //przekopiowujemy
	        for(Strona p :referencje)
	        {
	            Strony.add(new Strona(p));
	        }
	        Strona n;
	        for (int i = 0; i < Strony.size(); i++) {
	            n = Strony.get(i);
	            petla:
	            if (ramka.size() < SIZE_OF_RAMKA) {
	                for (Strona p : ramka)
	                {
	                    if (p.getNumber() == n.getNumber())
	                    	
	                    {
	                        p.setNr_ref(p.getNr_ref()+1); // dodajemy 1 bo bylo odwolanie a potem sortujemy po odwolaniach i tam bedzie wiece
	                        break petla;
	                    }
	                }
	                blad_count++;
	                ramka.add(n);
	            }

	            else
	            {
	                for (Strona p : ramka)
	                {
	                    if (p.getNumber() == n.getNumber())
	                    {
	                        p.setNr_ref(p.getNr_ref()+1);
	                        break petla;
	                    }
	                }

	                Collections.sort(ramka, Strona.nr_ref_Comparator);
	                ramka.remove(0);
	                ramka.add(n);
	                blad_count++;

	            }
	        }
	        ramka.clear();
	        return  blad_count;
	    }
	  	    
	    public Strona ktora(Strona p, ArrayList <Strona> refs, ArrayList <Strona> ramka_2)  {
	    	ArrayList <Strona> temp = new ArrayList<>();
	    	
	    	for(Strona p1 : ramka_2) {
	    		temp.add((new Strona(p1)));
	    	}
	    	
	    	for(int i = refs.indexOf(p); i < refs.size(); i++) {
	    		for(int j = 0; j < temp.size(); j++) {
	    			//przelatujemy ramke ciagle
	    			// znajdujemy ten ktory bedzie uzywany najblizej i usuwamy go
	    			// na koniec zostaje nam jeden, ten ktory bedzie najdluzej nieuzywany
	    			if(temp.get(j).getNumber() == refs.get(i).getNumber()) {
	    				temp.remove(j);
	    			}
	    			// znajdujemy tego najdluzej nieuzywanego w ramce
	    			if(temp.size() == 1) {
	    				for(int k = 0; k < ramka_2.size(); k++) {
	    					if(temp.get(0).getNumber() == ramka_2.get(k).getNumber())
	    						return ramka_2.get(k);
	    				}
	    			}
	    		}
	    	}
	    	return null;
	    }
}
