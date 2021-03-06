package application;

import com.google.gson.GsonBuilder;
import furniture.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;


public class Controller implements Initializable {
    @FXML
    private TextField lengthField;
    @FXML
    private TextField widthField;
    @FXML
    private TextField heightField;
    @FXML
    private ChoiceBox typeBox;
    @FXML
    private ChoiceBox materialBox;
    @FXML
    private ListView listView;

    ObservableList<Furniture> furnitureList = FXCollections.observableArrayList();

    Furniture furniture = null;
    boolean createNew = false;

    @FXML
    private void tableBtnClick() {
        clearFields();
        createNew = true;
        furniture = new Table(0, 0, 0);
        updateTypeList();
    }

    @FXML
    private void chairBtnClick() {
        clearFields();
        createNew = true;
        furniture = new Chair(0, 0, 0);
        updateTypeList();
    }

    @FXML
    private void bedBtnClick() {
        clearFields();
        createNew = true;
        furniture = new Bed(0, 0, 0);
        updateTypeList();
    }

    @FXML
    private void cabinetryBtnClick() {
        clearFields();
        createNew = true;
        furniture = new Cabinetry(0, 0, 0);
        updateTypeList();
    }

    @FXML
    private void deskBtnClick() {
        clearFields();
        createNew = true;
        furniture = new Desk(0, 0, 0);
        updateTypeList();
    }

    @FXML
    private void addToList() {
        furniture.setType(typeBox);
        furniture.setMaterial(materialBox);
        furniture.setLength(Integer.parseInt(lengthField.getText()));
        furniture.setWidth(Integer.parseInt(widthField.getText()));
        furniture.setHeight(Integer.parseInt(heightField.getText()));
        if (createNew)
            furnitureList.add(furniture);
        listView.setItems(furnitureList);
    }

    private void clearFields() {
        lengthField.clear();
        widthField.clear();
        heightField.clear();
    }

    private void updateTypeList() {
        furniture.setTypesList(typeBox);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initMaterialList();
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    furniture = (Furniture) listView.getSelectionModel().getSelectedItem();
                    createNew = false;
                    updateTypeList();
                    setFields();
                }
        );
    }

    private void setFields() {
        lengthField.setText(String.valueOf(furniture.getLength()));
        widthField.setText(String.valueOf(furniture.getWidth()));
        heightField.setText(String.valueOf(furniture.getHeight()));
        furniture.choiceType(typeBox);
        furniture.choiceMaterial(materialBox);
    }

    private void initMaterialList() {
        furniture.setMaterialList(materialBox);
    }

    @FXML
    private void serializeClick() throws FileNotFoundException {
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Furniture.class, new AbstractElementAdapter());
        String json = gson.setPrettyPrinting().create().toJson(furnitureList.toArray(), Furniture[].class);
        PrintWriter writer = new PrintWriter("FurnitureList.json");
        writer.write(json);
        writer.close();
    }

    @FXML
    private void deserializeClick() throws IOException {
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Furniture.class, new AbstractElementAdapter());
        Furniture[] furnitureArray= gson.create().fromJson((new String(readAllBytes(get("FurnitureList.json")))),
                Furniture[].class);
        furnitureList = FXCollections.observableArrayList(Arrays.asList(furnitureArray));
        listView.setItems(furnitureList);
    }
}
