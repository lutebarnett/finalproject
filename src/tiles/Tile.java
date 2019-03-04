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
	
	
	
	public boolean hasMine() {
		return containMine;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	
	
	
}
