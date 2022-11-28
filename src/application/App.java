package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage crud) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("App.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        crud.setTitle("CRUD Clínica Médica - Trabalho de Banco de Dados");
        crud.setScene(tela);
        crud.show();
    }

    public static void main(String[] args) throws Exception {
        Application.launch(App.class, args);
    }
}
