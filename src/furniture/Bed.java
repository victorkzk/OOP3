package furniture;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

public class Bed extends Furniture{

    public enum Type {
        BUNK, WATERBED, MURPHY, STEIGH, CANOPY
    }

    private Type type;

    public Bed(int length, int width, int height) {
        super(length, width, height);
        super.name = "Bed";
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