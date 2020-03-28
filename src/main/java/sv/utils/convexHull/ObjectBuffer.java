package sv.utils.convexHull;

import sv.utils.math.Simplex;
import sv.utils.vector.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ObjectBuffer {
    public int connector_table_size = 2017;
    public ArrayList[] connectorTable = new ArrayList[connector_table_size];
    public int dim;
    public Vertex currentVertex;
    public List<Vertex> inputVertices = new ArrayList<Vertex>();
    public float maxDist = Float.NEGATIVE_INFINITY;
    public Vertex furthestVertex;
    public ArrayList<Simplex> unprocessedFaces = new ArrayList<Simplex>();
    //To detect invalid input in advance and reduce processing
    public ArrayList<Vertex> singularVertices = new ArrayList<Vertex>();
    //faces that need to be change
    public ArrayList<Simplex> affectedFaces = new ArrayList<Simplex>();
    //To store unconfirmed cone face data
    public ArrayList<DeferredSimplex> coneFaces = new ArrayList<DeferredSimplex>();

    public ObjectBuffer(int dim){
        this.dim = dim;
        for(int i = 0; i < connector_table_size; i++){
            connectorTable[i] = new ArrayList<SimplexConnector>();
        }
    }

    public void addInput(ArrayList<Vertex> input, boolean assignIds, boolean checkInput){
        inputVertices = new ArrayList<Vertex>(input);

        if(assignIds){
            for(int i = 0; i < input.size(); i++){
                inputVertices.get(i).id = i;
            }
        }

        //Check for duplicates
        if(checkInput){
            HashSet<Integer> set = new HashSet<Integer>();

            for (int i = 0; i < input.size(); i++)
            {
                if (input.get(i) == null) throw new IllegalArgumentException("Input has a null vertex");
                if (input.get(i).dim != dim) throw new IllegalArgumentException("Input vertex is not the correct dimension"+input.get(i).dim);
                if (set.contains(input.get(i).id)) throw new IllegalArgumentException("Input vertex id is not unique"+input.get(i).id);
                else set.add(input.get(i).id);
            }
        }
    }
}