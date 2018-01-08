package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonEthan extends Button implements ButtonInterfaceEthan{

	private Color color;
	private Graphics2D g;
	
	public ButtonEthan(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}
	
	public void drawButton(Graphics2D g, boolean hover, boolean highlighting) {
		this.g = g;
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(color);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		
		if( highlighting)
		{
			g.setColor(color.brighter());
			g.fillRect(getX(), getY(), getWidth(), getHeight());
		}
		if(hover)
		{
			g.setColor(color.darker());
			g.fillRect(getX(), getY(), getWidth(), getHeight());
		}
	}
	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void highlight() {
		drawButton(g, false, true);
	}

	@Override
	public void dim() {
		drawButton(g,false,false);
		
	}

}
