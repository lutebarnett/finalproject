package player;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import battle.*;
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
	
	@FXML
	Button attack;
	@FXML
	Button ThrowMines;
	@FXML
	Button Heal;
	@FXML
	Button Run;
	
	
	Enemy e = new Enemy (100,10);
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
		attack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				e.takeDamage(controller.dealDamage());
				
				StringBuilder s = new StringBuilder("Health: [");
				
				double point = e.getMaxHealth()/20.0;
				double health = e.getHealth();
				
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
				enemyHealth.setText(String.format("%s", s.toString()));
				
				playerActions.setText(String.format("You punched the enemy! You have dealt %d to the enemy", controller.dealDamage()));
				
				if(e.getHealth() == 0) {
					enemyActions.setText("The enemy has surcome to their wounds! They have died!");
				}
				fightFinished();
			}
		});
		
		ThrowMines.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int damage = controller.useMine();
				e.takeDamage(damage);
				
				StringBuilder s = new StringBuilder("Health: [");
				
				double point = e.getMaxHealth()/20.0;
				double health = e.getHealth();
				
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
				enemyHealth.setText(String.format("%s", s.toString()));
				
				playerActions.setText(String.format("You thew a mine!%nCRITICAL DAMAGE!!!%n%d DAMAGE WAS DEALT TO THE ENEMY", damage));
				
				if(e.getHealth() == 0) {
					enemyActions.setText("The enemy has surcome to their wounds! They have died!");
				}
				
				fightFinished();
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
	
	public void fightFinished() {
		if(e.getHealth() <= 0) {
			JOptionPane.showMessageDialog(null, "The battle has ended. YOU WON!");
			playerActions.setText("You have won!");
			endBattle();
		} else if(controller.getHealth() <= 0) {
			JOptionPane.showMessageDialog(null, "The battle has ended. You lost.");
			playerActions.setText("You have lost.");
			endBattle();
		}
		
	}
	
	public void endBattle() {
		attack.setVisible(false);
		ThrowMines.setVisible(false);
		Heal.setVisible(false);
		Run.setVisible(false);
		enemyActions.setVisible(false);
	}
	
}
