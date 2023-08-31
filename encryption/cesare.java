package cesare;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cesare {
    static int max=100;
	private JFrame finestra;
	private JLabel chiaro1,cifrato1,c1,chiaro2,cifrato2,c2;
	private JTextField chiaro,cifrato,c,dchiaro,dcifrato,dc;
    private String ch,ci2;
    private int x,codice=0,kk,kk2,x2,codice2=0;
    private JButton b1,bc,b2,bc2;
    
	char[] tch=new char[max];
	char[] tci=new char[max];
	char[] tch2=new char[max];
	char[] tci2=new char[max];
	
	cesare(){
		finestra=new JFrame();
		finestra.setTitle("Cifrario di CESARE/Ciop-Biello");
		finestra.setSize(800,200);
		finestra.setLayout(new GridLayout(4,4));
		finestra.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windoEvent){
				System.exit(0);
			}
	    });
		
		c=new JTextField("3");
		c.addKeyListener(new KeyListener(){ 
			public void keyPressed(KeyEvent e){
			}
				
			public void keyReleased(KeyEvent e){	
				if((Integer.parseInt(c.getText())>26)||(Integer.parseInt(c.getText())<1))
				    {c1.setText("ERRORE");
				     chiaro.setEnabled(false);
				     cifrato.setEnabled(false);
				    }
				else
					{c1.setText("chiave");
					 chiaro.setEnabled(true);
				     cifrato.setEnabled(true);
					}
			}
				
			public void keyTyped(KeyEvent e){
			}			
		});
			
		chiaro=new JTextField("");
	    
		cifrato=new JTextField("");
		cifrato.setForeground(Color.RED);
		
		b1=new JButton("Cripta");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				ch=chiaro.getText();
			    x=ch.length();
				kk=Integer.parseInt(c.getText());
				for(int i=0;i<x;i++)
				    tch[i]=ch.charAt(i);
				
				for(int i=0;i<x;i++)
					if((tch[i]+kk)<='z')
						{codice=ch.codePointAt(i)+kk;
						 cifrato.setText(cifrato.getText()+(char)codice);}
					else
				    	{codice=ch.codePointAt(i)+kk-26;
				    	 cifrato.setText(cifrato.getText()+(char)codice);}
						
				for(int i=0;i<x;i++)
				if((tch[i]<97)||(tch[i]>122))
			       {chiaro1.setText("ERRORE");
			        cifrato.setEnabled(false);
			        cifrato.setText("");}
			}
		});
		
		bc=new JButton("Cancella");
		bc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				cifrato.setText("");
				chiaro.setText("");
				ch="";
				x=0;
				codice=0;
				chiaro.setEnabled(true);
				cifrato.setEnabled(true);
				c1.setText("chiave");
				chiaro1.setText("chiaro");
				cifrato1.setText("cifrato");
				
			}
		});
		
		c1=new JLabel("chiave", JLabel.CENTER);
				
		chiaro1=new JLabel("chiaro", JLabel.CENTER);
				
		cifrato1=new JLabel("cifrato", JLabel.CENTER);
		
//met� dell'algoritmo
		
		dc=new JTextField("3");
		dc.addKeyListener(new KeyListener(){ 
			public void keyPressed(KeyEvent e){
			}
				
			public void keyReleased(KeyEvent e){	
				if((Integer.parseInt(dc.getText())>26)||(Integer.parseInt(dc.getText())<1))
				    {c2.setText("ERRORE");
				     dchiaro.setEnabled(false);
				     dcifrato.setEnabled(false);
				    }
				else
					{c2.setText("chiave");
					 dchiaro.setEnabled(true);
				     dcifrato.setEnabled(true);
					}
			}
				
			public void keyTyped(KeyEvent e){
			}
		});
			
		dchiaro=new JTextField("");
		dchiaro.setForeground(Color.RED);
		
		dcifrato=new JTextField("");
		
		b2=new JButton("Decripta");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				ci2=dcifrato.getText();			
			    x2=ci2.length();
				kk2=Integer.parseInt(dc.getText());
				for(int i=0;i<x2;i++)
				    tci2[i]=ci2.charAt(i);
				
				for(int i=0;i<x2;i++)
					if((tci2[i]-kk2)>='a')
						{codice2=ci2.codePointAt(i)-kk2;
						 dchiaro.setText(dchiaro.getText()+(char)codice2);}
					else
						{codice2=ci2.codePointAt(i)-kk2+26;
						 dchiaro.setText(dchiaro.getText()+(char)codice2);}
				
				for(int i=0;i<x2;i++)
				if((tci2[i]<'a')||(tci2[i]>'z'))
			       {cifrato2.setText("ERRORE");
			        dchiaro.setEnabled(false);
			        dchiaro.setText("");}
			}
		});
		
		bc2=new JButton("Cancella");
		bc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				dcifrato.setText("");
				dchiaro.setText("");
				x2=0;
				codice2=0;
				dchiaro.setEnabled(true);
				dcifrato.setEnabled(true);
				c2.setText("chiave");
				chiaro2.setText("chiaro");
				cifrato2.setText("cifrato");
				
			}
		});
		
		c2=new JLabel("chiave", JLabel.CENTER);
				
		chiaro2=new JLabel("chiaro", JLabel.CENTER);
				
		cifrato2=new JLabel("cifrato", JLabel.CENTER);
		
		finestra.add(c1);
		finestra.add(c);
		
		finestra.add(c2);
		finestra.add(dc);
	
		
		finestra.add(chiaro1);
		finestra.add(chiaro);
		
		finestra.add(chiaro2);
		finestra.add(dchiaro);
		
		
		finestra.add(cifrato1);
		finestra.add(cifrato);
		
		finestra.add(cifrato2);
		finestra.add(dcifrato);
		
		
		finestra.add(b1);
		finestra.add(bc);
		
		finestra.add(b2);
		finestra.add(bc2);
		
		finestra.setVisible(true);
	}
	
	public static void main(String[] args) {
		cesare prova=new cesare();
	}
}