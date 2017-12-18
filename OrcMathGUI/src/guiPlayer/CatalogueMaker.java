package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
		BabyStuff.testSaveContent("test1.csv");
		
		/*System.out.println("Please enter: name ");
		while(counter < 4) {
			//System.out.println("Please enter: "+ field[counter]);
		}*/
	}
	
	public void addNewItem(String name, String race, String country, String gender) {
		List.add(new Babies(name, race, country, gender));
		System.out.println("Item added.");
		getCSVContent();
	}
	
	public void testSaveContent(String fileName) {
		try{    
			FileWriter fw=new FileWriter(fileName);
			for(Babies b: List) {
				fw.write(b + "\n");
			}   
			fw.close();    
			System.out.println("Success! File \""+fileName+"\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}    
	}
	
	private static List<String> testFileLoading() {
		Scanner in = new Scanner(System.in);
		String fileName = "";
		List<String> content = new ArrayList<String>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Open what?");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read teh file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {
					String[] param = line.split(",");
					content.add(line);
					
				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		//close the Scanner
		in.close();
		return content;
	}

}
