package rail_fence;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class rail_fence{
    static int max=100;
	private JFrame finestra;
	private JLabel chiaro1,cifrato1,chiaro2,cifrato2;
	private JTextField chiaro,cifrato,dchiaro,dcifrato;
    private String ch="",ci="",ch2="",ci2="";
    private int x=0,x2=0;
    private JButton b1,bc,b2,bc2;
    
	char[] tch=new char[max];
	char[] tci=new char[max];
	
	rail_fence(){
		finestra=new JFrame();
		finestra.setTitle("Cifrario di Rail Fence");
		finestra.setSize(800,200);
		finestra.setLayout(new GridLayout(3,4));
		finestra.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windoEvent){
				System.exit(0);
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
				
				for(int i=0;i<x;i++)
				    tch[i]=ch.charAt(i);
					
				for(int i=0;i<x;i++)
				    if(i%2==0) 
				       ci+=tch[i];
					
				for(int i=0;i<x/2;i++)
				    cifrato.setText(ci);
				
				for(int i=0;i<x;i++)
				    if(i%2!=0) 
				       ci+=tch[i];
					
				for(int i=x/2;i<x;i++)
				    cifrato.setText(ci);
			}
		});
		
		bc=new JButton("Cancella");
		bc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				cifrato.setText("");
				chiaro.setText("");
				ch="";
				x=0;
				chiaro.setEnabled(true);
				cifrato.setEnabled(true);
				chiaro1.setText("chiaro");
				cifrato1.setText("cifrato");
				ci="";
				
			}
		});
				
		chiaro1=new JLabel("chiaro", JLabel.CENTER);
				
		cifrato1=new JLabel("cifrato", JLabel.CENTER);
		
//metà dell'algoritmo
		
		dchiaro=new JTextField("");
		dchiaro.setForeground(Color.RED);
		
		dcifrato=new JTextField("");
		
		b2=new JButton("Decripta");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				ci2=dcifrato.getText();
				if(ci2.length()%2!=0)
				   ci2+=' ';
				x2=ci2.length();
				
				for(int i=0;i<x2;i++)
					tci[i]=ci2.charAt(i);
				
				for(int i=0;i<x2/2;i++)
				   {ch2+=tci[i];
				    ch2+=tci[i+(x2/2)];
				    dchiaro.setText(ch2);}
				    
			}		
		});
		
		bc2=new JButton("Cancella");
		bc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				dcifrato.setText("");
				dchiaro.setText("");
				ci="";
				x2=0;
				dchiaro.setEnabled(true);
				dcifrato.setEnabled(true);
				chiaro2.setText("chiaro");
				cifrato2.setText("cifrato");
				ch2="";
				
			}
		});
				
		chiaro2=new JLabel("chiaro", JLabel.CENTER);
				
		cifrato2=new JLabel("cifrato", JLabel.CENTER);
		
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
		rail_fence prova=new rail_fence();
	}
}