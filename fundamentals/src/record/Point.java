package record;

public class Point {
    private final int x;
    public int getX() {
        return x;
    }

    private final int y;

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Point p = new Point(10, 20);
        System.out.println(p.getX());
        System.out.println(p.getY());
    }
}
