package pl.sda.addressManager.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pl.sda.addressManager.model.Person;
import pl.sda.addressManager.view.PersonView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VerticalBoxController implements Initializable {
    @FXML
    private Label nameLb;
    @FXML
    private Label lastNameLb;
    @FXML
    private Label streetLb;
    @FXML
    private Label cityLb;
    @FXML
    private Label postLb;
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

        personView.getPersonObservableList().remove(personTb.getSelectionModel().getSelectedItem());
    }
    public void newBnPress(){
        personView.loadNewPersonView(null);
    }
    public void editBnPress(){
        if (personTb.getSelectionModel().getSelectedItem()!=null){
            personView.loadNewPersonView(personTb.getSelectionModel().getSelectedItem());
        }
    }
    public void saveBnPress(){

    }

    public void changeSelected()
    {
        Person tmpPerson = personTb.getSelectionModel().getSelectedItem();

        if (tmpPerson!=null) {

            nameLb.setText(tmpPerson.getName());
            lastNameLb.setText(tmpPerson.getLastname());
            cityLb.setText(tmpPerson.getCity());
            streetLb.setText(tmpPerson.getStreet());
            telephoneLb.setText(tmpPerson.getTelphone());
            postLb.setText(tmpPerson.getZipcode());

        }
        else{
            nameLb.setText("");
            lastNameLb.setText("");
            cityLb.setText("");
            streetLb.setText("");
            telephoneLb.setText("");
            postLb.setText("");
        }

    }


}
