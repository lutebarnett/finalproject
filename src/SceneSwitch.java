import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tiles.Empty;
import tiles.Mine;
import tiles.Tile;


public class SceneSwitch implements Initializable{

	@FXML 
	Button startBtn;
	@FXML
	Button mmBtn;
	@FXML 
	Button quitBtn;
	@FXML
	Button newGame;
	@FXML
	Text mineN;
	@FXML
	Rectangle 
	tile00,tile01,tile02,tile03,tile04,tile05,tile06,tile07,tile08,tile09,
	tile10,tile11,tile12,tile13,tile14,tile15,tile16,tile17,tile18,tile19,
	tile20,tile21,tile22,tile23,tile24,tile25,tile26,tile27,tile28,tile29,
	tile30,tile31,tile32,tile33,tile34,tile35,tile36,tile37,tile38,tile39,
	tile40,tile41,tile42,tile43,tile44,tile45,tile46,tile47,tile48,tile49,
	tile50,tile51,tile52,tile53,tile54,tile55,tile56,tile57,tile58,tile59,
	tile60,tile61,tile62,tile63,tile64,tile65,tile66,tile67,tile68,tile69,
	tile70,tile71,tile72,tile73,tile74,tile75,tile76,tile77,tile78,tile79,
	tile80,tile81,tile82,tile83,tile84,tile85,tile86,tile87,tile88,tile89,
	tile90,tile91,tile92,tile93,tile94,tile95,tile96,tile97,tile98,tile99;

	public Pane root;

	private Random r = new Random();
	
	
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
		 stage = (Stage) mmBtn.getScene().getWindow();
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
	 private void endGame(Rectangle[][] field, Tile[][] mines) {
			for(int i = 0; i < field.length; i++) {
				for(int j = 0; j < field[0].length; j++) {
					if(mines[i][j] instanceof Mine) {
						field[i][j].setFill(Color.RED);
					}
					field[i][j].setOnMouseClicked(new EventHandler<MouseEvent>()
					{
						@Override
						public void handle(MouseEvent t) {
							System.out.println("game ended");
						}
					});
				}
			}
		}
		
		public void updateTile(Rectangle[][] rect, Tile[][] tiles, int x, int y) {
			tiles[x][y].setFlag(true);
			if(tiles[x][y].nearbyMines(tiles)==-1) {
				endGame(rect, tiles);
			}
			else if(tiles[x][y].nearbyMines(tiles)==0) {
				rect[x][y].setFill(Color.color(.2, .4, 0));
			}
			else if(tiles[x][y].nearbyMines(tiles)==1) {
				rect[x][y].setFill(Color.color(.2, .8, .2));
			}
			else if(tiles[x][y].nearbyMines(tiles)==2) {
				rect[x][y].setFill(Color.color(.8, 1, .2));
			}
			else if(tiles[x][y].nearbyMines(tiles)==3) {
				rect[x][y].setFill(Color.color(1, 1, 0));
			}
			else if(tiles[x][y].nearbyMines(tiles)==4) {
				rect[x][y].setFill(Color.color(1, .8, 0));
			}
			else if(tiles[x][y].nearbyMines(tiles)==5) {
				rect[x][y].setFill(Color.color(1, .6, .2));
			}
			else if(tiles[x][y].nearbyMines(tiles)==6) {
				rect[x][y].setFill(Color.color(.6, .8, 1));
			}
			else if(tiles[x][y].nearbyMines(tiles)==7) {
				rect[x][y].setFill(Color.color(0, .2, 1));
			}
			else if(tiles[x][y].nearbyMines(tiles)==8) {
				rect[x][y].setFill(Color.color(.4, 0, .4));
			}
			
			boolean finished = true;
			for(int i = 0; i < 10; i++) {
				for( int j = 0; j < 10; j++){
					if(tiles[i][j] instanceof Empty && !tiles[i][j].getFlag()) {
						finished = false;;
					}
				}
			}
			if(finished)
				victory(rect, tiles);
		}
		
		public void victory(Rectangle[][] rect, Tile[][] tiles) {
			for(int i = 0; i < rect.length; i++) {
				for(int j = 0; j < rect[0].length; j++) {
					if(tiles[i][j] instanceof Mine) {
						rect[i][j].setFill(Color.DARKRED);
					}
					rect[i][j].setOnMouseClicked(new EventHandler<MouseEvent>()
					{
						public void handle(MouseEvent t) {
							System.out.println("game ended");
						}
					});
				}
			}
			
			try (PrintWriter fout = new PrintWriter(new File("src/Unlocked.txt"));) {
				fout.printf("%d", 2);
				
				
			}catch(FileNotFoundException ex) {
				
			}
		}
		
		@FXML
		private void setUp(){
			System.out.println("Initializing minefield");
			Rectangle[][] minefield = 
				{
						{tile00,tile01,tile02,tile03,tile04,tile05,tile06,tile07,tile08,tile09},
						{tile10,tile11,tile12,tile13,tile14,tile15,tile16,tile17,tile18,tile19},
						{tile20,tile21,tile22,tile23,tile24,tile25,tile26,tile27,tile28,tile29},
						{tile30,tile31,tile32,tile33,tile34,tile35,tile36,tile37,tile38,tile39},
						{tile40,tile41,tile42,tile43,tile44,tile45,tile46,tile47,tile48,tile49},
						{tile50,tile51,tile52,tile53,tile54,tile55,tile56,tile57,tile58,tile59},
						{tile60,tile61,tile62,tile63,tile64,tile65,tile66,tile67,tile68,tile69},
						{tile70,tile71,tile72,tile73,tile74,tile75,tile76,tile77,tile78,tile79},
						{tile80,tile81,tile82,tile83,tile84,tile85,tile86,tile87,tile88,tile89},
						{tile90,tile91,tile92,tile93,tile94,tile95,tile96,tile97,tile98,tile99},
				};
			Tile[][] tileinfo = new Tile[10][10];
			int mCount = 0;
			for(int i = 0; i < tileinfo.length; i++) {
				for(int j = 0; j < tileinfo[0].length; j++) {
					minefield[i][j].setFill(Color.gray(0.784));
					if(r.nextDouble()<.1) {
						tileinfo[i][j]=new Mine(i,j);
						mCount++;
					}
					else {
						tileinfo[i][j]=new Empty(i,j);
					}
				}
			}
			
			
			mineN.setText("Mines: "+mCount);
			tile00.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [0][0] pressed");
					System.out.println(tileinfo[0][0].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,0,0);
				}
			});
			tile01.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [0][1] pressed");
					System.out.println(tileinfo[0][1].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,0,1);
				}
			});
			tile02.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [0][2] pressed");
					System.out.println(tileinfo[0][2].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,0,2);
				}
			});
			tile03.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [0][3] pressed");
					System.out.println(tileinfo[0][3].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,0,3);
				}
			});
			tile04.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [0][4] pressed");
					System.out.println(tileinfo[0][4].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,0,4);
				}
			});
			tile05.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [0][5] pressed");
					System.out.println(tileinfo[0][5].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,0,5);
				}
			});
			tile06.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [0][6] pressed");
					System.out.println(tileinfo[0][6].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,0,6);
				}
			});
			tile07.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [0][7] pressed");
					System.out.println(tileinfo[0][7].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,0,7);
				}
			});
			tile08.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [0][8] pressed");
					System.out.println(tileinfo[0][8].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,0,8);
				}
			});
			tile09.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [0][9] pressed");
					System.out.println(tileinfo[0][9].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,0,9);
				}
			});

			tile10.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [1][0] pressed");
					System.out.println(tileinfo[1][0].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,1,0);
				}
			});
			tile11.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [1][1] pressed");
					System.out.println(tileinfo[1][1].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,1,1);
				}
			});
			tile12.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [1][2] pressed");
					System.out.println(tileinfo[1][2].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,1,2);
				}
			});
			tile13.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [1][3] pressed");
					System.out.println(tileinfo[1][3].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,1,3);
				}
			});
			tile14.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [1][4] pressed");
					System.out.println(tileinfo[1][4].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,1,4);
				}
			});
			tile15.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [1][5] pressed");
					System.out.println(tileinfo[1][5].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,1,5);
				}
			});
			tile16.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [1][6] pressed");
					System.out.println(tileinfo[1][6].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,1,6);
				}
			});
			tile17.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [1][7] pressed");
					System.out.println(tileinfo[1][7].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,1,7);
				}
			});
			tile18.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [1][8] pressed");
					System.out.println(tileinfo[1][8].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,1,8);
				}
			});
			tile19.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [1][9] pressed");
					System.out.println(tileinfo[1][9].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,1,9);
				}
			});

			tile20.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [2][0] pressed");
					System.out.println(tileinfo[2][0].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,2,0);
				}
			});
			tile21.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [2][1] pressed");
					System.out.println(tileinfo[2][1].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,2,1);
				}
			});
			tile22.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [2][2] pressed");
					System.out.println(tileinfo[2][2].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,2,2);
				}
			});
			tile23.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [2][3] pressed");
					System.out.println(tileinfo[2][3].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,2,3);
				}
			});
			tile24.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [2][4] pressed");
					System.out.println(tileinfo[2][4].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,2,4);
				}
			});
			tile25.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [2][5] pressed");
					System.out.println(tileinfo[2][5].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,2,5);
				}
			});
			tile26.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [2][6] pressed");
					System.out.println(tileinfo[2][6].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,2,6);
				}
			});
			tile27.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [2][7] pressed");
					System.out.println(tileinfo[2][7].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,2,7);
				}
			});
			tile28.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [2][8] pressed");
					System.out.println(tileinfo[2][8].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,2,8);
				}
			});
			tile29.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [2][9] pressed");
					System.out.println(tileinfo[2][9].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,2,9);
				}
			});

			tile30.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [3][0] pressed");
					System.out.println(tileinfo[3][0].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,3,0);
				}
			});
			tile31.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [3][1] pressed");
					System.out.println(tileinfo[3][1].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,3,1);
				}
			});
			tile32.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [3][2] pressed");
					System.out.println(tileinfo[3][2].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,3,2);
				}
			});
			tile33.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [3][3] pressed");
					System.out.println(tileinfo[3][3].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,3,3);
				}
			});
			tile34.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [3][4] pressed");
					System.out.println(tileinfo[3][4].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,3,4);
				}
			});
			tile35.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [3][5] pressed");
					System.out.println(tileinfo[3][5].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,3,5);
				}
			});
			tile36.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [3][6] pressed");
					System.out.println(tileinfo[3][6].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,3,6);
				}
			});
			tile37.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [3][7] pressed");
					System.out.println(tileinfo[3][7].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,3,7);
				}
			});
			tile38.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [3][8] pressed");
					System.out.println(tileinfo[3][8].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,3,8);
				}
			});
			tile39.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [3][9] pressed");
					System.out.println(tileinfo[3][9].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,3,9);
				}
			});

			tile40.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [4][0] pressed");
					System.out.println(tileinfo[4][0].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,4,0);
				}
			});
			tile41.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [4][1] pressed");
					System.out.println(tileinfo[4][1].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,4,1);
				}
			});
			tile42.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [4][2] pressed");
					System.out.println(tileinfo[4][2].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,4,2);
				}
			});
			tile43.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [4][3] pressed");
					System.out.println(tileinfo[4][3].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,4,3);
				}
			});
			tile44.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [4][4] pressed");
					System.out.println(tileinfo[4][4].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,4,4);
				}
			});
			tile45.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [4][5] pressed");
					System.out.println(tileinfo[4][5].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,4,5);
				}
			});
			tile46.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [4][6] pressed");
					System.out.println(tileinfo[4][6].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,4,6);
				}
			});
			tile47.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [4][7] pressed");
					System.out.println(tileinfo[4][7].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,4,7);
				}
			});
			tile48.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [4][8] pressed");
					System.out.println(tileinfo[4][8].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,4,8);
				}
			});
			tile49.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [4][9] pressed");
					System.out.println(tileinfo[4][9].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,4,9);
				}
			});

			tile50.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [5][0] pressed");
					System.out.println(tileinfo[5][0].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,5,0);
				}
			});
			tile51.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [5][1] pressed");
					System.out.println(tileinfo[5][1].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,5,1);
				}
			});
			tile52.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [5][2] pressed");
					System.out.println(tileinfo[5][2].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,5,2);
				}
			});
			tile53.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [5][3] pressed");
					System.out.println(tileinfo[5][3].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,5,3);
				}
			});
			tile54.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [5][4] pressed");
					System.out.println(tileinfo[5][4].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,5,4);
				}
			});
			tile55.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [5][5] pressed");
					System.out.println(tileinfo[5][5].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,5,5);
				}
			});
			tile56.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [5][6] pressed");
					System.out.println(tileinfo[5][6].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,5,6);
				}
			});
			tile57.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [5][7] pressed");
					System.out.println(tileinfo[5][7].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,5,7);
				}
			});
			tile58.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [5][8] pressed");
					System.out.println(tileinfo[5][8].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,5,8);
				}
			});
			tile59.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [5][9] pressed");
					System.out.println(tileinfo[5][9].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,5,9);
				}
			});

			tile60.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [6][0] pressed");
					System.out.println(tileinfo[6][0].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,6,0);
				}
			});
			tile61.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [6][1] pressed");
					System.out.println(tileinfo[6][1].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,6,1);
				}
			});
			tile62.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [6][2] pressed");
					System.out.println(tileinfo[6][2].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,6,2);
				}
			});
			tile63.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [6][3] pressed");
					System.out.println(tileinfo[6][3].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,6,3);
				}
			});
			tile64.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [6][4] pressed");
					System.out.println(tileinfo[6][4].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,6,4);
				}
			});
			tile65.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [6][5] pressed");
					System.out.println(tileinfo[6][5].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,6,5);
				}
			});
			tile66.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [6][6] pressed");
					System.out.println(tileinfo[6][6].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,6,6);
				}
			});
			tile67.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [6][7] pressed");
					System.out.println(tileinfo[6][7].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,6,7);
				}
			});
			tile68.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [6][8] pressed");
					System.out.println(tileinfo[6][8].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,6,8);
				}
			});
			tile69.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [6][9] pressed");
					System.out.println(tileinfo[6][9].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,6,9);
				}
			});

			tile70.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [7][0] pressed");
					System.out.println(tileinfo[7][0].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,7,0);
				}
			});
			tile71.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [7][1] pressed");
					System.out.println(tileinfo[7][1].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,7,1);
				}
			});
			tile72.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [7][2] pressed");
					System.out.println(tileinfo[7][2].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,7,2);
				}
			});
			tile73.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [7][3] pressed");
					System.out.println(tileinfo[7][3].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,7,3);
				}
			});
			tile74.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [7][4] pressed");
					System.out.println(tileinfo[7][4].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,7,4);
				}
			});
			tile75.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [7][5] pressed");
					System.out.println(tileinfo[7][5].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,7,5);
				}
			});
			tile76.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [7][6] pressed");
					System.out.println(tileinfo[7][6].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,7,6);
				}
			});
			tile77.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [7][7] pressed");
					System.out.println(tileinfo[7][7].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,7,7);
				}
			});
			tile78.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [7][8] pressed");
					System.out.println(tileinfo[7][8].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,7,8);
				}
			});
			tile79.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [7][9] pressed");
					System.out.println(tileinfo[7][9].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,7,9);
				}
			});

			tile80.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				public void handle(MouseEvent t) {
					System.out.println("Mine [8][0] pressed");
					System.out.println(tileinfo[8][0].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,8,0);
				}
			});
			tile81.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [8][1] pressed");
					System.out.println(tileinfo[8][1].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,8,1);
				}
			});
			tile82.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [8][2] pressed");
					System.out.println(tileinfo[8][2].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,8,2);
				}
			});
			tile83.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [8][3] pressed");
					System.out.println(tileinfo[8][3].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,8,3);
				}
			});
			tile84.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [8][4] pressed");
					System.out.println(tileinfo[8][4].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,8,4);
				}
			});
			tile85.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [8][5] pressed");
					System.out.println(tileinfo[8][5].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,8,5);
				}
			});
			tile86.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [8][6] pressed");
					System.out.println(tileinfo[8][6].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,8,6);
				}
			});
			tile87.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [8][7] pressed");
					System.out.println(tileinfo[8][7].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,8,7);
				}
			});
			tile88.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [8][8] pressed");
					System.out.println(tileinfo[8][8].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,8,8);
				}
			});
			tile89.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [8][9] pressed");
					System.out.println(tileinfo[8][9].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,8,9);
				}
			});

			tile90.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [9][0] pressed");
					System.out.println(tileinfo[9][0].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,9,0);
				}
			});
			tile91.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [9][1] pressed");
					System.out.println(tileinfo[9][1].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,9,1);
				}
			});
			tile92.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [9][2] pressed");
					System.out.println(tileinfo[9][2].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,9,2);
				}
			});
			tile93.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [9][3] pressed");
					System.out.println(tileinfo[9][3].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,9,3);
				}
			});
			tile94.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [9][4] pressed");
					System.out.println(tileinfo[9][4].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,9,4);
				}
			});
			tile95.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [9][5] pressed");
					System.out.println(tileinfo[9][5].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,9,5);
				}
			});
			tile96.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [9][6] pressed");
					System.out.println(tileinfo[9][6].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,9,6);
				}
			});
			tile97.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [9][7] pressed");
					System.out.println(tileinfo[9][7].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,9,7);
				}
			});
			tile98.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [9][8] pressed");
					System.out.println(tileinfo[9][8].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,9,8);
				}
			});
			tile99.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent t) {
					System.out.println("Mine [9][9] pressed");
					System.out.println(tileinfo[9][9].nearbyMines(tileinfo));
					updateTile(minefield,tileinfo,9,9);
				}
			});
		}
}
