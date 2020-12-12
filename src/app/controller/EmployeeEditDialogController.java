package app.controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import app.model.Employee;

public class EmployeeEditDialogController {

    public Label Id;
    @FXML
    private TextField IDTextField;
    @FXML
    private TextField NameTextField;
    @FXML
    private TextField LastNameTextField;
    @FXML
    private TextField EmailTextField;
    @FXML
    private TextField PhoneTextField;


    private Stage dialogStage;
    private Employee employee;
    private boolean okClicked = false;


    @FXML
    private void initialize() {
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;

        IDTextField.setText(employee.getEmployee_id());
        NameTextField.setText(employee.getFirst_name());
        LastNameTextField.setText(employee.getLast_name());
        EmailTextField.setText(employee.getEmail());
        PhoneTextField.setText(employee.getPhone_number());
    }


    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            employee.setEmployee_id(IDTextField.getText());
            employee.setFirst_name(NameTextField.getText());
            employee.setLast_name(LastNameTextField.getText());
            employee.setEmail(EmailTextField.getText());
            employee.setPhone_number(PhoneTextField.getText());


            okClicked = true;
            dialogStage.close();
        }
    }


    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    private boolean isInputValid() {
        String errorMessage = "";

        if (IDTextField.getText() == null || IDTextField.getText().length() == 0) {
            errorMessage += "No valid ID!\n";
        }
        if (NameTextField.getText() == null || NameTextField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (LastNameTextField.getText() == null || LastNameTextField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }

        if (EmailTextField.getText() == null || EmailTextField.getText().length() == 0) {
            errorMessage += "No valid email !\n";

        }

        if (PhoneTextField.getText() == null || PhoneTextField.getText().length() == 0) {
            errorMessage += "No valid value!\n";
        }
            if (errorMessage.length() == 0) {
                return true;
            } else {
                // Show the error message.
                Alert alert = new Alert(AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText(errorMessage);

                alert.showAndWait();

                return false;
            }
        }
    }
