/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

import java.awt.*;
import java.time.LocalDate;

public class TableviewList
{
    private String trueString = "true";
    private CheckBox status;
    private SimpleStringProperty description;
    private LocalDate dueDate;


    public TableviewList(String description, LocalDate dueDate)
    {
        this.status = new CheckBox();
        this.description = new SimpleStringProperty(description);
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
        //this.description.set(description);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public CheckBox getStatus() {
        return status;
    }

    public void setStatus(CheckBox status) {
        this.status = status;
    }

    /*
    public String getTitle()
    {
        return title.get();
    }

    public SimpleStringProperty titleProperty()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title.set(title);
    }

     */
}
