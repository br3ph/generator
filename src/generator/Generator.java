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
    private static final int x = 40;
    

    public Generator() {
        super("Generator");
        // Groesse des Fensters
        setSize(600, 600);
        // Position des Fensters
        setLocation(400, 100);
        // Programm beim Schliessen des Fensters beenden
        // kann nachher weg, ist aber sinnvoll zum testen
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout(5, 5));


        // Buttons/spielfeld erzeugen
        spielfeld = new Button[x][x];
        
        
        // Panels auf GridLayout erzeugen
        panelButton = new JPanel(new GridLayout(x, x));
        
        // init
        for(int i=0; i<spielfeld.length; i++)
			for(int j=0; j<spielfeld[0].length; j++)
				this.spielfeld[i][j] = new Button(new JButton(), Button.Button_Type.BOTTOM);


        generate();

        // Buttons auf panel packen
        for(int i=0; i<spielfeld.length; i++) {
        	for(int j=0; j<spielfeld[0].length; j++) {
        		this.panelButton.add(spielfeld[i][j].getButton());
        	}
        }


        //Panels auf Frame packen (das panelButton hat ein GridLayout, dass jetzt in den WestBereich des BorderLayouts kommt)
        getContentPane().add(BorderLayout.CENTER, panelButton);
        // sichtbar machen
        setVisible(true);
    }

    public void generate() {
    	/**
    	 * Obere Seite
    	 */
    	Random rn = new Random();
		int number;

		for(int k=0; k<x; k++) {
			if((k > 0 && spielfeld[0][k-1].getType() == Button.Button_Type.WALL) || (k>1 && spielfeld[0][k-2].getType() == Button.Button_Type.WALL) || (k>2 && spielfeld[0][k-3].getType() == Button.Button_Type.WALL))
				continue;
			number = rn.nextInt(8);
			if(number < 1 && k>2 && k<x-1) spielfeld[0][k] = new Button(new JButton(), Button.Button_Type.WALL);
		}


		for(int i=1; i<x; i++) {
			for(int j=0; j<x; j++) {
				if(spielfeld[i-1][j].getType() == Button.Button_Type.WALL || spielfeld[i-1][j].getType() == Button.Button_Type.WINDOW || spielfeld[i-1][j].getType() == Button.Button_Type.DOOR) {
					number = rn.nextInt(20);
					if(number < 2)
						spielfeld[i][j] = new Button(new JButton(), Button.Button_Type.WINDOW);
					else if(number < 19)
						spielfeld[i][j] = new Button(new JButton(), Button.Button_Type.WALL);
					else
						spielfeld[i][j] = new Button(new JButton(), Button.Button_Type.DOOR);


				}
			}
		}

		for(int i=1; i<x-1; i++) {
			for(int j=0; j<x-1; j++) {
				if(spielfeld[i][j].getType() != Button.Button_Type.WALL)
					continue;
				number = rn.nextInt(x);
				if(number < 1) {
					for(; j<x; j++) {
						spielfeld[i][j] = new Button(new JButton(), Button.Button_Type.WALL);
					}
				} else if(number <2) {
					for(; j>=0; j--) {
						spielfeld[i][j] = new Button(new JButton(), Button.Button_Type.WALL);
					}
					i++;
				}
			}
		}
		
		
    }
    
}
