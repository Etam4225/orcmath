package simon;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonEthan extends Button implements ButtonInterfaceEthan{
	
	private Color color;
	private boolean highlight;
	
	public ButtonEthan(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", action);
		highlight = false;
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		if(highlight){
			g.setColor(color.gray);
			g.fillRect(0, 0, getWidth(), getHeight());
		}else{
			g.setColor(color);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	
	@Override
	public void highlight() {
		highlight = true;
		update();	
	}

	@Override
	public void dim() {
		highlight = false;
		update();
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		update();
		
	}

}
