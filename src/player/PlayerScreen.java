package player;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tiles.Tile;

public class PlayerScreen extends Application{
		private Button[][] btn = new Button[10][10];
		//each button will correspond to each tile.
		//when a button is clicked, the location is sought out for and will then
		//correspond to the location in the tile array
		private Tile[][] tile = new Tile[10][10];

	
		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) {
			//title of the window/stage
			primaryStage.setTitle("Minesweeper the RPG");
			
			BorderPane border = new BorderPane();
			
			//creates numerous buttons for the minesweeper game
			GridPane grid = new GridPane();
			for(int i = 0; i < btn.length; i++) {
				for(int i2 = 0; i2 < btn[0].length; i2++) {
					btn[i][i2] = new Button();
					btn[i][i2].setText("X");
					
					//turns to button into a rectangle shape, specifically a square
					Rectangle r = new Rectangle(30,30);
					
					//setting the arcs to 0/turning the curved parts into edges
					r.setArcHeight(0);
					r.setArcWidth(0);
					
					btn[i][i2].setShape(r);
					grid.add(btn[i][i2], i, i2);
					
				}
			}
			
			
			//creates a menu that will appear on the right side of the borderpane
			HBox hBox = new HBox();
			Button btn2 = new Button();
			btn2.setText("Menu");
			hBox.getChildren().addAll(btn2);
			
			border.setLeft(hBox);
			border.setCenter(grid); 
			
			//Creates the scene for primary stage
			Scene scene = new Scene(border, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		
		
	}

