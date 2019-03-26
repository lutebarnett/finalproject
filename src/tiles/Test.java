package tiles;

public class Test {
	public static void main(String[] args) {
		Tile[][] tiles = new Tile[3][2];
		
		tiles[2][0] = new Mine();
		tiles[1][1] = new Mine();
		tiles[2][1] = new Empty(2,1);
		
		System.out.println(((Empty) tiles[2][1]).nearbyMines(tiles));
		
	}

}
