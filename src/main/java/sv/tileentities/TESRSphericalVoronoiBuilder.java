package sv.tileentities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import sv.utils.Edge;
import sv.utils.render.PrimitiveRender;

public class TESRSphericalVoronoiBuilder extends TileEntitySpecialRenderer<TileEntitySphericalVoronoiBuilder>{
    @Override
    public boolean isGlobalRenderer(TileEntitySphericalVoronoiBuilder p_isGlobalRenderer_1_) {
        return true;
    }

    @Override
    public void render(TileEntitySphericalVoronoiBuilder te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.5, y + 1 + te.r, z + 0.5);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        GlStateManager.disableLighting();

        GlStateManager.color(0.1f, 0.1f, 0.1f);
//        for(Edge edge : te.sVoronoi.edges){
//            edge.show();
//        }

        GlStateManager.color(.9f, .3f, .1f);
        PrimitiveRender.sphere(te.r);

//        GlStateManager.color(0f, 0.2f, 0.2f);
//        for(Edge edge : te.sVoronoi.edges){
//            PrimitiveRender.cube(edge.sp.x, edge.sp.y, edge.sp.z, 0.1f);
//        }

        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
    }
}
