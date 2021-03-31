package edu;

public class GameTest {

	public static void main(String[] args) 
	{
		DominoTable t = new DominoTable();
		t.addLeft(new DominoTile(1, 2));
		t.addLeft(new DominoTile(3, 1));
		t.addLeft(new DominoTile(4, 3));
		t.addLeft(new DominoTile(5, 4));
		t.addLeft(new DominoTile(6, 5));
		t.addLeft(new DominoTile(0, 6));
		t.addRight(new DominoTile(2, 4));
		
		LinkedList<DominoTile> tile = new LinkedList<>();
		tile.add(new DominoTile(3, 6));
		tile.add(new DominoTile(3, 2));
		tile.add(new DominoTile(1, 6));
		tile.add(new DominoTile(5, 4));
		tile.add(new DominoTile(0, 6));
		
	}

}
