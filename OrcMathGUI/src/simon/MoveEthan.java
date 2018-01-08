package simon;

public class MoveEthan implements MoveInterfaceEthan{
	
	ButtonInterfaceEthan  button;
	
	public MoveEthan(ButtonInterfaceEthan input)
	{
		this.button = input;
	}
	
	public ButtonInterfaceEthan getButton() {
		return button;
	}

}
