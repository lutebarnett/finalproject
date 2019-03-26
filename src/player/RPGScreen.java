package player;

import java.net.URL;
import java.util.ResourceBundle;

import battle.Enemy;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RPGScreen extends Application implements Initializable{
	
	@FXML
	Text myText;
	@FXML
	Button attack;
	
	Enemy e = new Enemy (100,100);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader screen = new FXMLLoader(getClass().getResource("BattleScreen.fxml"));
		
		BorderPane p = screen.load();
		
		Scene scene = new Scene(p);
		primaryStage.setTitle("Minesweeper the RPG");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		attack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				e.takeDamage(10);
				
				StringBuilder s = new StringBuilder("[");
				
				for(int i = 0; i < 20; i++) {
					
				}
				
				s.append("]");
				myText.setText(String.format("%d", e.getHealth()));
			}
		});

	}

}
