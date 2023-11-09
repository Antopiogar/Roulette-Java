package model;

public class TrasferisciDati {
	private int a;
	private boolean puntataFatta;

	public TrasferisciDati(int a) {
		this.a = a;
		puntataFatta=false;
	}

	public boolean isPuntataFatta() {
		return puntataFatta;
	}

	public void setPuntataFatta(boolean puntataFatta) {
		this.puntataFatta = puntataFatta;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return Integer.toString(a);
	}

	
}
