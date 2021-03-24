package edu;

public class DominoTile 
{
	private int firstSquare;
	private int secondSquare;

	public DominoTile() {
		this.firstSquare = 0;
		this.secondSquare = 0;
	}

	public DominoTile(int fs, int ss) {
		if (fs >= 0 && fs <= 6)
			this.firstSquare = fs;
		if (ss >= 0 && ss <= 6)
			this.secondSquare = ss;
	}

	public void setFirstSquare(int fs) {
		if (fs >= 0 && fs <= 6)
			this.firstSquare = fs;
	}

	public void setSecondSquare(int ss) {
		if (ss >= 0 && ss <= 6)
			this.secondSquare = ss;
	}

	public int getFirstSquare() {
		return this.firstSquare;
	}

	public int getSecondSquare() {
		return this.secondSquare;
	}

	public void swapSquares() {
			int temp;
			temp = this.secondSquare;
			this.secondSquare = this.firstSquare;
			this.firstSquare = temp;
		
	}

	public boolean equals(DominoTile tileToCompare) {
		if (this.getFirstSquare() == tileToCompare.getFirstSquare()
				&& this.getSecondSquare() == tileToCompare.getSecondSquare()) {
			return true;
		}
		if (this.getFirstSquare() == tileToCompare.getSecondSquare()
				&& this.getSecondSquare() == tileToCompare.getFirstSquare()) {
			return true;
		}
		return false;
	}
	
	public boolean isApplicable(DominoTile tileToCompare, int direction) 
	{
		
		boolean isApplicable = false;
		if(direction == DominoTable.LEFT)
		{
			if(tileToCompare == null)
			{
				return false;
			}
			else if(this.getFirstSquare() == tileToCompare.getSecondSquare())
			{
				isApplicable = true;
			}
			else if(this.getFirstSquare() == tileToCompare.getFirstSquare())
			{
				tileToCompare.swapSquares();
				isApplicable = true;
			}
			else
			{
				isApplicable = false;
			}
		}
		else
		{
			if(tileToCompare == null)
				return false;
			else if(this.getSecondSquare() == tileToCompare.getFirstSquare())
			{
				isApplicable = true;
			}
			else if(this.getSecondSquare() == tileToCompare.getSecondSquare())
			{
				tileToCompare.swapSquares();
				isApplicable = true;
			}
			else
			{
				isApplicable = false;
			}
		}
		
		return isApplicable;
		/*boolean isApplicable = false;
		if(direction == DominoTable.LEFT) 
		{
			if(tileToCompare == null)
				return false;
			if(this.getSecondSquare() == tileToCompare.getFirstSquare()) 
			{
				isApplicable = true;
			}
			else if(this.getFirstSquare() == tileToCompare.getFirstSquare()) 
			{
				this.swapSquares();
				isApplicable = true;
			}
		}
		else if(direction == DominoTable.RIGHT) 
		{
			if(tileToCompare == null)
				return false;
			if(this.getFirstSquare() == tileToCompare.getSecondSquare()) 
			{
				isApplicable = true;
			}
			else if(this.getSecondSquare() == tileToCompare.getSecondSquare()) 
			{
				this.swapSquares();
				isApplicable = true;
			}
		}
		return isApplicable;
		*/
	}

	public String toString() {
		String result = "";
		result += this.firstLine(1);
		result += this.firstLine(2);
		result += "\n";
		result += this.secondLine(1);
		result += this.secondLine(2);
		result += "\n";
		result += this.thirdLine(1);
		result += this.thirdLine(2);
		result += "\n";
		return result;
	}
	
	public String firstLine(int squareIndex) {
		String firstLine = "";
		if(squareIndex == 1) {
			if(this.firstSquare == 0 || this.firstSquare == 1) {
				firstLine = "   ";
			}
			else if(this.firstSquare == 2 ||this.firstSquare == 3) {
				firstLine = "*  ";
			}
			else if(this.firstSquare == 4 || this.firstSquare == 5) {
				firstLine = "* *";
			}
			else {
				firstLine = "***";
			}
		}
		else {
			if(this.secondSquare == 0 || this.secondSquare == 1) {
				firstLine = "   ";
			}
			else if(this.secondSquare == 2 ||this.secondSquare == 3) {
				firstLine = "*  ";
			}
			else if(this.secondSquare == 4 || this.secondSquare == 5) {
				firstLine = "* *";
			}
			else {
				firstLine = "***";
			}
		}
		return firstLine;
	}
	
	public String secondLine(int squareIndex) {
		String secondLine = "";
		if(squareIndex == 1) {
			if(this.firstSquare == 0 || this.firstSquare == 2 || this.firstSquare == 4 || this.firstSquare == 6) {
				secondLine = "   ";
			}
			else if(this.firstSquare == 1 || this.firstSquare == 5 || this.firstSquare == 3) {
				secondLine = " * ";
			}
		}
		else {
			if(this.secondSquare == 0 || this.secondSquare == 2 || this.secondSquare == 4 || this.secondSquare == 6) {
				secondLine = "   ";
			}
			else if(this.secondSquare == 1 || this.secondSquare == 5 || this.secondSquare == 3) {
				secondLine = " * ";
			}
		}
		
		return secondLine;
	}
	
	public String thirdLine(int squareIndex) {
		String thirdLine = "";
		if(squareIndex == 1) {
			if(this.firstSquare == 0 || this.firstSquare == 1) {
				thirdLine = "   ";
			}
			else if(this.firstSquare == 2 || this.firstSquare == 3) {
				thirdLine = "  *";
			}
			else if(this.firstSquare == 4 || this.firstSquare == 5) {
				thirdLine = "* *";
			}
			else {
				thirdLine = "***";
			}
		}
		else {
			if(this.secondSquare == 0 || this.secondSquare == 1) {
				thirdLine = "   ";
			}
			else if(this.secondSquare == 2 || this.secondSquare == 3) {
				thirdLine = "  *";
			}
			else if(this.secondSquare == 4 || this.secondSquare == 5) {
				thirdLine = "* *";
			}
			else {
				thirdLine = "***";
			}
		}
		
		return thirdLine;
	}
	
}
