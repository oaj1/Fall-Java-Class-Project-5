import java.util.Scanner;

public class AuthoringAssistant {
   
   public static void main(String[] args) {
      /* Type your code here. */
      
      Scanner scnr = new Scanner (System.in); // scanner object to read in text      
      System.out.println("Enter a sample text: ");// prompt user
      String userText = scnr.nextLine (); // used to read in the line

      System.out.println();// create a space
      System.out.println ("You entered: " + userText);//show user what they entered
      
      char optionChoice=printMenu();//user selects the option of their choice
      
      switch (optionChoice){
      
      case 'c':
      int actualNumber = getNumOfNonWSCharacters(userText); // pass userText as the arguement to be trimmed
      System.out.println("c");//let user know they picked option c
      //now print out the actual number of characters
      System.out.println("Number of characters with no white space characters: " + actualNumber );
      break;
      
      
      case 'w':
      int NumberOfWords = getNumOfWords(userText);
      System.out.println("w");
      //int actualNumber = getNumOfWords(userText); //pass userText as the arguement to find num of words in the string
      System.out.println("Number of words: " + NumberOfWords);
      break;
      
      case 'q':
         System.out.println ("quitting");
         break;
      
      case 'f':
         System.out.println("Enter word for count: ");//prompt user for word
         String word = scnr.nextLine();//read in word
         System.out.println(word); //print the word for viewing
         //now create a variable to hold the integer number of that word in text by calling the findText method
         int wordMatchNumber = findText(userText, word);//call the method
         //print results     
         System.out.println(word + "instances: " + wordMatchNumber);
      
      case 'r':
         String replaceText = replaceExclamation(userText); //call method with user text as the arguement as this is what is edited
         System.out.println ("Edited: " + replaceText);//print modified text
         break;
         
      case 's':
         String shortenText = shortenSpace (userText);
         System.out.println ("Shortened: " + shortenText);
         break;
      }
      
      
      
      
      }
      
      //this method will return the number of non white spaces
      public static int getNumOfNonWSCharacters(String text){
      
      text = text.trim().replaceAll("\\s",""); // this code gets rid of all white spaces
      
      //now I want to return the length of the text with no white space      
      return text.length();
      
      
      } 
      
      public static int getNumOfWords(String text){
      
      //first thing I want to do is create an array to hold hold all the words separated by 
      String [] numOfWords = text.split(" ");//splits on space
      return numOfWords.length;//returns the number of words used due to splitting of words at blank spaces
      
      }
      
      public static int findText(String text, String Word){
      //i will answer this question by creating a for loop and counter variable that will update
      int i = 0;//used for index
      int wordCounter = 0; //word counter variable that will update on each find
      // create an array to hold all text words
      String [] wordsInText = text.split(" ");
      
      //loop through text and add to word counter for any matches
      for (i=0; i <wordsInText.length ; ++i){
         if ( wordsInText[i].equals(Word)){
         wordCounter +=1;
         }
      
      }
      return wordCounter; //return number of word matches
      }
      
      public static String replaceExclamation (String text){
         
         text = text.replaceAll ("!", ".");//replace ! with .
         return text;//return modified text
      
      }
      
      public static String shortenSpace (String text){
         text = text.trim().replaceAll("\\s+"," "); //this code removes one space
         return text;//return modified text
      }
            
      public static char printMenu(){
      Scanner scanner = new Scanner (System.in);
      
      System.out.println("\nMENU");
       System.out.println("c - Number of non-whitespace characters");
       System.out.println("w - Number of words");
       System.out.println("f - Find text");
       System.out.println("r - Replace all !'s");
       System.out.println("s - Shorten spaces");
       System.out.println("q - Quit");

       System.out.println("\nChoose an option: ");


       char choice=scanner.nextLine().charAt(0);

       return choice;
      }
      
      }      