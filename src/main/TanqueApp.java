package main;

import control.ControlTanque;

public class TanqueApp {

    private int cantidadInicial;
    private int capacidad;
    private Suma suma;
    private Suma resta;
    private Tanque tanque;
    private ControlTanque mainControl;
    
    public TanqueApp(int cantidadInicial, int capacidad) {
        this.cantidadInicial = cantidadInicial;
        this.capacidad = capacidad;
        inicializarTanque(this);
        inicializarControl(this);
        inicializarHilos();
    }
    
    public static void main(String[] args) {        
        TanqueApp main = new TanqueApp(12, 558);
        main.show();
    }
    
    public void show() {
        mainControl.show();
    }
    
    public void refresh(int value) {
        this.mainControl.refresh(value);
    }
    
    private void inicializarHilos() {
        if (suma == null)
            this.suma = new Suma(mainControl.getLlenado(), tanque, 1);
        if (resta == null)
            this.resta = new Suma(-mainControl.getVaciado(), tanque, 2);
        if (!suma.isAlive())
            suma.start();
        if (!resta.isAlive())
            resta.start();
    }
    
    private void inicializarTanque(TanqueApp main) {
        if (this.tanque == null)
            this.tanque = new Tanque(capacidad, cantidadInicial, main);
    }
    
    private void inicializarControl(TanqueApp main) {
        if (this.mainControl == null)
            this.mainControl = new ControlTanque(cantidadInicial, capacidad, main); 
    }
    
    public void startAll() {
        suma.pausar = false;
        resta.pausar = false;
        tanque.setCapacidad(mainControl.getCapacidad());
        suma.valor = mainControl.getLlenado();
        resta.valor = - mainControl.getVaciado();
    }
    
    public void stopAll() {
        suma.pausar = true;
        resta.pausar = true;
    }
    
    public void startSuma() {
        suma.pausar = false;
        tanque.setCapacidad(mainControl.getCapacidad());
        suma.valor = mainControl.getLlenado();
    }
    
    public void startResta() {
        resta.pausar = false;
        tanque.setCapacidad(mainControl.getCapacidad());
        resta.valor = - mainControl.getVaciado();
    }
    
    public void stopSuma() {
        suma.pausar = true;
    }
    
    public void stopResta() {
        resta.pausar = true;
    }
}