package furniture;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

public class Table extends Furniture {

    public enum Type {
        BEDSIDE, COFFEE, GATELEG, REFECTORY, DRAFTING, DINNING_ROOM, WORKBENCH
    }

    private Type type;

    public Table(int length, int width, int height) {
        super(length, width, height);
        super.name = "Table";
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
