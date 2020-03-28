package sv.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import sv.Main;
import sv.blocks.BlockSphericalDelaunay;
import sv.blocks.BlockSphericalVoronoi;
import sv.utils.IHasTESR;
import sv.utils.IHasTileEntity;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final BlockSphericalDelaunay SphericalDelaunayBlock = new BlockSphericalDelaunay("spherical_delaunay_block", Material.IRON);
    public static final BlockSphericalVoronoi SphericalVoronoiBlock = new BlockSphericalVoronoi("spherical_voronoi_block", Material.IRON);

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(BLOCKS.toArray(new Block[0]));
        for (Block block : BLOCKS) {
            if (block instanceof IHasTileEntity) {
                IHasTileEntity IHTE = ((IHasTileEntity) block);
                Class TEClass = IHTE.getTileEntityClass();
                GameRegistry.registerTileEntity(TEClass, new ResourceLocation(Main.MOD_ID + ":" + block.getRegistryName().toString()));
                TileEntity TE = IHTE.createTileEntity();
                if(TE instanceof IHasTESR){
                    Main.proxy.registerRenderers(TEClass, ((IHasTESR) TE).getTESR());
                }
            }
        }
    }
}
