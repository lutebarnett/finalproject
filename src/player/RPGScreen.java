package player;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import battle.*;
import battle.Character;
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
	
	
	Minion e = new Minion ();
	PlayerData controller = new PlayerData(200, 20, "Player");
	
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
		returnMenu.setVisible(false); 
		nextGame.setVisible(false);
		enemyName.setText(e.getName());
		
		attack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				e.takeDamage(controller.dealDamage());
				
				StringBuilder s = alterHealth(e);
				enemyHealth.setText(String.format("%s", s.toString()));
				
				playerActions.setText(String.format("You punched the enemy! You have dealt %d to the enemy", controller.dealDamage()));
				
				fight();
			}
		});
		
		ThrowMines.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int damage = controller.useMine();
				if (damage == -1) {
					playerActions.setText("Unable to do action! Please try something else!");
				} else {
					e.takeDamage(damage);
					StringBuilder s = alterHealth(e);
					enemyHealth.setText(String.format("%s", s.toString()));
					playerActions.setText(String.format("You thew a mine!%nCRITICAL DAMAGE!!!%n%d DAMAGE WAS DEALT TO THE ENEMY", damage));

					fight();
				}
			}
		});
		
		Heal.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
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
		});
		
		Run.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "You have run away!");
				playerActions.setText("You have run away!");
				endBattle();
			}
		});
	}
	
	public void fight() {
		if(e.getHealth() == 0) {
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
	
	public void endBattle() {
		attack.setVisible(false);
		ThrowMines.setVisible(false);
		Heal.setVisible(false);
		Run.setVisible(false);
		enemyActions.setVisible(false);
	}
	
	public void enemyReaction() {
		Action a = e.randomActions();
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
}
