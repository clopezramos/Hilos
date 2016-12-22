package main;

public class MultiplicacionMatrizThread extends Thread {
    private int[] fila;
    private int[][] matriz;
    private MatrizApp main;
    private int numero;
    public long tiempoTranscurrido;
    
    public MultiplicacionMatrizThread(MatrizApp main, int[] fila, int[][] matriz, int numero) {
        super();
        this.fila = fila;
        this.matriz = matriz;
        this.main = main;
        this.numero = numero;
        this.tiempoTranscurrido = 0;
    }

    public void run() {
        long startTime = System.nanoTime();
        int[] resultado = new int[fila.length];
        
        for (int itr = 0; itr < resultado.length; itr++) {
            for (int itr2 = 0; itr2 < fila.length; itr2++) {
                resultado[itr] += fila[itr2] * matriz[itr2][itr];
            }
        }

        tiempoTranscurrido = System.nanoTime() - startTime;
        main.sendResultado(resultado, this.numero);
    }

    public int getNumero() {
        return numero;
    }
}
