package ca.bcit.comp2613.coursematerial.wow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.log4j.Logger;

/**
 * 
 * @author Henry
 *
 * For those of you who don't know, I am a WoW Addict
 * WoW stands for World Of Warcraft
 * So here's the problem.
 * How powerful are my characters?
 * But before that do:
 * 
 * 1) Modify the Race enum to include HUMAN
 * 2) Implement rollCharacters
 * 3) Sort the characters by level
 * 4) Print out the characters in a readable format
 * 5) Implement checkForHordeSpies
 * 6) Print out the characters again after we remove those pesky Horde spies
 */
public class Wow {

	private Logger log = Logger.getLogger(Wow.class);
	public static void main(String[] args) {
		ArrayList<Character> characters = rollCharacters();
		Comparator<Character> characterComparator = createCharacterComparator();
		Collections.sort(characters, characterComparator);
		printCharacters(characters);
		checkForHordeSpies(characters);
		printCharacters(characters);

	}

	

	

	private static ArrayList<Character> rollCharacters() {
		// TODO create 100 Random Characters with java.util.Random
		// The Race's assigned should be pretty random
		// Each Character's level must be between 0 and 85
		// strength, 0-100
		// armour, 0-100
		return null;
	}
	
	private static Comparator<Character> createCharacterComparator() {
		// TODO compares Characters by level
		return null;
	}
	
	private static void checkForHordeSpies(ArrayList<Character> characters) {
		// TODO loop through each character in the characters list
		// if the character is of Race: HORDE, remove that character from the list
		// and save those to a File and use the Logger as well
		// hint (see checkForAllianceSpies)
		
	}
	
	private static void printCharacters(ArrayList<Character> characters) {
		// TODO Auto-generated method stub
		
	}



}
