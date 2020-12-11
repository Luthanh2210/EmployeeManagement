package app.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import app.model.Employee;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Insets;


import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class
EmployeeController implements Initializable {

    @FXML
    private TextField empIdText;
    @FXML
    private TextArea resultArea;
    @FXML
    private TextField newEmailText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField surnameText;
    @FXML
    private TextField emailText;
    @FXML
    private TextField empPText;
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, String> empIdColumn;
    @FXML
    private TableColumn<Employee, String> empNameColumn;
    @FXML
    private TableColumn<Employee, String> empLastNameColumn;
    @FXML
    private TableColumn<Employee, String> empEmailColumn;
    @FXML
    private TableColumn<Employee, String> empPhoneNumberColumn;
//    @FXML
//    public TableColumn<Employee, Date> empHireDateColumn;

    private ObservableList<Employee> dataList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataList = FXCollections.observableArrayList(
                new Employee("1", "dat", "quoc", "dat@", "12*"),
                new Employee("2", "dat", "vinh", "dat@", "13*")
        );
        empIdColumn.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        empNameColumn.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        empLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        empEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        empPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
//        empHireDateColumn.setCellValueFactory(new PropertyValue   Factory<>("EmployeeHireDate"));
        empNameColumn.setSortType(TableColumn.SortType.DESCENDING);
        empLastNameColumn.setSortable(false);

        employeeTable.setItems(dataList);
    }

    //observable list to store data

    public void insert(ActionEvent actionEvent) {
        Employee employee = new Employee((empIdText.getText()), nameText.getText(), surnameText.getText(), emailText.getText(), empPText.getText());
        employeeTable.getItems().add(employee);
    }
    public void delete(ActionEvent actionEvent) {
        Employee selected = employeeTable.getSelectionModel().getSelectedItem();
        dataList.remove(selected);
    }
}
