package p2.draggableimageview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class DraggableImageController implements Initializable {
	@FXML
	private ImageView	imgView;
	ClipboardContent content ;

	public void initialize(URL location, ResourceBundle resources) {


	}
	
	
/**
 * méthode qu détecte le drag , copy le contenu et le mets dans le presse papier
 * @param event
 */
	@FXML
	private void dragDetected(DragEvent event) {
		Dragboard db = this.imgView.startDragAndDrop(TransferMode.COPY);
		 this.content  =  new ClipboardContent();
		this.content.putImage(this.imgView.getImage());
		db.setContent(content);
		event.consume();
	}



/**
 * méthode qui va accépter le drag  (copy ou move)
 * @param event
 */
	@FXML
	private void dragOver(DragEvent event) {
		
			if (event.getDragboard().hasFiles()) {
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			}
			event.consume();
	
	}

	/**
	 * méthode qui récupe le cntenu du presse papier (le path du fichier selectionné) va chercher le fichier
	 * et set l'image de imageView 
	 * @param event
	 * @throws FileNotFoundException
	 */
	@FXML
	private void handleDrop(DragEvent event) throws FileNotFoundException {
		List<File> files  = event.getDragboard().getFiles();
		if(!files.isEmpty()) {
			Image img = new Image(new FileInputStream(files.get(0)));
			this.imgView.setImage(img);
			event.setDropCompleted(true);	
		}else {
			event.setDropCompleted(false);
		}
		
		event.consume();
	}
	
	@FXML
	private void dragDone() {
		this.imgView.setOnDragDone((DragEvent event)->{
			TransferMode modeUsed = event.getTransferMode();
			
			if(modeUsed == TransferMode.COPY) {

			}
			event.consume();
		});
	
	}
	/**
	 * méthode qui détecte sous la souris est entrée dans la zonne de drag 
	 * tout en assurant qu'il ya un fichier séléctionné
	 */
	@FXML
	private void dragEntered() {
		this.imgView.setOnDragEntered((DragEvent event ) -> {
			if(event.getDragboard().hasFiles()) {
				System.out.println("zone draggable , type drag : " + event.getDragboard().getFiles());
			}
			event.consume();
		});
	}
	
	// detecte si on est sortit de la zone du drag and drop
	@FXML
	private void dragExited() {
		this.imgView.setOnDragExited((DragEvent event) ->{
			System.out.println("Sortie de la zone draggable");
			event.consume();
		});
	}



}
