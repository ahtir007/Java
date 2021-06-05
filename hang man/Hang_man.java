import java.io.*;
import java.util.*;
import java.util.Random;
public class Assignment_3 {

    public static void main(String args[]) throws Exception
      {


        String secret_word=search_from_file();
        //System.out.println(secret_word); //Uncomment to see the secret word
        guess_from_user(secret_word);

      }
    static String search_from_file()throws Exception{
        FileReader file = new FileReader("wordlist.txt");
		BufferedReader b = new BufferedReader(file);
		ArrayList<String> list_of_words = new ArrayList<String>();
		String str;
		while ((str=b.readLine())!= null) {
			    if (str.contains(" ")){
			    	System.out.println(str);
			    }
			    else{
			    	list_of_words.add(str);
			    }
			}
		int no_of_words = list_of_words.size();	
		double random = Math.random()*no_of_words-1;
		int random_index = (int)random; 		

        return list_of_words.get(random_index);

      }

      static void guess_from_user(String secret_word)throws Exception{  
        Scanner obj = new Scanner(System.in);
        int no_of_games_in_file=0;
        int total_attempts=0;
        int total_guesses=8;
        int checker=0;
        int count_word_for_dash=secret_word.length();
        ArrayList<Character> array_for_dash = new ArrayList<Character>();
        for (int i=0;i<count_word_for_dash;i++){
        	array_for_dash.add('_');
        }

        System.out.print("Welcome to Hangman!");
        while (true){
        	System.out.print("\nThe word looks like this:");
        	for (int i=0;i<count_word_for_dash;i++){
        			System.out.print(array_for_dash.get(i));			
        }
        System.out.println("\nYou have "+total_guesses+" guesses left.");
        System.out.print("Your guess: ");
        char guess= obj.next().charAt(0);
        if (secret_word.contains(""+guess))
        {
        	    System.out.print("That guess is correct.\n");
        	    total_attempts+=1;	
		        for (int i=0;i<secret_word.length();i++)
		        {
		        	if (secret_word.charAt(i)==guess){
		        		if (array_for_dash.get(i)=='_'){
		        			array_for_dash.set(i,guess);
		        			checker+=1;
		        		}
		        		else{
		        			System.out.println("\nBut you have already entered! You lost 1 guess! Try again");
		        			total_guesses-=1;
		        			total_attempts+=1;
		        			break;
		        		}
		        		
		        		
		        	}
               }
        }
        else{
        	System.out.println("There are no "+guess+ "'s in the word.");
        	total_guesses-=1;
        	total_attempts+=1;

        }
        if (total_guesses==0){
        	System.out.print("\nYou're completely Hung.");
        	System.out.println("\nThe word was: "+secret_word);
        	System.out.println("You lose");
	        File newFile1 = new File("score_card.txt");
	        if (newFile1.length() == 0) 
	        {
	      	newFile1.createNewFile();
		    FileWriter writer = new FileWriter(newFile1,true);
		    writer.write("Game 1 lost\n");
		    writer.flush();
	        writer.close();   
	        break;  	
	   		 } 
	   		else
	   		 {
	   		
	   		FileReader file22 = new FileReader("score_card.txt"); 	
			BufferedReader b = new BufferedReader(file22);
			String str;
			while ((str=b.readLine())!= null) {
				    no_of_games_in_file+=1;
				    }
			File file2 = new File("score_card.txt");	    
			FileWriter writer1 = new FileWriter(file2,true);
			no_of_games_in_file+=1;
		    writer1.write("Game "+(no_of_games_in_file) +" lost\n");
		    writer1.flush();
	        writer1.close();        	

        	break;
             }
         }
        if (checker==secret_word.length()){
        	System.out.print("\nYou guessed the word: ");
        	for (int i=0;i<array_for_dash.size();i++)
        	{
        			System.out.print(array_for_dash.get(i));			
            }
					        System.out.println("\nYou won!");
					        File newFile3 = new File("score_card.txt");
					        if (newFile3.length() == 0) 
					        {
					      	newFile3.createNewFile();
						    FileWriter writer2 = new FileWriter(newFile3,true);
						    writer2.write("Game 1 won-"+total_attempts+" attempts\n");
						    writer2.flush();
					        writer2.close();     	
					   		 } 
					   		else
					   		 {
					        
					        FileReader file44 = new FileReader("score_card.txt"); 
							BufferedReader b = new BufferedReader(file44);
							String str;
							while ((str=b.readLine())!= null) {
								    no_of_games_in_file+=1;
								    }
							File file4 = new File("score_card.txt");	    
							FileWriter writer3 = new FileWriter(file4,true);
							no_of_games_in_file+=1;
						    writer3.write("Game "+no_of_games_in_file+" won-"+total_attempts+" attempts\n");
						    writer3.flush();
					        writer3.close();            
        
                            }






        break;
        }

    }
}
}
        
        
  