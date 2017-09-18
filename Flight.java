/* Flight.java
 * Emily Van Laarhoven
 * Pset 02, Task 2
 * Due: 9/19/19 11:59pm
 */

import java.util.Scanner;

public class Flight {
  
  //instance variables:
  private String airline;
  private int flightNum;
  private String from;
  private String to;
  
  //constructor:
  public Flight (String airline, int flightNum, String from, String to) {
    this.airline = airline;
    this.flightNum = flightNum;
    this.from = from;
    this.to = to;
  }
  
  //toString method:
  public String toString(){
    return "Flight number "+flightNum+" with "+airline+" departs from "+from+" and lands at "+to+".";
  }
  
  //Getters
  public String getAirline(){
    return airline;
  }
  
  public int getFlightNumber() {
    return flightNum;
  }
  
  public String getDestination() {
    return to;
  }
  
  public String getOrigin() {
    return from;
  }
  
  //Setters
  public void setAirline(String newAirline) {
    airline = newAirline;
  }
  
  public void setFlightNumber(int flNum) {
    flightNum = flNum;
  }
  
  public void setDestination(String toCity) {
    to = toCity;
  }
  
  public void setOrigin(String fromCity) {
    from = fromCity;
  }
  
  //instance methods
  static boolean stopOver(Flight f1, Flight f2) {
    return ((f1.getOrigin().equals(f2.getDestination()))||(f1.getDestination().equals(f2.getOrigin())));
  } //do we need to compare whether the origins are equal and destinations are equal as well??
  
  //get user input
  public static Flight readFlight() {
    Scanner scan = new Scanner (System.in);
    //ask for airline name
    System.out.println("Enter in the airline name");
    String readAirline = scan.nextLine();
    //ask for origin
    System.out.println("Enter in the city of origin");
    String readFrom = scan.nextLine();
    //ask for destination
    System.out.println("Enter in the destination city");
    String readTo = scan.nextLine();
    //ask for flight number; store as int
    System.out.println("Enter in the flight number");
    int readFlNum = scan.nextInt();
    //create new Flight object
    return new Flight(readAirline,readFlNum,readFrom,readTo);
  }
  
  //main method
  public static void main (String [] args) {
   //test getting user input and toString method
    Flight f1 = readFlight();
    System.out.println(f1);
    Flight f2 = readFlight();
    System.out.println(f2);
   //test stopOver method
  System.out.println("Is there a stopover in common?  "+stopOver(f1,f2));
  }
}