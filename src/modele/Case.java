package modele;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import vue.Fenetre;

/**
 * Classe représentant une case.
 * La canvas est constitué de cases, représentée par cette classe.
 * @author Layce17
 *
 */
public abstract class Case {
	protected Point position;
	protected Color couleur;
	
	/**
	 * Constructeur principal de la classe.
	 * @param x numéro de la colonne, devient la position exacte en x sur le canvas.
	 * @param y numéro de la ligne, devient la position exacte en y sur le cavas.
	 */
	public Case(float x, float y) {
		float px = x * (Fenetre.WIDTH() + Fenetre.MARGIN())+ Fenetre.MARGIN() + 5;
		float py = y * (Fenetre.WIDTH() + Fenetre.MARGIN())+ Fenetre.MARGIN() + 5;
		position = new Point(px, py);
		couleur = Color.rgb((int)(x * 20), (int)(y * 5), (int)(y*20));
	}
	
	/**
	 * @return la position exacte de la case sur le canvas
	 */
	public Point getPosition() {
		return position;
	}
	
	/**
	 * Fonction permettant de dessiner la case (si beasoin).
	 * @param gc pour dessiner.
	 */
	public abstract void draw(GraphicsContext gc);
	
	/**
	 * Appellée à chaque tour de boucle.
	 * Met à jour certaines valeur de la case.
	 */
	public abstract void update();
}
