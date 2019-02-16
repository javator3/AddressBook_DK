package pl.sda.addressManager.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressManager.controller.VerticalBoxController;
import pl.sda.addressManager.model.Person;

import java.io.IOException;

public class PersonView {
    private Stage primaryStage;
    private ObservableList<Person> personObservableList=
            FXCollections.observableArrayList();

    public PersonView() {
    }

    public ObservableList<Person> getPersonObservableList() {
        return personObservableList;
    }


    public PersonView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        personObservableList.add(new Person("Tomasz","Skoczylas","Kręta","Toruń","87-100","+489999"));
        personObservableList.add(new Person("Roman","Radkowski","Rumuńska","Grębocin","87-102","+489999332"));
    }

    public void  loadView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/VerticalBox.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        primaryStage.setTitle("Address Book");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        VerticalBoxController verticalBoxController = loader.getController();
        verticalBoxController.setPersonView(this);
        primaryStage.show();

    }

    public void loadNewPersonView(){
        FXMLLoader content = new FXMLLoader(getClass().getResource("/PersonManager.fxml"));
        Parent root2 = null;
        try {
            root2 = content.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        content.getRoot();
        stage.setResizable(false);
        stage.setTitle("Add Worker");
        stage.setScene(new Scene(root2));
        stage.showAndWait();

    }
}
