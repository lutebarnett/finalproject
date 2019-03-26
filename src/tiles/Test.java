package tiles;

public class Test {
	public static void main(String[] args) {
		Tile[][] tiles = new Tile[3][3];
		
		tiles[0][0] = new Mine();
		tiles[1][1] = new Empty(1,1);
		
		System.out.println(((Empty) tiles[1][1]).nearbyMines(tiles));
		
	}

}
