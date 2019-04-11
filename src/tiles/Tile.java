/**
 * This program symbolizes a tile in the minesweeper game. Contains their location, as well as whether or not they have a mine.
 * 
 * 
 * @author lij19
 */


package tiles;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile {
	
	private int posX;
	private int posY;
	private boolean flagged = false;
	private boolean unknown = true;
	
	public Tile(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public Tile() {
		this(10, 10);
	}
	
	/**
	 * returns value of the private int length of the object
	 * @return returns the location of the tile length only
	 */	
	public int getX() {
		return posX;
	}
	
	/**
	 * returns value of the private int width of the object
	 * @return returns the location of the tile Width only
	 */	
	public int getY() {
		return posY;
	}
	/**
	 * returns whether or not something was flagged
	 * @return returns the boolean flagged which represents whechter or not something was flagged
	 */
	public boolean getFlag() {
		return flagged;
	}
	/**
	 * sets whether or not something was flagged
	 * sets the flagged boolean to a or whatever the person decides to put the boolean as
	 */
	public void setFlag(boolean a) {
		flagged = a;
	}
	
	public boolean getUnknown() {
		return unknown;
	}
	
	public void revealUnknown() {
		unknown = false;
	}
	public int nearbyMines(Tile[][] tiles) {
		return -2;
	}
	
	
}
