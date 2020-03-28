package sv.tileentities;

import net.minecraft.block.state.IBlockProperties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import sv.utils.Edge;
import sv.utils.MathHelper;
import sv.utils.SphericalVoronoi;
import sv.utils.convexHull.Utils;
import sv.utils.interfaces.IHasTESR;
import sv.utils.vector.FVector;
import sv.utils.vector.Vector;
import sv.utils.vector.Vertex;

import java.util.ArrayList;

public class TileEntitySphericalVoronoiBuilder extends TileEntity implements IHasTESR {
    float r = 80;
    ArrayList<Vertex> points = new ArrayList<Vertex>();
    ArrayList<Edge> edges = new ArrayList<Edge>();
    SphericalVoronoi sVoronoi = new SphericalVoronoi();
    public TileEntitySphericalVoronoiBuilder(){
        for(int i = 0; i < 100; i++) {
            float u = (float)MathHelper.random(-1, 1);
            float theta = (float)MathHelper.random(0, 2d*Math.PI);
            points.add(new Vertex(0, FVector.mult(Utils.sphereSampling(u, theta), r)));
        }
        sVoronoi.Generate(points);
        edges = sVoronoi.edges;
    }

    public void build(){
        BlockPos pos = getPos();
        IBlockState blockState = world.getBlockState(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
        for(int x = (int)-r; x <= r; x++) {
            for(int y = (int)-r; y <= r; y++) {
                for(int z = (int)-r; z <= r; z++) {
                    for(Edge edge : edges) {
                        if (edge.dist(new Vector(x, y, z)) < 1) {
                            world.setBlockState(new BlockPos(pos.getX() + x, pos.getY() + y + r, pos.getZ() + z), blockState);
                        }
                    }
                }
            }
        }
        world.setBlockToAir(pos);
    }

    @Override
    public TileEntitySpecialRenderer<TileEntitySphericalVoronoiBuilder> getTESR() {
        return new TESRSphericalVoronoiBuilder();
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
