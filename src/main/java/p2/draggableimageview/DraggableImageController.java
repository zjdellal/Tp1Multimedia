package p2.draggableimageview;

import java.awt.Toolkit;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class DraggableImageController implements Initializable {
	@FXML
	private ImageView imgView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		Image img = new Image(this.getClass().getResourceAsStream("/car.jpeg"));
//		this.imgView.setImage(img);
		this.dragAndDrop();
		this.dragDetected();
		
	}
	
	@FXML
	private void dragDetected() {
		this.imgView.setOnDragOver((DragEvent event) -> {
			Dragboard db  = event.getDragboard();
			java.awt.datatransfer.Clipboard clipBoard ;
			Image img  = new Image(this.getClass().getResourceAsStream("/car.jpeg"));
			if(db.hasFiles()) {
				System.out.println("allo");
				event.acceptTransferModes(TransferMode.COPY);

			}
			clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
			db.getContentTypes();
			
			event.consume();

		});
	} 
	
	@FXML
	private void dragAndDrop(){
		
		
	}

}
