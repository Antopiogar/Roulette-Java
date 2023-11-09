package model;

import java.awt.Component;

import javax.swing.JLabel;

public class Totale {
	private double vinciteTot;
	private JLabel [] vincite = {
			new JLabel("TOTALE ="),
			new JLabel("")
		};
	
	public Totale() {
		vinciteTot=0;
		
	}
	public Totale(double vinciteTot, JLabel[] vincite) {
		this.vinciteTot = vinciteTot;
	}
	public void cambiaTot() {
		if(vinciteTot%1!=0)
			vincite[1].setText(Double.toString(vinciteTot));
		else
			vincite[1].setText("%d".formatted(Math.round(vinciteTot)));
	}
	public double getVinciteTot() {
		return vinciteTot;
	}
	public void setVinciteTot(double vinciteTot) {
		this.vinciteTot = vinciteTot;
	}
	public Component getLabel(int index) {
		return vincite[index];
	}
	
}
