package sv.tileentities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import sv.utils.Edge;
import sv.utils.MathHelper;
import sv.utils.convexHull.ConvexHull;
import sv.utils.convexHull.Utils;
import sv.utils.interfaces.IHasTESR;
import sv.utils.math.Simplex;
import sv.utils.vector.FVector;
import sv.utils.vector.Vector;
import sv.utils.vector.Vertex;

import java.util.ArrayList;

public class TileEntitySphericalDelaunayBuilder extends TileEntity implements IHasTESR {
    float r = 80;
    int n = 100;
    ArrayList<Vertex> points = new ArrayList<Vertex>();
    ArrayList<Edge> edges = new ArrayList<Edge>();
    ConvexHull hull = new ConvexHull(3);
    public TileEntitySphericalDelaunayBuilder(){
        for(int i = 0; i < n; i++) {
            float u = (float)MathHelper.random(-1, 1);
            float theta = (float)MathHelper.random(0, 2d*Math.PI);
            points.add(new Vertex(0, FVector.mult(Utils.sphereSampling(u, theta), r)));
        }
        hull.Generate(points);
        for(Simplex simplex : hull.simplexes){
            edges.add(new Edge(simplex.vertices[0].pos, simplex.vertices[1].pos));
            edges.add(new Edge(simplex.vertices[1].pos, simplex.vertices[2].pos));
            edges.add(new Edge(simplex.vertices[2].pos, simplex.vertices[0].pos));
        }
    }

    public void build(){
        BlockPos pos = getPos();
        IBlockState blockState = world.getBlockState(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
        for(int x = (int)-r; x <= r; x++) {
            for(int y = (int)-r; y <= r; y++) {
                for(int z = (int)-r; z <= r; z++) {
                    for(Edge edge : edges) {
                        if (edge.dist(new Vector(x, y, z)) < 1) {
                            world.setBlockState(new BlockPos(pos.getX() + x, pos.getY() + y + r, pos.getZ() + z), blockState, 15);
                        }
                    }
                }
            }
        }
        world.setBlockToAir(pos);
    }

    @Override
    public TileEntitySpecialRenderer<TileEntitySphericalDelaunayBuilder> getTESR() {
        return new TESRSphericalDelaunayBuilder();
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
