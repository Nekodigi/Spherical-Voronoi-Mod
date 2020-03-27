package sv.init;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import sv.Main;

public class ModTextures {

    public static ResourceLocation makeRL(String dir){
        return new ResourceLocation(Main.MOD_ID + ":" + dir);
    }

    public static void register(TextureMap textureMap){
        textureMap.registerSprite(makeRL("blocks/white_tile"));
    }
}
