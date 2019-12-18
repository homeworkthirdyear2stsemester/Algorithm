public class Point {
    public double x;
    public double y;

    public Point(double x, double y) { // x, y를 저장하는 객체
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
