/**
 * @author David Petrovics
 * Coding exercises from Chapter 1 of "Cracking the Coding Interview"
 */

import java.util.HashMap;

public class ChapterOne {
	
	public static void main(String[] args) {
		//System.out.println(removeDuplicatesBitWay("bbgeebccgccbfab"));
	}
	
	//This works for all ASCII chars (256) so creates a boolean[] with 256 slots.
	public static boolean uniqueChars(String input) {
	    boolean[] chars = new boolean[256];
	    for (int i=0; i<input.length(); i++) {
	    	char a= input.charAt(i);
	    	if (chars[a])
	    		return false;
	    	else
	    		chars[a]=true;
	    }
	    return true;
	}
	
	//this function takes in an input string, with characters A-Z, a-z. No letters or special chars. Uses a single long (8 bytes)
	//ie 64 bits to keep track of characters that have already been seen in the input string. Returns '\n' if there are no unique
	//chars, otherwise it returns the first duplicate char.
	public static char uniqueCharsBit(String input) {
		
		long store=0;
		for (int i=0; i<input.length(); i++) {
			char a = input.charAt(i);
			//test to see if the char is already in the bit vector
			if ((store & (1 << (a-'A'))) != 0)
				return a;
			else //put char into the bit vector
				store = store | (1 << (a-'A'));
		}
		return '\n';
	}
	
	public static boolean uniqueCharsMap(String input) {
		HashMap<Character, Boolean> charmap = new HashMap<Character, Boolean>();
		
		for (int i=0; i<input.length(); i++)
		{
			Character cObj = new Character(input.charAt(i));
			if (charmap.containsKey(cObj))
				return false;
			else
				charmap.put(cObj, Boolean.TRUE);
		}
		return true;
	}
	
	public static String reverse(String input) {
		char[] reversed = new char[input.length()];
		for (int i=input.length()-1; i>=0; i--) {
		    reversed[input.length()-1-i]=input.charAt(i);	
		}
		return new String(reversed);
	}
	
	public static String removeDuplicatesBitWay(String input) {
		char[] res = input.toCharArray();
		int tail=0;
		int bits=0;
		for (int i=0; i<input.length(); i++) {
			char a = input.charAt(i);
			if ( (bits & (1 << (a-'a'))) > 0) { //if bits contains a, we have a duplicate
				System.out.println("Removed: " + a);
			}
			else {//no duplicate, add a 1 bit to the right spot in bits
				System.out.println("no duplicate: " + a);
				bits = (bits | (1 << (a-'a')));
				res[tail]=a;
				tail++;
			}
		}
		
		System.out.println("Bit Vector: " + Integer.toBinaryString(bits));
		
		for (int j=tail; j<res.length; j++) {
			res[j]=0;
		}
		return new String(res);
	}
}
