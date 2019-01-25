package SpellChecker;

/**
 * Author: Thomas Tavarez
 * Date: 1/24/19
 * Program Name: Tavarez_SpellChecker
 * Purpose: To check for misspelled words 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tavarez_SpellChecker 
{
	public static void main (String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		// Read the file to check
		System.out.print("Enter in your file to check:");
		String fileToCheck = scanner.next();
		String fileText = ReadFile(fileToCheck);
		
		// Read the dictionary file
		System.out.print("Enter the dictionary file");
		String dictionaryFile = scanner.next();
		String dictionaryText = ReadFile(dictionaryFile);
		
		scanner.close();
		
		// Separate each word in the files
		ArrayList<String> fileWords = new ArrayList<>(Arrays.asList(fileText.split("\n")));
		ArrayList<String> dictionaryWords = new ArrayList<>(Arrays.asList(dictionaryText.split("\n")));
		
		// Check for words that do not exist in the dictionary file
		for(String s : fileWords) {
			if(!dictionaryWords.contains(s)) {
				System.out.println("Word not found: " + s);
			}
		}
	}
	
	private static String ReadFile(String fileName) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		// The text in the file
		String fileText = "";
		
		try {
			String line = br.readLine();
			
			// Read each line in the file and enter a new line to separate the words later
			while(line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			
			fileText = sb.toString();
		}
		finally {
			br.close();
		}
		
		return fileText;
	}
}
