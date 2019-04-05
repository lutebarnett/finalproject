import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class SceneSwitch implements Initializable{

	@FXML 
	Button startBtn;
	@FXML
	Button testBtn;
	@FXML 
	Button quitBtn;
	
	private Stage stage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	 @FXML
	   private void openMinefield() throws IOException{
	        stage = (Stage) startBtn.getScene().getWindow();
	        Pane root;
	        root = (Pane) FXMLLoader.load(getClass().getResource("minefield.fxml"));
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        System.out.println("minefeild.fxml opened");
	   }
	 @FXML
	 	private void quitGame() {
		 System.out.println("Quitting game");
		 System.exit(0);
	 }
	 
	 @FXML
	   private void openMainmenu() throws IOException{
	        stage = (Stage) testBtn.getScene().getWindow();
	        Pane root;
	        root = (Pane) FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        System.out.println("mainMenud.fxml opened");
	   }

}
