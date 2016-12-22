package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.TextoApp;
import view.TextoWindow;

public class ControlTexto implements ActionListener{

	private TextoApp main;
	private TextoWindow window;
	
	public ControlTexto(TextoApp main) {
		this.main = main;
		this.window = new TextoWindow(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		int action = this.window.getAction(source);
		if (action == TextoWindow.actionOne) {
			main.prepare(getDuracion(), getTiempo(), getNumeroHilos(), getThreadText(), getType());
			this.window.alternarControles(false);
		}
	}
	
	public void stop() {
		this.window.alternarControles(true);
	}
	
	public void show() {
		this.window.setVisible(true);
	}
	
	public void hide() {
		this.window.setVisible(false);
	}
	
	public int getNumeroHilos() {
		return window.getNumeroHilos();
	}
	
	public int getDuracion() {
		return window.getDuracion();
	}
	
	public int getTiempo() {
		return window.getTiempo();
	}
	
	public void addText(String text) {
		this.window.addText(text);
	}
	
	public String getThreadText(){
		return window.getText();
	}
	
	public String getType(){
		return window.getComboBoxText();
	}
}
