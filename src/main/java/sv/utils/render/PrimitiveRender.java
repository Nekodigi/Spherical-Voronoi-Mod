package sv.utils.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;
import sv.utils.vector.Vector;

public class PrimitiveRender {
    public static void sphere(double r){
        sphere(r, 32, 16);
    }

    public static void sphere(double r, int NI, int NJ){
        TextureAtlasSprite icon = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("sv:blocks/white_tile");
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer =  tessellator.getBuffer();
        double deltaU = icon.getMaxU() - icon.getMinU();
        double deltaV = icon.getMaxV() - icon.getMinV();
        Vector[][] ps = new Vector[NI][NJ+1];
        for(int i = 0; i < NI; i++) {
            double theta = 2d * Math.PI * i / NI - Math.PI;
            for (int j = 0; j <= NJ; j++) {
                double phi = Math.PI * j / NJ - Math.PI / 2d;
                ps[i][j] = Vector.fromAngle(theta, phi, r);
            }

        }

        for(int i = 0; i < NI; i++) {
            for (int j = 0; j < NJ; j++) {
                buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
                Vector p1 = ps[i][j];
                Vector p2 = ps[i][j + 1];
                Vector p3 = ps[(i + 1) % NI][j + 1];
                Vector p4 = ps[(i + 1) % NI][j];
                buffer.pos(p1.x, p1.y, p1.z).tex(icon.getMinU(), icon.getMaxV()).endVertex();
                buffer.pos(p2.x, p2.y, p2.z).tex(icon.getMinU(), icon.getMinV()).endVertex();
                buffer.pos(p3.x, p3.y, p3.z).tex(icon.getMaxU(), icon.getMinV()).endVertex();
                buffer.pos(p4.x, p4.y, p4.z).tex(icon.getMaxU(), icon.getMaxV()).endVertex();
                tessellator.draw();
            }
        }
    }

    public static void cube(double x, double y, double z, double size){
        TextureAtlasSprite icon = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("sv:blocks/white_tile");
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer =  tessellator.getBuffer();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);//render botton surface
        buffer.pos(x-size, y-size, z-size).tex(icon.getMinU(), icon.getMaxV()).endVertex();
        buffer.pos(x+size, y-size, z-size).tex(icon.getMinU(), icon.getMinV()).endVertex();
        buffer.pos(x+size, y-size, z+size).tex(icon.getMaxU(), icon.getMinV()).endVertex();
        buffer.pos(x-size, y-size, z+size).tex(icon.getMaxU(), icon.getMaxV()).endVertex();
        tessellator.draw();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);//render top surface
        buffer.pos(x-size, y+size, z-size).tex(icon.getMinU(), icon.getMaxV()).endVertex();
        buffer.pos(x-size, y+size, z+size).tex(icon.getMinU(), icon.getMinV()).endVertex();
        buffer.pos(x+size, y+size, z+size).tex(icon.getMaxU(), icon.getMinV()).endVertex();
        buffer.pos(x+size, y+size, z-size).tex(icon.getMaxU(), icon.getMaxV()).endVertex();
        tessellator.draw();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);//render left surface
        buffer.pos(x-size, y-size, z-size).tex(icon.getMinU(), icon.getMaxV()).endVertex();
        buffer.pos(x-size, y-size, z+size).tex(icon.getMinU(), icon.getMinV()).endVertex();
        buffer.pos(x-size, y+size, z+size).tex(icon.getMaxU(), icon.getMinV()).endVertex();
        buffer.pos(x-size, y+size, z-size).tex(icon.getMaxU(), icon.getMaxV()).endVertex();
        tessellator.draw();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);//render right surface
        buffer.pos(x+size, y+size, z-size).tex(icon.getMinU(), icon.getMaxV()).endVertex();
        buffer.pos(x+size, y+size, z+size).tex(icon.getMinU(), icon.getMinV()).endVertex();
        buffer.pos(x+size, y-size, z+size).tex(icon.getMaxU(), icon.getMinV()).endVertex();
        buffer.pos(x+size, y-size, z-size).tex(icon.getMaxU(), icon.getMaxV()).endVertex();
        tessellator.draw();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);//render front surface
        buffer.pos(x-size, y-size, z-size).tex(icon.getMinU(), icon.getMaxV()).endVertex();
        buffer.pos(x-size, y+size, z-size).tex(icon.getMinU(), icon.getMinV()).endVertex();
        buffer.pos(x+size, y+size, z-size).tex(icon.getMaxU(), icon.getMinV()).endVertex();
        buffer.pos(x+size, y-size, z-size).tex(icon.getMaxU(), icon.getMaxV()).endVertex();
        tessellator.draw();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);//render back surface
        buffer.pos(x-size, y+size, z+size).tex(icon.getMinU(), icon.getMaxV()).endVertex();
        buffer.pos(x-size, y-size, z+size).tex(icon.getMinU(), icon.getMinV()).endVertex();
        buffer.pos(x+size, y-size, z+size).tex(icon.getMaxU(), icon.getMinV()).endVertex();
        buffer.pos(x+size, y+size, z+size).tex(icon.getMaxU(), icon.getMaxV()).endVertex();
        tessellator.draw();
    }
}
