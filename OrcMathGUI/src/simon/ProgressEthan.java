package simon;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;

public class ProgressEthan extends Component implements ProgressInterfaceEthan{
	
	private TextLabel text;
	private int rounds;
	private int sequence;
	
	public ProgressEthan(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void displayRound(int rNum) {
		text.setText(Integer.toString(rNum));
	}

	@Override
	public void gameover() {
		text.setText("Game Over!");
	}

	@Override
	public void setRound(int round) {
		this.rounds = round;
	}

	@Override
	public void setSequenceSize(int size) {
		this.sequence = size;
	}

	@Override
	public void update(Graphics2D g) {
		
	}

	@Override
	public void setText(String string) {
		// TODO Auto-generated method stub
		
	}
}
