package essais;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application implements Initializable {
	@FXML
	Label lbl;
	@FXML
	TextField txt;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root   = FXMLLoader.load(getClass().getResource("/tuto.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("tuto");;
		primaryStage.show();
		
	}

	public void initialize(URL location, ResourceBundle resources) {
		this.lbl.textProperty().bind(this.txt.textProperty());
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
