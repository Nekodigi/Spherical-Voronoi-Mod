package sv.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;
import sv.utils.vector.Vector;

public class Edge {
    public Vector sp, ep;
    public float width = 0.1f;

    public Edge(Vector sp, Vector ep){
        this.sp = sp;
        this.ep = ep;
    }

    public Edge(float[] sp, float[] ep){
        this.sp = new Vector(sp);
        this.ep = new Vector(ep);
    }

    public void show(){
        TextureAtlasSprite icon = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("sv:blocks/white_tile");
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer =  tessellator.getBuffer();
        GlStateManager.disableCull();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);//render botton surface
        buffer.pos(sp.x-width/2, sp.y, sp.z).tex(icon.getMinU(), icon.getMaxV()).endVertex();
        buffer.pos(sp.x+width/2, sp.y, sp.z).tex(icon.getMinU(), icon.getMinV()).endVertex();
        buffer.pos(ep.x+width/2, ep.y, ep.z).tex(icon.getMaxU(), icon.getMinV()).endVertex();
        buffer.pos(ep.x-width/2, ep.y, ep.z).tex(icon.getMaxU(), icon.getMaxV()).endVertex();
        tessellator.draw();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);//render botton surface
        buffer.pos(sp.x, sp.y-width/2, sp.z).tex(icon.getMinU(), icon.getMaxV()).endVertex();
        buffer.pos(sp.x, sp.y+width/2, sp.z).tex(icon.getMinU(), icon.getMinV()).endVertex();
        buffer.pos(ep.x, ep.y+width/2, ep.z).tex(icon.getMaxU(), icon.getMinV()).endVertex();
        buffer.pos(ep.x, ep.y-width/2, ep.z).tex(icon.getMaxU(), icon.getMaxV()).endVertex();
        tessellator.draw();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);//render botton surface
        buffer.pos(sp.x, sp.y, sp.z-width/2).tex(icon.getMinU(), icon.getMaxV()).endVertex();
        buffer.pos(sp.x, sp.y, sp.z+width/2).tex(icon.getMinU(), icon.getMinV()).endVertex();
        buffer.pos(ep.x, ep.y, ep.z+width/2).tex(icon.getMaxU(), icon.getMinV()).endVertex();
        buffer.pos(ep.x, ep.y, ep.z-width/2).tex(icon.getMaxU(), icon.getMaxV()).endVertex();
        tessellator.draw();
        GlStateManager.enableCull();
    }
}
