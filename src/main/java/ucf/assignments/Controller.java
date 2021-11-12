package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML private TableView<TodoTask> taskTable;
    @FXML private TableColumn<TodoTask, String> taskTitle;

    @FXML private TextField titleText;


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
        TodoTask newTask = new TodoTask(titleText.getText());
        taskTable.getItems().add(newTask);

        Parent dataTableParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TodoGUI.fxml")));
        Scene dataTableScene = new Scene(dataTableParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(dataTableScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //set up the columns in the table
        taskTitle.setCellValueFactory(new PropertyValueFactory<TodoTask, String>("Title"));

        //load dummy data
        taskTable.setItems(getTasks());

        //Update the table to allow for the first and last name fields
        //to be editable
        //tableView.setEditable(true);
        //firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //This will allow the table to select multiple rows at once
        //tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Disable the detailed person view button until a row is selected
        //this.detailedPersonViewButton.setDisable(true);
    }

    public ObservableList<TodoTask> getTasks()
    {
        ObservableList<TodoTask> task = FXCollections.observableArrayList();
        task.add(new TodoTask("Tasks"));

        return task;
    }

}
