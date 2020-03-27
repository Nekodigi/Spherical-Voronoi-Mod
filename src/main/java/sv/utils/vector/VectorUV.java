package sv.utils.vector;

public class VectorUV extends Vector {
    public double u, v;

    public VectorUV(double x, double y, double z, double u, double v) {
        super(x, y, z);
        this.u = u;
        this.v = v;
    }
}
