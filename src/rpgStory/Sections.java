package rpgStory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Sections implements Initializable {
	@FXML
	Button btn1;
	@FXML
	Button battleBtn;
	@FXML
	Button battleBtn2;
	@FXML
	Button battleBtn3;
	@FXML
	Button goBack;
	
	private Stage stage;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try (Scanner input = new Scanner(new File("src/Unlocked.txt"));
			 Scanner out = new Scanner(new File("src/Max.txt"));
			 ) {
				int count = input.nextInt();
				int largest = out.nextInt();
				
				if(largest > count) {
					count = largest;
				} else {
					changeMax(count);
				}
				
				if (count <= 1) {
					battleBtn.setVisible(false);
					battleBtn2.setVisible(false);
					battleBtn3.setVisible(false);
				} else if (count <= 2) {
					battleBtn.setVisible(true);
					battleBtn2.setVisible(false);
					battleBtn3.setVisible(false);
				} else if (count <= 3) {
					battleBtn.setVisible(true);
					battleBtn2.setVisible(true);
					battleBtn3.setVisible(false);
				} else {
					battleBtn.setVisible(true);
					battleBtn3.setVisible(true);
				}
				
				
			} catch (FileNotFoundException ex) {

			}
	}
	
	public void printing() {
		System.out.println("hi");
	}
	
	@FXML
	private void openRpgBattle1() throws IOException{
		try (
			 PrintWriter fin = new PrintWriter(new File("src/BattleDecision.txt"));
			) {
			fin.printf("%d", 1);
		}catch(FileNotFoundException ex) {
			
		}
		
		
		stage = (Stage) battleBtn.getScene().getWindow();
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/screen/BattleScreen.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		System.out.println("BattleScreen.fxml opened");
	}
	
	@FXML
	private void openRpgBattle2() throws IOException{
		try (
			 PrintWriter fin = new PrintWriter(new File("src/BattleDecision.txt"));
			) {
			fin.printf("%d", 2);
		} catch (FileNotFoundException ex) {

		}
		
		stage = (Stage) battleBtn.getScene().getWindow();
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/screen/BattleScreen.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		System.out.println("BattleScreen.fxml opened");
		 
	}
	
	@FXML
	private void openRpgBattle3() throws IOException{
		try (PrintWriter fin = new PrintWriter(new File("src/BattleDecision.txt"));
			) {
			fin.printf("%d",3);
		}catch(FileNotFoundException ex) {
			
		}
		
		stage = (Stage) battleBtn.getScene().getWindow();
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/screen/BattleScreen.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		System.out.println("BattleScreen.fxml opened");
		 
	}
	
	@FXML
	private void mainMenuReturn() throws IOException{
		stage = (Stage) battleBtn.getScene().getWindow();
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/screen/mainMenu.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		System.out.println("BattleScreen.fxml opened");
	}
	
	private void changeMax(int i) {
		try (PrintWriter change = new PrintWriter(new File("src/Max.txt"));) {
			change.printf("%d", i);
		} catch (FileNotFoundException ex) {

		}
	}

		

}
