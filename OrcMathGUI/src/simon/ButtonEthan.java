package simon;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonEthan extends Button implements ButtonInterfaceEthan{
	
	private Graphics2D g;
	private Color color;
	private boolean highlight;
	
	public ButtonEthan(int x, int y, int w, int h, String text, Action action, Color color) {
		super(x, y, w, h, text, action);
		this.color = color;
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		this.g = g; 
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(this.color);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}

	@Override
	public void highlight() {
		g.setColor(g.getColor().brighter());
		update();
	}

	@Override
	public void dim() {
		g.setColor(g.getColor().darker());
		update();
	}

}
