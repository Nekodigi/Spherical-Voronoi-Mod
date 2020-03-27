package sv.utils.handlers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sv.init.ModBlocks;
import sv.init.ModItems;
import sv.init.ModTextures;
import sv.utils.IHasModel;

@Mod.EventBusSubscriber
public class ResistryHandler {
    @SubscribeEvent
    public static void onItemResister(RegistryEvent.Register<Item> event){
        ModItems.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event){
        ModBlocks.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for(Item item : ModItems.ITEMS){
            if(item instanceof IHasModel){
                ((IHasModel)item).registerModels();
            }
        }

        for(Block block : ModBlocks.BLOCKS){
            if(block instanceof IHasModel){
                ((IHasModel)block).registerModels();
            }
        }
    }

    @SubscribeEvent
    public static void textureStitch(TextureStitchEvent.Pre event){
        TextureMap textureMap = event.getMap();
        ModTextures.register(textureMap);
    }
}
