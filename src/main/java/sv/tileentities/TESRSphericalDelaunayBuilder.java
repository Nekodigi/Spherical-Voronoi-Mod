package sv.tileentities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import sv.utils.Edge;
import sv.utils.math.Simplex;
import sv.utils.render.PrimitiveRender;
import sv.utils.vector.Vector;
import sv.utils.vector.Vertex;

public class TESRSphericalDelaunayBuilder extends TileEntitySpecialRenderer<TileEntitySphericalDelaunayBuilder>{
    @Override
    public boolean isGlobalRenderer(TileEntitySphericalDelaunayBuilder p_isGlobalRenderer_1_) {
        return true;
    }

    @Override
    public void render(TileEntitySphericalDelaunayBuilder te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.5, y + 0.5 + te.r, z + 0.5);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        GlStateManager.disableLighting();

        GlStateManager.color(0.1f, 0.1f, 0.1f);
//        for(Simplex simplex : te.hull.simplexes){
//            simplex.show();
//        }

        GlStateManager.color(.9f, .3f, .1f);
        PrimitiveRender.sphere(te.r);

        GlStateManager.color(0f, 0.2f, 0.2f);
//        for(Vertex v : te.points){
//            PrimitiveRender.cube(v.pos[0], v.pos[1], v.pos[2], 0.1f);
//        }
        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
    }
}
