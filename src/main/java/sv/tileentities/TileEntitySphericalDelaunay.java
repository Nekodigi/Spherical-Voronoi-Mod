package sv.tileentities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import sv.utils.IHasTESR;
import sv.utils.MathHelper;
import sv.utils.convexHull.ConvexHull;
import sv.utils.convexHull.Utils;
import sv.utils.vector.FVector;
import sv.utils.vector.Vertex;

import java.util.ArrayList;

public class TileEntitySphericalDelaunay extends TileEntity implements IHasTESR {
    float r = 5;
    ArrayList<Vertex> points = new ArrayList<Vertex>();
    ConvexHull hull = new ConvexHull(3);
    public TileEntitySphericalDelaunay(){
        for(int i = 0; i < 100; i++) {
            float u = (float)MathHelper.random(-1, 1);
            float theta = (float)MathHelper.random(0, 2d*Math.PI);
            points.add(new Vertex(0, FVector.mult(Utils.sphereSampling(u, theta), r)));
        }
        hull.Generate(points);
    }
    @Override
    public TileEntitySpecialRenderer<TileEntitySphericalDelaunay> getTESR() {
        return new TESRSphericalDelaunay();
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return TileEntity.INFINITE_EXTENT_AABB;
    }

    @Override
    public double getMaxRenderDistanceSquared() {
        return Float.POSITIVE_INFINITY;
    }
}
