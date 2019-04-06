package rpgStory;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Sections {
	@FXML
	Button btn1;
	@FXML
	Button battleBtn;
	private Stage stage;
	
	public void printing() {
		System.out.println("hi");
	}
	
	@FXML
	 private void openRpgBattle() throws IOException{
		 stage = (Stage) battleBtn.getScene().getWindow();
		 Pane root = (Pane) FXMLLoader.load(getClass().getResource("/screen/BattleScreen.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 System.out.println("BattleScreen.fxml opened");
		 
	 }
}
