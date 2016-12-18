package utcluj.ac.ro.view;
import javafx.event.ActionEvent;
import javafx.scene.image.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


@SuppressWarnings("restriction")
public abstract class SceneMaker {
	private static final Image IMAGE = 
		    new Image("http://icons.iconarchive.com/icons/artdesigner/gentle-romantic/256/rose-icon.png");
	
	protected Stage stage;
	protected Button btnBack;
	protected GridPane grid;
	
	public SceneMaker(){
		initComponents();
	}
	public abstract Scene makeScene();
	
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	protected void addActionHandlerForBackButton(){
		btnBack.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				InitialSceneMaker init = new InitialSceneMaker();
				init.setStage(stage);
				stage.setScene(init.makeInitialScene());
			}
		});
		
		
	}
	
	private void initComponents(){
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(50);
		grid.setVgap(50);
		grid.setPadding(new Insets(1, 1, 1, 1));
		btnBack= new Button();
		btnBack.setText("Back to LogIn");
		grid.add(btnBack, 0, 0);
	}
}
