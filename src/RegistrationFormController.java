package src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx. scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx. scene. control. Button;
import javafx. scene. control. PasswordField;
import javafx. scene.control.TextField;
import javafx. stage. Window;

public class RegistrationFormController {
@ FXML
private TextField nameField;

@ FXML
private TextField emailField;

@ FXML
private PasswordField passwordField;

@ FXML
private Button submitButton ;
@FXML
protected void handleSubmitButtonAction (ActionEvent event)
{
Window owner = submitButton.getScene() .getWindow();
Alert alert = new Alert (AlertType. ERROR);
if (nameField.getText () .isEmpty () ) {
alert.setTitle("Form Error!");
alert.setHeaderText (null);
alert.setContentText ("Please enter your name") ;
alert.initOwner (owner);
alert.show ();
}
else if (emailField.getText () .isEmpty () ) {
    alert.setTitle("Form Error!");
    alert.setHeaderText (null);
    alert.setContentText ("Please enter your email") ;
    alert.initOwner (owner);
    alert.show ();
}
else if (passwordField.getText () .isEmpty () ) {
    alert.setTitle("Form Error!");
    alert.setHeaderText (null);
    alert.setContentText ("Please enter your Password") ;
    alert.initOwner (owner);
    alert.show ();
}
else{
    Alert a = new Alert (AlertType.INFORMATION);
    a.setTitle("Registeration Successful!");
    a.setContentText ("Welcome " + nameField.getText () ) ;
    a.show();
}
 
}
}