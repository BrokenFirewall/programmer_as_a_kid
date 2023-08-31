package quindici;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class quindici {
	private JFrame finestra;
	private int i,j,c=0,temp=0,x,y,ii,jj,iii,jjj,mosse=0;
	private String temp2; 
	private JButton bn,nm,bv;
	
	private class pulsanti extends JButton{
		int valore;
		pulsanti(){
			super(); }
	}
	
	pulsanti mat[][]=new pulsanti[4][4];
	int vet[]=new int[15];
	int vet2[]=new int[15];
	
	quindici(){
	
	finestra=new JFrame();
	finestra.setTitle("Quindici");
	finestra.setSize(500,500);
	finestra.setLayout(new GridLayout(5,1));
	finestra.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent windoEvent){
			System.exit(0);
		}
    });
	
	for(i=0;i<4;i++)
		for(j=0;j<4;j++)
		{   mat[i][j]=new pulsanti();
			mat[i][j].valore=0;
			finestra.add(mat[i][j]);
			mat[i][j].setBackground(Color.LIGHT_GRAY); 
			}
	
	for(i=0;i<15;i++)
		vet[i]=i+1;

	for(i=0;i<10000;i++)
	{ x=(int)(Math.random()*15);
	  y=(int)(Math.random()*15);
	  temp=vet[x];
	  vet[x]=vet[y];
	  vet[y]=temp;
	}
	
	for(i=0;i<15;i++)
		mat[i/4][i%4].valore=vet[i];
	
	for(i=0;i<4;i++)
		for(j=0;j<4;j++)
			{mat[i][j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					for(ii=0;ii<4;ii++)
						for(jj=0;jj<4;jj++){
							if(e.getSource()==mat[ii][jj])
							{	
					for(iii=Math.max(0,ii-1);iii<=Math.min(ii+1,4-1);iii++)
						for(jjj=Math.max(0,jj-1);jjj<=Math.min(jj+1,4-1);jjj++)
							if((mat[iii][jjj].valore==0)&&((ii==iii)||(jj==jjj)))
							{  mosse++;
							   temp=mat[ii][jj].valore;
				               mat[ii][jj].valore=mat[iii][jjj].valore;	
							   mat[iii][jjj].valore=temp;
							   mat[iii][jjj].setEnabled(true);
							   mat[iii][jjj].setBackground(Color.LIGHT_GRAY);
							   mat[ii][jj].setEnabled(false);
							   mat[ii][jj].setBackground(Color.BLUE);
							   temp2=mat[ii][jj].getText();
							   mat[ii][jj].setText(mat[iii][jjj].getText());	
							   mat[iii][jjj].setText(temp2);	   
							} 
					nm.setText(""+mosse);
							}
				}
					vet2[i]=mat[i/4][i%4].valore;
					//controllo di vittoria
					if(vet2[i]<vet2[i+1])
					{	bv.setText("Hai vinto!!");
					    mat[i][j].setEnabled(false);
					}	
				}
	});
	mat[i][j].setText(""+mat[i][j].valore);
	}
	
	mat[3][3].setBackground(Color.BLUE);
	
	for(i=0;i<4;i++)
		for(j=0;j<4;j++)
		{   mat[i][j].setText(""+mat[i][j].valore); 
			mat[3][3].setText("");}
	
	bn=new JButton("N. Partita");
	
	bn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	for(i=0;i<4;i++)
	    		for(j=0;j<4;j++)
	    		{	mat[i][j].valore=0;
	    			mat[i][j].setBackground(Color.LIGHT_GRAY);
	    			mat[i][j].setEnabled(true);
	    			}
	    	
	    	for(i=0;i<15;i++)
	    		vet[i]=i+1;

	    	for(i=0;i<10000;i++)
	    	{ x=(int)(Math.random()*15);
	    	  y=(int)(Math.random()*15);
	    	  temp=vet[x];
	    	  vet[x]=vet[y];
	    	  vet[y]=temp;
	    	}
	    	
	    	for(i=0;i<15;i++)
	    		mat[i/4][i%4].valore=vet[i];
	    	
	    	for(i=0;i<4;i++)
	    		for(j=0;j<4;j++)
	    		{   mat[i][j].setText(""+mat[i][j].valore); 
	    		    }
	    	
	    	mat[3][3].setText("");
	    	mat[3][3].setBackground(Color.BLUE);
	    	mat[3][3].setEnabled(false);
	    	nm.setText("N. Mosse");
	    	mosse=0;
	    	bv.setText("In gioco");
	    }	
	    });
	
	bv=new JButton("In gioco");
	
	nm=new JButton("N. Mosse");
		
	finestra.add(nm);
	finestra.add(bn);
	finestra.add(bv);
	finestra.setVisible(true);
	}
	
	public static void main(String[] args) {
		quindici prova=new quindici();
	}
}