package sv.utils.convexHull;

import sv.utils.math.Simplex;

public class DeferredSimplex {
    public Simplex face;
    public Simplex pivot;
    public Simplex oldFace;
    public int faceIndex;
    public int pivotIndex;

    public DeferredSimplex(Simplex face, int faceIndex, Simplex pivot, int pivotIndex, Simplex oldFace){
        this.face = face;
        this.faceIndex = faceIndex;
        this.pivot = pivot;
        this.pivotIndex = pivotIndex;
        this.oldFace = oldFace;
    }
}
