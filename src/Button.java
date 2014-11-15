package generator;

import java.awt.Color;

import javax.swing.JButton;

public class Button {
	private JButton button;
	private type type;
	
	public enum type { WALL, BOTTOM, WINDOWS, DOOR, STAIRS };
	
	private Color black = new Color(0, 0, 0);
	private Color brown = new Color(139,69,19);
	private Color lightBrown = new Color(210,105,30);
	private Color cyan = new Color(121,205,205);
	private Color white = new Color(255, 255, 255);
	private Color fail = new Color(255,0,0);
	
	
	
	public Button() {
		this.button = new JButton();
		this.type = null;
	}
	
	public Button(JButton button, type type) {
		this.button = button;
		this.type = type;

		
		switch(type) {
		case WALL: this.button.setBackground(black); break;
		case BOTTOM: this.button.setBackground(white); break;
		case WINDOWS: this.button.setBackground(cyan); break;
		case DOOR: this.button.setBackground(brown); break;
		case STAIRS: this.button.setBackground(lightBrown); break;
		default: this.button.setBackground(fail); break;
		}
	}
	
	public type getType() {
		return type;
	}
	
	public void setType(type  type) {
		this.type = type;
	}
	
	public JButton getButton() {
		return button;
	}
	
	public void setButton(JButton button) {
		this.button = button;
	}
	
	
}
