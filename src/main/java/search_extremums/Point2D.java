package search_extremums;

import java.util.Objects;

public class Point2D {
    private double x, y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        x = 0;
        y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return Double.compare(point2D.x, x) == 0 &&
                Double.compare(point2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return  "(" + x +
                ", " + y + ')';
    }

    public static Point2D difference(Point2D p1, Point2D p2) {
        Point2D newPoint = new Point2D();
        newPoint.setX(p1.getX() - p2.getX());
        newPoint.setY(p1.getY() - p2.getY());
        return newPoint;
    }
}
