package model;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ThreadControllo implements Runnable {
	private Casella cVincente;
	private JLabel tempo;
	private TrasferisciDati f;
	private double valPuntato;
	private JFrame frame;
	private double r;
	private Totale t;
	private int [] primaFila= {
			3,6,9,12,15,18,21,24,27,30,33,36
	};
	private int [] secondaFila= {
			2,5,8,11,14,17,20,23,26,29,32,35
	};
	private int [] terzaFila= {
			1,4,7,10,13,16,19,22,25,28,31,34
	};
	
	public ThreadControllo(Casella cVincente, TrasferisciDati f, double valPuntato,JLabel tempo, JFrame frame,Totale t) {
		this.t=t;
		this.cVincente = cVincente;
		this.tempo = tempo;
		this.f = f;
		this.valPuntato = valPuntato;
		this.frame = frame;
		this.r=t.getVinciteTot();
	}
	private boolean isInPrimaFila() {
		for (int n:primaFila)
			if(n==cVincente.getNumero())
				return true;
		return false;
	}
	private boolean isInSecondaFila() {
		for (int n:secondaFila)
			if(n==cVincente.getNumero())
				return true;
		return false;
	}
	private boolean isInTerzaFila() {
		for (int n:terzaFila)
			if(n==cVincente.getNumero())
				return true;
		return false;
	}
	private boolean isRosso() {
		if(cVincente.getColore().trim().equals("rosso"))
			return true;
		return false;
	}
	private boolean isNero() {
		if(cVincente.getColore().trim().equals("nero"))
			return true;
		return false;
	}
	private boolean isNumber() {
		return f.getA()<38 ?true : false;
	}
	private boolean isInteger(double a) {
		if (a % 1 == 0){
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public void run() {
		System.out.println("THREAD CONTROLLO INIZIATO");
		for(int i =15;i>1;i--) {
			try {
				System.out.println("Risultato tra "+ i +" secondi");
				tempo.setText(i+" Secondi");
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		System.out.println("Risultato tra 1 secondo");
		tempo.setText("1 secondo");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		if(isNumber()) {
			if(f.getA() == cVincente.getNumero()) {
				r+=valPuntato*36;
				if(isInteger(r)) 
					JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
				else
					JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*2,"RISULTATO",1);
			}
			else {
				r-=valPuntato;
				JOptionPane.showMessageDialog(null, "HAI PERSO","RISULTATO",0);
			}
		}else {
			switch (f.getA()) {
				case 40:{
					if(isInPrimaFila()) {
						r+=valPuntato*3;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*3,"RISULTATO",1);
					}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "HAI PERSO","RISULTATO",0);
					}
					break;
				}	
				case 41:{
					if(isInSecondaFila()) {
						r+=valPuntato*3;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*3,"RISULTATO",1);
						}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "HAI PERSO","RISULTATO",0);
					}
					break;
				}
				case 42:{
					if(isInTerzaFila()) {
						r+=valPuntato*3;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*3,"RISULTATO",1);
					}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "HAI PERSO","RISULTATO",0);
					}
					break;
				}
				case 43:{
					if(cVincente.getNumero()>=1 && cVincente.getNumero()<=12) {
						r+=valPuntato*3;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*3,"RISULTATO",1);
						}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "Hai perso","RISULTATO",0);
						}
					break;
				}
				case 44:{
					if(cVincente.getNumero()>=13 && cVincente.getNumero()<=24) {
						r+=valPuntato*3;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*3,"RISULTATO",1);
						}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "Hai perso","RISULTATO",0);
						}
					break;
				}
				case 45:{
					if(cVincente.getNumero()>=25 && cVincente.getNumero()<=36) {
						r+=valPuntato*3;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*3,"RISULTATO",1);
						}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "Hai perso","RISULTATO",0);
						}
					break;
				}
				case 46:{
					if(cVincente.getNumero()>=1 && cVincente.getNumero()<=18) {
						r+=valPuntato*2;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*2,"RISULTATO",1);
						}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "Hai perso","RISULTATO",0);
						}
					break;
				}
				case 47:{
					if(cVincente.getNumero()%2==1) {
						r+=valPuntato*2;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*2,"RISULTATO",1);
						}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "Hai perso","RISULTATO",0);
						}
				}
				case 48:{
					if(isRosso()) {
						r+=valPuntato*2;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*2,"RISULTATO",1);
						}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "Hai perso","RISULTATO",0);
					}
					break;
				}
				case 49:{
					if(isNero()) {
						r+=valPuntato*2;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*2,"RISULTATO",1);
						}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "Hai perso","RISULTATO",0);
					}
					break;
				}
				case 50:{
					if(cVincente.getNumero()%2==0) {
						r+=valPuntato*2;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*2,"RISULTATO",1);
						}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "Hai perso","RISULTATO",0);
					}
					break;
				}
				case 51:{
					if(cVincente.getNumero()>=19 && cVincente.getNumero()<=36) {
						r+=valPuntato*2;
						if(isInteger(r)) 
							JOptionPane.showMessageDialog(null, "Hai vinto "+ Math.round(r),"RISULTATO",1);
						else
							JOptionPane.showMessageDialog(null, "Hai vinto "+valPuntato*2,"RISULTATO",1);
											
					}
					else {
						r-=valPuntato;
						JOptionPane.showMessageDialog(null, "Hai perso","RISULTATO",0);
					}
				break;
				}
			}
			
		}
		//fine switchcase
		vuoiRiavviare();
	}
	private void vuoiRiavviare() {
		int a= JOptionPane.showConfirmDialog(null, "Vuoi rigiocare");
		if(a==JOptionPane.YES_OPTION) {
			Tabellone fanculo = new Tabellone(new Casella(), new JPanel(),t);
			frame.dispose();
			t.setVinciteTot(r);
			fanculo.inizializza();
		}
		else {
			System.exit(0);
		}
	}
}
