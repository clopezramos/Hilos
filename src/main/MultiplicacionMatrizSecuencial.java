package main;

import java.util.Vector;

public class MultiplicacionMatrizSecuencial {
	private Vector<int[][]> matrices;
	public long tiempoTranscurrido;

	public MultiplicacionMatrizSecuencial() {
		tiempoTranscurrido = 0;
	}

	public void setMatricesCuadradas(Vector<int[][]> matrices) {
		this.matrices = matrices;
	}

	public int[][] MultiplicacionMatricesCuadradas() {
		long startTime = System.nanoTime();
		int suma = 0;
		int A[][] = matrices.elementAt(0);
		int B[][] = matrices.elementAt(1);
		int result[][] = new int[A.length][B.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				suma = 0;
				for (int k = 0; k < B.length; k++) {
					suma += A[i][k] * B[k][j];
				}
				result[i][j] = suma;
			}
		}
		tiempoTranscurrido = System.nanoTime() - startTime;
		return result;
	}
}
