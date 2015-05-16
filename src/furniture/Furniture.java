package furniture;

import com.sun.javafx.scene.control.skin.ChoiceBoxSkin;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

import java.util.HashSet;

abstract public class Furniture {

    public enum Material {
        METAL, WOOD, PLASTIC, GLASS
    };


    protected Material material;
    protected int length;
    protected int width;
    protected int height;
    protected String name;

    public Furniture(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    static public void setMaterialList(ChoiceBox choiceBox) {
        Material[] materials = Material.values();
        choiceBox.setItems(FXCollections.observableArrayList(materials));
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public void setMaterial(ChoiceBox choiceBox) {
        material = (Material)choiceBox.getValue();
    }

    public String getMaterial() {
        return material.toString();
    }

    @Override
    public String toString() {
        return name;
    }

    public void choiceMaterial(ChoiceBox choiceBox) {
        choiceBox.getSelectionModel().select(material);
    }

    abstract public void setTypesList(ChoiceBox choiceBox);
    abstract public void setType(ChoiceBox choiceBox);
    abstract public void choiceType(ChoiceBox choiceBox);
}
