/**
 * Created by pearlterminal on 2/3/16.
 */
package Matrix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent inputScreen = FXMLLoader.load(getClass().getResource("input.fxml"));
        Scene inputScene = new Scene(inputScreen, 600, 400);
        stage.setTitle("The Matrix Multiplier");
        stage.setScene(inputScene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

/*
    TODO:
        Make a clear/reset button
 */