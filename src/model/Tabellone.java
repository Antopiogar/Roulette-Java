package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class Tabellone {
	private Totale tot;
	private Casella c;
	private Color verde = new Color(0x349d34);
	private Color sfondo = new Color(0x03747b);
	private double valPuntata;
	private ArrayList<Color> colori;
	private JFrame frame;
	private JPanel panel;
	private ArrayList<JLabel> bottoniNumero;	
	private ImageIcon logo;
	private Border bordo;
	private Border bordoNero;
	private Border bordoPuntate;
	private ArrayList<JLabel> bottoniPuntate;
	private Color pannelli = new Color(0xe2e2e2);
	private TrasferisciDati numScelto;
	private JPanel pannelloPuntata;
	private JSplitPane pane;
	private JPanel pannelloTabellone;
	private JPanel ruota;
	private JSplitPane destra;
	private JTextField inPuntata;
	private ArrayList<JLabel> nPuntato;
	private Border bordoDentro;
	private JLabel [] testo = {
			new JLabel("PUNTATA: "),
			new JLabel("PUNTA")
	};
	public void inizializza() {
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setTitle("Roulette");
		frame.setIconImage(logo.getImage());
		frame.add(pane);
		pannelloPuntata.setBackground(pannelli);
		ruota.setBackground(pannelli);
		pannelloTabellone.setBackground(sfondo);
		pane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  
        pane.setDividerLocation(250);                    
        destra.add(pannelloPuntata);
        destra.add(ruota);
        destra.setBottomComponent(ruota);
        destra.setTopComponent(pannelloPuntata);
        pannelloPuntata.setMinimumSize(new Dimension(180, 100));
        ruota.setMinimumSize(new Dimension(250, 225));
        ruota.setMaximumSize(new Dimension(300, 250));
        pane.setLeftComponent(pannelloTabellone);   
        pane.setRightComponent(destra);
		pane.setDividerLocation(1160);
		numScelto.setA(-1);
		pannelloTabellone.setLayout(null);
		pannelloTabellone.setBounds(0, 0, 1200, 500);
		pannelloTabellone.setMinimumSize(new Dimension(1160, 500));
		pannelloPuntata.setLayout(null);
		pannelloPuntata.setBounds(1180, 0, 300, 500);
		pannelloPuntata.setVisible(true);
		aggiungiBottoniNumero();
		aggiuntaElementiPuntata();
		posizionaElementiPuntata();
		aggiungiColori();
		aggiungiBottoniPuntate();
		posiziona();
		aggiuntaAzioniBottoneNumero();
		aggiuntaAzioniBottoniPuntata();
		impostaColori();
	}

	public Tabellone(Casella c, JPanel ruota, Totale tot) {
		this.tot = tot;
		nPuntato= new ArrayList<>();
		colori = new ArrayList<>();
		frame = new JFrame();
		panel = new JPanel();
		bottoniNumero = new ArrayList<>();
		logo = new ImageIcon("img/logo60.png");
		bordo = BorderFactory.createLineBorder(Color.WHITE);
		bordoNero = BorderFactory.createLineBorder(Color.BLACK);
		this.c = c;
		numScelto= new TrasferisciDati(-1);
		pannelloPuntata= new JPanel();
		bottoniPuntate= new ArrayList<>();
		pane = new JSplitPane();
		this.ruota=ruota;
		bordoPuntate = BorderFactory.createLineBorder(Color.BLACK);
		pannelloTabellone = new JPanel();
		destra = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		inPuntata = new JTextField("0");		
		bordoDentro = BorderFactory.createLineBorder(new Color(0x00fff7),3);
		nPuntato.add(new JLabel("SCELTA = "));
		nPuntato.add(new JLabel("NULLA"));
		nPuntato.add(new JLabel("TEMPO MANCANTE A RISULTATO= "));
		nPuntato.add(new JLabel("PUNTA PRIMA "));
	}
	
	
	private void aggiungiBottoniPuntate() {
		for (int i =0; i < 12;i++) {
			bottoniPuntate.add(new JLabel());
			bottoniPuntate.get(i).setOpaque(true);
			bottoniPuntate.get(i).setBorder(bordoPuntate);
			bottoniPuntate.get(i).setBackground(verde);
			bottoniPuntate.get(i).setBackground(Color.WHITE);
			bottoniPuntate.get(i).setForeground(Color.BLACK);
			bottoniPuntate.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			pannelloTabellone.add(bottoniPuntate.get(i));	
		}
		bottoniPuntate.get(0).setText("2:1");
		bottoniPuntate.get(1).setText("2:1");
		bottoniPuntate.get(2).setText("2:1");
		bottoniPuntate.get(3).setText("1-12");
		bottoniPuntate.get(4).setText("13-24");
		bottoniPuntate.get(5).setText("25-36");
		bottoniPuntate.get(6).setText("1-18");
		bottoniPuntate.get(7).setText("DISPARI");
		bottoniPuntate.get(8).setText("ROSSO");
		bottoniPuntate.get(9).setText("NERO");
		bottoniPuntate.get(10).setText("PARI");
		bottoniPuntate.get(11).setText("19-36");

		bottoniPuntate.get(8).setBackground(Color.RED);
		bottoniPuntate.get(9).setBackground(Color.black);
		bottoniPuntate.get(8).setForeground(Color.WHITE);
		bottoniPuntate.get(9).setForeground(Color.WHITE);
	}
	
	private void posizionaBottoniPuntate() {
		bottoniPuntate.get(0).setBounds(1060, 0, 60, 80);
		bottoniPuntate.get(1).setBounds(1060, 80, 60, 80);
		bottoniPuntate.get(2).setBounds(1060, 160, 60, 80);
		bottoniPuntate.get(3).setBounds(100, 240, 320, 60);
		bottoniPuntate.get(4).setBounds(420, 240, 320, 60);
		bottoniPuntate.get(5).setBounds(740, 240, 320, 60);
		bottoniPuntate.get(6).setBounds(100, 300, 160, 60);
		bottoniPuntate.get(7).setBounds(260, 300, 160, 60);
		bottoniPuntate.get(8).setBounds(420, 300, 160, 60);
		bottoniPuntate.get(9).setBounds(580, 300, 160, 60);
		bottoniPuntate.get(10).setBounds(740, 300, 160, 60);
		bottoniPuntate.get(11).setBounds(900, 300, 160, 60);
	}
	
	private void aggiungiColori() {
		colori.add(verde);
		//riga 1
		colori.add(Color.RED);
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		//riga 2
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		colori.add(Color.BLACK);
		//riga 3
		colori.add(Color.RED);
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		//riga 4
		colori.add(Color.BLACK);
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		//riga 5
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		colori.add(Color.BLACK);
		//riga 6
		colori.add(Color.RED);
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		//riga 7
		colori.add(Color.RED);
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		//riga 8
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		colori.add(Color.BLACK);
		//riga 9
		colori.add(Color.RED);
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		//riga 10
		colori.add(Color.BLACK);
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		//riga 11
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		colori.add(Color.BLACK);
		//riga 12
		colori.add(Color.RED);
		colori.add(Color.BLACK);
		colori.add(Color.RED);
		System.out.println("Nnumeri"+bottoniNumero.size());
		System.out.println("NColori= "+colori.size());
	}
	private void impostaColori() {
		for(int i = 0; i<colori.size();i++) {
			bottoniNumero.get(i).setOpaque(true);
			bottoniNumero.get(i).setBackground(colori.get(i));
			bottoniNumero.get(i).setHorizontalAlignment(SwingConstants.CENTER);
		}
		bottoniNumero.get(0).setForeground(Color.BLACK);
	}
	private void aggiungiBottoniNumero() {
		for (int i = 0; i < 37; i++) {
			bottoniNumero.add(new JLabel());
			bottoniNumero.get(i).setBorder(bordo);
			bottoniNumero.get(i).setText(Integer.toString(i));
			bottoniNumero.get(i).setForeground(Color.WHITE);
		}
	}

	private void posiziona() {
		frame.setBounds(0, 0, 1850, 500);
		posizionaBottoniNumero();
		posizionaBottoniPuntate();
	}

	private void posizionaBottoniNumero() {
		JButton b = new JButton();
		int lato = 75;
		pannelloTabellone.add(b);
		for (int i = 0; i < 38; i++) {
			bottoniNumero.add(new JLabel(""));
			pannelloTabellone.add(bottoniNumero.get(i));
		}
		bottoniNumero.get(0).setBounds(0,0,100,240);
		//riga 1
		bottoniNumero.get(1).setBounds(100,160,lato,lato);
		bottoniNumero.get(2).setBounds(100,80,lato,lato);
		bottoniNumero.get(3).setBounds(100,0,lato,lato);
		//riga 2
		bottoniNumero.get(4).setBounds(180,160,lato,lato);
		bottoniNumero.get(5).setBounds(180, 80, lato, lato);
		bottoniNumero.get(6).setBounds(180,0,lato,lato);
		//riga 3
		bottoniNumero.get(7).setBounds(260,160,lato,lato);
		bottoniNumero.get(8).setBounds(260, 80, lato, lato);
		bottoniNumero.get(9).setBounds(260,0,lato,lato);
		//riga 4
		bottoniNumero.get(10).setBounds(340,160,lato,lato);
		bottoniNumero.get(11).setBounds(340, 80, lato, lato);
		bottoniNumero.get(12).setBounds(340,0,lato,lato);
		//riga 5
		bottoniNumero.get(13).setBounds(420,160,lato,lato);
		bottoniNumero.get(14).setBounds(420, 80, lato, lato);
		bottoniNumero.get(15).setBounds(420,0,lato,lato);
		//riga 6
		bottoniNumero.get(16).setBounds(500,160,lato,lato);
		bottoniNumero.get(17).setBounds(500, 80, lato, lato);
		bottoniNumero.get(18).setBounds(500,0,lato,lato);
		//riga 7
		bottoniNumero.get(19).setBounds(580,160,lato,lato);
		bottoniNumero.get(20).setBounds(580, 80, lato, lato);
		bottoniNumero.get(21).setBounds(580,0,lato,lato);
		//riga 8
		bottoniNumero.get(22).setBounds(660,160,lato,lato);
		bottoniNumero.get(23).setBounds(660, 80, lato, lato);
		bottoniNumero.get(24).setBounds(660,0,lato,lato);
		//riga 9
		bottoniNumero.get(25).setBounds(740,160,lato,lato);
		bottoniNumero.get(26).setBounds(740, 80, lato, lato);
		bottoniNumero.get(27).setBounds(740,0,lato,lato);
		//riga 10
		bottoniNumero.get(28).setBounds(820,160,lato,lato);
		bottoniNumero.get(29).setBounds(820, 80, lato, lato);
		bottoniNumero.get(30).setBounds(820,0,lato,lato);
		//riga 11
		bottoniNumero.get(31).setBounds(900,160,lato,lato);
		bottoniNumero.get(32).setBounds(900, 80, lato, lato);
		bottoniNumero.get(33).setBounds(900,0,lato,lato);
		//riga 12
		bottoniNumero.get(34).setBounds(980,160,lato,lato);
		bottoniNumero.get(35).setBounds(980, 80, lato, lato);
		bottoniNumero.get(36).setBounds(980,0,lato,lato);
	}
	private void aggiuntaAzioniBottoneNumero() {
		for(int i=0;i<bottoniNumero.size();i++) {
			bottoniNumero.get(i).addMouseListener(new AzioniBottoniNumero(i,numScelto,bottoniNumero.get(i),nPuntato.get(1)));
		}
		bottoniNumero.get(37).setVisible(false);
	}
	private void aggiuntaElementiPuntata() {
		for(JLabel l:testo) {
			pannelloPuntata.add(l);
		}
		
		pannelloPuntata.add(inPuntata);
		testo[1].setBorder(bordoNero);
		pannelloPuntata.add(tot.getLabel(0));
		pannelloPuntata.add(tot.getLabel(1));
		tot.cambiaTot();
	}
	private void posizionaElementiPuntata() {
		for(JLabel l: nPuntato) {
			pannelloPuntata.add(l);
		}
		testo[0].setBounds(10, 10, 70, 20);
		testo[1].setBounds(175, 10, 50, 20);
		inPuntata.setBounds(80, 10, 80, 20);
		inPuntata.setHorizontalAlignment(SwingConstants.CENTER);
		testo[1].setHorizontalAlignment(SwingConstants.CENTER);
		nPuntato.get(0).setBounds(10,55,70,20);
		nPuntato.get(1).setBounds(85, 55, 90, 20);
		nPuntato.get(2).setBounds(10,80,220,20);
		nPuntato.get(3).setBounds(225, 80, 200, 20);
		tot.getLabel(0).setBounds(10,30,70,20);
		tot.getLabel(1).setBounds(85,30,70,20);
	}
	private void aggiuntaAzioniBottoniPuntata() {
		for(int i=0;i<bottoniPuntate.size();i++) {
			bottoniPuntate.get(i).addMouseListener(new AzioniBottoniNumero(i+40,numScelto,bottoniPuntate.get(i),nPuntato.get(1)));
		}
		inPuntata.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					  punta();
				  } 
			}
		});
		testo[1].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				punta();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				testo[1].setBorder(bordoNero);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				testo[1].setBorder(bordoDentro);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void punta() {
		String num;
		boolean pValida = true;
		try {
			num=inPuntata.getText();
			num=inPuntata.getText();
			valPuntata=Double.parseDouble(num);
			System.out.println("PUNTATA=" + numScelto);
			if(valPuntata<=0) 
				pValida=false;
			if(numScelto.getA()==-1)
				pValida=false;
		} catch (Exception e) {
			pValida=false;
		}
		if(pValida) {
			
			inPuntata.setEnabled(false);
			inPuntata.setDisabledTextColor(Color.LIGHT_GRAY);
			Thread piatto = new Thread(new ThreadRuota(c,panel));
			numScelto.setPuntataFatta(true);
			impostaNumScelto();
	        ruota.add(panel);
	        destra.setBottomComponent(ruota);
	        ruota.setBackground(pannelli);
			piatto.start();
			Thread ris = new Thread(new ThreadControllo(c, numScelto, valPuntata,nPuntato.get(3),frame,tot));
			ris.start();
		}
		else {
			inPuntata.setText("");
			JOptionPane.showMessageDialog(frame, "PUNTATA NON VALIDA");

		}
		
	}

	private void impostaNumScelto() {
		if(numScelto.getA()<38)
	        nPuntato.get(1).setText("%s".formatted(numScelto.getA()));
		else {
			int n= numScelto.getA();
			System.out.println(n);
			switch(n) {
				case 40:{
					System.out.println("SCELTA prima riga");
					nPuntato.get(1).setText("Prima riga");
					break;
				}
				case 41:{
					System.out.println("SCELTA seconda riga");
					nPuntato.get(1).setText("Seconda riga");
					break;
				}
				case 42:{
					System.out.println("SCELTA terza riga");
					nPuntato.get(1).setText("Terza riga");
					break;
				}
				case 43:{
					System.out.println("SCELTA 1-12");
					nPuntato.get(1).setText("1-12");
					break;
				}
				case 44:{
					System.out.println("SCELTA 13-24");
					nPuntato.get(1).setText("13-24");
					break;
				}
				case 45:{
					System.out.println("SCELTA 25-36");
					nPuntato.get(1).setText("25-36");
					break;
				}
				case 46:{
					System.out.println("SCELTA 1-18");
					nPuntato.get(1).setText("1-18");
					break;
				}
				case 47:{
					System.out.println("SCELTA dispari");
					nPuntato.get(1).setText("Dispari");
					break;
				}
				case 48:{
					System.out.println("SCELTA rosso");
					nPuntato.get(1).setText("Rosso");
					break;
				}
				case 49:{
					System.out.println("SCELTA nero");
					nPuntato.get(1).setText("Nero");
					break;
				}
				case 50:{
					System.out.println("SCELTA pari");
					nPuntato.get(1).setText("Pari");
					break;
				}
				case 51:{
					System.out.println("SCELTA 19-36");
					nPuntato.get(1).setText("19-36");
					break;
				}
			}
		}
	}
	
	
}
