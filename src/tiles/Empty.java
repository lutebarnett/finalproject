package tiles;

public class Empty extends Tile{
	
	public Empty(int x, int y) {
		super(x,y);
	}
	
	//will define later
	public int nearbyMines(Tile[][] tiles) {
		int amount = 0; 

		for (int i = getLength() - 1; i < getLength() + 1; i++) {
			if (i < 0) {
				i = 0;
			}

			for (int count = getWidth() - 1; count < getWidth() + 1; count++) {
				if(count < 0) {
					count++;
				}
				
				if(count == getWidth() && i == getLength()) {
					count++;
				}
				
				if(tiles[i][count] instanceof Mine) {
					amount++;
				}
			}
		}
		
		
		return amount;
	}
}
