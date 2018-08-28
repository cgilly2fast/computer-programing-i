public class AsciiArt{ //this method prints out various numbers of dawgs
   public static void main(String[] args){
      dawgs(3);
      dawgs(2);
      dawgs(1);
   }
   
   public static void dawgs(int n){//prints out Ascii sign pic of n dawgs in a row
         for(int j=1; j<=n;j++){
         System.out.print("           ___    ");
         }
         System.out.println();
         for(int j=1; j<=n;j++){
         System.out.print("   ________| .\\_  ");
         }
         System.out.println();
         for(int j=1; j<=n;j++){
         System.out.print("  /|       |____| ");
         }
         System.out.println();
         for(int j=1; j<=n;j++){
         System.out.print(" / |_______|      ");
         }
         System.out.println();
         for(int j=1; j<=n;j++){
         System.out.print("   | \\     |\\     ");
         }
         System.out.println();
    }
}