package player;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PlayerScreen extends Application{
		private Button[][] btn = new Button[10][10];

	
		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) {
			//title of the window/stage
			primaryStage.setTitle("Minesweeper the RPG");
			
			//created a single button on the stage/inside the window
			GridPane grid = new GridPane();
			for(int i = 0; i < btn.length; i++) {
				for(int i2 = 0; i2 < btn[0].length; i2++) {
					btn[i][i2] = new Button();
					Rectangle r = new Rectangle(30,30);
					r.setArcHeight(0);
					r.setArcWidth(0);
					btn[i][i2].setShape(r);
					btn[i][i2].setText("X");
					grid.add(btn[i][i2], i, i2);
				}
			}
			 
			Scene scene = new Scene(grid, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
	}

