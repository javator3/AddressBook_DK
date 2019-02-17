package pl.sda.addressManager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pl.sda.addressManager.model.Person;
import pl.sda.addressManager.view.PersonView;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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
        Stage currentStage = (Stage) newBn.getScene().getWindow();
        currentStage.hide();
        personView.loadNewPersonView(null);
        currentStage.show();
    }
    public void editBnPress(){

        if (personTb.getSelectionModel().getSelectedItem()!=null){
            Stage currentStage = (Stage) newBn.getScene().getWindow();
            currentStage.hide();
            personView.loadNewPersonView(personTb.getSelectionModel().getSelectedItem());
            currentStage.show();
        }

    }

    public void loadBnPress() throws IOException {
       // Person [] personList = new ObjectMapper().readValue(new File("workers.json"), Person[].class);
       // ObservableList<Person> tmplist = FXCollections.observableArrayList();
     //   for (Person p: personList
      //       ) {
       //     tmplist.add(p);
      //  }
      //  personView.setPersonObservableList(tmplist);
        personView.setPersonObservableList(FXCollections.observableArrayList(new ObjectMapper().readValue(new File("workers.json"), Person[].class)));
        personTb.setItems(personView.getPersonObservableList());

    }

    public void saveBnPress() throws IOException {
           new ObjectMapper().writeValue(new File("workers.json"), personView.getPersonObservableList());
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
