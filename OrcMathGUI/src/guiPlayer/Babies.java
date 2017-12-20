package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Babies extends AnimatedComponent {
	
	private String name;
	private String race;
	private String country;
	private String sex;
	

	public Babies(String name, String race, String country, String sex) {
		super(40,40,109,125);
		this.name = name;
		this.race = race;
		this.country = country;
		this.sex = sex;
//		addSequence("resources/rotmgSprite.png", 150, 0, 0, 111, 120, 5);
//		Thread animation = new Thread(this);
//		animation.start();
		update();
	}

	@Override
	public String toString() {
		return name + "," + race + "," + country + "," + sex;
	}

	@Override
	public void update(Graphics2D g) {
//		super.update(g);
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
