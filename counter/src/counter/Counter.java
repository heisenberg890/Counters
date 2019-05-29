package counter;

import java.io.*;
import java.util.Scanner;
public class Counter 
{
	public static void main(String[] args) throws IOException 
	{
		//String Text = "";
		if(args.length != 2) {
			System.out.println("Must provide valid input and output files");
			System.exit(0);}
		
		//call the BufferedReader to read through the file
			Scanner scanner = new Scanner(new File(args[0]),"utf-8");
			
			
		//the placer variable will be used to iterate through the unique characters in the text file
			int placer = 0;
			
		//the char array line is initialized here and will be used to store the contents of the text file as an array of chars
			char[] line = null;
			
		//declare a printwriter class to be used later to print to file
			PrintWriter writer = new PrintWriter(args[1], "UTF-8");
		//"output.txt"
		/*
		 * a while statement iterates through the text file and places the contents into the line variable
		 * The toLowerCase() built in java function converts and char characters to lower case and then the built in
		 * JAVA function toCharArray splits the text into a char array
		 * */
		while(scanner.hasNext()) 
		{
			line = scanner.nextLine().toLowerCase().toCharArray();			
		}
		
		/* 
		 * Two for loops are introduced
		 * the outer for loop creates a new characterFrequency class for each character in the data file
		 * 
		 * */
		for (int a=0; a< line.length ; a++)
		{
			//create a new instance of CharacterFrequency
				CharacterFrequency CF = new CharacterFrequency();
			
			//(i.e if count > 0 it means that the particular element is not the first instance)
			/* 
			 * Initialize a variable to count how many instances of the unique char are present in
			 * the document provided
			 * */
				int count = 0;
			
				for (int b=0; b< line.length ;b++)
					{
						// pass the char variables through the setter class in our characterFrequency method to store the character
						CF.setCh(line[a]);
						//compare the current value of the char with the rest of the chars available to see if there is a match
						if (CF.Equals(line[a], (line[b])))
							{
									//if there is a match, call the increment class within Character frequency to increment the frequency variable
									CF.increment();
									if(a>b)
										{
											/*
											 * if the count from the initial loop is greater than the count 
											 * from the current loop, increment the count variable to continue the current loop
											 * */
												count++;
										}//endif
							}//endif  	
					}//endif
			/*
			 * if the count variable has not been incremented during the previous phase, print the result of the ToString method from the 
			 * Character Frequency class to an outputted text file with the name output.txt
			 */
			if (count==0)
				{  
				//add the end result to a string to print to the console
					//Text += CF.ToString(placer)  + "\n";
				//write the result to an output text file
					writer.println(CF.ToString(placer));

					
					
					
				}//close if statement
			// increment the placer variable in order to move on to the next character
			placer++;
		}//end for loop
		//Print to the console as well for testing
		//System.out.println(Text);
		writer.close();
		scanner.close();//close scanner
		
		System.out.println("Job Complete");
	}//close main Method
	
}//close class
	



