package main;

public class Temporizador extends Thread {
    
    public int duracion;
    public int contador;
    public int incremento;
    private TextoApp main;
    public boolean pausa;
    
    public Temporizador(TextoApp main, int duracion, int incremento) {
        super();
        this.duracion = duracion;
        this.incremento = incremento;
        contador = 0;
        this.main = main;
        this.pausa = false;
    }

    public void run() {
        while (true) {
            if (!pausa) {
                if (contador < duracion) {
                    contador += incremento;
                } else {
                    pausa = true;
                    main.stop();
                }
            }
            dormir(incremento);
        }
    }
    
    private void dormir(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
