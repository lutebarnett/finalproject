package screen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JOptionPane;
import battle.*;
import battle.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RPGScreen extends Opponent implements Initializable{
	
	//Texts that describe situations
	@FXML
	Text enemyHealth;
	@FXML
	Text playerHealth;
	@FXML
	Text enemyName;
	@FXML
	Text player;
	@FXML
	Text enemyActions;
	@FXML
	Text playerActions;
	
	//Buttons that the player uses to initiate actions
	@FXML
	Button attack;
	@FXML
	Button ThrowMines;
	@FXML
	Button Heal;
	@FXML
	Button Run;
	
	//Buttons that will appear after battle is over
	@FXML
	Button returnMenu;
	@FXML
	Button nextGame;
	
	Opponent e = new Opponent();
	PlayerData controller = new PlayerData(200, 20, "Player");
	private Stage stage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		returnMenu.setVisible(false); 
		nextGame.setVisible(false);
		enemyName.setText(e.getOpponent().getName());
	}
	
	@FXML
	public void attack() {
		e.getOpponent().takeDamage(controller.dealDamage());				
		StringBuilder s = alterHealth(e.getOpponent());
		enemyHealth.setText(String.format("%s", s.toString()));
			
		playerActions.setText(String.format("You punched the enemy! You have dealt %d to the enemy", controller.dealDamage()));
			
		fight();
	}
	
	@FXML
	public void ThrowMines(ActionEvent event) {
			int damage = controller.useMine();
		if (damage == -1) {
			playerActions.setText("Unable to do action! Please try something else!");
		} else {
			e.getOpponent().takeDamage(damage);
			StringBuilder s = alterHealth(e.getOpponent());
			enemyHealth.setText(String.format("%s", s.toString()));
			playerActions.setText(String.format("You thew a mine!%nCRITICAL DAMAGE!!!%n%d DAMAGE WAS DEALT TO THE ENEMY", damage));
				
			fight();
		}
	}
		
	@FXML
	public void heal() {
		int healAmount = 30;
		if (controller.getHealth() + healAmount > controller.getMaxHealth()) {
			controller.setHealth(controller.getMaxHealth());
		} else {
			controller.setHealth(controller.getHealth() + healAmount);
		}

		if (controller.getHealth() == controller.getMaxHealth()) {
			playerActions.setText(String.format("You have healed yourself to max health!"));
		} else {
			playerActions.setText(String.format("You have healed yourself by %d health!", healAmount));
		}
				
		StringBuilder s = alterHealth(controller);
		playerHealth.setText(s.toString());
			
		enemyReaction();
		fight();
			
	}	
		
	@FXML	
	public void run() {
		JOptionPane.showMessageDialog(null, "You have run away!");
		playerActions.setText("You have run away!");
		endBattle();
		returnMenu.setVisible(true);
	}	
	
	@FXML
	public void fight() {
		if(e.getOpponent().getHealth() <= 0) {
			enemyActions.setText("The enemy has surcome to their wounds! They have died!");
			JOptionPane.showMessageDialog(null, "The battle has ended. YOU WON!");
			playerActions.setText("You have won!");
			endBattle();
			nextGame.setVisible(true);
		} else {
			enemyReaction();
		}
		
		if(controller.getHealth() <= 0) {
			JOptionPane.showMessageDialog(null, "The battle has ended. You lost.");
			playerActions.setText("You have lost.");
			endBattle();
			returnMenu.setVisible(true);
		}
	}
	
	@FXML
	private void openMainmenu() throws IOException{
		stage = (Stage) returnMenu.getScene().getWindow();
		Pane root;
		root = (Pane) FXMLLoader.load(getClass().getResource("/screen/mainMenu.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		System.out.println("/screen/mainMenu.fxml opened");
	}
	
	public void endBattle() {
		attack.setVisible(false);
		ThrowMines.setVisible(false);
		Heal.setVisible(false);
		Run.setVisible(false);
		enemyActions.setVisible(false);
		
		try (PrintWriter fout = new PrintWriter(new File("src/Unlocked.txt"));
			 Scanner fin = new Scanner(new File("src/BattleDecision.txt"));
			 ) {
			fout.printf("%d", fin.nextInt() + 2);

		} catch (FileNotFoundException ex) {

		}
	}
	
	public void enemyReaction() {
		Action a = e.getOpponent().randomActions();
		enemyActions.setText(a.getDesciption());
		controller.takeDamage(a.getDamage());
		
		StringBuilder s = alterHealth(controller);
		playerHealth.setText(s.toString());
	}
	
	public StringBuilder alterHealth(Character c) {
		StringBuilder s = new StringBuilder("Health: [");
		double point = c.getMaxHealth()/20.0;
		double health = c.getHealth();
		
		for(int i = 0; i < 20; i++) {
			if(health - point < 0) {
				s.append(" ");
			}
			else {
				s.append("I");
				health = health - point;
			}
		}
		s.append("]");
		
		return s;
	}
	
	@FXML
	private void returnMainMenu() throws IOException{
		 stage = (Stage) returnMenu.getScene().getWindow();
		 Pane root;
		 root = (Pane) FXMLLoader.load(getClass().getResource("/screen/mainMenu.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 System.out.println("/screen/mainMenu.fxml opened");
	}
	
	@FXML
	private void returnSection() throws IOException{
		 stage = (Stage) nextGame.getScene().getWindow();
		 Pane root = (Pane) FXMLLoader.load(getClass().getResource("/rpgStory/StorySections.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 System.out.println("StorySections.fxml opened");
		 
	}
}
