package modele;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

/**
 * Représente la figure de Lissajous tracé dans le canvas.
 * @author Layce17
 */
public class Figure extends Case {
	private ArrayList<Point> points;

	/**
	 * Constructeur principal de la classe.
	 * @param x numéro de la colonne.
	 * @param y numéro de la ligne.
	 */
	public Figure(float x, float y) {
		super(x, y);
		points = new ArrayList<Point>();
	}
	
	/**
	 * Fonction ajoutant un point à la figure.
	 * @param p point à ajouter.
	 */
	public void ajouterPoint(Point p) {
		points.add(p);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(couleur);
		for (Point p : points)
			gc.fillOval(p.getX()-0.5, p.getY()-0.5, 1, 1);
	}

	@Override
	public void update() {
		// VIDE
	}
	
	/**
	 * Fonction qui remet à zéro la figure (supprime tous les points).
	 */
	public void reset() {
		points.clear();
	}
}
