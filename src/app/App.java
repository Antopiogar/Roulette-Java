package app;

import java.net.MalformedURLException;

import javax.swing.JPanel;

import model.Casella;
import model.Menu;
import model.Totale;

public class App {

	public static void main(String[] args) throws MalformedURLException {

		Casella c = new Casella();
		JPanel panel = new JPanel();
		Totale t = new Totale();
		Menu m = new Menu(c, panel,t);
		m.visualizza();
		}
}
