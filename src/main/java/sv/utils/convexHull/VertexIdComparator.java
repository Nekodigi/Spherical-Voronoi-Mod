package sv.utils.convexHull;

import sv.utils.vector.Vertex;

import java.util.Comparator;

public class VertexIdComparator implements Comparator<Vertex> {
    @Override
    public int compare(Vertex a, Vertex b) {
        return a.id - b.id;
    }
}