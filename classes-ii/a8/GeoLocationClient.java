// Colby Gilbert
// 11/26/2014
// TA: Michlle Cho
// 1362877
// Assignmnt #8
//
// this program creates 3 geo location objects and use them 
// to find the distance between them

public class GeoLocationClient {
   public static void main(String[] args){
      GeoLocation stash = new GeoLocation(34.988889,-106.614444);
      GeoLocation studio = new GeoLocation(34.989978,-106.614357); 
      GeoLocation fbi = new GeoLocation(35.131281,-106.61263);
      
      System.out.println("the stash is at latitude: " + stash.getLatitude() + ", longitude: " + stash.getLongitude());
      System.out.println("ABQ studio is at latitude: " + studio.getLatitude() + ", longitude: " + studio.getLongitude());
      System.out.println("FBI building is at latitude: " + fbi.getLatitude() + ", longitude: "+  fbi.getLongitude());
      System.out.println("distance in miles between:");
      System.out.println("    stash/studio = " + stash.distanceFrom(studio));
      System.out.println("    stash/fbi    = " + stash.distanceFrom(fbi));
   }
}   