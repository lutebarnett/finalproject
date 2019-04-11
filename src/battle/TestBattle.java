package battle;

import java.util.ResourceBundle;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TestBattle  extends Application implements Initializable{
	
	@FXML
	Text test;
	
	@FXML
	Button btn;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final FXMLLoader root = new FXMLLoader(getClass().getResource("/battle/ScreenTest.fxml"));
		Pane p = root.load();

		Scene scene = new Scene(p);
		scene.setFill(javafx.scene.paint.Color.RED);
		primaryStage.setTitle("MyExampleApp");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				StringBuilder s = new StringBuilder("HELLO EVERYONE");
								
				for(int i = 0; i <= s.toString().length(); i++) {
					String a = s.toString().substring(0, i);
					try {
						wait(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}		
		});
	}
	
}

	

	

