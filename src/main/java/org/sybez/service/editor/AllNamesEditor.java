package org.sybez.service.editor;

public class AllNamesEditor {

	public static String toFirstCapitalLetter(String string){
		StringBuilder newString = new StringBuilder();
		newString.append(string.substring(0,1).toUpperCase());
		newString.append(string.substring(1).toLowerCase());
		return newString.toString();
	}
}
