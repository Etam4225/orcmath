package simon;

public class MoveEthan implements MoveInterfaceEthan{
	
	private ButtonInterfaceEthan[] buttons;
	private int idx;
	
	public MoveEthan(int idx, ButtonInterfaceEthan[] arrayList)
	{
		this.idx = idx;
		this.buttons = arrayList;
	}
	
	public ButtonInterfaceEthan getButton(int idx) {
		return buttons[this.idx];
	}

}
