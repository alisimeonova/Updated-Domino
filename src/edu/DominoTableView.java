package edu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class DominoTableView extends JComponent
{
private DominoTable table;
	
	public DominoTableView(DominoTable t)
	{
		this.table = t;
		table.addTableEventListener(new TableEventListener() {

			@Override
			public void onTableChanged(DominoTable table) {
				// TODO Auto-generated method stub
				DominoTableView.this.repaint();
			}
			
		});
	}
	
	@Override
	public void paintComponent(Graphics graphics)
	{
		Graphics2D g = (Graphics2D)graphics.create();
		g.setColor(Color.lightGray);
		g.fill(new Rectangle2D.Double(0, 0, 500, 500));
		int x = 60;
		int y = 220;
		Iterator<DominoTile> it = table.getDominoTable().getIterator();
		while(it.hasNext())
		{
			g.translate(x, y);
			paintTile(g, it.next());
			g.translate(-x,  -y);
			x += 120;
		}
		/*for(DominoTile t : table.getDominoTable())
		{
			if(t == null)
				continue;
			g.translate(x, y);
			paintTile(g, t);
			g.translate(-x,  -y);
			x += 120;
		}*/
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
