package sv.tileentities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;
import sv.utils.render.PrimitiveRender;
import sv.utils.vector.Vector;

public class TESRSphericalVoronoi extends TileEntitySpecialRenderer<TileEntitySphericalVoronoi>{
    @Override
    public boolean isGlobalRenderer(TileEntitySphericalVoronoi p_isGlobalRenderer_1_) {
        return true;
    }

    @Override
    public void render(TileEntitySphericalVoronoi te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.5, y + 1 + te.r, z + 0.5);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        GlStateManager.disableLighting();
        TextureAtlasSprite icon = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("sv:blocks/white_tile");

        PrimitiveRender.sphere(te.r, icon);

        GlStateManager.color(0.5f, 0, 0);
        for(Vector v : te.points){
            PrimitiveRender.cube(v.x, v.y, v.z, 0.5f, icon);
        }
        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
    }
}
