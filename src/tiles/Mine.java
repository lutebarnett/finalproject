package tiles;

public class Mine extends Tile{
	public Mine(int x, int y) {
		super(x,y);
	}
	@Override
	public int nearbyMines(Tile[][] tiles) {
		return -1;
	}
}
