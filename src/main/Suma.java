package main;

public class Suma extends Thread {
    public int valor;
    public boolean pausar;
    private Tanque tanque;
    
    public Suma(int valor, Tanque tanque, int number) {
        super();
        this.valor = valor;
        this.pausar = true;
        this.tanque = tanque;
    }

    public void run() {
        while (true) {
            if (!pausar)
                this.tanque.setActual(this.tanque.getActual() + this.valor);
            dormir(1000);
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
