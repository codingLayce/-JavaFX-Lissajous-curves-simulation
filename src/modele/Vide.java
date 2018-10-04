package modele;

import javafx.scene.canvas.GraphicsContext;

/**
 * Classe représantant une case vide.
 * @author Layce17
 */
public class Vide extends Case {

	/**
	 * Constructeur principal de la classe.
	 * @param x numéro de la colonne.
	 * @param y numéro de la ligne.
	 */
	public Vide(float x, float y) {
		super(x, y);
	}

	@Override
	public void draw(GraphicsContext gc) {
		// VIDE
	}

	@Override
	public void update() {
		// VIDE
	}

}
