package simon;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceEthan extends Visible {

	void gameover();

	void setRound(int round);
	
	void setSequenceSize(int size);
}
