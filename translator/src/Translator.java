import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Translator {

	//VARIABLES
	public static HashMap<String, String> dict = new HashMap<String, String>();
	
	//CONSTRUCTOR
	public Translator() throws IOException{
		
		//create buffer reader
		BufferedReader in = new BufferedReader(new FileReader("EnglishToArabicDictionary.txt"));
		
		//go through list and assign map values
		for (String line = in.readLine(); line != null; line = in.readLine()) {	
			
			//remove sof character
			if(line.charAt(0) == 65279) {
				line = line.substring(1);
			}
			
			String nextLine = in.readLine();
			dict.put(line.trim().toLowerCase(), nextLine.trim().toLowerCase());
		}
		
		//close reader
		in.close();
		
		//System.out.println(dict);
		
		run();
	}
	
	//METHODS
	public void run() {
		
		//get the english word typed in console
		Scanner s = new Scanner(System.in);
		String eWord = s.nextLine();
		
		while(eWord != "q") {
			
			//get the arabic translation
			String aWord = dict.get(eWord);
			
			//print the arabic word
			System.out.println("This word in Arabic is " + aWord + "\n");
			
			//get the next english word
			eWord = s.nextLine();
		}
		
	}
	
	
	
	//MAIN
	public static void main(String[] args) throws IOException {
		new Translator();
	}
	
}
