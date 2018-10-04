package search_extremums;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExtremumTest {

    private static final double step0 = 0.5, value0 = 1, epsilon0 = 0.005;
    private static final double step1 = 0.01, value1 = 1.433, epsilon1 = 0.0001;
    private static final double step2 = 0.001, value2 = -5.8, epsilon2 = 0.00001;
    private static final double step3 = 0.15, value3 = 2.845, epsilon3 = 0.0001;

    @Test
    public void searchMin() throws ExceptionZero {
        Extremum extremum = new Extremum();
        Point2D point1 = extremum.search(step0, value0, epsilon0);
        Point2D point2 = extremum.searchForParabola();
        Assert.assertTrue((point1.getX() - point2.getX()) < 1e-5d);
        Assert.assertTrue((point1.getY() - point2.getY()) < 1e-5d);
    }

}