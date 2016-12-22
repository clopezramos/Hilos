package main;

import control.ControlMainWindow;

public class MainApp {

	private static MainApp singleton = null;
	private ControlMainWindow controlMainWindow;
	private TextoApp texto;
	private TanqueApp tanque;
	private MatrizApp matriz;
	
	private static String applicationOne = "TextoApp";
	private static String applicationTwo = "TanqueApp";
	private static String applicationThree = "MatrizApp";
	
	private static String[] applications = {
			applicationOne,
			applicationTwo,
			applicationThree
	};

	public MainApp() {
		inicializarControl(applications, this);
	}

	public static void main(String[] args) {
		MainApp main = getInstance();
		main.controlMainWindow.show();
	}

	public void startApplication(String name) {
		if (name.equals(applicationOne)) {
			if (texto == null)
				texto = new TextoApp();
			texto.show();
		}
		if (name.equals(applicationTwo)) {
			if (tanque == null)
				tanque = new TanqueApp(50, 100);
			tanque.show();
		}
		if (name.equals(applicationThree)) {
			if (matriz == null)
				matriz = new MatrizApp();
			matriz.show();
		}
	}

	private void inicializarControl(String[] applications, MainApp main) {
		if (this.controlMainWindow == null)
			this.controlMainWindow = new ControlMainWindow(applications, main);
	}

	public ControlMainWindow getControlMainWindow() {
		return controlMainWindow;
	}

	public static MainApp getInstance() {
		if (singleton == null) {
			singleton = new MainApp();
		}

		return singleton;
	}
}
