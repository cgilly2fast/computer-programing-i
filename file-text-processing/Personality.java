// Colby Gilbert
// 11/16/2014
// TA: Michlle Cho
// 1362877
// Assignmnt #7
//
// this program calculates the score of a list of peoples scores on the 
// kiersey personailty test, then outputs a list of results to a spciefied 
// file

import java.util.*;
import java.io.*;

public class Personality {
   public static final int NUM_CATEGORIES = 4;
   
   // this method initailizes vairablea and arrays nessacary for computing the indivuals 
   // scores,  
   public static void main(String[] args)  throws FileNotFoundException {
      String[] file = new String[2];
      Scanner console = new Scanner(System.in);
      int[] countA = new int[NUM_CATEGORIES];
      int[] countB = new int[NUM_CATEGORIES];
      int[] percentB = new int[NUM_CATEGORIES];
      String[] leftAnswers = {"E", "S", "T", "J"};
      String[] rightAnswers = {"I", "N", "F", "P"};
      String[] answerB = new String[70];
      
      giveIntro();
      Scanner input = promptInputFiles(console, file);
      PrintStream output = new PrintStream(new File(file[1]));
      while(input.hasNextLine()) {
         String answers = toAnswersString(input, output);
         countsAB(answers, countA, countB);
         calcPercentB(countA, countB, percentB, output);
         outputType(percentB, leftAnswers, rightAnswers, output);
      }
   }
   
   // this method shows gives the user instruction on how to use this program
   public static void giveIntro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter.  It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   // promptOutputFile method takes in the parameters of a scanner console 
   // to allow the user to type a responses of  input/output file they would 
   // like to have the program use and the parameter string[] array to store the
   // user response for use later in the program 
   public static Scanner promptInputFiles(Scanner console, String[] file) 
                                          throws FileNotFoundException {
      for (int i = 0;  i < 2; i++) {
         if(i == 0){
            System.out.print("input file name? ");
            
         } else {
            System.out.print("output file name? ");
         }
         file[i] = console.next();
      }
      Scanner input = new Scanner(new File(file[0]));   
      return input;
   }
   
   // takes input in and prints out the name of person with the "PrintStream output" 
   // parameter to the user spiceified outputfile and returns the string that contains 
   // the person's answers  
   public static String toAnswersString(Scanner input, PrintStream output) {
      output.print(input.nextLine() + ": ");
      return input.nextLine();
   }
   
   // tailing of each answer and what catagory of question it answers
   // method: takes in the answer string, and 2 arrays for counting answers
   public static void countsAB(String answers, int[] countA, int[] countB) {
      int index = -1;
      for(int j = 0; j < countA.length; j++) {
         countA[j] = 0;
         countB[j] = 0;
      }   
      for(int i = 0; i < answers.length(); i++) {
         if( ((i + 1) % 7) == 0) {
            index = 3; 
         } else {
            index = ((i + 1) % 7) / 2;
         }
         if(answers.toLowerCase().charAt(i) == 'a'){
            countA[index]++;
         } else if(answers.toLowerCase().charAt(i) == 'b') { 
            countB[index]++;
         }
      }   
   }
   
   // calculates the percent of b answers per catagory of question
   // method: takes in the counts of A and B questions and an array for storing 
   // the percent B scores, the "PrintStream output" parameter is used to print 
   // results to the user specified output file
   public static void calcPercentB(int[] countA, int[] countB, int[] percentB,
                                   PrintStream output) {
      for(int i = 0; i < countB.length; i++) {
        percentB[i] = (int) Math.round(countB[i] / (double)(countA[i] + 
                                       countB[i]) *100);
      }
      output.print(Arrays.toString(percentB));    
   }
   
   // this method use the inputs of the percent of b answers and all possible 
   // catagories the detemines what catagories the person falls under the 
   // "PrintStream output" parameter is used to print results to the user specified output file 
   public static void outputType(int[] percentB, String[] leftAnswers, 
                                 String[] rightAnswers, PrintStream output) {
      String type = "";
      for(int i = 0; i < percentB.length; i++) { 
         if(percentB[i] > 50) {
            type = type + rightAnswers[i];
         } else if (percentB[i] == 50) {
            type = type + "X";
         } else {
            type = type + leftAnswers[i];
         }
      }
      output.println(" = " + type);
   }
}                        