package operationmathtp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OperationMath_P1_TP1 extends Application{


			
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root   = FXMLLoader.load(getClass().getResource("/OperationMath_P1_TP1.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("tp1");;
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
