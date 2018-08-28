0&2// Colby Gilbert
// 11/5/2014
// TA: Michlle Cho
// 1362877
// Assignmnt #6
//
// this program prompts for a name and gender and shows its rank
// in the top 1000 baby names complied every 10 years and then displays
// the data in a graph 
         
import java.util.*;
import java.io.*;
import java.awt.*;
// NUMDECADES is the number of decades back in time the user desires to 
// see data on the name, STARTYEAR calcultes and stores thsi value HORIZWIDTH
// is the width in pixels each piont (decade) is away fromeach other
public class Names {
   public static final int NUMDECADES = 14;
   public static final int STARTYEAR = 2010 - (NUMDECADES-1) * 10;
   public static final int HORIZWIDTH = 70;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("names.txt"));
      Scanner console = new Scanner(System.in);
     
      
      giveIntro();
      String phrase = promptName(console);
      String line = find(phrase, input);
      if (line.length() > 0) {
         DrawingPanel panel = new DrawingPanel(HORIZWIDTH * NUMDECADES,550);
         Graphics g = panel.getGraphics();
         drawPanel(g);
         drawLines(line, g);
      } else {
         System.out.println("name/gender comination not found");       
      }
   }   
   // gives user an intro of the program and how it works
   public static void giveIntro () {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since 1920.");
      System.out.println();
   } 
   // this method askes the user for the name and gender they would 
   // like to search  
   public static String promptName(Scanner console) {
      System.out.print("name? ");
      String name = console.nextLine().toLowerCase();
      System.out.print("gender (M or F)? ");
      String gender = console.nextLine().toLowerCase();
      String phrase = name + " " + gender;
      return phrase;
   }
   // method finds the name the user denotes, if it exists   
   public static String find(String phrase, Scanner input) {
      while (input.hasNextLine()) {
         String line = input.nextLine();
         Scanner line1 = new Scanner(line);
         Scanner phrase1 = new Scanner(phrase);
         if (line1.next().toLowerCase().equals(phrase1.next().toLowerCase()) && 
             line1.next().toLowerCase().equals(phrase1.next().toLowerCase())){
            return line;
         }
      }
      return "";
   }
   // this method uses the data that comes with the name and draws the actual 
   // lines, name and rank each decade on the graph 
   public static void drawLines(String line, Graphics g) {
      Scanner data = new Scanner(line);
      int xValue = -1;
      int yValue = -1;
      int xValuePrevious = -1;
      int yValuePrevious = -1;
      int count = -1;
      int rank = -1;
      String name = data.next() + " " + data.next()+ " ";
       
      while (data.hasNextInt() && count < NUMDECADES - 1) {
         rank = data.nextInt();
         g.setColor(Color.RED);
         if (rank == 0) {
            yValue = 525;
         } else {
            yValue = computeX(rank);      
         }
         count++;
         xValue = HORIZWIDTH * count;
         g.drawString(name +rank, xValue, yValue);
         if(xValuePrevious != -1 && yValuePrevious != -1) {
            g.drawLine(xValuePrevious, yValuePrevious, xValue, yValue);
         }    
         xValuePrevious = xValue;
         yValuePrevious = yValue;
       }
   }     
   // formula for the taking the rank of the baby name 1-1000 and converting 
   // it to the x cooridnate of the graph   
   public static int computeX(int rank) {
      return ((rank + 1) / 2) + 24;
   } 
   // this creates the graph/window that the graph will appear on 
   public static void drawPanel(Graphics g) {
      int year = STARTYEAR;
      g.setColor(Color.BLACK);
      g.drawLine(0, 25, HORIZWIDTH * NUMDECADES, 25);
      g.drawLine(0, 525, HORIZWIDTH * NUMDECADES, 525);
      for(int i = 0; i < NUMDECADES; i++) {
         g.drawLine(i * HORIZWIDTH, 0, i * HORIZWIDTH, 550);
         g.drawString("" + year, i * HORIZWIDTH, 550);
         year += 10;
       }
   }
}    