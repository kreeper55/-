package search_extremums;

public class Extremum {
    private double A, B, C;
    private double Δdelta;
    private Point2D p1, p2, p3;

    public Extremum() {
        p1 = new Point2D();
        p2 = new Point2D();
        p3 = new Point2D();
    }

    public Point2D search(double value, double step, double ε) throws ExceptionZero{
        if (step == 0 || ε == 0) throw new ExceptionZero("step or epsilon equals is zero");
        Point2D pExtr = new Point2D();
        double answer = 0;
        boolean flag = true;
        do {
            p2.setX(value);
            p2.setY(Function.calc(value));
            p3.setX(value + step);
            p3.setY(Function.calc(value + step));

            if (p2.getY() < p3.getY()) {
                p1.setX(value - step);
                p1.setY(Function.calc(value - step));
            } else {
                p1.setX(value);
                p1.setY(Function.calc(value));
                p2.setX(value + step);
                p2.setY(Function.calc(value + step));
                p3.setX(value + 2 * step);
                p3.setY(Function.calc(value + 2 * step));
            }

            if (flag) {
                answer = this.δ1();
                flag = false;
            }
            else answer = this.δ2();

            if (Math.abs(Function.calc(value) - Function.calc(answer)) < ε) {
                pExtr.setX(answer);
                pExtr.setY(Function.calc(answer));

                break;
            }
            value = answer;
        } while(true);
        this.setCoefficient(p1, p2, p3);
        return pExtr;
    }

    public Point2D searchForParabola() throws ExceptionZero{
        if (A == 0 ) throw new ExceptionZero("A = 0(parabola)");
        Point2D pExtr = new Point2D();

        pExtr.setX(this.δ2());
        pExtr.setY(parabola(this.δ2()));

        return pExtr;
    }

    public double δ1() {
        return 0.5 * (
              ( ( (Math.pow(p2.getX(), 2) - Math.pow(p3.getX(), 2)) * p1.getY() ) +
                ( (Math.pow(p3.getX(), 2) - Math.pow(p1.getX(), 2)) * p2.getY() ) +
                ( (Math.pow(p1.getX(), 2) - Math.pow(p2.getX(), 2)) * p3.getY() ) ) /
                   ( ( (p2.getX() - p3.getX()) * p1.getY()) +
                     ( (p3.getX() - p1.getX()) * p2.getY()) +
                     ( (p1.getX() - p2.getX()) * p3.getY()) )
        );
    }


    public double δ2() {
        return 0.5 * (p1.getX() + p2.getX()) +
            0.5 * ((p1.getY() - p2.getY()) * (p2.getX() - p3.getX()) * (p3.getX() - p1.getX())) /
            (   (p2.getX() - p3.getX()) * p1.getY() +
                (p3.getX() - p1.getX()) * p2.getY() +
                (p1.getX() - p2.getX()) * p3.getY()  );
    }

    private void Δ(Point2D p1, Point2D p2, Point2D p3) {
        Δdelta = (p1.getX() - p2.getX()) * (p2.getX() - p3.getX()) * (p3.getX() - p1.getX());
    }

    private void calcA() throws ExceptionZero{
        if (Δdelta == 0) throw new ExceptionZero("delta is zero");
        this.A = Math.abs(  (p3.getX() - p2.getX()) * p1.getY() +
                            (p1.getX() - p3.getX()) * p2.getY() +
                            (p2.getX() - p1.getX()) * p3.getY()) / Δdelta;
    }

    private void calcB() throws ExceptionZero {
        if (Δdelta == 0) throw new ExceptionZero("delta is zero");
        this.B = Math.abs(  (p2.getX() * p2.getX() - p3.getX() * p3.getX()) * p1.getY() +
                            (p3.getX() * p3.getX() - p1.getX() * p1.getX()) * p2.getY() +
                            (p1.getX() * p1.getX() - p2.getX() * p2.getX()) * p3.getY()) / Δdelta;
    }

    private void calcC() throws ExceptionZero {
        if (Δdelta == 0) throw new ExceptionZero("delta is zero");
        this.C = Math.abs(  p2.getX() * p3.getX() * (p3.getX() - p2.getX()) * p1.getY() +
                            p3.getX() * p1.getX() * (p1.getX() - p3.getX()) * p2.getY() +
                            p1.getX() * p2.getX() * (p2.getX() - p1.getX()) * p3.getY()) / Δdelta;
    }

    public double parabola(double x) {
        return A * x * x - B * x - C;
    }

    public void setCoefficient(Point2D p1, Point2D p2, Point2D p3) throws ExceptionZero {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        Δ(p1, p2, p3);
        calcA();
        calcB();
        calcC();
    }
}
