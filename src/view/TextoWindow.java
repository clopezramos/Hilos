package view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ControlTexto;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;

public class TextoWindow extends JFrame {
    
    public static int actionOne = 1;
    
    public static String defaultText = "Hilo numero : ";
    public static String metodoUno = "Thread";
    public static String metodoDos = "Runnable";
    
    private static final long serialVersionUID = 3421533098845934188L;
    private ControlTexto control;
    
    private JButton start;    
    private JPanel panel;
    private JTextPane textPane;
    private JScrollPane scrollPane;
    private JSeparator separator;
    private JLabel numeroHilos;
    private JLabel labelTiempo;
    private JSpinner spinnerHilos;
    private JSpinner spinnerDuracion;
    private JTextField textField;
    private JLabel labelTexto;
    private JLabel labelSalida;
    private JLabel labelRetraso;
    private JSpinner spinnerRetraso;
    private JLabel labelMetodo;
    private JComboBox<String> comboBox;
    
    public TextoWindow(ControlTexto control) {
        super();
        this.control = control;
        
        this.setTitle("TextoApp");
        this.setSize(485, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        
        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setDragEnabled(false);
        scrollPane = new JScrollPane(textPane);
        scrollPane.setBounds(10, 36, 198, 224);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);

        start = new JButton("Start");
        start.addActionListener(this.control);
        start.setBounds(298, 224, 106, 23);
        panel.add(start);
        
        separator = new JSeparator();
        separator.setBounds(223, 211, 246, 2);
        panel.add(separator);
        
        numeroHilos = new JLabel("Numero de hilos:");
        numeroHilos.setBounds(244, 130, 96, 14);
        panel.add(numeroHilos);
        
        labelTiempo = new JLabel("Duracion: ");
        labelTiempo.setBounds(244, 173, 57, 14);
        panel.add(labelTiempo);
        
        spinnerHilos = new JSpinner();
        spinnerHilos.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        spinnerHilos.setBounds(347, 127, 35, 20);
        panel.add(spinnerHilos);
        
        spinnerDuracion = new JSpinner();
        spinnerDuracion.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        spinnerDuracion.setBounds(311, 170, 35, 20);
        panel.add(spinnerDuracion);
        
        labelTexto = new JLabel("Texto:");
        labelTexto.setBounds(244, 88, 46, 14);
        panel.add(labelTexto);
        
        labelSalida = new JLabel("Salida:");
        labelSalida.setBounds(10, 11, 46, 14);
        panel.add(labelSalida);
        
        textField = new JTextField();
        textField.setBounds(286, 85, 183, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        labelRetraso = new JLabel("Retraso:");
        labelRetraso.setBounds(356, 173, 57, 14);
        panel.add(labelRetraso);
        
        spinnerRetraso = new JSpinner();
        spinnerRetraso.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        spinnerRetraso.setBounds(414, 170, 35, 20);
        panel.add(spinnerRetraso);
        
        labelMetodo = new JLabel("Metodo");
        labelMetodo.setBounds(244, 46, 67, 14);
        panel.add(labelMetodo);
        
        String[] metodos = { metodoUno, metodoDos };
        comboBox = new JComboBox<String>(metodos);
        comboBox.setBounds(298, 43, 171, 20);
        panel.add(comboBox);
        
        panel.setOpaque(true);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));        
        this.setContentPane(panel);

        // inicializar
        textField.setText(defaultText);        
        setNumeroHilos(1);
        setTiempo(1);
    }
    
    public void setDuracion(int cantidad) {
        this.spinnerDuracion.setValue(cantidad);
    }
    
    public int getDuracion() {
        return Integer.parseInt(this.spinnerDuracion.getValue().toString().trim());
    }
    
    public void setTiempo(int cantidad) {
        this.spinnerRetraso.setValue(cantidad);
    }
    
    public int getTiempo() {
        return Integer.parseInt(this.spinnerRetraso.getValue().toString().trim());
    }
    
    public void setNumeroHilos(int cantidad) {
        this.spinnerHilos.setValue(cantidad);
    }
    
    public int getNumeroHilos() {
        return Integer.parseInt(this.spinnerHilos.getValue().toString().trim());
    }
    
    public String getText(){
        return this.textField.getText();
    }
    
    public void addText (String texto) {
        Document doc = textPane.getDocument();
        try {
            doc.insertString(doc.getLength(), texto, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    
    public void clearTextPane() {
        textPane.removeAll();
    }
    
    public int getAction(Object source) {
        if (source.equals(this.start))
                return actionOne;
        
        return 0;
    }
    
    public String getComboBoxText() {
        return this.comboBox.getSelectedItem().toString();
    }
    
    public void alternarControles(boolean activado) {
        if (!activado) {
            this.start.setText("Procesando");
            this.start.setEnabled(false);
            this.spinnerDuracion.setEnabled(false);    
            this.spinnerHilos.setEnabled(false);
            this.spinnerRetraso.setEnabled(false);
            this.comboBox.setEnabled(false);
            this.textField.setEnabled(false);
        } else {
            this.start.setText("Start");
            this.start.setEnabled(true);
            this.spinnerDuracion.setEnabled(true);
            this.spinnerHilos.setEnabled(true);
            this.spinnerRetraso.setEnabled(true);
            this.comboBox.setEnabled(true);
            this.textField.setEnabled(true);
        }
    }
}
