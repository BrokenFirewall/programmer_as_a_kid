package calcolatrice;

import java.awt.*;
import java.awt.event.*;


public class calcolatrice {
	private Frame finestra;
	private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bcanc,badd,bsub,bmul,bdiv,buguale,bp,bpm;
	private Label visualizzazione;
	private Panel p79,p46,p13,p0,pp;
	private int op=0,x=0;
	private double val_att=0,risultato_prec=0,peso=0.1;
	private String vis="";
	private boolean punto=false;
	
	private void operazione(String visualizza) 
	{ double tasto=Double.parseDouble(visualizza);
      if(punto==false)
	    {if(val_att==0)
		{  val_att=tasto;
		   vis=visualizza;}
		else 
		{  val_att=val_att*10+tasto;	
		   vis+=visualizza; }
	}
	else
		{ val_att=val_att+tasto*peso;
		  vis+=visualizza;
		  peso=peso/10;
		};
	visualizzazione.setText(vis);
	}
	
	
	
	calcolatrice(){
		finestra=new Frame("Calcolatrice");
		finestra.setSize(200,250);
		finestra.setLayout(new GridLayout(6,1));
		finestra.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windoEvent){
				System.exit(0);
			};
	});
		
	b0=new Button("0");
	b1=new Button("1");
	b2=new Button("2");
	b3=new Button("3");
	b4=new Button("4");
	b5=new Button("5");
	b6=new Button("6");
	b7=new Button("7");
	b8=new Button("8");
	b9=new Button("9");
	bcanc=new Button("C");
	badd=new Button("+");
	bsub=new Button("-");
	bmul=new Button("x");
	bdiv=new Button(":");
	buguale=new Button("=");
	bp=new Button(".");
	bpm=new Button("+/-");
	
	b1.setPreferredSize(new Dimension(30,30));
	b2.setPreferredSize(new Dimension(30,30));
	b3.setPreferredSize(new Dimension(30,30));
	b4.setPreferredSize(new Dimension(30,30));
	b5.setPreferredSize(new Dimension(30,30));
	b6.setPreferredSize(new Dimension(30,30));
	b7.setPreferredSize(new Dimension(30,30));
	b8.setPreferredSize(new Dimension(30,30));
	b9.setPreferredSize(new Dimension(30,30));
	b0.setPreferredSize(new Dimension(30,30));
	badd.setPreferredSize(new Dimension(30,30));
	bcanc.setPreferredSize(new Dimension(30,30));
	bsub.setPreferredSize(new Dimension(30,30));
	bmul.setPreferredSize(new Dimension(30,30));
	bdiv.setPreferredSize(new Dimension(30,30));
	bp.setPreferredSize(new Dimension(30,30));
	buguale.setPreferredSize(new Dimension(30,30));
	bpm.setPreferredSize(new Dimension(30,30));
	
	bp.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    	
		if(punto==false)
		  punto=true;
		  vis=vis+".";
		  visualizzazione.setText(vis);
		 }
	});
	    
	b1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    visualizzazione.setText("1"); 
	    operazione("1"); }	
	    });
	
	b2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("2"); 
		operazione("2");}
	}); 
	
	b3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("3"); 
		operazione("3");}
	}); 
	
	b4.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("4"); 
		operazione("4");}
	});
	
	b5.addActionListener(new ActionListener() {		
		public void actionPerformed(ActionEvent e){
		visualizzazione.setText("5");
		operazione("5");}
	});
	
	b6.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("6"); 
		operazione("6");}
	}); 
	
	b7.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("7"); 
		operazione("7");}
	}); 
	
	b8.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("8"); 
		operazione("8");}
	}); 
	
	b9.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("9"); 
		operazione("9");}
	}); 
	
	b0.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("0"); 
		operazione("0");}
	}); 
	
	badd.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("");
		risultato_prec=val_att;
		val_att=0;
		op=1;
		punto=false;
		vis=""; }
	}); 
	
	bsub.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText(""); 
		risultato_prec=val_att;
		val_att=0;
	    op=2;
	    punto=false;
	    vis=""; }
	}); 
	
	bdiv.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText(""); 
		risultato_prec=val_att;
		val_att=0;
	    op=4;
	    punto=false;
	    vis="";}
	}); 
	
	bmul.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("");
		risultato_prec=val_att;
		val_att=0;
	    op=3; 
	    punto=false;
	    vis="";}
	}); 
	
	bcanc.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("0"); 
		val_att=0;
		risultato_prec=0; 
		visualizzazione.setText("");
		punto=false;
		vis="";
		}
	}); 
	
	bpm.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		visualizzazione.setText("0");
		risultato_prec=val_att;
		val_att=risultato_prec*(-1); 
		visualizzazione.setText("-"+risultato_prec);
		punto=false;
		vis="";
		}
	}); 
	
	buguale.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	    punto=false;
	    	switch(op){
	    	case 1: risultato_prec+=val_att; break;
	    	case 2: risultato_prec-=val_att; break;
	    	case 3: risultato_prec*=val_att; break;
	    	case 4: risultato_prec/=val_att; break;
	    	}
	    visualizzazione.setText(""+risultato_prec);
	    
	    }
	}); 
	
	pp=new Panel();
	p79=new Panel();
	p46=new Panel();
	p13=new Panel();
	p0=new Panel();
	
	pp.add(bp);
	pp.add(bpm);
			
	p79.add(b7);
	p79.add(b8);
	p79.add(b9);
	p79.add(bdiv);
	
	p46.add(b4);
	p46.add(b5);
	p46.add(b6);
	p46.add(bmul);
	
	p13.add(b1);
	p13.add(b2);
	p13.add(b3);
	p13.add(bsub);
	
	p0.add(b0);
	p0.add(bcanc);
	p0.add(buguale);
	p0.add(badd);
	
	visualizzazione=new Label();
	visualizzazione.setText("0");
	visualizzazione.setAlignment(Label.CENTER);
	visualizzazione.setSize(10,30);
	visualizzazione.setBackground(Color.WHITE);
	
	finestra.add(visualizzazione);
	finestra.add(p79);
	finestra.add(p46);
	finestra.add(p13);
	finestra.add(p0);
	finestra.add(pp);
	
	finestra.setVisible(true);
	};
	
public static void main(String[] args) {
		calcolatrice provaCalcolatrice=new calcolatrice();
	}
}