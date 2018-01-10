package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenEthan extends ClickableScreen implements Runnable{

	private ProgressInterfaceEthan progress;
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
		
		addButtons();
		for(ButtonInterfaceEthan b: buttons){ 
		    viewObjects.add(b); 
		} 
		
		progress = getProgress();
		response = new TextArea(250,50,150,150,"Simon's turn");
		viewObjects.add(response);
		
		
		move = new ArrayList<MoveInterfaceEthan>();
		lastButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		rNum = 0;
		viewObjects.add(progress);
		
		
		

	}

	public MoveInterfaceEthan randomMove() {
		ButtonInterfaceEthan b = null;
		  int bIndex = (int)(Math.random()*buttons.length);
		    while(bIndex == lastButton){
		        bIndex = (int)(Math.random()*buttons.length);
		    }
		    b = buttons[bIndex];
		    lastButton = bIndex;
		    return getMove(b);
	}
	
	public MoveInterfaceEthan getMove(ButtonInterfaceEthan b) {
		return new MoveEthan(b);
	}
	
	public ProgressInterfaceEthan getProgress() {
		return new ProgressEthan(50, 350, 100, 100);
	}

	private void addButtons() {
		int numberOfButtons = 5;
		buttons = new ButtonInterfaceEthan[numberOfButtons];
		Color[] color = {Color.CYAN, Color.green, Color.yellow, Color.red, Color.blue};
		for(int i = 0; i < numberOfButtons; i++) {
			buttons[i] = getAButton();
			buttons[i].setColor(color[i]);
			buttons[i].setX(250 + i *25 + i * 50);
			buttons[i].setY(150);
			final ButtonInterfaceEthan b = buttons[i];
			b.dim();
			b.setAction(new Action() {
				
				@Override
				public void act() {
					if(acceptInput) {
						Thread changeButton = new Thread(new Runnable() {
							
							@Override
							public void run() {
								b.highlight();
								try {
									Thread.sleep(400);
								}catch(InterruptedException e){
									e.printStackTrace();
								}
								b.dim();
							}
						});
						changeButton.start();
						if(b == move.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						}else {
							progress.gameover();
							acceptInput = false;
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

	private ButtonInterfaceEthan getAButton() {
		return new ButtonEthan(0, 0, 75, 75, "", null);
		
	}

	@Override
	public void run() {
		response.setText("");
		nextRound();
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
		progress.setRound(rNum);
		progress.setSequenceSize(move.size());
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
			int sleepTime = (1000 - (1 + i * 10 ));
			try {
					Thread.sleep(sleepTime);
				}catch(InterruptedException e){
					e.printStackTrace();
				}			
		}
		b.dim();
	}

}
