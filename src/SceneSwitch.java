import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
	@FXML
	Button newGame;
		
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
		 System.out.println("minefield.fxml opened");
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
		 root = (Pane) FXMLLoader.load(getClass().getResource("/screen/mainMenu.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 System.out.println("/screen/mainMenu.fxml opened");
	 }
	 
	 @FXML
	 private void openRpgStory() throws IOException{
		 stage = (Stage) startBtn.getScene().getWindow();
		 Pane root = (Pane) FXMLLoader.load(getClass().getResource("/rpgStory/StorySections.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 System.out.println("StorySections.fxml opened");
		 
	 }
	 
	 @FXML
	 private void setNewGame() throws IOException {
		 try(PrintWriter change = new PrintWriter(new File("src/Max.txt"));
			 PrintWriter change2 = new PrintWriter(new File("src/Unlocked.txt"));
			 ){
			 change.printf("%d", 1);
			 change2.printf("%d", 1);
			 
			 newGame.setVisible(false);
			 
		 } catch (FileNotFoundException ex) {
			
		}
	 }
}
