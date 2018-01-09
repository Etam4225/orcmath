package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenEthan extends ClickableScreen implements Runnable{

	private TextArea progress;
	private TextArea response;
	private ArrayList<MoveInterfaceEthan> move;
	private ButtonInterfaceEthan[] buttons;
	private int rNum;
	private boolean acceptInput;
	private int lastButton;
	private int sequenceIndex;
	
	public SimonScreenEthan(int width, int height) {
		super(width, height);
		Thread runner = new Thread(this);
		runner.start();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//CODE THAT WORKS (displays)
		
		/*
		
		 Color[] color = {Color.black, Color.green, Color.yellow, Color.red, Color.blue};
		for(int i = 0; i < 5; i++) {
			Button button = new Button(250 + i * 50, 150, 50, 50, "name", null);
			button.setBackground(color[i]);
			button.setText("changed");
			viewObjects.add(button);
		}
		TextArea response = new TextArea(250, 75, 150, 150, "stuff goes here");
		viewObjects.add(response); 
		
		*/
		
		
		
		addButtons();
		for(ButtonInterfaceEthan b: buttons){ 
		    viewObjects.add(b); 
		} 
		
		progress = getProgress();
		response = new TextArea(250,50,150,150,"Simon's turn");
		viewObjects.add(response);
		
		/*
		move = new ArrayList<MoveInterfaceEthan>();
		lastButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		move.add(randomMove());
		rNum = 0;
		viewObjects.add(progress);*/
		
		
		

	}

	private MoveInterfaceEthan randomMove() {
		  int bIndex = (int)(Math.random()*buttons.length);
		    while(bIndex == lastButton){
		        bIndex = (int)(Math.random()*buttons.length);
		    }
		    return getMove(bIndex);
	}
	
	private MoveInterfaceEthan getMove(int bIndex) {
		MoveInterfaceEthan choice = new MoveEthan(bIndex, buttons);
//		choice.getButton(bIndex).highlight();
	    return choice;
	}
	
	
	/*
	private ProgressInterfaceEthan getProgress() {
		// TODO Auto-generated method stub
		return null;
	}*/

	private void addButtons() {
		int numberOfButtons = 5;
		buttons = new ButtonInterfaceEthan[numberOfButtons];
		Color[] color = {Color.black, Color.green, Color.yellow, Color.red, Color.blue};
		for(int i = 0; i < numberOfButtons; i++) {
			final ButtonInterfaceEthan b = new ButtonEthan(0, 0, 50, 50, "", null, color[i]);
			buttons[i] = b;
			  b.update();
			  b.setX(250 + i *25 + i * 50);
			  b.setY(150);
			  b.setAction(new Action() {
				
				@Override
				public void act() {
					if(acceptInput) {
						Thread changeButton = new Thread(new Runnable() {
							
							@Override
							public void run() {
								b.highlight();
								try {
									Thread.sleep(500);
								}catch(InterruptedException e){
									e.printStackTrace();
								}
								b.dim();
							}
						});
						changeButton.start();
						if(b == move.get(sequenceIndex).getButton(sequenceIndex)) {
							sequenceIndex++;
						}else {
							progress.setText("Game Over");
						}
						if(sequenceIndex == move.size()) {
							Thread nextRound = new Thread(SimonScreenEthan.this); 
						    nextRound.start();
						}
					}
				}
			});
		}
		
	}

	public TextArea getProgress() {
		return progress;
	}

	private ButtonInterfaceEthan getAButton() {
		int rand = ((int) Math.random()*buttons.length)+1;
		return buttons[rand];
		
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/

	@Override
	public void run() {
//		response.setText("");
//		nextRound();
		
		
	}

	private void changeText(String string) {
		Thread sleep = new Thread(new Runnable() {
			
			@Override
			public void run() {
				response.setText(string);
				try {
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		});
		sleep.start();
	}

	private void nextRound() {
		acceptInput = false;
		rNum++;
		move.add(randomMove());
		/*progress.displayRound(rNum);
		progress.setRound(rNum);
		progress.setSequenceSize(sequenceIndex);*/
		progress = new TextArea(40, 40, 100, 100, "Progress");
		progress.setText("Rounds: "+ rNum+" Sequence: "+ sequenceIndex);
		changeText("Simon's Turn.");
		response.setText("");
		playSequence();
		changeText("Your Turn!");
		acceptInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceEthan b = null;
		for(int i = 0; i < move.size(); i++) {
			if(b != null) {
				b.dim();
			}
			b = move.get(i).getButton();
			b.highlight();
			int sleepTime = 1000 - (((rNum * 20 + 16) * 2)/4);
			if(sleepTime < 0) {
				sleepTime = (((rNum * 20 + 16) * 2)/4) * 15;
			}
			Thread sleep = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(500);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			});
			sleep.start();
			
		}
		b.dim();
	}

}
