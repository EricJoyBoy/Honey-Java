package usingObjects;

public class Rectangle { //classe Rectangle
    public int width = 0; // attributo width
    public int height = 0; // attributo height
    public Point origin; // attributo origin
 
    // four constructors
    public Rectangle() { //
    origin = new Point(0, 0);
    }
    public Rectangle(Point p) {
    origin = p;
    }
    public Rectangle(int w, int h) {
    origin = new Point(0, 0);
    width = w;
    height = h;
    }
    public Rectangle(Point p, int w, int h) { //   construtor com parametros
    origin = p;
    width = w;
    height = h;
    }
 
    // a method for moving the rectangle
    public void move(int x, int y) { // metodo move
    origin.x = x;
    origin.y = y;
    }
 
    // a method for computing the area of the rectangle
    public int getArea() { // metodo getArea
    return width * height;
    }
}
