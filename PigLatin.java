/** Program: PigLatin converter
 * File: PigLatin.java
 * Summary: Reads text from a file and changes the words in it to piglatin
 * Author: Richard Boyd
 * Date: December 17th, 2017
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class PigLatin {

	public static void main(String[] args) throws IOException {
		String input = new String(Files.readAllBytes(Paths.get("input.txt")));  //reads the .txt file into a string
		String[] split = input.split(" ");  //Splits the string into an array of separate words
		String pig;
		int length = split.length, count = 0; //finds how many words are in the array and sets up loop counter
		while (count != length) {  //loop that calls the convert method until it has converted all the words
			pig = (convert(split[count])).toUpperCase();
			System.out.printf("%-20s%-20s\n", split[count], pig);
			count++;
		}
	}	
	
	public static String convert(String word) {  //method that takes a word and translates it to pig latin
		boolean vowel = false;
		int charcount = 0;
		String pig;
		while (vowel == false) {
			char test = Character.toLowerCase(word.charAt(charcount));
			if (test == 'a' || test == 'e' || test == 'i' || test == 'o' || test == 'u') {
				vowel = true;
			}
			
			else {
				charcount++;
			}
		}
		
		if (charcount == 0) {
			pig = word + "way";
		}
		
		else {
			String first = word.substring(0, charcount);
			String last = word.substring(charcount);
			pig = last + first + "ay";
		}
		
		return pig;
	}

}