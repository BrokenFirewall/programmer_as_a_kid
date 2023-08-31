package monouso;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class monouso{
    static int max=100;
	private JFrame finestra;
	private JLabel chiaro1,cifrato1,c1,chiaro2,cifrato2,c2;
	private JTextField chiaro,cifrato,c,dchiaro,dcifrato,dc;
    private String ch,ci2,k,dk;
    private int x,codice=0,x2,codice2=0,y,y2;
    private JButton b1,bc,b2,bc2;
    
	char[] tch=new char[max];
	char[] tci=new char[max];
	char[] tch2=new char[max];
	char[] tci2=new char[max];
	int[] kk=new int[max];
	int[] kk2=new int [max];
	
	monouso(){
		finestra=new JFrame();
		finestra.setTitle("Cifrario MONOUSO");
		finestra.setSize(800,200);
		finestra.setLayout(new GridLayout(4,4));
		finestra.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windoEvent){
				System.exit(0);
			}
	    });
		
		c=new JTextField("00");
		c.addKeyListener(new KeyListener(){ 
			public void keyPressed(KeyEvent e){
			}
				
			public void keyReleased(KeyEvent e){	
				/*if((Integer.parseInt(c.getText())>26)||(Integer.parseInt(c.getText())<1))
				    {c1.setText("ERRORE");
				     chiaro.setEnabled(false);
				     cifrato.setEnabled(false);
				    }
				else
					{c1.setText("chiave");
					 chiaro.setEnabled(true);
				     cifrato.setEnabled(true);
					}*/
				
				k=c.getText();
			    y=k.length();
			    
				for(int j=0;j<y/2;j++){
					kk[j]=(k.charAt(j*2)-'0')*10+(k.charAt(j*2+1)-'0');	
					if((kk[j]>25)||(kk[j]<0))
					{ c1.setText("ERRORE");
				      chiaro.setEnabled(false);
				      cifrato.setEnabled(false); }
					else
					{ c1.setText("chiave");
					  chiaro.setEnabled(true);
				      cifrato.setEnabled(true);}
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
			    k=c.getText();
			    y=k.length();
			    
			    for(int i=0;i<x;i++)
					tch[i]=ch.charAt(i);
			    
			    for(int i=0;i<x;i++)
			    	kk[i]=k.charAt(i);
			    	
			    for(int j=0;j<y/2;j++){
					kk[j]=(k.charAt(j*2)-'0')*10+(k.charAt(j*2+1)-'0');
					
						if((tch[j]+kk[j])<='z')
							{codice=ch.codePointAt(j)+kk[j];
							 cifrato.setText(cifrato.getText()+(char)codice);}
						else
				    		{codice=ch.codePointAt(j)+kk[j]-26;
				    		 cifrato.setText(cifrato.getText()+(char)codice);}
			    }
			    
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
				
				k=c.getText();
			    y=k.length();
			    
				for(int j=0;j<y/2;j++){
					kk[j]=(k.charAt(j*2)-'0')*10+(k.charAt(j*2+1)-'0');	
					if((kk[j]>25)||(kk[j]<0))
					{ c1.setText("ERRORE");
				      chiaro.setEnabled(false);
				      cifrato.setEnabled(false); }
					else
					{ c1.setText("chiave");
					  chiaro.setEnabled(true);
				      cifrato.setEnabled(true);}
				}
			}
		});
		
		c1=new JLabel("chiave", JLabel.CENTER);
				
		chiaro1=new JLabel("chiaro", JLabel.CENTER);
				
		cifrato1=new JLabel("cifrato", JLabel.CENTER);
		
//metà dell'algoritmo
		
		dc=new JTextField("00");
		dc.addKeyListener(new KeyListener(){ 
			public void keyPressed(KeyEvent e){
			}
				
			public void keyReleased(KeyEvent e){	
				dk=dc.getText();
				y2=dk.length();
			    
				for(int j=0;j<y2/2;j++){
					kk2[j]=(dk.charAt(j*2)-'0')*10+(dk.charAt(j*2+1)-'0');	
					if((kk2[j]>25)||(kk2[j]<0))
					{ c2.setText("ERRORE");
				      dchiaro.setEnabled(false);
				      dcifrato.setEnabled(false); }
					else
					{ c2.setText("chiave");
					  dchiaro.setEnabled(true);
				      dcifrato.setEnabled(true);}
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
				dk=dc.getText();
				y2=dk.length();
			    
			    for(int i=0;i<x2;i++)
					tci2[i]=ci2.charAt(i);
			    	
			    for(int j=0;j<y2/2;j++){
					kk2[j]=(dk.charAt(j*2)-'0')*10+(dk.charAt(j*2+1)-'0');	
				    
						if((tci2[j]-kk2[j])>='a')
							{codice2=ci2.codePointAt(j)-kk2[j];
							 dchiaro.setText(dchiaro.getText()+(char)codice2);}
						else
				    		{codice2=ci2.codePointAt(j)-kk2[j]+26;
				    		 dchiaro.setText(dchiaro.getText()+(char)codice2);}
			    }
			    
				for(int i=0;i<x;i++)
				if((tci2[i]<97)||(tci[i]>122))
			       {cifrato2.setText("ERRORE");
			        chiaro2.setEnabled(false);
			        chiaro2.setText("");}
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
			
				dk=dc.getText();
				y2=dk.length();
			    
				for(int j=0;j<y2/2;j++){
					kk2[j]=(dk.charAt(j*2)-'0')*10+(dk.charAt(j*2+1)-'0');	
					if((kk2[j]>25)||(kk2[j]<0))
					{ c2.setText("ERRORE");
				      dchiaro.setEnabled(false);
				      dcifrato.setEnabled(false); }
					else
					{ c2.setText("chiave");
					  dchiaro.setEnabled(true);
				      dcifrato.setEnabled(true);}
				}
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
		monouso prova=new monouso();
	}
}