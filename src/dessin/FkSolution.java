package dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class FkSolution extends AbstractSolution {

	private static final long serialVersionUID = 1L;

	public FkSolution(int profondeur) {
		super(profondeur);
	}

	@Override
	public void drawSolutionk(Graphics drawingArea, double... arg) {

		Graphics2D g2d = (Graphics2D) drawingArea;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		int x = (int)arg[0];
		int y = (int)arg[1];
		int size = (int)arg[2];

		//pi * r²; somme{i=0}{k} pi * (r/(1+i*2))²
		g2d.setColor(Color.pink);
		g2d.fillOval(x, y, size, size);

		g2d.setColor(Color.black);
		g2d.drawOval(x, y, size, size);
		
		if(arg[3] != 1){

			int depth = (int) (arg[3] -1);
			drawSolutionk(drawingArea, x+size, y+(size/4), size/2,depth);
			drawSolutionk(drawingArea, x+(size/4), y+size, size/2,depth);

		}
		
	}
	
}
