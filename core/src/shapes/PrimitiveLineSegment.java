package shapes;

public class PrimitiveLineSegment {
    public double x1; // 0..1
    public double y1; // 0..1
    public double x2; // 0..1
    public double y2; // 0..1

    public PrimitiveLineSegment(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
