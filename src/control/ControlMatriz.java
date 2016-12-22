package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import main.MatrizApp;
import view.MatrizWindow;
import view.TextoWindow;

public class ControlMatriz implements ActionListener {
	
	private MatrizApp main;
	private MatrizWindow window;
	
	public ControlMatriz(MatrizApp main) {
		this.main = main;
		this.window = new MatrizWindow(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		int action = this.window.getAction(source);
		if (action == TextoWindow.actionOne) {
			main.prepare();
		}
	}

	public void show() {
		window.setVisible(true);
	}
	
	public int[][] getMatriz(int r0c0, int r0c1, int r0c2,
						     int r1c0, int r1c1, int r1c2,
						     int r2c0, int r2c1, int r2c2) {
		int matriz[][] = new int[3][3];
		matriz[0][0] = r0c0;
		matriz[0][1] = r0c1;
		matriz[0][2] = r0c2;
		matriz[1][0] = r1c0;
		matriz[1][1] = r1c1;
		matriz[1][2] = r1c2;
		matriz[2][0] = r2c0;
		matriz[2][1] = r2c1;
		matriz[2][2] = r2c2;
		
		return matriz;
	}
	
	public Vector<int[][]> getMatrices() {
		Vector<int[][]> matrices = new Vector<int[][]>();
		matrices.addElement(getMatriz(this.window.getA1m1_field(), this.window.getB1m1_field(), this.window.getC1m1_field(),
									  this.window.getA2m1_field(), this.window.getB2m1_field(), this.window.getC2m1_field(),
									  this.window.getA3m1_field(), this.window.getB3m1_field(), this.window.getC3m1_field()));
	
		matrices.addElement(getMatriz(this.window.getA1m2_field(), this.window.getB1m2_field(), this.window.getC1m2_field(), 
									  this.window.getA1m2_field(), this.window.getB2m2_field(), this.window.getC2m2_field(),
									  this.window.getA3m2_field(), this.window.getB3m2_field(), this.window.getC3m2_field()));
		
		return matrices;
	}
	
	public void addTextTiempoSecuencial(String text) {
		this.window.addTextTiempoSecuencial(text);
	}
	
	public void addTextTiempoConcurrente(String text) {
		this.window.addTextTiempoConcurrente(text);
	}
	
	public void addTextSecuencial(String text) {
		this.window.addTextSecuencial(text);
	}
	
	public void addTextConcurrente(String text) {
		this.window.addTextConcurrente(text);
	}

}
