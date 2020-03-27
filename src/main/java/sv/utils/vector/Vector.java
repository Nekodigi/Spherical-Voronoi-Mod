package sv.utils.vector;

public class Vector {
    public double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector mult(double value){
        x *= value;
        y *= value;
        z *= value;
        return this;
    }

    public static Vector fromAngle(double theta, double phi, double r){
        double tx = r * Math.cos(theta) * Math.cos(phi);
        double ty = r * Math.sin(phi);
        double tz = r * Math.sin(theta) * Math.cos(phi);
        return new Vector(tx, ty, tz);
    }

    public static Vector sphereSampling(double u, double theta){
        double x = Math.sqrt(1-u*u)*Math.cos(theta);
        double y = Math.sqrt(1-u*u)*Math.sin(theta);
        return new Vector(x, y, u);
    }
}
