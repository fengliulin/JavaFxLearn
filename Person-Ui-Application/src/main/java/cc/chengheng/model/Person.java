/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/10
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class Person {
    private StringProperty firstname =
            new SimpleStringProperty(this, "firstname", "");

    private StringProperty lastname =
            new SimpleStringProperty(this, "lastname", "");

    private StringProperty notes =
            new SimpleStringProperty(this, "notes", "");

    public Person() {
    }

    public Person(String firstname, String lastname, String notes) {
        this.firstname.set(firstname);
        this.lastname.set(lastname);
        this.notes.set(notes);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public StringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
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

    public String getNotes() {
        return notes.get();
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstname.equals(person.firstname) && lastname.equals(person.lastname) && notes.equals(person.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, notes);
    }
}

