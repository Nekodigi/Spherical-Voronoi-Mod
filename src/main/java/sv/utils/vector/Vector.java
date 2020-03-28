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

    public double dot(Vector v){
        return x*v.x + y*v.y + z*v.z;
    }

    public Vector normalize(){
        div(mag());
        return this;
    }

    public double mag(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public static double dist(Vector a, Vector b){
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        double dz = a.z - b.z;
        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }

    public static Vector add(Vector a, Vector b){
        return new Vector(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public static Vector sub(Vector a, Vector b){
        return new Vector(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    public static Vector mult(Vector v, double value){
        return new Vector(v.x*value, v.y*value, v.z*value);
    }

    public Vector mult(double value){
        x *= value;
        y *= value;
        z *= value;
        return this;
    }

    public Vector div(double value){
        return mult(1d/value);
    }

    public static Vector fromAngle(double theta, double phi, double r){
        double tx = r * Math.cos(theta) * Math.cos(phi);
        double ty = r * Math.sin(phi);
        double tz = r * Math.sin(theta) * Math.cos(phi);
        return new Vector(tx, ty, tz);
    }
}
