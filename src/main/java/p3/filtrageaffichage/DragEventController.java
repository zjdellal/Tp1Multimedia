package p3.filtrageaffichage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class DragEventController implements Initializable {

	@FXML // fx:id="panneauGacuhe"
	private AnchorPane panneauGacuhe; // Value injected by FXMLLoader

	@FXML // fx:id="groupeGauche1"
	private ToggleButton groupeGauche1; // Value injected by FXMLLoader

	@FXML // fx:id="panneauGacuhe1"
	private AnchorPane panneauGacuhe1; // Value injected by FXMLLoader

	@FXML // fx:id="groupeGauche"
	private ToggleButton groupeGauche; // Value injected by FXMLLoader

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
