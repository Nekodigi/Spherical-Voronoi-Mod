package sv.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sv.Main;
import sv.init.ModItems;
import sv.utils.IHasModel;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels(){
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
