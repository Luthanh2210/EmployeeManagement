package app.controller;

import app.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        dataList = FXCollections.observableArrayList(
                new Employee("1", "dat", "quoc", "dat@", "12*"),
                new Employee("2", "dat", "vinh", "dat@", "13*")
        );
        empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employee_idProperty());
        empNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        empEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        empPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().PhoneNumberProperty());
//        empHireDateColumn.setCellValueFactory(new PropertyValue   Factory<>("EmployeeHireDate"));
        empNameColumn.setSortType(TableColumn.SortType.DESCENDING);
        empLastNameColumn.setSortable(false);

        employeeTable.setItems(dataList);
        showEmployeeDetail(null);

        employeeTable.getSelectionModel().selectedItemProperty().addListener(
                (observable,oldValue, newValue) -> showEmployeeDetail(newValue));





    }

    private void showEmployeeDetail(Employee employee){
        if(employee !=null) {
            //fill the field text with info from employee object
            empIdText.setText(employee.getEmployee_id());
            nameText.setText(employee.getFirst_name());
            surnameText.setText(employee.getLast_name());
            emailText.setText(employee.getEmail());
            empPText.setText(employee.getPhone_number());

        }else {
            empIdText.setText("");
            nameText.setText("");
            surnameText.setText("");
            emailText.setText("");
            empPText.setText("");
        }
    }


    public void insert(ActionEvent actionEvent) {
        Employee employee = new Employee((empIdText.getText()), nameText.getText(), surnameText.getText(), emailText.getText(), empPText.getText());
        employeeTable.getItems().add(employee);
    }
    @FXML
    public void delete(ActionEvent actionEvent) {
        int selectionIndex = employeeTable.getSelectionModel().getSelectedIndex();
        if(selectionIndex >=0) {
            employeeTable.getItems().remove(selectionIndex);
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a Employee in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void EditEmployee() {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            boolean onClicked = Main.ShowEmployeeEditDialog(selectedEmployee);
            if(onClicked) {
                showEmployeeDetail(selectedEmployee);
            }

        } else  {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Emplopee Selected");
            alert.setContentText("Please select a employee !!!");

            alert.showAndWait();
        }
    }
}

