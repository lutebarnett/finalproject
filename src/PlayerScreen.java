import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class PlayerScreen extends Application{


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		 try {
			 Pane root = (Pane)FXMLLoader.load(getClass().getResource("/screen/mainMenu.fxml"));
			 Scene scene = new Scene(root);
			 primaryStage.setScene(scene);
			 primaryStage.setTitle("Menu");
			 primaryStage.show();
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		
		
	}

		
	
}