package sv.init;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static void register(IForgeRegistry registry){
        registry.registerAll(ITEMS.toArray(new Item[0]));
    }
}
