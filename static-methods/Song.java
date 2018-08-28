// Colby Gilbert
// 10/1/2014
//CSE142
//TA: Michelle Cho
// Assingment 1
// 
//This porgram outputs the lyrics of a song

public class Song {
   public static void main(String[] args){
      verse1();
      verse2();
      verse3();
      verse4();
      verse5();
      verse6();
      verse7();
   } 
   public static void verse1() {
      System.out.println("There was an old woman who swallowed a fly.");
      endVerse1();
   }
   public static void verse2() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      endVerse2();
   }
   public static void verse3() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      endVerse3();
   }
   public static void verse4() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      endVerse4();
   }
   public static void verse5() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      endVerse5();
   }
   public static void verse6() {
      System.out.println("There was an old woman who swallowed a monkey,");
      System.out.println("What a donkey to swallow a monkey.");
      endVerse6();
   }
   public static void verse7() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   public static void endVerse1() {
      whyFly();
      die();
      space();
   }
   public static void endVerse2() {
      spiderCause();
      endVerse1();
   }
   public static void endVerse3() {
      birdCause();
      endVerse2();
   }
   public static void endVerse4() {
      catCause();
      endVerse3();
   }
   public static void endVerse5() {
      dogCause();
      endVerse4();
   }
   public static void endVerse6() {
      monkeyCause();
      endVerse5();
   }
   public static void whyFly() {
      System.out.println("I don't know why she swallowed that fly,");
   }
   public static void die() {
      System.out.println("Perhaps she'll die.");
   }
   public static void space() {   
      System.out.println();
   }
   public static void spiderCause() {
      System.out.println("She swallowed the spider to catch the fly,");
   }
   public static void birdCause() {
      System.out.println("She swallowed the bird to catch the spider,");
   }
   public static void catCause() {
      System.out.println("She swallowed the cat to catch the bird,");
   }
   public static void dogCause() {
      System.out.println("She swallowed the dog to catch the cat,");
   }
   public static void monkeyCause() {
      System.out.println("She swallowed the monkey to catch the dog");
   }

}
