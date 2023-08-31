package pratofiorito;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pratofiorito {
	private JFrame finestra;
	private JLabel visualizza;
	private JButton bn;
	private final int dimensione_pulsanti=45,d_griglia=10; 
	private int i=0,j=0,ii=0,jj=0,punteggio=0;
	private JPanel p1,p2,p3;
	
	private class pulsanti extends JButton{
		int valore;
		pulsanti(){
			super(); }
	}

	pulsanti matrice[][]=new pulsanti[d_griglia][d_griglia];
	
	pratofiorito(){
		for(i=0;i<d_griglia;i++)
			for(j=0;j<d_griglia;j++)
				{matrice[i][j]=new pulsanti();
				 matrice[i][j].valore=0;
				 matrice[i][j].setPreferredSize(new Dimension(dimensione_pulsanti,dimensione_pulsanti));}
		
		JPanel p2=new JPanel();
		
		for(i=0;i<d_griglia;i++)
			for(j=0;j<d_griglia;j++)
				p2.add(matrice[i][j]);
		
		finestra=new JFrame();
		finestra.setTitle("Pratofiorito");
		finestra.setSize(1300,700);
		finestra.setLayout(new GridLayout(3,1));
		finestra.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windoEvent){
				System.exit(0);
			}
	    });
		
		for(i=0;i<d_griglia;i++)
			for(j=0;j<d_griglia;j++)
			{   double random=Math.random();
				if(random<0.22)
					matrice[i][j].valore=0;
				if((random>0.22)&&(random<0.5))
					matrice[i][j].valore=2;
				if((random>0.5)&&(random<1.0))
					matrice[i][j].valore=1; 
				//System.out.println(""+matrice[i][j].valore); 
				}
					
		//inserire il contatore delle partite effettuate
		
		for(i=0;i<d_griglia;i++)
			for(j=0;j<d_griglia;j++)
				{matrice[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							for(i=0;i<d_griglia;i++)
								for(j=0;j<d_griglia;j++)
									if(e.getSource()==matrice[i][j])
										{ii=i;
										jj=j;}
									if(matrice[ii][jj].valore==0)
										{ for(ii=0;ii<d_griglia;ii++)
											for(jj=0;jj<d_griglia;jj++)
												{matrice[ii][jj].setEnabled(false);
												 if(matrice[ii][jj].valore==0)
												   {matrice[ii][jj].setText("F");
												    matrice[ii][jj].setBackground(Color.RED);
												    if(punteggio<10) visualizza.setText("Sei scarso...punteggio="+punteggio); 
													if((punteggio<20)&&(punteggio>10)) visualizza.setText("Sei meno scarso dai...punteggio="+punteggio);
													if((punteggio<30)&&(punteggio>20))visualizza.setText("Beh solo fortuna...punteggio="+punteggio); 
													if((punteggio<40)&&(punteggio>30)) visualizza.setText("Ti pago una spina...punteggio="+punteggio); 
													if((punteggio<50)&&(punteggio>40))visualizza.setText("Lo chiamano l'immortale...punteggio="+punteggio); 
													if((punteggio<60)&&(punteggio>50)) visualizza.setText("Hai quasi vinto su'...punteggio="+punteggio);  
													if((punteggio<69)&&(punteggio>60)) visualizza.setText("Ci manca un pelo!!...punteggio="+punteggio); } 
												 
												 //dopo aver perso la partita per vedere anche il resto dei bottoni...ma senza togliere il colore a quelli azionati
												 /*if((matrice[ii][jj].valore==1)&&(matrice[ii][jj].getText()==null))
												 {matrice[ii][jj].setText("1");
												  matrice[ii][jj].setBackground(null);}
												 if((matrice[ii][jj].valore==2)&&(matrice[ii][jj].getText()==null))
												 {matrice[ii][jj].setText("2");
												  matrice[ii][jj].setBackground(null);}*/
												} 
										 }
									if(matrice[ii][jj].valore==1)
								   		 {matrice[ii][jj].setText("1");
										  punteggio++;
										  matrice[ii][jj].setBackground(Color.BLUE);
										  visualizza.setText("In gioco...punteggio="+punteggio);}
									if(matrice[ii][jj].valore==2)
										 {matrice[ii][jj].setText("2");
										  punteggio+=2;
										  matrice[ii][jj].setBackground(Color.GREEN);
										  visualizza.setText("In gioco...punteggio="+punteggio);}
									if(punteggio==69)
										visualizza.setText("Hai vinto!!!!");
							matrice[ii][jj].setEnabled(false);
					}
				}); 
				}
		
		visualizza=new JLabel();
		visualizza.setFont(new Font("Serif", Font.PLAIN, 20));
		visualizza.setText("In gioco...punteggio=0");
		visualizza.setForeground(Color.RED);
		
		bn=new JButton();
		bn.setText("Nuova partita");
		bn.setSize(50,50);
		bn.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e){	
				visualizza.setText("In gioco...punteggio=0");
				punteggio=0;
				for(i=0;i<d_griglia;i++)
					for(j=0;j<d_griglia;j++)
						{matrice[i][j].valore=0;
						 matrice[i][j].setText("");
						 matrice[i][j].setBackground(null);
						 matrice[i][j].setEnabled(true);}
				for(i=0;i<d_griglia;i++)
					for(j=0;j<d_griglia;j++)
					{   double random=Math.random();
						if(random<0.22)
							matrice[i][j].valore=0;
						if((random>0.22)&&(random<0.5))
							matrice[i][j].valore=2;
						if((random>0.5)&&(random<1.0))
							matrice[i][j].valore=1;
					}
			  }
			});
		
		p1=new JPanel();
		p3=new JPanel();
		
		p1.setSize(800,50);
		p2.setSize(800,500);
		p3.setSize(800,50);
		
		p1.add(bn);
		p3.add(visualizza);
		
		finestra.add(p1);
		finestra.add(p2);
		finestra.add(p3);
		
		finestra.setVisible(true);
	}
	
	public static void main(String[] args) {
			pratofiorito prova=new pratofiorito();
	}
}