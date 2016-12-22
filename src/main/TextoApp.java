package main;

import java.util.Vector;

import control.ControlTexto;

public class TextoApp {
	
	public static int MILLISECONDS = 1000;
	
	private ControlTexto control;
	private Vector<Object> hilos;
	private int duracion;
	private Temporizador temporizador;
	
	public TextoApp() {
		control = new ControlTexto(this);
		hilos = new Vector<Object>();
		duracion = 0;
	}
	
	public void prepare(int duracion, int  retraso, int numeroHilos, String texto,String tipo) {
		this.duracion = duracion;
		inicializarHilos(duracion, retraso, numeroHilos, texto, tipo);
		run();
	}
	
	public void run() {
		for (Object element : hilos) {
			startThread(element);
		}
		if (temporizador == null)
			temporizador = new Temporizador(this, duracion * MILLISECONDS, 1* MILLISECONDS);
		
		temporizador.pausa = false;
		temporizador.contador = 0;
		temporizador.duracion = this.duracion * MILLISECONDS;
		if (!temporizador.isAlive())
			temporizador.start();
	}
	
	public void stop() {
		for (Object element : hilos) {
			stopThread(element);
		}

		control.stop();
		sendText("-------------------------\n");
	}

	public static void main(String[] args) {		
		TextoApp main = new TextoApp();
		main.show();
	}
	
	public void show() {
		control.show();
	}
	
	public void newTextoThread(String texto, int numero, int retraso){
		TextoThread newThread = new TextoThread(this, texto, numero, retraso);
		hilos.addElement(newThread);
	}
	
	public void newTextoRunnable(String texto, int numero, int retraso){
		TextoRunnable newThread = new TextoRunnable(this, texto, numero, retraso);
		hilos.addElement(newThread);
	}
	
	public void startThread(Object thread){
		if (thread instanceof TextoThread) {
			TextoThread temp = (TextoThread)thread;
			temp.start();
		}
		if (thread instanceof TextoRunnable) {
		    new Thread((TextoRunnable)thread).start();
		}
	}
	
	public void stopThread(Object thread){
		if (thread instanceof TextoThread) {
			TextoThread temp = (TextoThread)thread;
			temp.terminar = true;
		}
		if (thread instanceof TextoRunnable) {
			TextoRunnable temp = (TextoRunnable)thread;
			temp.terminar = true;
		}
	}

	public void inicializarHilos (int duracion, int retraso, int numeroHilos, String texto, String tipo) {
		hilos.clear();
		if (tipo.equals("Thread")){
			for (int itr = 1; itr <= numeroHilos; itr++) {
				newTextoThread(texto, itr, retraso);
			}
		} else if (tipo.equals("Runnable")) {
			for (int itr = 1; itr <= numeroHilos; itr++) {
				newTextoRunnable(texto, itr, retraso);
			}			
		}
	}
	
	public void sendText(String text) {
		control.addText(text) ;
	}
}
