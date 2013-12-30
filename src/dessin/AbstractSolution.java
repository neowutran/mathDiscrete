package dessin;
import java.awt.*;                    // Pour  Graphics, Frame
import java.awt.event.WindowAdapter;  // Pour fermer
import java.awt.event.WindowEvent;    // Pour fermer

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class AbstractSolution extends JPanel {
	
	protected int profondeur; // profondeur de r�cursivit�

	public AbstractSolution(int profondeur) {
		
		this.profondeur=profondeur;

	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

		int frameHeight = getSize().height; // taille du frame, cette fois avec les bordures
		int frameWidth = getSize().width;   
		g2d.setColor(Color.black);  // La couleur avec laquelle on va dessiner
		//g2d.translate(frameWidth/2,frameHeight/2); //pour d�placer l'origine si besoin

		// mettre ici un appel de drawSolutionk avec une liste d'arguments adapt�s, par exemple : 
		drawSolutionk(g2d, 300, 300, 50,profondeur);
	}

	/** drawSolutionk 
	 *  Produit un dessin recursif
	 * Parametres: 
	 *    Graphics drawingArea : L'objet graphique dans lequel on dessine
	 *    int ... arg : les coordonn�es, longueur et autres si besoin, et profondeur de r�cursivit�
	 **/ 
	public abstract void drawSolutionk(Graphics drawingArea, double ... arg) ;

}


 