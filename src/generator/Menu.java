package generator;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private Choice type = new Choice();
    private JButton startGenerator = new JButton("Starte Generator");
    private JPanel panel;
    private JLabel background;

    public Menu() {
        super("Menu - Generator");
        this.setIconImage(new ImageIcon(this.getClass().getResource("icon/background.jpg")).getImage());

                // Groesse des Fensters
        setSize(600, 600);
        // Position des Fensters
        setLocation(400, 100);
        // Programm beim Schliessen des Fensters beenden
        // kann nachher weg, ist aber sinnvoll zum testen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout(5, 5));

        // Liste fuellen
        listMenu();

        // Elemente der GUI hinzufuegen
        addElements();

        // sichtbar machen
        setVisible(true);
    }

    private void listMenu() {
        type.add("Labyrinth");
        type.add("Haus");
        type.add("Dungeon");
    }

    private void addElements() {
        // Background
        panel = new JPanel();
        background = new JLabel(new ImageIcon("Pictures/background.jpg"));
        background.setLayout(null);
        background.setOpaque(false);
        background.setBounds(1, 1, 100, 100);

        // Add's
        panel.add(type);
        panel.add(startGenerator);
        panel.add(background);
        add(panel);

        startGenerator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Generator gen = new Generator();
            }
        });
    }



    public static void main(String[] args) {
        Menu menu = new Menu();
    }
}
