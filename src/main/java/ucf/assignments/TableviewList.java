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
    //private LocalDate dueDate;
    private SimpleStringProperty dueDate;


    public TableviewList(String description, String dueDate)
    {
        this.status = new CheckBox();
        this.description = new SimpleStringProperty(description);
        this.dueDate = new SimpleStringProperty(dueDate);
    }

    public TableviewList()
    {
        this.status = null;
        this.description = null;
        this.dueDate = null;
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

    /*public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) { // LocalDate -> String
        this.dueDate = LocalDate.parse(dueDate); //  = dueDate
    }

     */

    public String getDueDate() {
        return dueDate.get();
    }

    public SimpleStringProperty dueDateProperty() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = new SimpleStringProperty(dueDate);
    }

    public CheckBox getStatus() {
        return status;
    }

    public void setStatus(String status) { // Checkbox status
        CheckBox tempCheckBox = new CheckBox();

        tempCheckBox.setSelected(Boolean.parseBoolean(status));

        this.status = tempCheckBox;
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
