package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.TanqueApp;
import view.TanqueWindow;

public class ControlTanque implements ActionListener {
	
	private TanqueWindow window;
	private TanqueApp main;
	
	public ControlTanque(int inicial, int capacidad, TanqueApp main) {
		super();
		this.main = main;
		this.window = new TanqueWindow(inicial, capacidad, this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		int action = this.window.getAction(source);
		if (action == TanqueWindow.actionOne) {
			this.main.startAll();
		} else if (action == TanqueWindow.actionTwo) {
			this.main.stopAll();
		} else if (action == TanqueWindow.actionThree) {
			this.main.startSuma();
		} else if (action == TanqueWindow.actionFour) {
			this.main.stopSuma();
		} else if (action == TanqueWindow.actionFive) {
			this.main.startResta();
		} else if (action == TanqueWindow.actionSix) {
			this.main.stopResta();
		}

		if (action != 0)
			this.window.performAction(source);
	}
	
	public void show() {
		this.window.setVisible(true);
	}
	
	public void hide() {
		this.window.setVisible(false);
	}
	
	public void refresh(int value) {
		this.window.refresh(value);
	}
	
	public int getLlenado() {
		return this.window.getLlenado();
	}
	
	public int getVaciado() {
		return this.window.getVaciado();
	}
	
	public int getCapacidad() {
		int max = this.window.getMaximumInput();
		int value = this.window.getValue();
		if (value > max)
			value = max;
		
		this.window.setMaximum(max);
		this.window.refresh(value);
		return this.window.getMaximum();
	}
}
