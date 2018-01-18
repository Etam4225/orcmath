package assessment;

import guiTeacher.GUIApplication;

public class AssessmentGUI extends GUIApplication {
	
	public static AssessmentGUI gui;

	public AssessmentGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		StartScreen start = new StartScreen(getWidth(), getHeight());
		setScreen(start);
//		gui.setScreen(start);

	}

	public static void main(String[] args) {
		gui = new AssessmentGUI(800,800);
		Thread stuff = new Thread(gui);
		stuff.start();

	}

}
