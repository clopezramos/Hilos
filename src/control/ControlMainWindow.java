package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainApp;
import view.MainWindow;

public class ControlMainWindow implements ActionListener {    
    
    private MainWindow mainWindow;
    private MainApp main;
    
    public ControlMainWindow(String[] applications, MainApp main) {
        super();
        this.main = main;

        this.mainWindow = new MainWindow(applications, this);
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        int action = this.mainWindow.getAction(source);
        if (action == MainWindow.actionOne)
            main.startApplication(this.mainWindow.getCurrentApplication());
    }

    public void show() {
        this.mainWindow.setVisible(true);
    }
    
    public void hide() {
        this.mainWindow.setVisible(false);
    }
}
