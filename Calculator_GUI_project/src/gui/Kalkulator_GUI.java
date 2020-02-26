package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Kalkulator_GUI  extends JFrame{
	
	
	// etykietki
	
	@SuppressWarnings("unused")
	private JLabel Label_NUM1;
	@SuppressWarnings("unused")
	private JLabel Label_NUM2;
	@SuppressWarnings("unused")
	private JLabel Label_Wynik;
	
	//wielomian etykietki
	@SuppressWarnings("unused")
	private JLabel Label_A;
	@SuppressWarnings("unused")
	private JLabel Label_B;
	@SuppressWarnings("unused")
	private JLabel Label_C;
	//operacje
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtSin;
    private JButton jbtCos;
    private JButton jbtTan;
    private JButton jbtSqrt;
    private JButton jbtPow;
    private JButton jbtLn;
    //funkcyjne
    private JButton jbtSolve;
    private JButton jbtClear;
    
    //pola tekstowe
    private JTextField numer1;
    private JTextField numer2;
    private JTextField wynik;
    
    //pola wielomian
    private JTextField Wielomian_A;
    private JTextField Wielomian_B;
    private JTextField Wielomian_C;
    private JTextField Wielomian_Pierw1;
    private JTextField Wielomian_Pierw2;
	
	private JButton Solve_Wiel;
    
    
    //zmienne przekazywane do liczenia
    private double TEMP1;
    private double TEMP2;
    private double TEMP3;
    //zmienna do numerowania polecen
    
     private int function = 0;
     
     
    

	

	//-----------------KONSTRUKTOR------------------------    
    public Kalkulator_GUI()
    {
    	setTitle("Kalkulator");
    	
    	JPanel p1 = new JPanel();
    	
    	p1.setLayout(new GridLayout(7, 2) );
    	
    	p1.add(Label_NUM1 = new JLabel("Liczba 1") );
    	p1.add(Label_NUM2 = new JLabel("Liczba 2") );
    	p1.add(numer1 = new JTextField("") );
    	p1.add(numer2 = new JTextField("") );
    	p1.add(jbtAdd = new JButton("+") );
        p1.add(jbtSubtract = new JButton("-") );
        p1.add(jbtMultiply = new JButton("*") );
        p1.add(jbtDivide = new JButton("/") );
        p1.add(jbtSin = new JButton("sin x") );
        p1.add(jbtCos = new JButton("cos x") );
        p1.add(jbtTan = new JButton("tan x") );
        p1.add(jbtSqrt = new JButton("sqrt x") );
        p1.add(jbtPow = new JButton("a^b") );
        p1.add(jbtLn = new JButton("ln x") );
    	
        
        JPanel p2 = new JPanel();
        
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS) );
        
        p2.add(Label_Wynik = new JLabel("Wynik") );
        p2.add( wynik  = new JTextField("") );
        p2.add(jbtSolve = new JButton("=") );
        p2.add(jbtClear = new JButton("C") );
        wynik.setEditable(false);
		
		//wielomian umieszczenia
		JPanel p3 = new JPanel();
		
		p3.setLayout(new GridLayout(3,3) );
		
		p3.add(Label_A = new JLabel("Współczynnik A") );
		p3.add(Label_B = new JLabel("Współczynnik B") );
		p3.add(Label_C = new JLabel("Współczynnik C") );
		p3.add( Wielomian_A = new JTextField(""));
		p3.add( Wielomian_B = new JTextField(""));
		p3.add( Wielomian_C = new JTextField(""));
		p3.add( Solve_Wiel =  new JButton("Znajdź pierwiastki"));
		p3.add( Wielomian_Pierw1 = new JTextField("Pierwiastek 1"));
		p3.add( Wielomian_Pierw2 = new JTextField("Pierwiastek 2"));
		
		Wielomian_Pierw1.setEditable(false);
		Wielomian_Pierw2.setEditable(false);
        
        //tworzenie obsługi zdarzeń
        
        jbtAdd.addActionListener(new AddListener());
        jbtSubtract.addActionListener(new SubtractListener());
        jbtMultiply.addActionListener(new MultiplyListener());
        jbtDivide.addActionListener(new DivideListener());
        jbtSin.addActionListener(new SinListener());
        jbtCos.addActionListener(new CosListener());
        jbtTan.addActionListener(new TanListener());
        jbtSqrt.addActionListener(new SqrtListener());
        jbtPow.addActionListener(new PowListener());
        jbtLn.addActionListener(new LnListener());
        
		jbtSolve.addActionListener(new SolveListener());
        jbtClear.addActionListener(new ClearListener());
		
		//obsługa zdarzeń wielomian
		
		Solve_Wiel.addActionListener(new Solve_Wiel_Listener() );
	
    	
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(p1, BorderLayout.WEST);
        p.add(p2, BorderLayout.CENTER);
		p.add(p3, BorderLayout.SOUTH);
       
        add(p);
    }
	
//koniec konstruktora
    public JTextField getWynik() {
		return wynik;
	}
// --------------------------------Main--------------------    
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
    	Kalkulator_GUI calc = new Kalkulator_GUI();
    	
    	calc.setSize(1200,1200);
    	calc.pack();
    	calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    			
    
    }
    //----------koniec maina---------------
    
    //listenery
    
	class AddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			TEMP1= Double.parseDouble(numer1.getText());
			TEMP2= Double.parseDouble(numer2.getText());
			function =1;
		}
	}
	
	class SubtractListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			TEMP1= Double.parseDouble(numer1.getText());
			TEMP2= Double.parseDouble(numer2.getText());
			function =2;
		}
	}
	
	class MultiplyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			TEMP1= Double.parseDouble(numer1.getText());
			TEMP2= Double.parseDouble(numer2.getText());
			function =3;
		}
	}
	
	class DivideListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			TEMP1= Double.parseDouble(numer1.getText());
			TEMP2= Double.parseDouble(numer2.getText());
			function =4;
		}
	}
	
	class SinListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(numer1.getText().isEmpty() ) 
			{
			TEMP1= Double.parseDouble(numer2.getText());
			} else  TEMP1= Double.parseDouble(numer1.getText());
			function =5;
		}
	}
	
	class CosListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(numer1.getText().isEmpty()) 
			{
			TEMP1= Double.parseDouble(numer2.getText());
			} else  TEMP1= Double.parseDouble(numer1.getText());			
			function =6;
		}
	}
	
	class TanListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(numer1.getText().isEmpty() ) 
			{
			TEMP1= Double.parseDouble(numer2.getText());
			} else  TEMP1= Double.parseDouble(numer1.getText());			
			function =7;
		}
	}
	
	class SqrtListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(numer1.getText().isEmpty() ) 
			{
			TEMP1= Double.parseDouble(numer2.getText());
			} else  TEMP1= Double.parseDouble(numer1.getText());			
			function =8;
		}
	}
	
	class PowListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			TEMP1= Double.parseDouble(numer1.getText());
			TEMP2= Double.parseDouble(numer2.getText());
			function =9;
		}
	}
	
	class LnListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if((numer1.getText() ).isEmpty() ) 
			{
			TEMP1= Double.parseDouble(numer2.getText());
			} else  TEMP1= Double.parseDouble(numer1.getText());			
			function =10;
		}
	}
	//---------------------------BLOK FUNKCYJNY, OPERACJE------------------
	class SolveListener implements ActionListener {
	
		
		public void actionPerformed(ActionEvent e) {
        	
        	double TEMPwynik=0;
        	
        	switch (function) {
        		case 1:
        		{
        			TEMPwynik = TEMP1+TEMP2;
        			break;
        		}
        		case 2:
        		{
        			TEMPwynik = TEMP1-TEMP2;
        			break;
        		}
        		case 3:
        		{
        			TEMPwynik = TEMP1*TEMP2;
        			break;
        		}
        		case 4:
        		{
        			try {
        			dzielenie_przez0();
        			}
        			catch(Wyjatek_Dzielenie_przez0 error)
        			{
        				error.printStackTrace();
        			}
        			break;
        		}
        		case 5:
        		{
        			TEMPwynik= Math.sin(TEMP1) ;
        			break;
        		}
        		case 6:
        		{
        			TEMPwynik= Math.cos(TEMP1) ;
        			break;
        		}
        		case 7:
        		{
        			TEMPwynik= Math.tan(TEMP1) ;
        			break;
        		}
        		case 8:
        		{
        			TEMPwynik= Math.sqrt(TEMP1) ;
        			break;
        		}
        		case 9:
        		{
        			TEMPwynik= Math.pow(TEMP1, TEMP2) ;
        			break;
        		}
        		case 10:
        		{
        			TEMPwynik= Math.log(TEMP1) ;
        			break;
        		}
        		default:
        			break;
          
            	
        	}	
        	if(function!=4) wynik.setText(  Double.toString(TEMPwynik) );

            function=0;
        }
		
		public   void dzielenie_przez0 ()throws Wyjatek_Dzielenie_przez0
		{
			if(TEMP2 == 0) 
			{
				getWynik().setText("Nie mozna dzielic przez 0");
				throw  new Wyjatek_Dzielenie_przez0();
			}	
			else   getWynik().setText( Double.toString(TEMP1/TEMP2) );
		}
    }
	
	class ClearListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			numer1.setText("");
			numer2.setText("");
			wynik.setText("");
			//wielomian
			Wielomian_A.setText("");
			Wielomian_B.setText("");
			Wielomian_C.setText("");
			Wielomian_Pierw1.setText("");
			Wielomian_Pierw2.setText("");
		}
	}
	
	//-----Listenery Wielomianu
	
	class Solve_Wiel_Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
		 if(Wielomian_A.getText().isEmpty()) TEMP1= 0; 
		 	else TEMP1= Double.parseDouble(Wielomian_A.getText());
		 if(Wielomian_B.getText().isEmpty()) TEMP2=0; 
		 	else  TEMP2= Double.parseDouble(Wielomian_B.getText());
		 if(Wielomian_C.getText().isEmpty()) TEMP3=0; 
		 	else TEMP3= Double.parseDouble(Wielomian_C.getText());
		  
		  double delta = TEMP2*TEMP2 - (4*TEMP1*TEMP3);
		  if (delta <0)
		  {
			  Wielomian_Pierw1.setText("brak pierwiastka");
			  Wielomian_Pierw2.setText("brak pierwiastka");
		  }
		  else if(delta > 0)
		  {
			  double x1 = (-TEMP2 + Math.sqrt(delta) ) / (2*TEMP1); 
			  double x2 = (-TEMP2 - Math.sqrt(delta) ) / (2*TEMP1); 
			  
			  Wielomian_Pierw1.setText(  Double.toString(x1) );
			  Wielomian_Pierw2.setText(  Double.toString(x2) );
		  }
		  else
		  {
			  double x = (-TEMP2/(2*TEMP1) );
			  Wielomian_Pierw1.setText(  Double.toString(x) );
			  Wielomian_Pierw2.setText("tylko jeden pierwiastek");
			  
		  }
		  
		}
	}
}
