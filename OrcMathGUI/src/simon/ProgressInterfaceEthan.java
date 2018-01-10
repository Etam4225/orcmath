package simon;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceEthan extends Visible {

	void displayRound(int rNum);

	void gameover();

	void setRound(int round);
	
	void setSequenceSize(int size);

	void setText(String string);
}
