package holidayGreetings;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class GreetingScreen extends FullFunctionScreen {
	
	private TextArea area;
	private Button change;

	public GreetingScreen(int width, int height) {
		super(width, height);
//		StyledComponent.setBackgroundColor(Color.GREEN);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		area = new TextArea(250, 250, 200, 200, "It's New Years! If you want a special message, click the button!");
		area.setBackgroundColor(Color.red);
		area.setCustomTextColor(Color.RED);
		viewObjects.add(area);
		change = new Button(50,50,100,100, "CLICK ME", new Action() {
			
			public void act() {
				HolidayGUI.holiday.setScreen(HolidayGUI.screen2);
			}
		});
		change.setBackgroundColor(Color.green);
		viewObjects.add(change);
	}

}
