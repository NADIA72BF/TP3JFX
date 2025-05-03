
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddBookControlor implements Initializable {



    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button addBtn;
    @FXML
    private Button exportBtn;
    @FXML
    private Button importBtn;
    @FXML
    private Button removeBtn;
    
    @FXML
    private Button quitBtn;
    @FXML
    private TableView<Person> table;
  
    @FXML
    private TableColumn<Person, String> emailCol;
    @FXML
    private TableColumn<Person, String> firstNameCol;
    @FXML
    private TableColumn<Person, String> lastNameCol;
    
    private DataClass data;

  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = new DataClass();
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("adrMail"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("prenom"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("nom"));
        table.setItems(FXCollections.observableArrayList());
    }

    javafx.scene.control.Alert alert = new javafx.scene.control.Alert(AlertType.WARNING);
    public void showAlert(String message) {
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static boolean isValidEmail(String email) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher m= p.matcher(email.toUpperCase());
        return m.matches();
    }
    
    public void addBtn(javafx.event.ActionEvent event) {
        String prenom = tfFirstName.getText();
        String nom = tfLastName.getText();
        String adrMail = tfEmail.getText();
        if(prenom.isEmpty() || nom.isEmpty() || adrMail.isEmpty()) {
            showAlert("Remplir tous les champs !");
            return;
        }
        else{
            if (!isValidEmail(adrMail)){
                showAlert(adrMail+ " : Email incorrect ! ");
            }
            else{
                Person p = new Person(prenom, nom, adrMail);
                List <Person> list = new java.util.ArrayList<>();
                list.add(p);
                table.setItems(FXCollections.observableArrayList(list));   
            }
        }
    }
   
    public void removeBtn() {
        Person selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            table.getItems().remove(selected); 
        } else {
            showAlert("Veuillez sélectionner une personne à supprimer !");
        }
    }

    public void importBtn(){
        data.getImportList();
        table.setItems(FXCollections.observableArrayList(data.getImportList()));
    }   

    public void exportBtn(){
        data.getExportList();
        table.setItems(FXCollections.observableArrayList(data.getExportList()));
    }
    
    public void quitBtn(){
        System.exit(0);
    }
   
  
}

    
  
    
  
