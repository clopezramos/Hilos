package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import control.ControlTanque;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

public class TanqueWindow extends JFrame {
    
    public static int actionOne = 1;
    public static int actionTwo = 2;
    public static int actionThree = 3;
    public static int actionFour = 4;
    public static int actionFive = 5;
    public static int actionSix = 6;
    
    private static final long serialVersionUID = 3172688540921699213L;
    private ControlTanque control;
    
    private JButton iniciar;
    private JButton llenar;
    private JButton vaciar;    
    private JPanel panel;
    private JProgressBar progreso;
    private JSpinner spinnerLlenar;
    private JSpinner spinnerVaciar;
    private JLabel labelCapacidad;
    private JSpinner spinnerCapacidad;

    public TanqueWindow(int inicial, int maximo, ControlTanque mainControl) {
        this.control = mainControl;
        this.setTitle("Tanque App");
        this.setSize(380, 199);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.panel = new JPanel();
        this.panel.setLayout(null);
        
        this.iniciar = new JButton("Iniciar");
        iniciar.setBounds(20, 94, 88, 30);
        this.iniciar.addActionListener(this.control);
        
        this.panel.add(iniciar);
        
        this.progreso = new JProgressBar(0, maximo);
        progreso.setBounds(20, 27, 248, 30);
        this.progreso.setValue(inicial);
        this.progreso.setStringPainted(true);
        this.panel.add(progreso);

        this.llenar = new JButton("Activar llenado");
        llenar.setBounds(205, 118, 150, 23);
        this.llenar.addActionListener(this.control);
        this.vaciar = new JButton("Activar vaciado");
        vaciar.setBounds(205, 78, 150, 23);
        this.vaciar.addActionListener(this.control);
        this.panel.add(this.llenar);
        this.panel.add(this.vaciar);
        
        spinnerLlenar = new JSpinner();
        spinnerLlenar.setBounds(133, 120, 51, 20);
        panel.add(spinnerLlenar);
        
        spinnerVaciar = new JSpinner();
        spinnerVaciar.setBounds(133, 80, 51, 20);
        panel.add(spinnerVaciar);
        
        labelCapacidad = new JLabel("Capacidad");
        labelCapacidad.setBounds(301, 11, 73, 14);
        panel.add(labelCapacidad);
        
        spinnerCapacidad = new JSpinner();
        spinnerCapacidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        spinnerCapacidad.setBounds(295, 30, 60, 20);
        spinnerCapacidad.setValue(maximo);
        panel.add(spinnerCapacidad);
        
        this.panel.setOpaque(true);
        this.panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));        
        this.setContentPane(panel);
    }

    public void setLlenado(int cantidad) {
        this.spinnerLlenar.setValue(cantidad);        
    }
    
    public void setVaciado(int cantidad) {
        this.spinnerVaciar.setValue(cantidad);        
    }
    
    public int getLlenado() {
        return  Integer.parseInt(this.spinnerLlenar.getValue().toString().trim());        
    }
    
    public int getVaciado() {
        return Integer.parseInt(this.spinnerVaciar.getValue().toString().trim());        
    }

    public ControlTanque getControl() {
        return this.control;
    }
    
    public void refresh(int value) {
        this.progreso.setValue(value);
    }
    
    public void setMaximum(int max) {
        this.progreso.setMaximum(max);
    }
    
    public int getMaximum() {
        return this.progreso.getMaximum();
    }
    
    public int getMaximumInput() {
        return Integer.parseInt(this.spinnerCapacidad.getValue().toString().trim());
    }
    
    public int getValue() {
        return this.progreso.getValue();
    }
    
    public int getAction(Object source) {
        if (source.equals(this.iniciar)) {
            if (this.iniciar.getText().equals("Iniciar"))
                return actionOne;
            else
                return actionTwo;
        } else if (source.equals(this.llenar)) {
            if (this.llenar.getText().equals("Activar llenado"))
                return actionThree;        
            else
                return actionFour;
        } else if (source.equals(this.vaciar)) {
            if (this.vaciar.getText().equals("Activar vaciado"))
                return actionFive;
            else
                return actionSix;
        }
        return 0;
    }
    
    public void performAction(Object source) {    
        if (source.equals(this.iniciar)) {
            if (this.iniciar.getText().equals("Iniciar")) {
                this.iniciar.setText("Parar");
                alternarControles(false);
            } else {
                this.iniciar.setText("Iniciar");
                alternarControles(true);
            }
        }    
        if (source.equals(this.llenar)) {
            if (this.llenar.getText().equals("Activar llenado")) {
                this.llenar.setText("Desactivar llenado");
                this.iniciar.setText("Parar");
                this.spinnerLlenar.setEnabled(false);
                this.spinnerCapacidad.setEnabled(false);
            } else {
                this.llenar.setText("Activar llenado");
                this.spinnerLlenar.setEnabled(true);
                if (this.vaciar.getText().equals("Activar vaciado")) {
                    this.iniciar.setText("Iniciar");
                    this.spinnerCapacidad.setEnabled(true);
                }
            }
        }
        if (source.equals(this.vaciar)) {
            if (this.vaciar.getText().equals("Activar vaciado")) {
                this.vaciar.setText("Desactivar vaciado");
                this.iniciar.setText("Parar");
                this.spinnerVaciar.setEnabled(false);
                this.spinnerCapacidad.setEnabled(false);
            } else {
                this.vaciar.setText("Activar vaciado");
                this.spinnerVaciar.setEnabled(true);
                if (this.llenar.getText().equals("Activar llenado")) {
                    this.iniciar.setText("Iniciar");
                    this.spinnerCapacidad.setEnabled(true);
                }
            }
        }
    }
    
    public void alternarControles(boolean activado) {
        if (!activado) {
            this.llenar.setText("Desactivar llenado");
            this.spinnerLlenar.setEnabled(false);    
            this.vaciar.setText("Desactivar vaciado");
            this.spinnerVaciar.setEnabled(false);
            this.spinnerCapacidad.setEnabled(false);
        } else {
            this.vaciar.setText("Activar vaciado");
            this.spinnerVaciar.setEnabled(true);
            this.llenar.setText("Activar llenado");
            this.spinnerLlenar.setEnabled(true);
            this.spinnerCapacidad.setEnabled(true);
        }
    }
}