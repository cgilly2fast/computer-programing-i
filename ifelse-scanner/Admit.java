// Colby Gilbert
// 10/21/2014
// TA: Michelle Cho
// CSE 142: Assignment 4
//
// this program takes two peoples SAT or ACT score and wieghted GPA
// and converts them a standard scoreing system then 
// compares the two to see which is more qualified to be 
// accepted. this would likely be used to compare propective
// CSE mojars :D


import java.util.*;

public class Admit {
   public static void main(String[] args) { 
      giveIntro();
      Scanner console = new Scanner(System.in);
      double results1 = infoApp1(console);
      double results2 = infoApp2(console);
      results(results1, results2);
   }
   
   // Intro to user what this program does
   public static void giveIntro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   // This method conducts the gathering of information from appilcant 1
   // and converts it to the standard score
   public static double infoApp1(Scanner console) {
      System.out.println("Information for applicant #1:");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int b = console.nextInt();
      double examScore = 0;
      if ( b == 1) {
         examScore = promptSAT(console);
      } else {
         examScore = promptACT(console);
      }
      System.out.printf("    exam score = %.1f\n", examScore);
      double scoreGPA = promptGPA(console);
      System.out.printf("    GPA score = %.1f\n", scoreGPA);
      System.out.println();
      return examScore + scoreGPA;
   }
   
   // This method conducts the gathering of information from appilcant 2
   // and converts it to the standard score
   public static double infoApp2(Scanner console) {
      System.out.println("Information for applicant #2:");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int b = console.nextInt();
      double examScore = 0;
      if ( b == 1) {
         examScore = promptSAT(console);
      } else {
         examScore = promptACT(console);
      }
      System.out.printf("    exam score = %.1f\n", examScore);
      double scoreGPA = promptGPA(console);
      System.out.printf("    GPA score = %.1f\n", scoreGPA);
      System.out.println();
      return examScore + scoreGPA;
   }
   
   // this method tells the user the two converted scores and the compares them 
   public static void results(double results1, double results2) {
      System.out.printf("First applicant overall score  = %.1f\n", results1);
      System.out.printf("Second applicant overall score = %.1f\n", results2);
      if(results1 > results2) {
         System.out.print("The first applicant seems to be better");
      } else if(results1 == results2) {
         System.out.print("The two applicants seem to be equal");
      } else {
         System.out.print("The second applicant seems to be better");
      }
   }
   
   // This method is what the infoApp1/infoApp2 use to gather ACT scores
   // then compute standardized ACT score,if that is what the applicate took
   public static double promptACT(Scanner console) {
      System.out.print("    ACT English? ");
      int english = console.nextInt();
      System.out.print("    ACT math? ");
      int mathACT = console.nextInt();
      System.out.print("    ACT reading? ");
      int readingACT = console.nextInt();
      System.out.print("    ACT science? ");
      int science = console.nextInt();
      return convertACT(mathACT, readingACT, science, english);
   }
     
   // This method is what the infoApp1/infoApp2 use to gather SAT scores
   // then compute standardized SAT score, if that is what the applicate took.
   public static double promptSAT(Scanner console) {  
      System.out.print("    SAT math? ");
      int mathSAT = console.nextInt();
      System.out.print("    SAT critical reading? ");
      int readingSAT = console.nextInt();
      System.out.print("    SAT writing? ");
      int writing = console.nextInt();
      return convertSAT(mathSAT, readingSAT, writing);
   }
   
   // This method is what the infoApp1/infoApp2 use to gather weighted GPA
   // then compute standardize GPA score. 
   public static double promptGPA(Scanner console) {
      System.out.print("    overall GPA? ");
      double actualGPA = console.nextDouble();
      System.out.print("    max GPA? ");
      double maxGPA = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double multiplier = console.nextDouble();
      return convertGPA(actualGPA, maxGPA, multiplier);
   }
   
   // this method does the actual math of computing standardized SAT score
   // by taking the the applicants math SAT, critcal reading SAT score
   // and writing SAT score.
   public static double convertSAT(int mathSAT, int readingSAT, int writing) {
      return ((2 * mathSAT + readingSAT + writing) / 32.0);
   }
   
   // this method does the math for computing standardized ACT score
   // by taking the the applicants recieved math ACT, reading ACT score,
   // Science ACT score, and english ACT score.
   public static double convertACT(int mathACT, int readingACT, int science, 
                                   int english) {
      return ((english + 2 * mathACT + readingACT + science) / 1.8);
   }
   
   // this method does the actual math of computing standardized GPA score
   // by taking in the inputs of the applicants recived GPA, max possible GPA 
   // and the advisors given Transcript multplier.
   public static double convertGPA(double actualGPA, double maxGPA, 
                                   double multiplier) {
      return ((actualGPA/maxGPA) * 100 * multiplier);
   }
}