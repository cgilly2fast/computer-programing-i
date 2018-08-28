// Colby Gilbert
// 11/26/2014
// TA: Michlle Cho
// 1362877
// Assignmnt #8
//
// This class stores information about a place on Earth.  Locations are
// specified using name of building, address, tags for a defining what 
// kind of place it islatitude and longitude.  The class includes a 
// method for computing the distance between two locations.

public class PlaceInformation extends GeoLocation {

   private String name;
   private String address;
   private String tag; 
     
   // constructs a place information object with given name, address, tag,
   // latitude, longitude
   public PlaceInformation (String name, String address, String tag, double latitude, double longitude){
      super(latitude, longitude);
      this.name = name;
      this.address = address;
      this.tag = tag;
   }
   
   // returns the name of this place                            
   public String getName(){
      return name;
   }   
   
   // returns the address of this place 
   public String getAddress(){
      return address;
   }
   
   // returns the tag of this place    
   public String getTag() {
      return tag;
   }
   
   // returns a string representation of this place   
   public String toString() {
      return name + " (latitude: " + getLatitude() + ", longitude: " + getLongitude() + ")";
   }
   
   // returns a reference to the geo location of theis place
   public GeoLocation getLocation() {
      GeoLocation place = new GeoLocation(getLatitude(), getLongitude());
      return place; 
   } 
   // returns the distance from an other place  
   public double distanceFrom(GeoLocation spot){
      return super.distanceFrom(spot);
   }   
}