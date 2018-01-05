package simon;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceEthan extends Visible {

	void displayRound(int rNum);

	void gameover();

	void setRound(int round);
	
	void setSequenceSize(int size);
}
