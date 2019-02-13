package p2.draggableimageview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
				
		Parent root   = FXMLLoader.load(getClass().getResource("/DraggableImageView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("tp1");;
		primaryStage.show();
	}

	 public static void main(String[] args) {
		Application.launch(args);
	}
}
