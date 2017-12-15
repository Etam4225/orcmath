package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogueMaker {
	
	private ArrayList<Babies> List;

	public CatalogueMaker() {
		List = new ArrayList<Babies>();
		List.add(new Babies("john", "asian", "america", "male"));
		List.add(new Babies("ssjdshtrubg", "white", "slkja", "female"));
		List.add(new Babies("shawn", "black", "france", "transgender"));
		List.add(new Babies("steve", "n/a", "n/a", "n/a"));
	}

	public String getCSVContent() {
		String data = "first_name, race, country origin, gender\n";
		for(Babies c: List) {
			data += c + "\n";
		}
		return data;
		
	}
	public static void main(String[] args) {
		int counter = 0;
		Scanner n = new Scanner(System.in);
		CatalogueMaker BabyStuff = new CatalogueMaker();
		System.out.println(BabyStuff.getCSVContent());
		System.out.println("Please enter: name ");
		while(counter < 4) {
			//System.out.println("Please enter: "+ field[counter]);
		}
		
	}
	
	public void addNewItem(String name, String race, String country, String gender) {
		List.add(new Babies(name, race, country, gender));
		System.out.println("Item added.");
		getCSVContent();
	}

}
