import java.io.*;
import java.util.Vector;

public class CounterVector {

	public CounterVector() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException 
	{
		//String Text = "";
		if(args.length != 2) {
			System.out.println("Must provide valid input and output files");
			System.exit(0);}
		
		//call the BufferedReader to read through the file
		Reader r = new BufferedReader(new InputStreamReader(
		          new FileInputStream(args[0]), "US-ASCII"));
			
			
		//the placer variable will be used to iterate through the unique characters in the text file
			int placer = 0;
			
		//the LinkedList line is initialized here and will be used to store the contents of the text file as Chars
			Vector<Character> line = new Vector<Character>();
			
		//declare a printwriter class to be used later to print to file
//			PrintWriter writer = new PrintWriter("C:/Users/robin/Documents/projects/CounterLinkedList/src/output.txt", "UTF-8");
			PrintWriter writer = new PrintWriter(args[1], "UTF-8");
		//"output.txt"
		/*
		 * a while statement iterates through the text file and places the contents into the line variable
		 * The toLowerCase() built in java function converts and char characters to lower case and then the built in
		 * JAVA function toCharArray splits the text into a char array
		 * */
			

		
//		Reader r = new BufferedReader(new InputStreamReader(
//		          new FileInputStream("C:/Users/robin/Documents/projects/CounterLinkedList/src/hello.txt"), "US-ASCII"));
		

	
		
		try {
		    int count = 0;
		    int intch;
		    while ((intch = r.read()) != -1) {
		      char ch = (char) intch;
		      line.add(count, ch);
		      if (Character.isLetter(ch)) {
		        count++;
		      }
		      
		    }
		    
		  } finally {
		    r.close();
		  }
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* 
		 * Two for loops are introduced
		 * the outer for loop creates a new characterFrequency class for each character in the data file
		 * 
		 * */
		for (int a=0; a< line.size() ; a++)
		{
			//create a new instance of CharacterFrequency with type Character
				CharacterFrequency<Character> CF = new CharacterFrequency<Character>();
			
			//(i.e if count > 0 it means that the particular element is not the first instance)
			/* 
			 * Initialize a variable to count how many instances of the unique char are present in
			 * the document provided
			 * */
				int count = 0;
			
				for (int b=0; b< line.size() ;b++)
					{
						// pass the char variables through the setter class in our characterFrequency method to store the character
						CF.setCh(line.get(a));
						//compare the current value of the char with the rest of the chars available to see if there is a match
						if (CF.Equals(line.get(a), line.get(b)))
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
		//Close the writer
		writer.close();
		
		System.out.println("Job Complete");
	}//close main Method

}
