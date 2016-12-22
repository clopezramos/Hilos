package view;

import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ControlMatriz;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class MatrizWindow extends JFrame {
    
    public static int actionOne = 1;
    
    private static final long serialVersionUID = 8045693798760525818L;
    private ControlMatriz control;
    private JPanel panel;
    private JTextPane textPaneOne;
    private JScrollPane scrollPaneOne;
    private JTextPane textPaneTwo;
    private JScrollPane scrollPaneTwo;
    private JSpinner a1m1_field;
    private JSpinner a2m1_field;
    private JSpinner a3m1_field;
    private JSpinner b1m1_field;
    private JSpinner b2m1_field;
    private JSpinner b3m1_field;
    private JSpinner c1m1_field;
    private JSpinner c2m1_field;
    private JSpinner c3m1_field;
    private JSpinner a1m2_field;
    private JSpinner a2m2_field;
    private JSpinner a3m2_field;
    private JSpinner b2m2_field;
    private JSpinner b3m2_field;
    private JSpinner c1m2_field;
    private JSpinner c2m2_field;
    private JSpinner c3m2_field;
    private JSpinner b1m2_field;
    private JLabel c1_m1;
    private JLabel c2_m1;
    private JLabel c3_m1;
    private JLabel lblMatriz_2;
    private JLabel a1_m2;
    private JLabel a2_m2;
    private JLabel a3_m2;
    private JLabel b1_m2;
    private JLabel b2_m2;
    private JLabel b3_m2;
    private JLabel c1_m2;
    private JLabel c2_m2;
    private JLabel c3_m2;
    private JLabel lblTiemposDeEjecucion;
    private JLabel lblSecuencial;
    private JLabel lblConcurrente;
    private JSeparator separator_3;
    private JTextField tsecuencial_field;
    private JTextField tconcurrente_field;
    private JSeparator separator;
    private JSeparator separator_1;
    private JSeparator separator_2;
    private JSeparator separator_4;
    private JLabel lblResultadoSecuencial;
    private JLabel lblResultadoConcurrente;
    private JButton start;
    private JLabel lblMatriz_1;
    private JLabel a1_m1;
    private JLabel a2_m1;
    private JLabel a3_m1;
    private JLabel b1_m1;
    private JLabel b2_m1;    
    private JLabel b3_m1;
    private JLabel lblNs_1;
    private JLabel lblNs;
    
    public MatrizWindow(ControlMatriz control) {
        super();
        this.control = control;
        
        this.setTitle("Hilos");
        this.setSize(550, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        
        lblMatriz_1 = new JLabel("Matriz 1");
        lblMatriz_1.setBounds(30, 24, 46, 14);
        panel.add(lblMatriz_1);
        
        a1_m1 = new JLabel("a1");
        a1_m1.setBounds(35, 59, 46, 14);
        panel.add(a1_m1);
        
        a2_m1 = new JLabel("a2");
        a2_m1.setBounds(35, 84, 46, 14);
        panel.add(a2_m1);
        
        a3_m1 = new JLabel("a3");
        a3_m1.setBounds(35, 109, 46, 14);
        panel.add(a3_m1);
        
        b1_m1 = new JLabel("b1");
        b1_m1.setBounds(121, 59, 46, 14);
        panel.add(b1_m1);
        
        b2_m1 = new JLabel("b2");
        b2_m1.setBounds(121, 84, 46, 14);
        panel.add(b2_m1);
        
        b3_m1 = new JLabel("b3");
        b3_m1.setBounds(121, 109, 46, 14);
        panel.add(b3_m1);
        
        c1_m1 = new JLabel("c1");
        c1_m1.setBounds(198, 59, 46, 14);
        panel.add(c1_m1);
        
        c2_m1 = new JLabel("c2");
        c2_m1.setBounds(198, 84, 46, 14);
        panel.add(c2_m1);
        
        c3_m1 = new JLabel("c3");
        c3_m1.setBounds(198, 109, 46, 14);
        panel.add(c3_m1);
        
        lblMatriz_2 = new JLabel("Matriz 2");
        lblMatriz_2.setBounds(290, 24, 46, 14);
        panel.add(lblMatriz_2);
        
        a1_m2 = new JLabel("a1");
        a1_m2.setBounds(290, 59, 46, 14);
        panel.add(a1_m2);
        
        a2_m2 = new JLabel("a2");
        a2_m2.setBounds(290, 84, 46, 14);
        panel.add(a2_m2);
        
        a3_m2 = new JLabel("a3");
        a3_m2.setBounds(290, 109, 46, 14);
        panel.add(a3_m2);
        
        b1_m2 = new JLabel("b1");
        b1_m2.setBounds(370, 59, 46, 14);
        panel.add(b1_m2);
        
        b2_m2 = new JLabel("b2");
        b2_m2.setBounds(370, 84, 46, 14);
        panel.add(b2_m2);
        
        b3_m2 = new JLabel("b3");
        b3_m2.setBounds(370, 109, 46, 14);
        panel.add(b3_m2);
        
        c1_m2 = new JLabel("c1");
        c1_m2.setBounds(447, 59, 46, 14);
        panel.add(c1_m2);
        
        c2_m2 = new JLabel("c2");
        c2_m2.setBounds(447, 84, 46, 14);
        panel.add(c2_m2);
        
        c3_m2 = new JLabel("c3");
        c3_m2.setBounds(447, 109, 46, 14);
        panel.add(c3_m2);
        
        lblTiemposDeEjecucion = new JLabel("Tiempos de ejecucion:");
        lblTiemposDeEjecucion.setBounds(44, 147, 156, 14);
        panel.add(lblTiemposDeEjecucion);
        
        lblSecuencial = new JLabel("Secuencial:");
        lblSecuencial.setBounds(54, 172, 69, 14);
        panel.add(lblSecuencial);
        
        lblConcurrente = new JLabel("Concurrente:");
        lblConcurrente.setBounds(54, 197, 86, 14);
        panel.add(lblConcurrente);
        
        lblResultadoSecuencial = new JLabel("Resultado secuencial");
        lblResultadoSecuencial.setBounds(35, 229, 132, 14);
        panel.add(lblResultadoSecuencial);
        
        lblResultadoConcurrente = new JLabel("Resultado concurrente");
        lblResultadoConcurrente.setBounds(316, 229, 177, 14);
        panel.add(lblResultadoConcurrente);
        
        start = new JButton("Start");
        start.setBounds(340, 175, 121, 23);
        start.addActionListener(this.control);
        panel.add(start);
        
        //CAMPOS A RELLENAR
        a1m1_field = new JSpinner();
        a1m1_field.setBounds(65, 56, 46, 20);
        panel.add(a1m1_field);
        
        a2m1_field = new JSpinner();
        a2m1_field.setBounds(65, 81, 46, 20);
        panel.add(a2m1_field);
        
        a3m1_field = new JSpinner();
        a3m1_field.setBounds(65, 106, 46, 20);
        panel.add(a3m1_field);
        
        b1m1_field = new JSpinner();
        b1m1_field.setBounds(142, 56, 46, 20);
        panel.add(b1m1_field);
        
        b2m1_field = new JSpinner();
        b2m1_field.setBounds(141, 81, 47, 20);
        panel.add(b2m1_field);
        
        b3m1_field = new JSpinner();
        b3m1_field.setBounds(142, 106, 46, 20);
        panel.add(b3m1_field);
        
        c1m1_field = new JSpinner();
        c1m1_field.setBounds(219, 56, 46, 20);
        panel.add(c1m1_field);
        
        c2m1_field = new JSpinner();
        c2m1_field.setBounds(219, 81, 46, 20);
        panel.add(c2m1_field);
        
        c3m1_field = new JSpinner();
        c3m1_field.setBounds(219, 106, 46, 20);
        panel.add(c3m1_field);
        
        a1m2_field = new JSpinner();
        a1m2_field.setBounds(314, 56, 46, 20);
        panel.add(a1m2_field);
        
        a2m2_field = new JSpinner();
        a2m2_field.setBounds(314, 81, 46, 20);
        panel.add(a2m2_field);
        
        a3m2_field = new JSpinner();
        a3m2_field.setBounds(314, 106, 46, 20);
        panel.add(a3m2_field);
        
        b1m2_field = new JSpinner();
        b1m2_field.setBounds(391, 56, 46, 20);
        panel.add(b1m2_field);
        
        b2m2_field = new JSpinner();
        b2m2_field.setBounds(391, 81, 46, 20);
        panel.add(b2m2_field);
        
        b3m2_field = new JSpinner();
        b3m2_field.setBounds(391, 106, 46, 20);
        panel.add(b3m2_field);
        
        c1m2_field = new JSpinner();
        c1m2_field.setBounds(467, 56, 46, 20);
        panel.add(c1m2_field);
        
        c2m2_field = new JSpinner();
        c2m2_field.setBounds(467, 106, 46, 20);
        panel.add(c2m2_field);
        
        c3m2_field = new JSpinner();
        c3m2_field.setBounds(467, 81, 46, 20);
        panel.add(c3m2_field);
        
        tsecuencial_field = new JTextField();
        tsecuencial_field.setEditable(false);
        tsecuencial_field.setBounds(142, 169, 102, 20);
        panel.add(tsecuencial_field);
        tsecuencial_field.setColumns(10);
        
        tconcurrente_field = new JTextField();
        tconcurrente_field.setEditable(false);
        tconcurrente_field.setBounds(142, 191, 102, 20);
        panel.add(tconcurrente_field);
        tconcurrente_field.setColumns(10);
        
        //Paneles de matrices resultantes
        
        //Panel resultado concurrente
        textPaneOne = new JTextPane();
        textPaneOne.setEditable(false);
        textPaneOne.setDragEnabled(false);
        scrollPaneOne = new JScrollPane(textPaneOne);
        scrollPaneOne.setRequestFocusEnabled(false);
        scrollPaneOne.setBounds(300, 254, 198, 200);
        scrollPaneOne.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPaneOne);
        
        //Panel resultado secuencial
        textPaneTwo = new JTextPane();
        textPaneTwo.setEditable(false);
        textPaneTwo.setDragEnabled(false);
        scrollPaneTwo = new JScrollPane(textPaneTwo);
        scrollPaneTwo.setRequestFocusEnabled(false);
        scrollPaneTwo.setBounds(30, 254, 198, 200);
        scrollPaneTwo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPaneTwo);
        
        //Separadores    
        separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(275, 49, 2, 86);
        panel.add(separator);
        
        separator_2 = new JSeparator();
        separator_2.setBounds(23, 134, 500, 2);
        panel.add(separator_2);
        
        separator_3 = new JSeparator();
        separator_3.setBounds(23, 49, 500, 14);
        panel.add(separator_3);
        
        separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(23, 49, 2, 86);
        panel.add(separator_1);
        
        separator_4 = new JSeparator();
        separator_4.setOrientation(SwingConstants.VERTICAL);
        separator_4.setBounds(523, 49, 2, 86);
        panel.add(separator_4);
        
        panel.setOpaque(true);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));        
        this.setContentPane(panel);
        
        lblNs = new JLabel("ns");
        lblNs.setBounds(252, 172, 46, 14);
        panel.add(lblNs);
        
        lblNs_1 = new JLabel("ns");
        lblNs_1.setBounds(252, 197, 46, 14);
        panel.add(lblNs_1);
    }
    
    public void setTimeSecuencial(String time) {
        this.tsecuencial_field.setText(time);
    }
    
    public void setTimeConcurrente(String time) {
        this.tconcurrente_field.setText(time);
    }

    public int getA1m1_field() {
        return Integer.parseInt(this.a1m1_field.getValue().toString().trim());
    }

    public int getA2m1_field() {
        return Integer.parseInt(this.a2m1_field.getValue().toString().trim());
    }

    public int getA3m1_field() {
        return Integer.parseInt(this.a3m1_field.getValue().toString().trim());
    }

    public int getB1m1_field() {
        return Integer.parseInt(this.b1m1_field.getValue().toString().trim());
    }

    public int getB2m1_field() {
        return Integer.parseInt(this.b2m1_field.getValue().toString().trim());
    }

    public int getB3m1_field() {
        return Integer.parseInt(this.b3m1_field.getValue().toString().trim());
    }

    public int getC1m1_field() {
        return Integer.parseInt(this.c1m1_field.getValue().toString().trim());
    }

    public int getC2m1_field() {
        return Integer.parseInt(this.c2m1_field.getValue().toString().trim());
    }

    public int getC3m1_field() {
        return Integer.parseInt(this.c3m1_field.getValue().toString().trim());
    }

    public int getA1m2_field() {
        return Integer.parseInt(this.a1m2_field.getValue().toString().trim());
    }

    public int getA2m2_field() {
        return Integer.parseInt(this.a2m2_field.getValue().toString().trim());
    }

    public int getA3m2_field() {
        return Integer.parseInt(this.a3m2_field.getValue().toString().trim());
    }

    public int getB2m2_field() {
        return Integer.parseInt(this.b2m2_field.getValue().toString().trim());
    }

    public int getB3m2_field() {
        return Integer.parseInt(this.b3m2_field.getValue().toString().trim());
    }

    public int getC1m2_field() {
        return Integer.parseInt(this.c1m2_field.getValue().toString().trim());
    }

    public int getC2m2_field() {
        return Integer.parseInt(this.c2m2_field.getValue().toString().trim());
    }

    public int getC3m2_field() {
        return Integer.parseInt(this.c3m2_field.getValue().toString().trim());
    }

    public int getB1m2_field() {
        return Integer.parseInt(this.b1m2_field.getValue().toString().trim());
    }
    
    public void addTextConcurrente(String texto) {
        Document doc = textPaneOne.getDocument();
        try {
            doc.insertString(doc.getLength(), texto, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    
    public void addTextSecuencial(String texto) {
        Document doc = textPaneTwo.getDocument();
        try {
            doc.insertString(doc.getLength(), texto, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    
    public void addTextTiempoConcurrente(String texto) {
        tconcurrente_field.setText(texto);
    }
    
    public void addTextTiempoSecuencial(String texto) {
        tsecuencial_field.setText(texto);
    }
    
    public void alternarControles(boolean activado) {
        if (!activado) {
            this.start.setText("Procesando");
            this.start.setEnabled(false);
            this.a1m1_field.setEnabled(false);
            this.a2m1_field.setEnabled(false);
            this.a3m1_field.setEnabled(false);
            this.b1m1_field.setEnabled(false);
            this.b2m1_field.setEnabled(false);
            this.b3m1_field.setEnabled(false);
            this.c1m1_field.setEnabled(false);
            this.c2m1_field.setEnabled(false);
            this.c3m1_field.setEnabled(false);
            this.a1m2_field.setEnabled(false);
            this.a2m2_field.setEnabled(false);
            this.a3m2_field.setEnabled(false);
            this.b1m2_field.setEnabled(false);
            this.b2m2_field.setEnabled(false);
            this.b3m2_field.setEnabled(false);
            this.c1m2_field.setEnabled(false);
            this.c2m2_field.setEnabled(false);
            this.c3m2_field.setEnabled(false);
        } else {
            this.start.setText("Start");
            this.start.setEnabled(true);
            this.a1m1_field.setEnabled(true);
            this.a2m1_field.setEnabled(true);
            this.a3m1_field.setEnabled(true);
            this.b1m1_field.setEnabled(true);
            this.b2m1_field.setEnabled(true);
            this.b3m1_field.setEnabled(true);
            this.c1m1_field.setEnabled(true);
            this.c2m1_field.setEnabled(true);
            this.c3m1_field.setEnabled(true);
            this.a1m2_field.setEnabled(true);
            this.a2m2_field.setEnabled(true);
            this.a3m2_field.setEnabled(true);
            this.b1m2_field.setEnabled(true);
            this.b2m2_field.setEnabled(true);
            this.b3m2_field.setEnabled(true);
            this.c1m2_field.setEnabled(true);
            this.c2m2_field.setEnabled(true);
            this.c3m2_field.setEnabled(true);
        }
    }
    
    public int getAction(Object source) {
        if (source.equals(this.start))
                return actionOne;
        
        return 0;
    }
}