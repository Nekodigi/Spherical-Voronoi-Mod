package sv.utils;

public class MathHelper {
    public static double random(double start, double end){
        return Math.random()*(end - start) + start;
    }
}
