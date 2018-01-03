package simon;

import guiTeacher.GUIApplication;

public class SimonGameEthan extends GUIApplication {
	
	private static SimonScreenEthan screen;
	private static SimonGameEthan game;

	public SimonGameEthan(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenEthan screen = new  SimonScreenEthan(getWidth(), getHeight());
		setScreen(screen);

	}
	
	public static void main(String[] args) {
		game = new SimonGameEthan(850,500);
		Thread runner = new Thread();
		runner.start();
	}
}
