package tiles;

public class Empty extends Tile{
	
	public Empty(int x, int y) {
		super(x,y);
	}
	
	//will define later
	@Override
	public int nearbyMines(Tile[][] tiles) {
		int amount = 0; 
		
		if(this.getX()==0&&this.getY()==0) {
			if(tiles[this.getX()+1][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()] instanceof Mine) {
				amount++;
			}
		}
		else if(this.getX()==9&&this.getY()==9) {
			if(tiles[this.getX()-1][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()-1][this.getY()] instanceof Mine) {
				amount++;
			}
		}
		else if(this.getX()==9&&this.getY()==0) {
			if(tiles[this.getX()-1][this.getY()] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()-1][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()][this.getY()+1] instanceof Mine) {
				amount++;
			}
		}
		else if(this.getX()==0&&this.getY()==9) {
			if(tiles[this.getX()][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()] instanceof Mine) {
				amount++;
			}
		}
		
		
		else if(this.getX()==0) {
			if(tiles[this.getX()][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()+1] instanceof Mine) {
				amount++;
			}
		}
		else if(this.getY()==0) {
			if(tiles[this.getX()-1][this.getY()] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()-1][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()] instanceof Mine) {
				amount++;
			}
		}
		else if(this.getX()==9) {
			if(tiles[this.getX()][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()-1][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()-1][this.getY()] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()-1][this.getY()+1] instanceof Mine) {
				amount++;
			}
		}
		else if(this.getY()==9) {
			if(tiles[this.getX()-1][this.getY()] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()-1][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()] instanceof Mine) {
				amount++;
			}
		}
		else {
			if(tiles[this.getX()-1][this.getY()] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()-1][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()+1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()-1][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()][this.getY()-1] instanceof Mine) {
				amount++;
			}
			if(tiles[this.getX()+1][this.getY()-1] instanceof Mine) {
				amount++;
			}
		}
		
		return amount;
	}
}
