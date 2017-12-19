package myStuff;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField name;
	private TextField race;
	private TextField country;
	private TextField gender;
	private Button add;
	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		name = new TextField(40,70,200,30,"name here", "name");
		viewObjects.add(name);
		race = new TextField(40,130,200,30,"race here", "race");
		viewObjects.add(race);
		country = new TextField(40,190,200,30,"country here", "country");
		viewObjects.add(country);
		gender = new TextField(40,250,200,30,"gender here", "gender");
		viewObjects.add(gender);
		add = new Button(40,300,100,40, "add", new Action() {
			
			@Override
			public void act() {
				name.setText("text changed from button");
				
			}
		});
		viewObjects.add(add);
	}	

}
