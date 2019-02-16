package p1.operationmathtp1;


import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
	

	
	/**
	 * méthode qui met les compsants sous écoute , on retrouve seulement le boutton Somme
	 * qui va calculer la somme des chiffres selectionnées dans la listeView
	 */
	public void mettreComposantSousEcoute() {
		this.btnSomme.setOnAction(this.listenerBtnSomme());
	}
	
	private EventHandler<ActionEvent> listenerBtnSomme() {
		return  new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if(minVal.getValue() >= maxVal.getValue()) {
						ObservableList<Integer> selectedItesms = listeResult.getSelectionModel().getSelectedItems();
						Iterator<Integer> it  = selectedItesms.iterator();
						int somme = 0;
						while(it.hasNext()) {
							somme+= it.next();
							txtResult.setText(String.valueOf(somme));
						}
						
				}else {
					
				}
			}
		};
	}

	/**
	 * méthode initialize qui se lance via l'interface Initalizable , C,est la que notre Binding se fait
	 */
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("chargement des données");
		//StringProperty
		this.minProperty = txtMin.textProperty();
		this.maxProperty = txtMax.textProperty();
		
		//SimpleIntegerProperty
		minVal =  new SimpleIntegerProperty();
		this.minProperty.bindBidirectional(minVal,NumberFormat.getNumberInstance());
		
		this.maxVal =  new SimpleIntegerProperty();
		this.maxProperty.bindBidirectional(this.maxVal, NumberFormat.getNumberInstance());
		

		this.moyenneVal =  new SimpleStringProperty();

		
	
	this.txtMoyenne.textProperty().bind(this.moyenneVal);

		if(this.minVal.getValue() > this.maxVal.getValue()) {
			this.lblErr.setVisible(true);

		}else {
			this.lblErr.setVisible(false);

		}
			
		this.listeResult.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.chargerListeView();
		this.mettreComposantSousEcoute();

	}
	
	/**
	 * méthode qui charge les chiffres de la liste view (chiffres aléatoire entre 0 - 999)
	 * et les charger dans la liste View
	 */
	private void chargerListeView() {
		List<Integer>liste = new ArrayList<Integer>();

		
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
