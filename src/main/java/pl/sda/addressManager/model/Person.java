package pl.sda.addressManager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class Person {

    private StringProperty name;
    private StringProperty lastname;
    private StringProperty street;
    private StringProperty city;
    private StringProperty zipcode;
    private StringProperty telphone;

    public Person() {
    }

    public Person(String name, String lastname, String street, String city, String zipcode, String telphone) {
        this.name = new SimpleStringProperty(name);
        this.lastname = new SimpleStringProperty(lastname);
        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        this.zipcode = new SimpleStringProperty(zipcode);
        this.telphone = new SimpleStringProperty(telphone);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", lastname=" + lastname +
                ", street=" + street +
                ", city=" + city +
                ", zipcode=" + zipcode +
                ", telphone=" + telphone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(street, person.street) &&
                Objects.equals(city, person.city) &&
                Objects.equals(zipcode, person.zipcode) &&
                Objects.equals(telphone, person.telphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, street, city, zipcode, telphone);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastname() {
        return lastname.get();
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getZipcode() {
        return zipcode.get();
    }

    public StringProperty zipcodeProperty() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode.set(zipcode);
    }

    public String getTelphone() {
        return telphone.get();
    }

    public StringProperty telphoneProperty() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone.set(telphone);
    }
}
