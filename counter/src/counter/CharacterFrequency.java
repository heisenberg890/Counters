package counter;

public class CharacterFrequency {
	//declare variables
	private char ch;
	private int frequency = 0;
	private String product = "";
	private char[] line = null;
	private String finale = "";
	//declare setters and getters for incoming chars
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		//make the private variable ch equalled to the char submitted through arguements
		this.ch = ch;
		//add the char characters to a string product in order to store the results before creating the char array, this will be efficient for creating 
		//the char array only once instead of recreating and resizing the char array. This will minimize wasted resources 
		product += ch;
		//create the char array by splitting the product string into individual chars
		line = product.toLowerCase().toCharArray();	
		
	}
	public void setFrequency(int frequency) {
		//set the private variable frequency to the incoming frequency variable
		this.frequency = frequency;
	}
	public int getFrequency() {
		//return the frequency variable
		return frequency;
	}

	
	public void increment() {
		//increment the frequency variable by one
		frequency++;
	}
	
	public boolean Equals(char one, char two) {	
		//take in and compare two chars to see if they are exactly equal
		// if the two chars are equal, return true
			return one == two;
	}
	
	public String ToString(int placeHolder) {
		/*
		 * build the final statement to be written to the output file. 
		 * First the unique char is listed
		 * Second the ASCII number of the char is added to the string
		 * The third phase is to write in the frequency of which the char occurs as set by the getFrequency method
		 */
			finale += line[placeHolder] + " - (" + (int)line[placeHolder] +"): " + getFrequency() + " ";
			//return the finale string
		return finale;
		
	}
	
}//end class CharacterFrequency
