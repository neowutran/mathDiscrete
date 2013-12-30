package dessin;

import java.awt.Color;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Demonstrateur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	protected static final int WIDTH = 800;       // taille initiale de la frame 
	protected static final int HEIGHT = 1200;
	
	public static void main(String [] args)
	{
		
		new Demonstrateur(6);
		
	}
	
	public Demonstrateur(int profondeur){
		
		this.setSize(WIDTH, HEIGHT);
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		setTitle("Dessins recursifs au niveau : "+profondeur);
		panel = new F4kSolution(profondeur);
		this.setContentPane(panel);
		
	}
	
	 @Override
	 protected void processWindowEvent(final WindowEvent e) {

	        if (e.getID() == WindowEvent.WINDOW_CLOSING) {

	            System.exit(0);
	        }

	    }

}
