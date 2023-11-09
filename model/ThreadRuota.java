package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class ThreadRuota implements Runnable {
	private JPanel frame;
	private JPanel panel;
	private ArrayList<Casella> ruota;
	private JLabel img;
	private ArrayList<ImageIcon> sfondi;
	private int numRandom;
	private Casella c;
	private ArrayList<Semaphore> s = new ArrayList<>();

	private void inizializza() {
		frame.setVisible(true);
		frame.add(panel);
		frame.add(img);
		frame.setName("Roulette");
		frame.setBackground(new Color(0xe2e2e2));
		posiziona();
	}

	private void posiziona() {
		frame.setBounds(100, 100, 235, 260);
	}

	@Override
	public void run() {
		inizializza();
		gira();
		setColoreVincente();
	}

	private void setColoreVincente() {
		c.setColore(ruota.get(numRandom-1).getColore());
	}

	public ThreadRuota(Casella c,JPanel frame) {
		ruota = new ArrayList<>();
		this.frame=frame;
		panel = new JPanel();
		img = new JLabel();
		sfondi = new ArrayList<>();
		this.c = c;
		numRandom = numero();
		inizializza();
		aggiungiCaselle();
		s.add(new Semaphore(1));
		s.add(new Semaphore(1));
	}

	public int numero() {
		Random r = new Random();
		int low =0 ;
		int high = 36;
		int ris = r.nextInt(high - low) + low;
		System.out.println("numero random=" + ris);
		return ris;
	}

	private int nGiri() {
		Random r = new Random();
		int low = 2;
		int high = 4;
		int ris = r.nextInt(high - low) + low;
		System.out.println("numero giri:" + ris);
		return ris;
	}

	private void setC() {
		System.out.println("Ris dovrebbe essere " + ruota.get(numRandom - 1).getNumero());
		c.setNumero(ruota.get(numRandom - 1).getNumero());
	}

	private void gira() {

		int g = nGiri();
		setC();
		ArrayList<Integer> limiti = new ArrayList<>();
		switch (g) {
		case 2 :{
			limiti.add(40);
			limiti.add(70);
		}
		case 3 :{
			limiti.add(80);
			limiti.add(110);
		}
		case 4 :{
			limiti.add(120);
			limiti.add(140);
		}
		}
		for (int i = 0, j = 0; i < 38 * g + numRandom + 1; i++, j++) {
			if (j == 38)
				j = 0;
			if (i <= limiti.get(0)) {
				// velocit� massima
				img.setIcon(sfondi.get(j));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i > limiti.get(0) && i < limiti.get(1)) {
				// velocit� media
				img.setIcon(sfondi.get(j));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else if (i >= limiti.get(1)) {
				// velocit� minima
				img.setIcon(sfondi.get(j));
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void aggiungiCaselle() {
		int[] numeri = { 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14,
				31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26 };
		boolean posNero = false;
		ruota.add(new Casella(0, "verde", "img/0.png"));
		sfondi.add(new ImageIcon(ruota.get(0).getImmagine()));
		for (int i = 0; i < 36; i++) {
			if (posNero) {
				ruota.add(new Casella(numeri[i], "nero", "img/" + i + ".png"));
				posNero = false;
			} else {
				ruota.add(new Casella(numeri[i], "rosso", "img/" + i + ".png"));
				posNero = true;
			}
			sfondi.add(new ImageIcon(ruota.get(i + 1).getImmagine()));
		}
		sfondi.add(new ImageIcon("img/36.png"));
	}

}
