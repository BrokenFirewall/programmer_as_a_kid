package memoria;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class memoria {
    private int i,j,x,y,ii,jj,c=1,xx=0,yy=0,v=0,somma=0;
    private static int dim_m=4,dim_v=0;
    private JFrame finestra;
    private Label etichetta;
    private JButton bn;
    
    private class pulsanti extends JButton{
		int valore;
		pulsanti(){
			super(); }
	}
    
    pulsanti mat[][]=new pulsanti[dim_m][dim_m];
	int mat2[][]=new int[dim_m][dim_m];
    
	memoria(){
		dim_v=(dim_m*dim_m);
		
		etichetta=new Label();
		etichetta.setText("In gioco");
		etichetta.setAlignment(Label.CENTER);
		
		for(i=0;i<dim_v/2;i++)
			somma=(somma+(dim_v/2))-i;
		
		final int vet[]=new int[dim_v];
		
		finestra=new JFrame();
		finestra.setTitle("Gioco della Memoria");
		finestra.setSize(500,500);
		finestra.setLayout(new GridLayout(5,1));
		finestra.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windoEvent){
				System.exit(0);
			}
	    });
		
		for(i=0;i<dim_m;i++)
			for(j=0;j<dim_m;j++)
			{	mat[i][j]=new pulsanti();
				mat[i][j].valore=0;
				finestra.add(mat[i][j]);
				mat[i][j].setBackground(Color.LIGHT_GRAY);
				//mat[i][j].setSize(50,50);
			}
		
		for(i=0;i<dim_v;i++)
			vet[i]=0;
		
		for(i=0;i<dim_v/2;i++)
			{vet[i]=i+1;
			 vet[dim_v-i-1]=i+1;
			}
		
		for(i=0;i<10000;i++)
		{ int temp;
		  x=(int)(Math.random()*dim_v);
		  y=(int)(Math.random()*dim_v);
		  temp=vet[x];
		  vet[x]=vet[y];
		  vet[y]=temp;
		}
		
		for(i=0;i<dim_v;i++)
			mat[i/dim_m][i%dim_m].valore=vet[i];
		
		for(i=0;i<dim_m;i++)
			for(j=0;j<dim_m;j++)
				{finestra.add(mat[i][j]);
				 mat[i][j].setText(""+mat[i][j].valore);
				 mat[i][j].setBackground(Color.lightGray);
				}
		
		for(i=0;i<dim_m;i++)
			for(j=0;j<dim_m;j++)
				mat[i][j].setText("");
				
		for(i=0;i<dim_m;i++)
			for(j=0;j<dim_m;j++)
			{mat[i][j].addActionListener(new ActionListener(){ 
				public void actionPerformed(ActionEvent e){
					c=1-c;
					if(c==0)
					   	for(i=0;i<dim_m;i++)
							 for(j=0;j<dim_m;j++)
								if(e.getSource()==mat[i][j]){
									mat[i][j].setText(""+mat[i][j].valore);
									xx=i;
									yy=j;
								}
					if(c==1)
					    {for(ii=0;ii<dim_m;ii++)
						   for(jj=0;jj<dim_m;jj++)
							  if(e.getSource()==mat[ii][jj]){
								  mat[ii][jj].setText(""+mat[ii][jj].valore);
								  
								  if(mat[xx][yy]==mat[ii][jj])
								     mat[xx][yy].setText("");
								  
								  
								  
								  if(mat[xx][yy].valore!=mat[ii][jj].valore)
								  {  //try{
								     //  for(int iu=0; iu<1000000000;iu++);}
								     //catch(Exception eee){}
									  mat[ii][jj].setText(""+mat[ii][jj].valore);
									  
									  try{
										for(int iu=0; iu<1000000000;iu++);}
									  catch(Exception eee){}
									  
									  mat[ii][jj].setText("");
								  	  mat[xx][yy].setText(""); 	
								  }
								  
								  
								  
								  if((mat[xx][yy].valore==mat[ii][jj].valore)&&(mat[xx][yy]!=mat[ii][jj]))
								   {mat[xx][yy].setEnabled(false);
								  	mat[ii][jj].setEnabled(false);
								  	v+=mat[xx][yy].valore;
								
								  	if(v>=somma)
								  	{for(i=0;i<dim_m;i++)
										for(j=0;j<dim_m;j++)
											mat[i][j].setBackground(Color.BLUE);
								  	etichetta.setText("Hai vinto");
								  	}
							  }
								  	
							     //}
								   
								  //if(mat[xx][yy]!=mat[ii][jj])
									  
								  //sleep(2000), delay
								  
								  /*else
								  { 	mat[ii][jj].setText(""+mat[ii][jj].valore);
									    try {
										    Thread.sleep(2000);                 
									    	mat[ii][jj].setText("");
									    	mat[xx][yy].setText("");
									    	
										    } 
									    catch(InterruptedException ie) {
										}
								  }*/
					    }    
				}  
				}
			});
			}		
		

		bn=new JButton();
		bn.setText("Nuova partita");
		
		bn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				
				for(i=0;i<dim_v;i++)
					vet[i]=0;
				
				for(i=0;i<dim_v/2;i++)
					{vet[i]=i+1;
					 vet[dim_v-i-1]=i+1;
					}
				
				for(i=0;i<10000;i++)
				{ int temp;
				  x=(int)(Math.random()*dim_v);
				  y=(int)(Math.random()*dim_v);
				  temp=vet[x];
				  vet[x]=vet[y];
				  vet[y]=temp;
				}
				
				for(i=0;i<dim_v;i++)
					mat[i/dim_m][i%dim_m].valore=vet[i];
				
				/*for(i=0;i<dim_m;i++)
					for(j=0;j<dim_m;j++)
						mat[i][j].setText(""+mat[i][j].valore);*/
				
				for(i=0;i<dim_m;i++)
					for(j=0;j<dim_m;j++)
					  {	mat[i][j].setBackground(Color.lightGray);
						mat[i][j].setEnabled(true);
						mat[i][j].setText("");
					  }
				
				v=0;
				
				etichetta.setText("In gioco");
			}	
			});
			
		finestra.add(bn);
		finestra.add(etichetta);
		finestra.setVisible(true);
	}

	public static void main(String[] args) {
		memoria gioco=new memoria();
	}
}