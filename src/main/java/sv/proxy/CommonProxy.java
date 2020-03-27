package sv.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;

public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id){}

    public void registerRenderers(Class TEClass, TileEntitySpecialRenderer TESRIns){}
}
