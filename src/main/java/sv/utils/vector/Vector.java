package sv.utils.vector;

public class Vector {
    public double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(float[] v){
        this.x = v[0];
        this.y = v[1];
        this.z = v[2];
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
}
