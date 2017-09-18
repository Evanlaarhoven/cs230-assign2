/* Point.java
 * Emily Van Laarhoven
 * Pset 02, Task 1
 * Due: 9/19/19 11:59pm
 */

import java.util.Scanner;

public class Point {
  
  //instance variables:
  private double xCoord;
  private double yCoord;
  
  //constructor:
  public Point (double xCoord, double yCoord) {
    this.xCoord = xCoord;
    this.yCoord = yCoord;
  }
  
  //toString method:
  public String toString(){
    return "The point is ("+xCoord+","+yCoord+").";
  }
  
  //Getters
  public double getX(){
    return xCoord;
  }
  
  public double getY() {
    return yCoord;
  }
  
  //Setters
  public void setX(double newX) {
    xCoord = newX;
  }
  
  public void setY(double newY) {
    yCoord = newY;
  }
  
  //instance methods
  public double findDistance(Point other) {
    double dist = Math.sqrt(Math.pow((other.getX()-this.getX()),2)+Math.pow((other.getY()-this.getY()),2)); 
  return dist;
  }

public boolean areEquidistant(Point p2,Point p3) {
  final double tolerance = 0.01;
  return (Math.abs(((this.findDistance(p2)-this.findDistance(p3))))<tolerance); //return true when |d(p1,p2)-d(p1,p3)|<0.01
}

//ask for user input
public static Point readPoint(){
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter in the x-coordinate");
  Double readX = scan.nextDouble();
  System.out.println("Enter in the y-coordinate");
  Double readY = scan.nextDouble();
  return new Point(readX,readY);
}

//main method
public static void main(String[] args) {
  //create some points with user input
  Point p1 = readPoint();
  Point p2 = readPoint();
  Point p3 = readPoint();
  //testing toString()
  System.out.println(p1);
  System.out.println(p2);
  System.out.println(p3);
  //testing areEquidistant (uses the findDistance method)
  System.out.println("The distance between p1 and p2 is "+p1.findDistance(p2));
  System.out.println("The distance between p2 and p3 is "+p2.findDistance(p3));
  System.out.println("The distance between p2 and p3 is "+p3.findDistance(p1));
  System.out.println("Are p2 and p3 equidistant from p1?  "+p1.areEquidistant(p2,p3));
  System.out.println("Are p1 and p3 equidistant from p2?  "+p2.areEquidistant(p3,p1));
  System.out.println("Are p1 and p2 equidistant from p3?  "+p3.areEquidistant(p1,p2));  
}
  
}