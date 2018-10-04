package vue;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import modele.Case;
import modele.Cercle;
import modele.Figure;
import modele.Point;
import modele.Vide;

/**
 * Classe représentant la fenetre de l'application.
 * @author Layce17
 */
public class Fenetre extends Pane {
	private static Canvas canvas;
	private GraphicsContext gc;
	private static final float largeur = 80;
	private static final float margin = 10;
	private Case[][] cases;
	
	/**
	 * Constructeur principal.
	 * Instancie le canvas et lance la boucle d'animation.
	 */
	public Fenetre() {
		super();
		
		canvas = new Canvas(990, 790);
		this.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		this.initCases();
		this.loop();
	}
	
	/**
	 * Initialise les cases.
	 * Les cases devant être des cercles deviennent des cercles,... etc
	 */
	private void initCases() {
		int rows = (int)Math.ceil(canvas.getHeight() / (largeur + margin)) - 1;
		int cols = (int)Math.ceil(canvas.getWidth() / (largeur + margin)) - 1;
		
		cases = new Case[cols][rows];
		
		for (int x = 0; x < cols; x++) {
			for (int y = 0; y < rows; y++) {
				if (x == 0 && y == 0)
					cases[x][y] = new Vide(x, y);
				else if (x == 0 || y == 0)
					cases[x][y] = new Cercle(x, y, largeur);
				else
					cases[x][y] = new Figure(x, y);
			}
		}
	}
	
	/**
	 * Fonction matérialisant la boucle principale.
	 * Appèle les méthodes draw() et update() tant que le cercle le plus lent n'a pas fini son tour.
	 */
	public void loop() {
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), 
                new EventHandler<ActionEvent>() {        	
            @Override
            public void handle(ActionEvent t) {
        		draw();
        		update();
            }
            	
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setRate(1.0);
        timeline.setCycleCount((int)((Math.PI * 2)/0.01));
        timeline.play();
	}
	
	/**
	 * Dessine toutes les formes sur le canvas.
	 */
	public void draw() {
		gc.setFill(Color.GREY);
		gc.fillRect(10, 10, canvas.getWidth(), canvas.getHeight());
		gc.setStroke(Color.WHITE);
		
		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				cases[x][y].draw(gc);
			}
		}
	}
	
	/**
	 * Met à jour les angles des cercles, ajoute les points sur les figure et change les positions des points.
	 */
	public void update() {
		if (((Cercle)cases[1][0]).aFaitTour()) {
			for (int x = 0; x < cases.length; x++) {
				for (int y = 0; y < cases[x].length; y++) {
					if (cases[x][y] instanceof Figure) {
						((Figure)cases[x][y]).reset();
					}
				}
			}
		}
		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				if (cases[x][y] instanceof Figure) {
					((Figure)cases[x][y]).ajouterPoint(new Point(((Cercle) (cases[x][0])).getPointX(), ((Cercle) (cases[0][y])).getPointY()));
				} else {
					cases[x][y].update();
				}
			}
		}
	}
	
	/**
	 * @return le diamètre des cercles.
	 */
	public static float WIDTH() {
		return largeur;
	}
	
	/**
	 * @return l'espacement entre les cercles.
	 */
	public static float MARGIN() {
		return margin;
	}
	
	/**
	 * @return la largeur du canvas.
	 */
	public static float getCanvasWidth() {
		return (float)canvas.getWidth();
	}
	
	/**
	 * @return la hateur du canvas.
	 */
	public static float getCanvasHeight() {
		return (float)canvas.getHeight();
	}
}
