package main;

public class TextoRunnable implements Runnable {

	public String texto;
	public int numeroHilo;
	public boolean terminar;
	public int retraso;
	private TextoApp main;
	
	public TextoRunnable(TextoApp main, String string, int number, int retraso) {
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
