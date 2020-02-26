package Main_prog;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.font.*;

import javax.swing.*;

public class Waluta extends JFrame{
	private JButton jbt;
	private JLabel l1;
	private JLabel l2;
	private JTextField jtext1;
	private JTextField jtext2;
	
	private double temp1;
	
	public Waluta() {
		setTitle ("Konwerter walut");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/4, screenHeight/7);
		
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,2));
		
		
		p.add(l1 = new JLabel ("Zloty"));
		p.add(jtext1 = new JTextField());
		p.add(l2 = new JLabel ("Euro"));
		p.add(jtext2 = new JTextField());
		p.add(jbt = new JButton("Wyczysc pola"));
		
		Font font1 = new Font("SansSerif", Font.BOLD, 14);
		l1.setFont(font1);
		l2.setFont(font1);
		jtext1.setFont(font1);
		jtext2.setFont(font1);
		jbt.setFont(font1);
		
		jtext1.addActionListener(new ZlotyListener());
		jtext2.addActionListener(new EuroListener());
		jbt.addActionListener(new ClearListener());
		this.add(p);
		setVisible(true);
	}
	
	class ZlotyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				temp1 = Double.parseDouble(jtext1.getText());
				temp1 = Konwerter.toEuro(temp1);
				jtext2.setText(Double.toString(temp1));
			
			
			} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Nieprawidlowy format liczby", " ", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class EuroListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				temp1 = Double.parseDouble(jtext2.getText());
				temp1 = Konwerter.toZloty(temp1);
				jtext1.setText(Double.toString(temp1));
			}
			catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Nieprawidlowy format liczby", " ", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jtext1.setText("");
			jtext2.setText("");
		}
	}
	
	
	public static void main(String [] args) {
		Waluta object = new Waluta();
	}
}
