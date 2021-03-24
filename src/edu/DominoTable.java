package edu;

public class DominoTable
{
	private Deck<DominoTile> dominoTable;
	private int tilesIndex = 0;
	private TableEventListener listener;
	private final int TILES = 28;
	final static int LEFT = 0;
	final static int RIGHT = 1;

	public DominoTable() {
		dominoTable = new Deck<>();
	}
	
	public Deck<DominoTile> getDominoTable()
	{
		return this.dominoTable;
	}

	public boolean addLeft(DominoTile tile) 
	{
		if (tilesIndex > TILES - 2) 
		{
			return false;
		} 
		else if(dominoTable.isEmpty())
		{
			dominoTable.addLeft(tile);
			return true;
		}
		else if (dominoTable.getLeft().isApplicable(tile, LEFT) == true) 
		{
			dominoTable.addLeft(tile);
			/*
			for (int i = tilesIndex; i > 0; i--) 
			{
				dominoTable[i] = dominoTable[i - 1];
			}
			dominoTable[0] = tile;
			tilesIndex++;
			*/
			if(this.listener != null)
			{
				this.listener.onTableChanged(this);
			}
			return true;
		} 
		else 
		{
			return false;
		}
		// algorithm here - if applicable, add it to the beginning of the array and
		// tilesIndex++

	}

	public boolean addRight(DominoTile tile) 
	{
		if (tilesIndex > TILES - 2) 
		{
			return (false);
		} 
		else if(dominoTable.isEmpty())
		{
			dominoTable.addRight(tile);
			return true;
		}
		else if (dominoTable.getRight().isApplicable(tile, RIGHT) == true) 
		{
			dominoTable.addRight(tile);
			/*
			dominoTable[tilesIndex + 1] = tile;
			tilesIndex++;
			*/
			if(this.listener != null) 
			{
				this.listener.onTableChanged(this);
			}
			return true;
		} 
		else 
		{
			return false;
		}
		// algorithm here - if applicable, add it to the end of the current elements of
		// the array
		// (tilesIndex) and tilexIndex++
	}

	public void print() 
	{
		Iterator<DominoTile> it = dominoTable.getIterator();
		while(it.hasNext())
		{
			DominoTile t = it.next();
			System.out.print(t.toString());
		}
		/*
		for (int i = 0; i < TILES; i++) 
		{
			if (dominoTable[i] == null)
				break;
			System.out.print(dominoTable[i].toString());
		}
		*/
	}
	
	public void addTableEventListener(TableEventListener listener)
	{
		this.listener = listener;
	}
}
