package tris;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class tris {
    private JFrame finestra;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,bn;
    private String croce = "X", cerchio = "0";
    private int turno=0,vincitore=0,contatore=0,risultato=0;
    private JLabel vis;
    private JPanel p1,p2,p3,p4,p5; 
    private final int riga=200,colonna=600,bottone=135;
    
    int schema[][]=new int[3][3];
    
    private void controlla(){
    	contatore++;
    	risultato=schema[0][0]+schema[0][1]+schema[0][2];
    	switch(risultato){
    	case 3: vincitore=1; break;
    	case 6: vincitore=2; break;
    	}

    	risultato=schema[1][0]+schema[1][1]+schema[1][2];
    	switch(risultato){
    	case 3: vincitore=1; break;
    	case 6: vincitore=2; break;
    	}

    	risultato=schema[2][0]+schema[2][1]+schema[2][2];
    	switch(risultato){
    	case 3: vincitore=1; break;
    	case 6: vincitore=2; break;
    	}

    	risultato=schema[0][0]+schema[1][0]+schema[2][0];
    	switch(risultato){
    	case 3: vincitore=1; break;
    	case 6: vincitore=2; break;
    	}

    	risultato=schema[0][1]+schema[1][1]+schema[2][1];
    	switch(risultato){
    	case 3: vincitore=1; break;
    	case 6: vincitore=2; break;
    	}
    	
    	risultato=schema[0][2]+schema[1][2]+schema[2][2];
    	switch(risultato){
    	case 3: vincitore=1; break;
    	case 6: vincitore=2; break;
    	}
    	
    	risultato=schema[0][0]+schema[1][1]+schema[2][2];
    	switch(risultato){
    	case 3: vincitore=1; break;
    	case 6: vincitore=2; break;
    	}
    	
    	risultato=schema[0][2]+schema[1][1]+schema[2][0];
    	switch(risultato){
    	case 3: vincitore=1; break;
    	case 6: vincitore=2; break;
    	}
    	
    	switch(vincitore){
    	case 1:	vis.setText("Vincitore giocatore 1, scarsone giocatore 2"); break;
    	case 2:	vis.setText("Vincitore giocatore 2, scarsone giocatore 1"); break;
    	default: if(contatore==9) vis.setText("Pareggio"); break;
    	}
    	
    	if(vincitore!=0)
    	{	b1.setEnabled(false);
    		b2.setEnabled(false);
    		b3.setEnabled(false);
    		b4.setEnabled(false);
    		b5.setEnabled(false);
    		b6.setEnabled(false);
    		b7.setEnabled(false);
    		b8.setEnabled(false);
    		b9.setEnabled(false);
    		}
    }
    
    tris(){
    finestra=new JFrame("Tris");
	finestra.setSize(600,1000);
	finestra.setLayout(new GridLayout(5,1));
	
	for(int i=0;i<3;i++)
		for(int j=0;j<3;j++)
			schema[i][j]=27;
	
    finestra.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent windoEvent){
			System.exit(0);
		}
    });
	
	b1=new JButton();
	b2=new JButton();
	b3=new JButton();
	b4=new JButton();
	b5=new JButton();
	b6=new JButton();
	b7=new JButton();
	b8=new JButton();
	b9=new JButton();
	bn=new JButton();
	
	b1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	if(turno==0)
	    		{
	    		b1.setText(croce);
	    		schema[0][0]=1;}
	    	else
	    		{b1.setText(cerchio);
	    		 schema[0][0]=2;}
	    	b1.setEnabled(false);
	    turno=1-turno;
	    controlla(); }
	});
	
	b2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	if(turno==0)
	    		{b2.setText(croce);
	    		 schema[0][1]=1;}
	    	else
	    		{b2.setText(cerchio);
	    		 schema[0][1]=2;}
	    	b2.setEnabled(false);
	    turno=1-turno;
	    controlla(); }
	});
	

	b3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	if(turno==0)
	    		{b3.setText(croce);
	    		schema[0][2]=1;}
	    	else
	    		{b3.setText(cerchio);
	    		schema[0][2]=2; }
	    	b3.setEnabled(false);
	    turno=1-turno;
	    controlla(); }
	});
	

	b4.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	if(turno==0)
	    		{b4.setText(croce);
		         schema[1][0]=1;}
	    	else
	    		{b4.setText(cerchio);
		         schema[1][0]=2;}
	    	b4.setEnabled(false);
	    turno=1-turno;
	    controlla(); }
	});
	

	b5.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	if(turno==0)
	    		{b5.setText(croce);
	    		 schema[1][1]=1;}
	    	else
	    		{b5.setText(cerchio);
	    		schema[1][1]=2;}
	    	b5.setEnabled(false);
	    turno=1-turno;
	    controlla(); }
	});
	

	b6.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	if(turno==0)
	    		{b6.setText(croce);
	    		schema[1][2]=1;}
	    	else
    		    {b6.setText(cerchio);
	    	     schema[1][2]=2;}
	    	b6.setEnabled(false);
	    turno=1-turno;
	    controlla(); }
	});
	

	b7.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	if(turno==0)
	    		{b7.setText(croce);
	    	     schema[2][0]=1;}
	    	else
	    		{b7.setText(cerchio);
	    		 schema[2][0]=2;}
	    	b7.setEnabled(false);
	    turno=1-turno;
	    controlla(); }
	});
	

	b8.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	if(turno==0)
	    		{b8.setText(croce);
	    		 schema[2][1]=1;}
	    	else
	    		{b8.setText(cerchio);
	    		 schema[2][1]=2;}
	    	b8.setEnabled(false);
	    turno=1-turno;
	    controlla(); }
	});
	

	b9.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	if(turno==0)
	    		{b9.setText(croce);
	    		 schema[2][2]=1;}
	    	else
	    		{b9.setText(cerchio);
	    		 schema[2][2]=2;}
	    	b9.setEnabled(false);
	    turno=1-turno;
	    controlla(); }
	});
	
	bn.setText("Nuova PARTITA"); 
	
	bn.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e){	
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(true);
		b9.setEnabled(true);
		b1.setText(null);
		b2.setText(null);
		b3.setText(null);
		b4.setText(null);
		b5.setText(null);
		b6.setText(null);
		b7.setText(null);
		b8.setText(null);
		b9.setText(null);
		contatore=0;
		vincitore=0;
		turno=0; 
		vis.setText("vincitore...scarsone...");
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				schema[i][j]=27;
		}
	});
	
	p1=new JPanel();
	p1.setSize(colonna,riga);
	p2=new JPanel();
	p2.setSize(colonna,riga);
	p3=new JPanel();
	p3.setSize(colonna,riga);
	p4=new JPanel();
	p4.setSize(colonna,riga);
	p5=new JPanel();
	p5.setSize(colonna,riga);
	
	b1.setPreferredSize(new Dimension(bottone,bottone));
	b2.setPreferredSize(new Dimension(bottone,bottone));
	b3.setPreferredSize(new Dimension(bottone,bottone));
	
	b4.setPreferredSize(new Dimension(bottone,bottone));
	b5.setPreferredSize(new Dimension(bottone,bottone));
	b6.setPreferredSize(new Dimension(bottone,bottone));
	
	b7.setPreferredSize(new Dimension(bottone,bottone));
	b8.setPreferredSize(new Dimension(bottone,bottone));
	b9.setPreferredSize(new Dimension(bottone,bottone));
	
	bn.setPreferredSize(new Dimension(600,200));
	
	p1.add(b1);
	p1.add(b2);
	p1.add(b3);
	p2.add(b4);
	p2.add(b5);
	p2.add(b6);
	p3.add(b7);
	p3.add(b8);
	p3.add(b9);
	
	p5.add(bn);
	
	vis=new JLabel();
	vis.setSize(300,100);
	vis.setText("vincitore...scarsone...");

	p4.add(vis);

	finestra.add(p1);
	finestra.add(p2);
	finestra.add(p3);
	finestra.add(p4);
	finestra.add(p5);
	
	
	finestra.setVisible(true);
   }
    
	public static void main(String[] args) {
		tris nuovo=new tris();
	}
}
