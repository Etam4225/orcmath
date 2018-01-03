package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenEthan extends ClickableScreen implements Runnable{

	private ProgressInterfaceEthan progress;
	private ArrayList<MoveInterfaceEthan> move;
	private ButtonInterfaceEthan[] buttons;
	private int rNum;
	private boolean acceptInput;
	private TextLabel response;
	private int lastButton;
	
	public SimonScreenEthan(int width, int height) {
		super(width, height);
		Thread runner = new Thread(this);
		runner.start();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceEthan b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		response = new TextLabel(130,230,300,40,"Let's play Simon!");
		move = new ArrayList<MoveInterfaceEthan>();
		//add 2 moves to start
		lastButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		rNum = 0;
		viewObjects.add(progress);
		viewObjects.add(response);

	}

	private MoveInterfaceEthan randomMove() {
		  int bIndex = (int)(Math.random()*buttons.length);
		    while(bIndex == lastButton){
		        bIndex = (int)(Math.random()*buttons.length);
		    }
		    return getMove(bIndex);
	}
	
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceEthan getMove(int bIndex) {
	    return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceEthan getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 5;
		buttons = new ButtonInterfaceEthan[numberOfButtons];
		Color[] color = {Color.black, Color.green, Color.yellow, Color.red, Color.blue};
		for(int i = 0; i < numberOfButtons; i++) {
			ButtonInterfaceEthan b = getAButton();
			buttons[i] = b;
			  b.setColor(color[i]);
			  b.setX(150);
			  b.setY(150);
		}
		
	}
	
	
	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ButtonInterfaceEthan getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		progress.displayRound(rNum);
		
		
	}

}
