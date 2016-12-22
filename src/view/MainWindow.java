package view;

import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import control.ControlMainWindow;

public class MainWindow extends JFrame{

	public static int actionOne = 1;
	
	private static final long serialVersionUID = 3172688540921699213L;
	private ControlMainWindow control;
	private JPanel panel;
	private JComboBox<String> comboBox;
	private JLabel label;
	private JButton iniciar;

	public MainWindow(String[] applications, ControlMainWindow mainControl) throws HeadlessException {
		super();	
		control = mainControl;
		
		this.setTitle("Hilos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 136);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		iniciar = new JButton("Iniciar");
		iniciar.setBounds(316, 55, 88, 30);
	    iniciar.addActionListener(control);	    
	    panel.add(iniciar);
		
		comboBox = new JComboBox<String>(applications);
		comboBox.setBounds(26, 60, 280, 20);
		panel.add(comboBox);
		
		label = new JLabel("Selecciona la aplicación que desees inicar");
		label.setBounds(31, 29, 285, 20);
		panel.add(label);
		
	    panel.setOpaque(true);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));		
		this.setContentPane(panel);
	}

	public ControlMainWindow getControl() {
		return control;
	}
	
	public String getCurrentOption() {
		return comboBox.getSelectedItem().toString();
	}
	
	public int getAction(Object source) {
		if (source.equals(this.iniciar))
				return actionOne;
		return 0;
	}
	
	public String getCurrentApplication() {
		return this.comboBox.getSelectedItem().toString();
	}
}
