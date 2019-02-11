package operationmathtp1;


import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class FxmlCtrl_P1_TP implements Initializable {
private ObservableList<Integer> listeNumber;
	@FXML
	private Label								lblErr;
	@FXML
	private TextField						txtMax;
	@FXML
	private TextField						txtMin;
	@FXML
	private TextField						txtMoyenne;
	@FXML
	private TextField						txtResult;
	@FXML
	private ListView<Integer>	listeResult;
	@FXML
	private Button btnSomme;
	
	private StringProperty minProperty;
	private StringProperty maxProperty;

	private SimpleIntegerProperty minVal ,maxVal;
	private SimpleStringProperty moyenneVal;
	private StringProperty moyenneProperty;
	
	public void mettreComposantSousEcoute() {
		this.btnSomme.setOnAction(this.listenerBtnSomme());
	}
	
	private EventHandler<ActionEvent> listenerBtnSomme() {
		return  new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if(minVal.getValue() >= maxVal.getValue()) {
//					lblErr.setVisible(true);
//					System.out.println("min val = " + minVal.getValue());
//					moyenneVal.setValue((minVal.getValue()+maxVal.getValue())/2);
//				
				}else {
					
				}
			}
		};
	}

	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("chargement des données");
		//StringProperty
		this.minProperty = txtMin.textProperty();
		this.maxProperty = txtMax.textProperty();
		this.moyenneProperty =  this.txtMoyenne.textProperty();
		
		//SimpleIntegerProperty
		minVal =  new SimpleIntegerProperty();
		this.minProperty.bindBidirectional(minVal,NumberFormat.getNumberInstance());
		
		this.maxVal =  new SimpleIntegerProperty();
		this.maxProperty.bindBidirectional(this.maxVal, NumberFormat.getNumberInstance());
		
		this.maxVal.setValue(100);
		this.minVal.setValue(500);
		
		this.moyenneVal =  new SimpleStringProperty();
		this.moyenneVal.setValue(String.valueOf((this.minVal.getValue()+this.maxVal.getValue())/2));
		this.moyenneProperty.bind(this.moyenneVal);
	
		if(this.minVal.getValue() > this.maxVal.getValue()) {
			this.lblErr.setVisible(true);

		}else {
			this.lblErr.setVisible(false);

		}
	

		
		
		this.listeResult.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.chargerListeView();
		
		this.mettreComposantSousEcoute();

	}
	
	private void chargerListeView() {
		List<Integer>liste = new ArrayList<>();

		
		int max = 999;
		int min = 0;
		for(int i = 0 ; i < 10 ; i++) {
			int random =(int) (Math.random() * max + min );
			liste.add(random);
		}
		
		
		listeNumber =  FXCollections.observableArrayList(liste);
		this.listeResult.setItems(listeNumber);
	}

}
