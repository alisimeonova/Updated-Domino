package edu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class DominoPlayerView extends JComponent
{
	private DominoPlayer player;
	
	public DominoPlayerView(DominoPlayer p)
	{
		this.player = p;
	}
	
	private void paintTile(Graphics2D g, DominoTile t)
	{
		if(t == null)
			return;
		int width = 120;
		int height = 60;
		g.setColor(Color.black);
		g.fill(new Rectangle2D.Double(0, 0, width, height));
		g.setColor(Color.WHITE);
		g.draw(new Rectangle2D.Double(0, 0, width, height));
		int left = t.getFirstSquare();
		int right = t.getSecondSquare();
		g.setColor(Color.white);
		
		//paint first square
		//paint upper-left dot and lower-right dot
		if(left > 1)
		{
			g.fill(new Ellipse2D.Double(5, 5, 10, 10));
			g.fill(new Ellipse2D.Double(45, 45, 10, 10));
		}
		//paint upper-middle dot and lower-middle dot
		if(left == 6)
		{
			g.fill(new Ellipse2D.Double(25, 5, 10, 10));
			g.fill(new Ellipse2D.Double(25, 45, 10, 10));
		}
		//paint upper-right dot and lower-left dot
		if(left > 3)
		{
			g.fill(new Ellipse2D.Double(45, 5, 10, 10));
			g.fill(new Ellipse2D.Double(5, 45, 10, 10));
		}
		//middle-left and middle-right dots always empty
		//paint middle-middle dot
		if(left % 2 != 0)
		{
			g.fill(new Ellipse2D.Double(25, 25, 10, 10));
		}
		
		//paint second square
		//paint upper-left dot and lower-right dot
		if(right > 1)
		{
			g.fill(new Ellipse2D.Double(65, 5, 10, 10));
			g.fill(new Ellipse2D.Double(105, 45, 10, 10));
		}
		//paint upper-middle dot and lower-middle dot
		if(right == 6)
		{
			g.fill(new Ellipse2D.Double(85, 5, 10, 10));
			g.fill(new Ellipse2D.Double(85, 45, 10, 10));
		}
		//paint upper-right dot and lower-left dot
		if(right > 3)
		{
			g.fill(new Ellipse2D.Double(105, 5, 10, 10));
			g.fill(new Ellipse2D.Double(65, 45, 10, 10));
		}
		//middle-left and middle-right dots always empty
		//paint middle-middle dot
		if(right % 2 != 0)
		{
			g.fill(new Ellipse2D.Double(85, 25, 10, 10));
		}
	}
	
}
