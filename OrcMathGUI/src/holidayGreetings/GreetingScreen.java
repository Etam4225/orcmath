package holidayGreetings;

import java.awt.Color;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class GreetingScreen extends FullFunctionScreen {
	
//	private TextArea area;
	private Button change;

	public GreetingScreen(int width, int height) {
		super(width, height);
//		StyledComponent.setBackgroundColor(Color.GREEN);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(false);
		Graphic newyr = new Graphic(0,0,800, 550, "resources/newyear.jpg");
		viewObjects.add(newyr);
		Color mCol = new Color(239, 232, 177);
		change = new Button(200,450,400,50, "   ", new Action() {
			
			public void act() {
				HolidayGUI.holiday.setScreen(HolidayGUI.screen2);
			}
		});
//		change.getActiveBorderColor();
		change.setActiveBorderColor(null);
		change.setBackgroundColor(Color.green);
		viewObjects.add(change);
		
		Graphic STUFF = new Graphic(200,450,150, 150, "resources/mario.png");
		viewObjects.add(STUFF);
	}

}
