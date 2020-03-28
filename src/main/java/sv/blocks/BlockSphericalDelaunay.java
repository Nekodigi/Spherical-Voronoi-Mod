package sv.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import sv.tileentities.TileEntitySphericalDelaunay;
import sv.tileentities.TileEntitySphericalVoronoi;

import javax.annotation.Nullable;

public class BlockSphericalDelaunay extends BlockTileEntity<TileEntitySphericalDelaunay>  {
    public BlockSphericalDelaunay(String name, Material material){
        super(name, material);
        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(1.0F);
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) { return false; }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public Class<TileEntitySphericalDelaunay> getTileEntityClass() {
        return TileEntitySphericalDelaunay.class;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntitySphericalDelaunay createTileEntity(World world, IBlockState state) {
        return createTileEntity();
    }

    public TileEntitySphericalDelaunay createTileEntity(){
        return new TileEntitySphericalDelaunay();
    }
}
