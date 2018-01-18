package assessment;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class StartScreen extends FullFunctionScreen{
	
	private Button winButton;
	private Button loseButton;

	public StartScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		TextArea result = new TextArea(getWidth()/2, getHeight()/3, 100, 100, "text goes here.");
		viewObjects.add(result);
		winButton = new Button(getWidth()/2-100, getHeight()/2, 50, 50, "Win", Color.green,new Action() {
			
			@Override
			public void act() {
				result.setText("You win.");
				winButton.setEnabled(false);
				loseButton.setEnabled(false);
				
			}
		});
		viewObjects.add(winButton);
		
		loseButton = new Button(getWidth()/2+100, getHeight()/2, 50, 50, "Lose", Color.red,new Action() {
			
			@Override
			public void act() {
				result.setText("You lose.");
				winButton.setEnabled(false);
				loseButton.setEnabled(false);
				
			}
		});
		viewObjects.add(loseButton);
		
	}

}
