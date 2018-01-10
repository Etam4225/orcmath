package simon;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceEthan extends Clickable {
	
	void setAction(Action a);

	void highlight();

	void dim();

	void setColor(Color color);

}
