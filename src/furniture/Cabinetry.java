package furniture;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

public class Cabinetry extends Furniture{

    public enum Type {
        CLOSET, CUPBOARD, HUTCH, PANTRY, KITCHEN, HOOSIER
    }

    private Type type;

    public Cabinetry(int length, int width, int height) {
        super(length, width, height);
        super.name = "Cabinetry";
    }

    @Override
    public void setTypesList(ChoiceBox choiceBox) {
        Type[] types = Type.values();
        choiceBox.setItems(FXCollections.observableArrayList(types));
    }

    @Override
    public void setType(ChoiceBox choiceBox) {
        type = (Type)choiceBox.getValue();
    }

    @Override
    public void choiceType(ChoiceBox choiceBox) {
        choiceBox.getSelectionModel().select(type);
    }
}