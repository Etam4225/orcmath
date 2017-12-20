package myStuff;

import java.awt.Color;
import java.util.List;

import guiPlayer.Babies;
import guiPlayer.CatalogMaker;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField name;
	private TextField race;
	private TextField country;
	private TextField gender;
	private Button add;
	private CatalogMaker catalog;
	
	private TextArea area;
	private TextArea error;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		name = new TextField(40,70,200,30,"name here", "name");
		//name.setInputType(TextField.INPUT_TYPE_NUMERIC); to change soemthing to numeric entry
		viewObjects.add(name);
		race = new TextField(40,130,200,30,"race here", "race");
		viewObjects.add(race);
		country = new TextField(40,190,200,30,"country here", "country");
		viewObjects.add(country);
		gender = new TextField(40,250,200,30,"gender here", "gender");
		viewObjects.add(gender);
		area = new TextArea(400, 200, 200, 200, "Mark is a cool dude.");
		viewObjects.add(area);
		
		
		error = new TextArea(400, 50, 200, 200, "Error Message goes here");
		error.setVisible(false);
		error.setCustomTextColor(Color.red);
		viewObjects.add(error);
		add = new Button(40,300,100,100, "add", new Action() {
			
			@Override
			public void act() {
				addButtonClicked();
				
			}
		});
		viewObjects.add(add);
	}

	protected void addButtonClicked() {
		if(checkEmpty()) {
			error.setText("You didn't input anything for 1 or more text field. Please add them.");
			error.setVisible(true);
		}else {
			Babies b = new Babies(name.getText(), race.getText(), country.getText(), gender.getText());
			String s  = area.getText() + b + "\n";
			area.setText(s);
			catalog.addBaby(b);
		}
		name.setText("");
		gender.setText("");
		race.setText("");
		country.setText("");
	}

	private boolean checkEmpty() {
		return name.getText().equals("") || race.getText().equals("") || country.getText().equals("") || gender.getText().equals("");
		
	}	

}
