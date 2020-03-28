package sv.utils.convexHull;

import sv.utils.math.Simplex;
import sv.utils.vector.Vertex;

import java.util.ArrayList;

public class Utils {

    public static float[][] extractPos(Vertex ... vertices){
        float[][] result = new float[vertices.length][];
        for(int i = 0; i < vertices.length; i++){
            result[i] = vertices[i].pos;
        }
        return result;
    }

    public static ArrayList<Vertex> getNotIth(ArrayList<Vertex> vs, int i){
        ArrayList<Vertex> result = new ArrayList<Vertex>();
        for(int j = 0; j < vs.size(); j++){
            if(j == i){continue;}
            result.add(vs.get(j));
        }
        return result;
    }

    public static Simplex[] getAdjHasVertex(Simplex simplex, Vertex v){
        Simplex[] result = new Simplex[simplex.adjacent.length-1];
        for(int j = 0, k = 0; j < simplex.adjacent.length; j++){

            if(hasItem(v, simplex.adjacent[j].vertices)){
                result[k++] = simplex.adjacent[j];
            }else continue;
        }
        return result;
    }

    public static boolean hasItem(Vertex v, Vertex[] vertices){
        for(Vertex v_ : vertices){
            if(v_ == v)return true;
        }
        return false;
    }

    public static float[] sphereSampling(float u, float theta){//https://mathworld.wolfram.com/SpherePointPicking.html
        float x = (float)(Math.sqrt(1-u*u)*Math.cos(theta));
        float y = (float)(Math.sqrt(1-u*u)*Math.sin(theta));
        float[] result = {x, y, u};
        return result;
    }
}