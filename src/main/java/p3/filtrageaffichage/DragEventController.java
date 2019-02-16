/**
 * Sample Skeleton for 'DragEvent.fxml' Controller Class
 */

package p3.filtrageaffichage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DragEventController implements Initializable {

  @FXML // fx:id="paneGaucheHaut"
  private Pane paneGaucheHaut; // Value injected by FXMLLoader

  @FXML
  private Pane paneGaucheBas; // Value injected by FXMLLoader

  @FXML
  private Pane paneDroitBas; // Value injected by FXMLLoader
  @FXML
  private Pane paneDroitHaut; // Value injected by FXMLLoader
	
	@FXML // fx:id="imgViewGaucheHaut"
	private ImageView									imgViewGaucheHaut;	// Value injected by FXMLLoader

	@FXML // fx:id="imgViewGaucheBas"
	private ImageView									imgViewGaucheBas;		// Value injected by FXMLLoader

	@FXML // fx:id="groupeBtnGauche"
	private ButtonBar									groupeBtnGauche;		// Value injected by FXMLLoader

	@FXML // fx:id="btnEchangeGauche"
	private ToggleButton							btnEchangeGauche;		// Value injected by FXMLLoader

	@FXML // fx:id="btnInactifGauche"
	private ToggleButton							btnInactifGauche;		// Value injected by FXMLLoader

	@FXML // fx:id="vDroite"
	private VBox											vDroite;						// Value injected by FXMLLoader

	@FXML // fx:id="groupeBtnDroit"
	private ButtonBar									groupeBtnDroit;			// Value injected by FXMLLoader

	@FXML // fx:id="btnInactifDroit"
	private ToggleButton							btnInactifDroit;		// Value injected by FXMLLoader

	@FXML // fx:id="btnEchangerDroit"
	private ToggleButton							btnEchangerDroit;		// Value injected by FXMLLoader

	@FXML // fx:id="imgViewDroiteHaut"
	private ImageView									imgViewDroiteHaut;	// Value injected by FXMLLoader

	@FXML // fx:id="imgViewDroiteBas"
	private ImageView									imgViewDroiteBas;		// Value injected by FXMLLoader

	private EventHandler<InputEvent>	filtreInacrif;

	@FXML
	void dragDetected(MouseEvent event) {

	}

	@FXML
	void dragDone(DragEvent event) {

	}

	@FXML
	void dragEntered(DragEvent event) {

	}

	@FXML
	void dragExited(DragEvent event) {

	}

	@FXML
	void dragOver(DragEvent event) {

	}

	@FXML
	void handleDrop(DragEvent event) {

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert imgViewGaucheHaut != null : "fx:id=\"imgViewGaucheHaut\" was not injected: check your FXML file 'DragEvent.fxml'.";
		assert imgViewGaucheBas != null : "fx:id=\"imgViewGaucheBas\" was not injected: check your FXML file 'DragEvent.fxml'.";
		assert groupeBtnGauche != null : "fx:id=\"groupeBtnGauche\" was not injected: check your FXML file 'DragEvent.fxml'.";
		assert btnEchangeGauche != null : "fx:id=\"btnEchangeGauche\" was not injected: check your FXML file 'DragEvent.fxml'.";
		assert btnInactifGauche != null : "fx:id=\"btnInactifGauche\" was not injected: check your FXML file 'DragEvent.fxml'.";
		assert vDroite != null : "fx:id=\"vDroite\" was not injected: check your FXML file 'DragEvent.fxml'.";
		assert groupeBtnDroit != null : "fx:id=\"groupeBtnDroit\" was not injected: check your FXML file 'DragEvent.fxml'.";
		assert btnInactifDroit != null : "fx:id=\"btnInactifDroit\" was not injected: check your FXML file 'DragEvent.fxml'.";
		assert btnEchangerDroit != null : "fx:id=\"btnEchangerDroit\" was not injected: check your FXML file 'DragEvent.fxml'.";
		assert imgViewDroiteHaut != null : "fx:id=\"imgViewDroiteHaut\" was not injected: check your FXML file 'DragEvent.fxml'.";
		assert imgViewDroiteBas != null : "fx:id=\"imgViewDroiteBas\" was not injected: check your FXML file 'DragEvent.fxml'.";

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.filtreInacrif = new EventHandler<InputEvent>() {

			@Override
			public void handle(InputEvent event) {
				System.out.println(event.getEventType());
			}
		};
		
		this.paneGaucheHaut.addEventFilter(InputEvent.ANY, filtreInacrif);
		this.paneGaucheBas.addEventFilter(InputEvent.ANY, filtreInacrif);
		this.paneDroitHaut.addEventFilter(InputEvent.ANY, filtreInacrif);
		this.paneDroitBas.addEventFilter(InputEvent.ANY, filtreInacrif);
		

	}
	
	private ChangeListener<Toggle> listenerToGGle(){
		return new ChangeListener<Toggle>() {
			
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
						
			}
		};
	}
}
