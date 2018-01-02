package ethanstuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPlayer.CustomLabel;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button implements CustomLabel {
	
	private String field;
	private String field1;

	public CustomButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setColor(Color.BLACK);
		g.drawString(field, 50, 100);
		
	}

	@Override
	public void updateString1(String string) {
		string = field;
		
	}

	@Override
	public void updateString2(String string) {
		string = field1;
		
	}

	@Override
	public void setIconColor(Color color) {
		// TODO Auto-generated method stub
		
	}
	
	

}
