package main;

public class TextoThread extends Thread {
    public String texto;
    public int numeroHilo;
    public boolean terminar;
    public int retraso;
    private TextoApp main;
    
    public TextoThread(TextoApp main, String string, int number, int retraso) {
        super();
        this.main = main;
        texto = string;
        numeroHilo = number;
        this.retraso = retraso;
        terminar = false;
    }
    
    public void run() {
        while (!terminar) {
            main.sendText(texto + numeroHilo + "\n");
            dormir(retraso * numeroHilo * 1000);
        }
    }

    private void dormir(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
