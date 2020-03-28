package sv.utils.vector;

public class Vertex {
    public int dim;
    public int id;
    public int tag;
    public float[] pos;

    public Vertex(int id, float ... pos){
        dim = pos.length;
        this.pos = pos;
        this.id = id;
    }
}
