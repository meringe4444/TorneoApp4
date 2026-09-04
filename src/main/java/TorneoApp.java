import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TorneoApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                TorneoApp.class.getResource("TorneoView.fxml")
        );

        Scene scene = new Scene(loader.load(), 1080, 650);

        stage.setTitle("Torneo Aplicacion");
        stage.setScene(scene);
        stage.show();
    }
}