/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TodoTask
{
    private String trueString = "true";
    private SimpleStringProperty title;

    public TodoTask(String title)
    {
        this.title = new SimpleStringProperty(title);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }
}
