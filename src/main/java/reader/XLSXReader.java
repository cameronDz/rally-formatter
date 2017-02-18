package reader;

public class XLSXReader implements ExtractedDataInterface {

	/**
	 * Takes a formatted ID from rally, that contains integers as well as 
	 * letters, removes the letters, and returns the integer.
	 * http://stackoverflow.com/questions/2338790/get-int-from-string-also-containing-letters-in-java
	 * @param s String that contains desired ID
	 * @return integer that was previously in a String form with attached 
	 * letters
	 */
	private int getIntFromFormattedId(String s) {
		return Integer.parseInt(s.replaceAll("[\\D]", ""));
	}
}
