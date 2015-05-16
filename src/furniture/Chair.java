package furniture;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

/**
 * Created by Виктор on 16.05.2015.
 */
public class Chair extends Furniture{

    public enum Type {
        ROCKING, WATCHMANS, WINDSOR, WINGBACK
    }

    private Type type;

    public Chair(int length, int width, int height) {
        super(length, width, height);
        super.name = "Chair";
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
