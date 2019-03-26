/**
 * This program symbolizes a tile in the minesweeper game. Contains their location, as well as whether or not they have a mine.
 * 
 * 
 * @author lij19
 */


package tiles;

public class Tile {
	
	private int length;
	private int width;
	private boolean flagged = false;
	private boolean unknown = true;
	
	public Tile(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	public Tile() {
		this(0, 0);
	}
	
	/**
	 * returns value of the private int length of the object
	 * @return returns the location of the tile length only
	 */	
	public int getLength() {
		return length;
	}
	
	/**
	 * returns value of the private int width of the object
	 * @return returns the location of the tile Width only
	 */	
	public int getWidth() {
		return width;
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
	
	
	
}
