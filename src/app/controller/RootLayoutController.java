package app.controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import app.Main;
public class RootLayoutController {

    //Exit the program
    public void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    //Help Menu button behavior
    public void handleHelp(ActionEvent actionEvent) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("Program Information");
        alert.setHeaderText("it is fine if I borrow a bit right!");
        alert.setContentText("You can search, delete, update, insert a new employee with this program.");
        alert.show();
    }
}
