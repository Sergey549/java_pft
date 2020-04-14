package ru.stqa.pft.sandbox3;

public class PointDistance {


    public static void main(String[] args) {
        Point1 p1 = new Point1(1, 2);
        Point2 p2 = new Point2(2, 3);

        System.out.println("Расстояние между двумя точками Point1 и Point2 = " + distance(p1, p2));
    }

    public static double distance(Point1 p1, Point2 p2) {
        return Math.sqrt((p2.x2 - p1.x1) * (p2.x2 - p1.x1) + (p2.y2 - p1.y1) * (p2.y2 - p1.y1));

    }

}



