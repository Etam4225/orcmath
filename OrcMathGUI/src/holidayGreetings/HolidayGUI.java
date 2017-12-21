package holidayGreetings;

import java.awt.Color;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;

public class HolidayGUI extends GUIApplication{
	
	public static HolidayGUI holiday;
	public static GreetingScreen screen1;
	public static SurpriseScreen screen2;

	public HolidayGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		screen1 = new GreetingScreen(getWidth(), getHeight());
		screen2 = new SurpriseScreen(getWidth(), getHeight());
		setScreen(screen1);
	}

	public static void main(String[] args) {
		holiday = new HolidayGUI(800, 550);
		Thread go = new Thread(holiday);
		go.start();
	}
}
