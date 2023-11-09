package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class Menu {
	private Casella c;
	private Totale tot;
	private Color colorato = new Color(0x00fff7);
	private JPanel pannelloSchermata;
	private JFrame frame = new JFrame();
	private JPanel pannello = new JPanel();
	private JLabel [] start = {new JLabel("Start"),new JLabel("Come giocare"),new JLabel("Crediti"),new JLabel("Esci"),new JLabel("")};
	private ImageIcon titolo = new ImageIcon("img/logo.png");
	private String spiegazione = "VERSIONE RIVISITATA DELLA ROULETTE EUROPEA";
	private Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
	
	
	public Menu(Casella c, JPanel pannelloSchermata, Totale t) {
		this.c = c;
		this.pannelloSchermata = pannelloSchermata;
		this.tot=t;
	}
	private void inizializza() {
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(pannello, BorderLayout.CENTER);
		frame.setTitle("Roulette");
		frame.setIconImage(new ImageIcon("img/logo60.png").getImage());
		for(int i = 0; i<start.length;i++) {
			frame.add(start[i]);
			start[i].setBorder(border);
			start[i].setHorizontalTextPosition(SwingConstants.CENTER);
			start[i].setBackground(Color.LIGHT_GRAY);
			start[i].setForeground(Color.LIGHT_GRAY);
		}
		start[4].setIcon(titolo);
		
		frame.setBounds(100,100,310,220);
		start[4].setBounds(0, 0, 300, 180);
		start[0].setBounds(210,100,90,20);
		start[1].setBounds(210,120,90,20);
		start[2].setBounds(210,140,90,20);
		start[3].setBounds(210,160,90,20);
	}
	public void visualizza() {
		inizializza();	
		start[0].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				start[0].setForeground(Color.LIGHT_GRAY);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				start[0].setForeground(colorato);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Tabellone t = new Tabellone(c, pannelloSchermata,tot);
				t.inizializza();
				frame.dispose();
			}
		});
		
		start[1].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, spiegazione);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {

				start[1].setForeground(Color.LIGHT_GRAY);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				start[1].setForeground(colorato);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		start[2].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				start[2].setForeground(Color.LIGHT_GRAY);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				start[2].setForeground(colorato);				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "Gruppo:ClickerTeam\nCapogruppo:Gargiulo Antonio Pio\nCopyright ClickerTeam");
			}
		});
		start[3].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {

				start[3].setForeground(Color.LIGHT_GRAY);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				start[3].setForeground(colorato);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
