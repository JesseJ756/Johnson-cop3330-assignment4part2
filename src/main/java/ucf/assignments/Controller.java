/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller implements Initializable
{
    @FXML private TableView<TableviewList> listTable;
    @FXML private TableColumn<TableviewList, String> listDescriptionColumn;
    @FXML private TableColumn<TableviewList, String> listStatusColumn;
    @FXML private TableColumn<TableviewList, String> listDueDateColumn;

    @FXML private TextArea textDescriptionTextField;
    @FXML private TextField dueDateTextField;
    @FXML private Label counter;
    @FXML private Text invalidDate;

    //@FXML private Button newItemButton;
    //@FXML private Button deleteItemButton;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        final int MAX_CHARS = 256 ;

        //set up the columns in the table
        listStatusColumn.setCellValueFactory(new PropertyValueFactory<>("Status")); // <TableviewList, String>
        listDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description")); // <TableviewList, String>
        listDueDateColumn.setCellValueFactory(new PropertyValueFactory<>("DueDate")); // <TableviewList, String>

        textDescriptionTextField.setTextFormatter(new TextFormatter<String>(change ->
                                                    change.getControlNewText().length() <= MAX_CHARS ? change : null));

        counter.textProperty().bind(textDescriptionTextField.textProperty().length().asString("%d"));

        //This will allow the table to select multiple rows at once
        //listTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Allow texts in cells to be editable
        listTable.setEditable(true);
        listDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        listDueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void newItemButtonPressed()
    {
        TableviewList newItem; // = null
        int isDueDateValid = validDueDateCheck(dueDateTextField.getText());

        if(isDueDateValid == 1)
        {
            invalidDate.setFill(Color.TRANSPARENT);
            newItem = new TableviewList(textDescriptionTextField.getText(), dueDateTextField.getText());

            // Loops through items then add to end of list
            listTable.getItems().add(newItem);
        }
        else
        {
            invalidDate.setFill(Color.RED);
            System.out.println("Invalid due date format detected.");
        }
    }

    public int validDueDateCheck(String date)
    {
        boolean validDateFormat;
        int month;
        int day;
        int dayInMonth; // = 0

        System.out.println(date);

        validDateFormat = date.matches("\\d{4}-\\d{2}-\\d{2}");

        if(!validDateFormat)
            return 0;

        month = Integer.parseInt(date.substring(5, 7));
        day = Integer.parseInt(date.substring(8));

        if(month < 1 || month > 12)
            return 0;

        switch(month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayInMonth = 31;
                break;
            case 2:
                dayInMonth = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayInMonth = 30;
                break;
            default:
                return 0;
        }

        if(day > 0 && day <= dayInMonth)
            return 1;

        return 0;
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

    public void openFileMenuItemPressed() throws IOException {
        int i;
        FileChooser file = new FileChooser();
        File selectedFile = file.showOpenDialog(null);

        if(selectedFile != null)
        {
            System.out.println("File selected");
            System.out.println(selectedFile);

            Collection<TableviewList> allText = Files.readAllLines(selectedFile.toPath()).stream().map(line -> {
                String[] details = line.split(";;");
                TableviewList tempTableviewList = new TableviewList();

                tempTableviewList.setStatus(details[0]);
                tempTableviewList.setDescription(details[1]);
                tempTableviewList.setDueDate(details[2]);
                return tempTableviewList;

            }).collect(Collectors.toList());

            ObservableList<TableviewList> itemListToObserveList = FXCollections.observableArrayList(allText);

            listTable.setItems(itemListToObserveList);
        }
        else
        {
            System.out.println("File not valid");
        }
    }

    public void saveFileMenuItemPressed() throws IOException
    {
        ObservableList<TableviewList> itemsList;
        FileChooser file = new FileChooser();
        File selectedFile = file.showSaveDialog(null);

        if(selectedFile != null)
        {
            System.out.println("selected file");
            itemsList = listTable.getItems();
        }
        else
        {
            System.out.println("Could not select file to save.");
        }

    }

    //public void

}
