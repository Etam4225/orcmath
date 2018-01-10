package simon;

public class MoveEthan implements MoveInterfaceEthan{
	
	private ButtonInterfaceEthan b;
	
	public MoveEthan(ButtonInterfaceEthan b)
	{
		this.b = b;
	}

	@Override
	public ButtonInterfaceEthan getButton() {
		return b;
	}

}
