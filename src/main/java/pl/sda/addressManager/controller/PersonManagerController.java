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
    private Person currenPerson;
    private boolean addmode = false;

    public void setPersonView(PersonView personView, Person currenPerson)
    {
        this.personView = personView;
        this.currenPerson = currenPerson;
        if (currenPerson!=null){
            headerLb.setText("Editing Person");
            nameTf.setText(currenPerson.getName());
            lastnameTf.setText(currenPerson.getLastname());
            streetTf.setText(currenPerson.getStreet());
            cityTf.setText(currenPerson.getCity());
            zipCodeTf.setText(currenPerson.getZipcode());
            telephoneTf.setText(currenPerson.getTelphone());
        }
        else {
            headerLb.setText("Add New Person");
            addmode = true;
            this.currenPerson = new Person("","","","","","");
        }
    }


    public void saveBnPress(ActionEvent actionEvent) {
        currenPerson.setName(nameTf.getText());
        currenPerson.setLastname(lastnameTf.getText());
        currenPerson.setStreet(streetTf.getText());
        currenPerson.setCity(cityTf.getText());
        currenPerson.setZipcode(zipCodeTf.getText());
        currenPerson.setTelphone(telephoneTf.getText());
        if (addmode) {
           personView.getPersonObservableList().add(currenPerson);
        }
        Stage currentStage = (Stage)saveBn.getScene().getWindow();
        currentStage.close();
    }

    public void cancelBnPress(){
        Stage currentStage = (Stage)cancelBn.getScene().getWindow();
        currentStage.close();

    }
}
