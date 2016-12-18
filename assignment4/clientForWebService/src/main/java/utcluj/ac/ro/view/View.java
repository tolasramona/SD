package utcluj.ac.ro.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class View extends Application {


	@Override
	public void start(Stage primaryStage) {
		
		InitialSceneMaker init = new InitialSceneMaker();
		init.setStage(primaryStage);
		Scene scene = init.makeInitialScene();

		primaryStage.setScene(scene);
		primaryStage.setTitle("Packet Tracer");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(View.class.getResource("input.css").toExternalForm());
		primaryStage.show();
	}

	public void getStarted() {
		launch(null);
	}

	
}
