package rpgStory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

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
	 private void openRpgBattle1() throws IOException{
		try {
			PrintWriter fin = new PrintWriter(new File("/screen/BattleDecisions.txt"));
			fin.println(1);
		}catch(FileNotFoundException ex) {
			
		}
		
		
		stage = (Stage) battleBtn.getScene().getWindow();
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/screen/BattleScreen.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		System.out.println("BattleScreen.fxml opened");
		 
	}
}
