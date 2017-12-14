package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Paper extends Component {

	public Paper() {
		super(40,40,100,100);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
