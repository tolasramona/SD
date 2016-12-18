package utcluj.ac.ro.view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class InitialSceneMaker {
	
	private Stage stage;
	
	private Button btnAdmin;
	private Button btnClient;
	private Button btnRegister;

	private GridPane grid;

	public Scene makeInitialScene(){
		btnAdmin = new Button();
		btnAdmin.setText("Log in as ADMIN");
		btnClient = new Button();
		btnClient.setText("Log in as CLIENT");
		btnRegister = new Button();
		btnRegister.setText("Register as CLIENT");

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(30);
		grid.setVgap(30);
		grid.setPadding(new Insets(25, 25, 25, 25));		
		addActionHandlerForButtons();
		
		grid.add(btnAdmin, 1, 3);
		grid.add(btnClient, 2, 3);
		grid.add(btnRegister, 3, 3);
		
		grid.setStyle("-fx-background-color: #CED8F6;");
		Scene scene = new Scene(grid, 600, 375);
		scene.getStylesheets().add(View.class.getResource("input.css").toExternalForm());
		
		return scene;
	}

	private void addActionHandlerForButtons(){
		btnAdmin.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				AbstractLogInSceneMaker sceneMaker=new AdminLogInSceneMaker();
				sceneMaker.setStage(stage);
				stage.setScene(sceneMaker.makeScene());
			}
		});
		
		btnClient.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				ClientLogInSceneMaker sceneMaker=new ClientLogInSceneMaker();
				sceneMaker.setStage(stage);
				stage.setScene(sceneMaker.makeScene());
			}
		});
		
		btnRegister.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				RegisterSceneMaker sceneMaker=new RegisterSceneMaker();
				sceneMaker.setStage(stage);
				stage.setScene(sceneMaker.makeScene());
			}
		});
	}
	
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	
}
