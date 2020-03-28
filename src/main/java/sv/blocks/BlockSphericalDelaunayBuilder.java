package sv.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sv.tileentities.TileEntitySphericalDelaunayBuilder;

import javax.annotation.Nullable;

public class BlockSphericalDelaunayBuilder extends BlockTileEntity<TileEntitySphericalDelaunayBuilder>  {
    public BlockSphericalDelaunayBuilder(String name, Material material){
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand handler, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntitySphericalDelaunayBuilder tile =  getTileEntity(world, pos);
            tile.build();
        }
        return true;
    }

    @Override
    public Class<TileEntitySphericalDelaunayBuilder> getTileEntityClass() {
        return TileEntitySphericalDelaunayBuilder.class;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntitySphericalDelaunayBuilder createTileEntity(World world, IBlockState state) {
        return createTileEntity();
    }

    public TileEntitySphericalDelaunayBuilder createTileEntity(){
        return new TileEntitySphericalDelaunayBuilder();
    }
}
