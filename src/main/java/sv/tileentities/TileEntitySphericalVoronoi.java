package sv.tileentities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import sv.utils.IHasTESR;
import sv.utils.MathHelper;
import sv.utils.vector.Vector;

import java.util.ArrayList;

public class TileEntitySphericalVoronoi extends TileEntity implements IHasTESR {
    ArrayList<Vector> points = new ArrayList<Vector>();
    double r = 10;
    public TileEntitySphericalVoronoi(){
        for(int i = 0; i < 100; i++) {
            double u = MathHelper.random(-1, 1);
            double theta = MathHelper.random(0, 2d*Math.PI);
            points.add(Vector.sphereSampling(u, theta).mult(r));
        }
    }
    @Override
    public TileEntitySpecialRenderer<TileEntitySphericalVoronoi> getTESR() {
        return new TESRSphericalVoronoi();
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return TileEntity.INFINITE_EXTENT_AABB;
    }
}
