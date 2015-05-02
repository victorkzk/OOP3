package furniture;

import java.awt.Color;
import java.util.HashSet;

abstract public class Furniture {

    public enum Material {
        METAL, WOOD, PLASTIC, GLASS,
    };


    protected HashSet<Material> materials = new HashSet<Material>();
    protected int length;
    protected int width;
    protected int height;
    protected Color color;

    public Furniture(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    abstract public String[] getTypesList();
}
