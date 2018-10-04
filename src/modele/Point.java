package modele;

/**
 * Classe représentant un point sur le canvas.
 * @author Layce17
 */
public class Point {
	float x;
	float y;
	
	/**
	 * Constructeur principal de la classe.
	 * @param x numéro de la colonne.
	 * @param y numéro de la ligne.
	 */
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return la position en X.
	 */
	public float getX() {
		return x;
	}

	/**
	 * Définie la position en X.
	 * @param x nouvelle position en X.
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return la position en Y.
	 */
	public float getY() {
		return y;
	}

	/**
	 * Définie la position en Y.
	 * @param y nouvelle position en Y.
	 */
	public void setY(float y) {
		this.y = y;
	}
}
