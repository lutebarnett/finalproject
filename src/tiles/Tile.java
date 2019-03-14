/**
 * This program symbolizes a tile in the minesweeper game. Contains their location, as well as whether or not they have a mine.
 * 
 * 
 * @author lij19
 */


package tiles;

public class Tile {
	private boolean containMine;
	private int length;
	private int width;
	private boolean flagged = false;
	
	public Tile(boolean hasMine, int length, int width) {
		containMine = hasMine;
		this.length = length;
		this.width = width;
	}
	
	public Tile(int length, int width) {
		this(false, length, width);
	}
	
	//may create another constructor requiring two parameters
	
	public Tile() {
		this(false, 0, 0);
	}
	
	/**
	 * returns the boolean value of the private boolean containMine
	 * @return returns a boolean value which makes sure whether or not a tile has a mine
	 */
	public boolean hasMine() {
		return containMine;
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
	
	public boolean getFlag() {
		return flagged;
	}
	
	public void setFlag(boolean a) {
		flagged = a;
	}
	
	
	
}
