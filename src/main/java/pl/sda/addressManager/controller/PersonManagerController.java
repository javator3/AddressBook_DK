package pl.sda.addressManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.addressManager.model.Person;
import pl.sda.addressManager.view.PersonView;

public class PersonManagerController {
    @FXML
    private TextField nameTf;
    @FXML
    private TextField lastnameTf;
    @FXML
    private TextField streetTf;
    @FXML
    private TextField cityTf;
    @FXML
    private TextField zipCodeTf;
    @FXML
    private TextField telephoneTf;
    @FXML
    private Button saveBn;
    @FXML
    private Button cancelBn;
    @FXML
    private Label headerLb;

    private PersonView personView;
    private Person currentPerson;
    private boolean addMode = false;

    public void setPersonView(PersonView personView, Person currentPerson) {
        this.personView = personView;
        this.currentPerson = currentPerson;
        if (currentPerson != null) {
            headerLb.setText("Editing Person");
            nameTf.setText(currentPerson.getName());
            lastnameTf.setText(currentPerson.getLastname());
            streetTf.setText(currentPerson.getStreet());
            cityTf.setText(currentPerson.getCity());
            zipCodeTf.setText(currentPerson.getZipcode());
            telephoneTf.setText(currentPerson.getTelphone());
        } else {
            headerLb.setText("Add New Person");
            addMode = true;
            this.currentPerson = new Person("", "", "", "", "", "");
        }
    }

    public void saveBnPress() {
        currentPerson.setName(nameTf.getText());
        currentPerson.setLastname(lastnameTf.getText());
        currentPerson.setStreet(streetTf.getText());
        currentPerson.setCity(cityTf.getText());
        currentPerson.setZipcode(zipCodeTf.getText());
        currentPerson.setTelphone(telephoneTf.getText());
        if (addMode) {
            personView.getPersonObservableList().add(currentPerson);
        }
        cancelBnPress();
    }

    public void cancelBnPress() {
        Stage currentStage = (Stage) cancelBn.getScene().getWindow();
        currentStage.close();
    }
}
