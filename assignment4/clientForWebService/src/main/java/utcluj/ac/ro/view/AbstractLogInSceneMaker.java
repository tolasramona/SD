package utcluj.ac.ro.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import utcluj.ac.ro.view.controllers.LogInController;

@SuppressWarnings("restriction")
public abstract class AbstractLogInSceneMaker extends SceneMaker {

	protected LogInController controller = new LogInController();

	protected Label authnetificationMessage;
	private Label usernameLabel;
	protected TextField textFieldUsername;
	private Label passwordLabel;
	protected PasswordField textFieldPassword;
	protected Button btnLog;

	@Override
	public Scene makeScene() {

		initComponents();
		addActionHandlerForBackButton();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.add(usernameLabel, 1, 3);
		grid.add(textFieldUsername, 2, 3);
		grid.add(passwordLabel, 1, 4);
		grid.add(textFieldPassword, 2, 4);
		grid.add(btnLog, 1, 5);
		grid.add(authnetificationMessage, 1, 6);
		
		Scene scene = new Scene(grid, 800, 375);
		scene.getStylesheets().add(View.class.getResource("input.css").toExternalForm());
		return scene;
	}

	private void initComponents() {

		usernameLabel = new Label("Username:");
		textFieldUsername = new TextField();
		passwordLabel = new Label("Password:");
		textFieldPassword = new PasswordField();
		btnLog = new Button();
		btnLog.setText("Log in");
		authnetificationMessage = new Label("");
		addActionHandlerForLogInButton();
	}

	protected abstract void addActionHandlerForLogInButton();

}
