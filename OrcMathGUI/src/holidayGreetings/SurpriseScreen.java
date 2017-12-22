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
	private AnimatedComponent fireworks1;
	
	public SurpriseScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		fireworks = new AnimatedComponent(150, 150, 100, 100);
		fireworks.addSequence("resources/fireworks.png", 200, 0, 0, 100, 100, 5);
		Thread run = new Thread(fireworks);
		run.start();
		viewObjects.add(fireworks);
		
		fireworks1 = new AnimatedComponent(450, 150, 100, 110);
		fireworks1.addSequence("resources/fireworks.png", 200, 0, 0, 100, 110, 5);
		Thread run1 = new Thread(fireworks1);
		run1.start();
		viewObjects.add(fireworks1);
		
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
