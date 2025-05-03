

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage var1 )throws Exception {
      Parent var2 = FXMLLoader.load(this.getClass().getResource("AddBook.fxml"));
      var1.setTitle("Registration Form FXML Application");
      var1.setScene(new Scene(var2, 600.0, 550.0));
      var1.show();
    }

    public static void main(String[] var0) {
        launch(var0);
    }
}