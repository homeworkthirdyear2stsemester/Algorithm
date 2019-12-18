public class Point implements Comparable<Point> {
    int number;
    String data;

    public Point(int number, String data) {
        this.number = number;
        this.data = data;
    }

    @Override
    public String toString() {
        return number + ", " + data;
    }

    @Override
    public int compareTo(Point point) {
        if (this.number > point.number) {
            return 1;
        } else if (this.number < point.number) {
            return -1;
        }
        return 0;
    }
}
