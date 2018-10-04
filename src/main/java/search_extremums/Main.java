package search_extremums;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ExceptionZero {
        double value = -3.56, step = 1e-3d, ε = 1e-8d;
        double answer = 0, enter;
        boolean flag = true;
        Point2D fAlpha = new Point2D();
        Point2D fBeta = new Point2D();
        Point2D fGamma = new Point2D();
        Point2D pExtr = new Point2D();

        Scanner scan = new Scanner(System.in);
        System.out.println( "1 - scan values from terminal\n" +
                            "2 - read values from file\n" +
                            "other - default values");
        enter = scan.nextInt();
        if (enter == 1) {
            System.out.println("enter begin value, step, epsilon : ");
            value = scan.nextDouble();
            step = scan.nextDouble();
            ε = scan.nextDouble();
        } else if (enter == 2) {
            System.out.println("Read values from file...");
            FileInputStream fis = new FileInputStream("D:\\qi5\\quadraticInterpolation\\keeper.txt");
            Scanner read = new Scanner(fis);
            double[] arr = new double[3];
            int i = 0;

            while (true) {
                if (read.hasNextDouble()) {
                    arr[i] = read.nextDouble();
                    i++;
                }
                if (read.hasNext()) read.next();
                else break;
            }

            value = arr[0];
            step = arr[1];
            ε = arr[2];
            System.out.println("Successful : " + value + " " + step + " " + ε);
        }

        Extremum extremum = new Extremum();

        pExtr = extremum.search(value, step, ε);
        Point2D p2 = extremum.searchForParabola();

        System.out.println("parabola : " + p2);
        System.out.println("min " + pExtr);
    }
}

