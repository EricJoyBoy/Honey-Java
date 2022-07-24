package usingObjects;

public class CreateObjectDemo {

    public static void main(String[] args) {
        
        // Declare and create a point object and two rectangle objects.
        Point originOne = new Point(23, 94); // originOne is a Point object
        Rectangle rectOne = new Rectangle(originOne, 100, 200); // rectOne is a Rectangle object
        Rectangle rectTwo = new Rectangle(50, 100); // rectTwo is a Rectangle object
        
        // display rectOne's width, height, and area
        System.out.println("Width of rectOne: " + rectOne.width); 
        System.out.println("Height of rectOne: " + rectOne.height);
        System.out.println("Area of rectOne: " + rectOne.getArea());
        
        // set rectTwo's position
        rectTwo.origin = originOne; // rectTwo's origin is now the same as originOne
        
        // display rectTwo's position
        System.out.println("X Position of rectTwo: " + rectTwo.origin.x); // rectTwo's origin is now the same as originOne
        System.out.println("Y Position of rectTwo: " + rectTwo.origin.y); // rectTwo's origin is now the same as originOne
        
        // move rectTwo and display its new position
        rectTwo.move(40, 72);// rectTwo's origin is now 40, 72
        System.out.println("X Position of rectTwo: " + rectTwo.origin.x); // rectTwo's origin is now 40, 72
        System.out.println("Y Position of rectTwo: " + rectTwo.origin.y); // rectTwo's origin is now 40, 72
    }
}
