package pl.sda.addressManager.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sda.addressManager.model.Person;
import pl.sda.addressManager.view.PersonView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VerticalBoxController implements Initializable {
    @FXML
    private Label nameLb;
    @FXML
    private Label lastnameLb;
    @FXML
    private Label streetLb;
    @FXML
    private Label cityLb;
    @FXML
    private Label postcodeLb;
    @FXML
    private Label telephoneLb;
    @FXML
    private TableView<Person> personTb;
    @FXML
    private TableColumn<Person,String> nameCol;
    @FXML
    private TableColumn<Person,String> lastnameCol;
    @FXML
    private Button newBn;
    @FXML
    private Button editBn;
    @FXML
    private Button deleteBn;
    @FXML
    private Button saveBn;

    private PersonView personView;

    public void setPersonView(PersonView personView)
    {
        this.personView = personView;
        personTb.setItems(personView.getPersonObservableList());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(c -> c.getValue().nameProperty());
        lastnameCol.setCellValueFactory(c-> c.getValue().lastnameProperty());
    }

    public void deleteBnPress(){

    }
    public void newBnPress(ActionEvent actionEvent){
        personView.loadNewPersonView();
    }
    public void editBnPress(){

    }
    public void saveBnPress(){

    }

}
