package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vue.Fenetre;

/**
 * Classe principale du projet.
 * Elle permet le lancement de l'application
 * @author Layce17
 * @version 1.0
 */
public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage st) {
		Fenetre fen = new Fenetre();
		st.setTitle("Lissajous");
		st.setScene(new Scene(fen, 1000, 800));
		st.show();
	}
}
