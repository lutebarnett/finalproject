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
	
	public boolean getFlag() {
		return flagged;
	}
	
	public void setFlag(boolean a) {
		flagged = a;
	}
	
	
	
}
