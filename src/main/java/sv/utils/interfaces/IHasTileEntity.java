package sv.utils.interfaces;

import net.minecraft.tileentity.TileEntity;

public interface IHasTileEntity<TE extends TileEntity> {
    public Class<TE> getTileEntityClass();

    public TE createTileEntity();
}
