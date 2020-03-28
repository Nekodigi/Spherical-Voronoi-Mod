package sv.tileentities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import sv.utils.SphericalVoronoi;
import sv.utils.interfaces.IHasTESR;
import sv.utils.MathHelper;
import sv.utils.convexHull.ConvexHull;
import sv.utils.convexHull.Utils;
import sv.utils.vector.FVector;
import sv.utils.vector.Vertex;

import java.util.ArrayList;

public class TileEntitySphericalVoronoi extends TileEntity implements IHasTESR {
    float r = 5;
    ArrayList<Vertex> points = new ArrayList<Vertex>();
    SphericalVoronoi sVoronoi = new SphericalVoronoi();
    public TileEntitySphericalVoronoi(){
        for(int i = 0; i < 100; i++) {
            float u = (float)MathHelper.random(-1, 1);
            float theta = (float)MathHelper.random(0, 2d*Math.PI);
            points.add(new Vertex(0, FVector.mult(Utils.sphereSampling(u, theta), r)));
        }
        sVoronoi.Generate(points);
    }
    @Override
    public TileEntitySpecialRenderer<TileEntitySphericalVoronoi> getTESR() {
        return new TESRSphericalVoronoi();
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
