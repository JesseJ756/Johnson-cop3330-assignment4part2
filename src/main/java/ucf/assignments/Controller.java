/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML private TableView<TableviewList> listTable;
    @FXML private TableColumn<TableviewList, String> listDescriptionColumn;
    @FXML private TableColumn<TableviewList, String> listStatusColumn;
    @FXML private TableColumn<TableviewList, LocalDate> listDueDateColumn;


    @FXML private TextField titleText;

    @FXML private TextArea textDescriptionTextField;
    @FXML private DatePicker dueDateTextField;

    @FXML private Label counter;

    @FXML private Button newItemButton;
    @FXML private Button deleteItemButton;


    public void newListButtonPushed(javafx.event.ActionEvent event) throws IOException
    {
        /*
        Parent dataTableParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MakeTaskGUI.fxml")));
        Scene dataTableScene = new Scene(dataTableParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(dataTableScene);
        window.show();
        */
    }

    public void deleteItemButtonPushed(javafx.event.ActionEvent event)
    {

        // delete item from selected item from table view
        // move all lower items up

    }

    public void deleteTaskButtonPushed(javafx.event.ActionEvent event)
    {

        // delete item from selected task from table view
        // move all lower task up

    }

    public void returnFromNewListAdd(javafx.event.ActionEvent event) throws IOException
    {
        Parent dataTableParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ToDoGUI.fxml")));
        Scene dataTableScene = new Scene(dataTableParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(dataTableScene);
        window.show();
    }

    public void newItemButtonPushed(javafx.event.ActionEvent event) throws IOException
    {
        Parent dataTableParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MakeItemGUI.fxml")));
        Scene dataTableScene = new Scene(dataTableParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(dataTableScene);
        window.show();
    }

    public void returnFromNewItemAdd(javafx.event.ActionEvent event) throws IOException
    {
        Parent dataTableParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ItemInListGUI.fxml")));
        Scene dataTableScene = new Scene(dataTableParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(dataTableScene);
        window.show();
    }

    public void returnFromItems(javafx.event.ActionEvent event) throws IOException
    {
        Parent dataTableParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TodoGUI.fxml")));
        Scene dataTableScene = new Scene(dataTableParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(dataTableScene);
        window.show();
    }

    public void addTaskButtonPushed(javafx.event.ActionEvent event) throws IOException
    {
        /*
        TableviewList newTask = new TableviewList(titleText.getText());
        listTable.getItems().add(newTask);

        Parent dataTableParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TodoGUI.fxml")));
        Scene dataTableScene = new Scene(dataTableParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(dataTableScene);
        window.show();
        */
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        final int MAX_CHARS = 256 ;

        //set up the columns in the table
        listStatusColumn.setCellValueFactory(new PropertyValueFactory<TableviewList, String>("Status"));
        listDescriptionColumn.setCellValueFactory(new PropertyValueFactory<TableviewList, String>("Description"));
        listDueDateColumn.setCellValueFactory(new PropertyValueFactory<TableviewList, LocalDate>("DueDate"));

        textDescriptionTextField.setTextFormatter(new TextFormatter<String>(change ->
                                                    change.getControlNewText().length() <= MAX_CHARS ? change : null));

        counter.textProperty().bind(textDescriptionTextField.textProperty().length().asString("%d"));

        //load dummy data
        //taskTable.setItems(getTasks());

        //Update the table to allow for the first and last name fields
        //to be editable
        //tableView.setEditable(true);
        //firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //This will allow the table to select multiple rows at once
        //listTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Disable the detailed person view button until a row is selected
        //this.detailedPersonViewButton.setDisable(true);

        // Allow texts in cells to be editable
        listTable.setEditable(true);
        listDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //listDueDateColumn.setEditable(true);
        //listDueDateColumn.setCellFactory(editorProperty());
        //listDueDateColumn.setOnEditCommit(event -> event.getRowValue().setDueDate(event.getNewValue()));
    }

    /*
    public ObservableList<TableviewList> getTasks()
    {
        //ObservableList<TableviewList> task = FXCollections.observableArrayList();
        //task.add(new TableviewList("Tasks"));

        return task;
    }

     */

    public void newItemButtonPressed()
    {
        TableviewList newItem = new TableviewList(textDescriptionTextField.getText(), dueDateTextField.getValue());

        // Loops through items then add to end of list
        listTable.getItems().add(newItem);
    }

    public void changeDescription(TableColumn.CellEditEvent editCell)
    {
        TableviewList descriptionSelected = listTable.getSelectionModel().getSelectedItem();
        descriptionSelected.setDescription(editCell.getNewValue().toString());
    }

    public void changeDueDate(TableColumn.CellEditEvent editCell)
    {
        TableviewList dueDateSelected = listTable.getSelectionModel().getSelectedItem();
        dueDateSelected.setDueDate(editCell.getNewValue().toString());
    }

    public void deleteItemButtonPressed()
    {
        ObservableList<TableviewList> tempItemsList, selectedItems;
        tempItemsList = listTable.getItems();

        selectedItems = listTable.getSelectionModel().getSelectedItems();

        for(TableviewList items: selectedItems)
        {
            tempItemsList.remove(items);
        }
    }

    public void clearListButtonPressed()
    {
        ObservableList<TableviewList> tempItemsList;
        tempItemsList = listTable.getItems();

        tempItemsList.clear();
    }


}
