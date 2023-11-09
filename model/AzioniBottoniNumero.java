package model;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;

public class AzioniBottoniNumero implements MouseInputListener {
	
	private int n;
	private JLabel scelto;
	private TrasferisciDati scelta;
	private JLabel bottone;
	private Border in;
	private Border out;
	private Border bordoPuntate = BorderFactory.createLineBorder(Color.BLACK);

	public AzioniBottoniNumero(int n, TrasferisciDati scelta, JLabel bottone,JLabel scelto) {
		this.n = n;
		this.scelto=scelto;
		this.scelta = scelta;
		this.bottone = bottone;
		in = BorderFactory.createLineBorder(new Color(0x00fff7),7);
		out = BorderFactory.createLineBorder(Color.WHITE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(scelta.isPuntataFatta()) {
			JOptionPane.showMessageDialog(null, "Hai gi� puntato","NON PUOI PIU' PUNTARE",0);
		}
		else {
		scelta.setA(n);
		System.out.println(scelta);
		cambiaSceltaLabel();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		bottone.setBorder(in);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(n<38)
			bottone.setBorder(out);
		else
			bottone.setBorder(bordoPuntate);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	private void cambiaSceltaLabel() {
		if(scelta.getA()<38)
	        scelto.setText("%s".formatted(scelta.getA()));
		else {
			int n= scelta.getA();
			System.out.println(n);
			switch(n) {
				case 40:{
					System.out.println("SCELTA prima riga");
					scelto.setText("Prima riga");
					break;
				}
				case 41:{
					System.out.println("SCELTA seconda riga");
					scelto.setText("Seconda riga");
					break;
				}
				case 42:{
					System.out.println("SCELTA terza riga");
					scelto.setText("Terza riga");
					break;
				}
				case 43:{
					System.out.println("SCELTA 1-12");
					scelto.setText("1-12");
					break;
				}
				case 44:{
					System.out.println("SCELTA 13-24");
					scelto.setText("13-24");
					break;
				}
				case 45:{
					System.out.println("SCELTA 25-36");
					scelto.setText("25-36");
					break;
				}
				case 46:{
					System.out.println("SCELTA 1-18");
					scelto.setText("1-18");
					break;
				}
				case 47:{
					System.out.println("SCELTA dispari");
					scelto.setText("Dispari");
					break;
				}
				case 48:{
					System.out.println("SCELTA rosso");
					scelto.setText("Rosso");
					break;
				}
				case 49:{
					System.out.println("SCELTA nero");
					scelto.setText("Nero");
					break;
				}
				case 50:{
					System.out.println("SCELTA pari");
					scelto.setText("Pari");
					break;
				}
				case 51:{
					System.out.println("SCELTA 19-36");
					scelto.setText("19-36");
					break;
				}
			}
			
		}
	}
}
