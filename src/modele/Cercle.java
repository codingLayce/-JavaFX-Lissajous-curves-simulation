package modele;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import vue.Fenetre;

/**
 * Classe représentant les cercles tournants sur les bords du canvas.
 * @author Layce17
 */
public class Cercle extends Case {
	private float diametre;
	private Point point;
	private Point centre;
	private float angle;
	private float rayon;
	private float speed;

	/**
	 * Constructeur principal de la classe
	 * @param x numéro de la colonne.
	 * @param y numéro de la ligne
	 * @param d diamètre du cercle
	 */
	public Cercle(float x, float y, float d) {
		super(x, y);
		angle = 0;
		diametre = Fenetre.WIDTH();
		rayon = diametre /2;
		centre = new Point(position.getX() + rayon, position.getY() + rayon);
		point = new Point((float)(rayon * Math.cos(angle) + centre.getX()), (float)(rayon * Math.sin(angle) + centre.getY()));
		if (x != 0)
			speed = x * 0.01f;
		else
			speed = y * 0.01f;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setStroke(Color.WHITE);
		gc.strokeOval(position.getX(), position.getY(), diametre, diametre);
		gc.setFill(Color.RED);
		gc.fillOval(point.getX()-2.5, point.getY()-2.5, 5, 5);
		gc.setStroke(Color.WHITE);
		if (position.getX() < Fenetre.WIDTH() + Fenetre.MARGIN())
			gc.strokeLine(0, point.getY(), Fenetre.getCanvasWidth(), point.getY());
		else {
			gc.strokeLine(point.getX(), 0, point.getX(), Fenetre.getCanvasHeight());
		}
	}

	@Override
	public void update() {
		angle += speed;
		point.setX((float)(rayon * Math.cos(angle) + centre.getX()));
		point.setY((float)(rayon * Math.sin(angle) + centre.getY()));
	}
	
	/**
	 * Fonction qui test si le point a dejà fait le tour du cercle.
	 * @return true si deja fait, false sinon.
	 */
	public boolean aFaitTour() {
		if (angle > Math.PI * 2) {
			angle = 0;
			return true;
		} else
			return false;
	}
	
	/**
	 * @return position du point en X.
	 */
	public float getPointX() {
		return point.getX();
	}
	
	/**
	 * @return position du point en Y.
	 */
	public float getPointY() {
		return point.getY();
	}
}
