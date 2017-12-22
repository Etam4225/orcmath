package holidayGreetings;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SurpriseScreen extends FullFunctionScreen{

	private TextArea area;
	private Button change;
	private AnimatedComponent fireworks;
	
	public SurpriseScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		fireworks = new AnimatedComponent(150, 150, 100, 110);
		fireworks.addSequence("resources/fireworks.png", 200, 0, 0, 100, 110, 5);
		Thread run = new Thread(fireworks);
		run.start();
		viewObjects.add(fireworks);
		
		area = new TextArea(250, 250, 200, 200, "Your New Year's resolution should be to go to the gym!");
		viewObjects.add(area);
		
		change = new Button(50,50,100,100, "Go Back", new Action() {
			
			public void act() {
				HolidayGUI.holiday.setScreen(HolidayGUI.screen1);
			}
		});
		viewObjects.add(change);
	}

}
