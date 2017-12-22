package holidayGreetings;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
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
		setBackground(Color.BLACK);
		Graphic gym = new Graphic(0, 0, 800, 550, "resources/img.png");
		fireworks = new AnimatedComponent(0, 0, 128, 96);
		fireworks.addSequence("resources/fireworks.png", 200, 0, 0, 128, 96, 6);
		Thread run = new Thread(fireworks);
		run.start();
		viewObjects.add(fireworks);
		
		fireworks1 = new AnimatedComponent(650, 0, 128, 96);
		fireworks1.addSequence("resources/fireworks.png", 200, 0, 132, 128, 96, 6);
		Thread run1 = new Thread(fireworks1);
		run1.start();
		viewObjects.add(fireworks1);
		viewObjects.add(gym);
		area = new TextArea(220, 260, 450, 500, "NO CHICKEN LEGS THIS YEAR!");
		area.setCustomTextColor(Color.RED);
		area.setFont(getFont().deriveFont(30f));
		viewObjects.add(area);
		
		change = new Button(450,450,100,100, "Go Back", new Action() {
			
			public void act() {
				HolidayGUI.holiday.setScreen(HolidayGUI.screen1);
			}
		});
		viewObjects.add(change);
	}

}
