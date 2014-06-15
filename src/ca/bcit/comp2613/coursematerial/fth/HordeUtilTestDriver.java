package ca.bcit.comp2613.coursematerial.fth;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import ca.bcit.comp2613.coursematerial.day02.model.Teacher;

public class HordeUtilTestDriver {

	public static void main(String[] args) throws Exception {
		ArrayList<Character> characters = HordeUtil.create100HordeCharacters();
		String characterArrayListAsString =  HordeUtil.getCharacterArrayListAsString(characters);
		HordeUtil.saveCharactersToXMLFile(characterArrayListAsString);
	}

}
