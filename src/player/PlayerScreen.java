package player;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayerScreen extends Application{
		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) {
			//title of the window/stage
			primaryStage.setTitle("Minesweeper the RPG");
			
			//created a single button on the stage/inside the window
			Button button1 = new Button();
			Button button2 = new Button();
			
			GridPane grid = new GridPane();
			grid.add(button1, 1, 0);
			grid.add(button2, 2, 0);
			
			Scene scene = new Scene(grid, 400, 300);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
	}

