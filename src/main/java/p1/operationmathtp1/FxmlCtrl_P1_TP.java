package p1.operationmathtp1;


import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.event.DocumentEvent.EventType;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.SplitPane.Divider;

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
	StringProperty moy ;
	
	
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

	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("chargement des données");
		//StringProperty
		this.minProperty = txtMin.textProperty();
		this.maxProperty = txtMax.textProperty();
//		this.moyenneProperty =  this.txtMoyenne.textProperty();
		
		//SimpleIntegerProperty
		minVal =  new SimpleIntegerProperty();
		this.minProperty.bindBidirectional(minVal,NumberFormat.getNumberInstance());
		
		this.maxVal =  new SimpleIntegerProperty();
		this.maxProperty.bindBidirectional(this.maxVal, NumberFormat.getNumberInstance());
		
//		this.maxVal.setValue(100);
//		this.minVal.setValue(500);
		
		this.moyenneVal =  new SimpleStringProperty();


		
	
	this.txtMoyenne.textProperty().bind(this.moyenneVal);

		if(this.minVal.getValue() > this.maxVal.getValue()) {
			this.lblErr.setVisible(true);

		}else {
			this.lblErr.setVisible(false);

		}
	
this.brancherLblErr();
		
		
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
	
	private void brancherLblErr() {
//this.lblErr.textFillProperty().bind(this.minVal);

	}}
