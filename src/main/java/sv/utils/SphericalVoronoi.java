package sv.utils;

import sv.utils.convexHull.ConvexHull;
import sv.utils.math.Simplex;
import sv.utils.vector.Vertex;

import java.util.ArrayList;

public class SphericalVoronoi {
    public ArrayList<Vertex> vertices;
    public ArrayList<Edge> edges = new ArrayList<Edge>();
    ConvexHull hull = new ConvexHull(3);

    public SphericalVoronoi(){}

    public void Generate(ArrayList<Vertex> input) {
        hull.Generate(input);
        for (Simplex simplex : hull.simplexes) {//calculate all circumCenter
            simplex.calcCircumCenter();
            simplex.tag = 0;
        }
        vertices = hull.vertices;
        for (Simplex simplex : hull.simplexes) {//calculate all polygon
            simplex.tag = 1;
            for(Simplex adj : simplex.adjacent){
                if(adj.tag == 0){//Prevent the same Edge from being registered again
                    edges.add(new Edge(simplex.circumC.pos, adj.circumC.pos));
                }
            }
        }
    }
}
