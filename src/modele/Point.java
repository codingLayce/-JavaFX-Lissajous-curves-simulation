package modele;

/**
 * Classe repr�sentant un point sur le canvas.
 * @author Layce17
 */
public class Point {
	float x;
	float y;
	
	/**
	 * Constructeur principal de la classe.
	 * @param x num�ro de la colonne.
	 * @param y num�ro de la ligne.
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
	 * D�finie la position en X.
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
	 * D�finie la position en Y.
	 * @param y nouvelle position en Y.
	 */
	public void setY(float y) {
		this.y = y;
	}
}
