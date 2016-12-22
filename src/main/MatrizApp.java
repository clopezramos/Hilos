package main;

import java.util.Collections;
import java.util.Vector;

import control.ControlMatriz;

public class MatrizApp {
	
	private ControlMatriz control;
	private MultiplicacionMatrizSecuencial secuencial;
	private Vector<MultiplicacionMatrizThread> threads;
	private Vector<ResultadoThread> threadText;
	private long tiempoSecuencial;
	private long tiempoConcurrente;
	
	public class ResultadoThread implements Comparable<ResultadoThread>  {
		public int numero;
		public int[] resultado;
		
		public ResultadoThread(int numero, int[] resultado) {
			this.numero = numero;
			this.resultado = resultado;
		}

		public int compareTo(ResultadoThread element) {	
			return Integer.compare(this.numero, element.numero);
		}
	}
			
	public MatrizApp() {
		control = new ControlMatriz(this);
		secuencial = new MultiplicacionMatrizSecuencial();
		threads = new Vector<MultiplicacionMatrizThread>();
		threadText = new Vector<ResultadoThread>();
		tiempoSecuencial = 0;
		tiempoConcurrente = 0;
	}

	public static void main(String[] args) {		
		MatrizApp main = new MatrizApp();
		main.show();
	}
	
	public void show() {
		control.show();	
	}
	
	public void inicializarThreads(Vector<int[][]> matrices) {
		int[][] matriz1 = matrices.elementAt(0);
		int[][] matriz2 = matrices.elementAt(1);
		for (int itr = 0; itr < matriz1.length; itr++) {
			newMatrizThread(matriz1[itr], matriz2, itr);			
		}
	}
	
	public void newMatrizThread(int[] fila, int[][] matriz, int numero){
		MultiplicacionMatrizThread newThread = new MultiplicacionMatrizThread(this, fila, matriz, numero);
		threads.addElement(newThread);
	}
	
	public void prepare() {
		tiempoConcurrente = 0;
		threads.clear();
		threadText.clear();
		Vector<int[][]> matrices = control.getMatrices();
		secuencial.setMatricesCuadradas(matrices);
		inicializarThreads(matrices);
		run();
	}
	
	public void run() {
		startThreads();
		int[][] resultadoSecuencial = secuencial.MultiplicacionMatricesCuadradas();
		tiempoSecuencial = secuencial.tiempoTranscurrido;
		
		control.addTextSecuencial(matrizToString(resultadoSecuencial));
		control.addTextTiempoSecuencial(Long.toString(tiempoSecuencial));
	}
	
	public void startThreads(){
		for (MultiplicacionMatrizThread thread : threads) {
			thread.start();
		}
	}
	
	public String matrizToString(int[][] matriz) {
		String resultado = "";
		for (int itr = 0; itr < matriz.length; itr++) {
			for (int itr2 = 0; itr2 < matriz[itr].length; itr2++) {
				resultado += "      " + matriz[itr][itr2];
			}
			resultado += "\n";
		}
		return resultado + "\n";
	}
	
	public String filaToString(int[] fila) {
		String resultado = "";
		for (int itr = 0; itr < fila.length; itr++) {
			resultado +=  "      " + fila[itr];
		}
		return resultado + "\n";
	}
	
	public void sendResultado(int[] resultado, int numero) {
		threadText.addElement(new ResultadoThread(numero, resultado));
		if (threadText.size() == threads.size()) {
			Collections.sort(threadText);
			for (MultiplicacionMatrizThread thread : threads) {
				tiempoConcurrente += thread.tiempoTranscurrido;
			}
			for (ResultadoThread temp : threadText){
				control.addTextConcurrente(filaToString(temp.resultado));				
			}
			control.addTextConcurrente("\n");
			control.addTextTiempoConcurrente(Long.toString(tiempoConcurrente));
			
		}
	}
}
