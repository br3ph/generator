package generator;

import javax.swing.*;

import java.awt.*;
import java.util.Random;

public class Generator extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8834584233329405680L;
	private JPanel panelButton;
    private Button spielfeld[][];

    public Generator() {
        super("Generator");
        // Groesse des Fensters
        setSize(600, 600);
        // Position des Fensters
        setLocation(400, 100);
        // Programm beim Schliessen des Fensters beenden
        // kann nachher weg, ist aber sinnvoll zum testen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout(5, 5));


        // Buttons/spielfeld erzeugen
        spielfeld = new Button[100][100];
        
        
        // Panels auf GridLayout erzeugen
        panelButton = new JPanel(new GridLayout(100, 100));

        

        
        //Panels auf Frame packen (das panelButton hat ein GridLayout, dass jetzt in den WestBereich des BorderLayouts kommt)
        getContentPane().add(BorderLayout.CENTER, panelButton);
        // sichtbar machen
        setVisible(true);
    }

    public static void main(String[] args) {
		Generator gen = new Generator();
        gen.init();
        gen.generate();
        gen.addToPanel();
    }
    
    public void generate() {
    	for(int i=0; i<spielfeld.length; i++) {
        	for(int j=0; j<spielfeld[0].length; j++) {
        		Random rn = new Random();
        		int number = rn.nextInt(10);
        		
        		
//        		System.out.println(spielfeld[i][j].getType());
        	}
        }

    }
    
    public void addToPanel() {
    	// Buttons auf panel packen
        for(int i=0; i<spielfeld.length; i++) {
        	for(int j=0; j<spielfeld[0].length; j++) {
        		this.panelButton.add(spielfeld[i][j].getButton());
        	}
        }
    }
    
	public void init(){
		for(int i=0; i<spielfeld.length; i++)
			for(int j=0; j<spielfeld[0].length; j++)
				this.spielfeld[i][j] = new Button(new JButton("1"), Button.type.BOTTOM);
	}
	
}
