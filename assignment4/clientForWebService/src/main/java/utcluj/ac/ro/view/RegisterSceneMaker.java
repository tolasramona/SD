package utcluj.ac.ro.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import utcluj.ac.ro.view.controllers.RegisterController;

@SuppressWarnings("restriction")
public class RegisterSceneMaker extends SceneMaker {

	private Label helloMessage;
	private Label result;
	private Label usernameLabel;
	private TextField textFieldUsername;
	private Label passwordLabel;
	private PasswordField textFieldPassword;
	private Label password2Label;
	private PasswordField textFieldPassword2;
	private Button btnRegister;
	
	private  RegisterController controller =new RegisterController();

	public Scene makeScene() {
		initComponents();
		addActionHandlerForBackButton();

		grid.add(helloMessage, 0, 1);
		

		HBox hBox = new HBox();
		hBox.getChildren().addAll(grid,scrollPaneWithRegister());
		Scene scene = new Scene(hBox, 800, 475);
		scene.getStylesheets().add(View.class.getResource("input.css").toExternalForm());
		return scene;
	}

	private void initComponents() {

		helloMessage = new Label("Complete the following fields for registration");
		result = new Label("");
		usernameLabel = new Label("Username:");
		textFieldUsername = new TextField();
		passwordLabel = new Label("Password:");
		textFieldPassword = new PasswordField();
		password2Label = new Label("Retype password:");
		textFieldPassword2 = new PasswordField();

		btnRegister = new Button();
		btnRegister.setText("Register");
		addActionHandlerForRegisterButton();
	}
	
	private void addActionHandlerForRegisterButton(){
		btnRegister.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				String username=textFieldUsername.getText();
				String password=textFieldPassword.getText();
				String password2=textFieldPassword2.getText();
				if(password.equals(password2)){
					String resultStr=controller.registerClient(username, password);
					try{
						int i=Integer.parseInt(resultStr);
						result.setText("Registration OK with id "+resultStr);
					}catch(Exception e){
						result.setText("Registration not OK");
					}
				}else{
					System.out.println("passwords must be equal");
				}
				
				
			}
		});		
		
	}
	private GridPane scrollPaneWithRegister() {
		
		
		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.TOP_CENTER);
		pane1.setHgap(50);
		pane1.setVgap(50);
		pane1.setPadding(new Insets(1, 1, 1, 1));
		pane1.add(usernameLabel, 1,3);
		pane1.add(textFieldUsername, 2, 3);
		pane1.add(passwordLabel, 1, 4);
		pane1.add(textFieldPassword, 2, 4);
		pane1.add(password2Label, 1, 5);
		pane1.add(textFieldPassword2, 2,5);
		pane1.add(btnRegister, 0, 6);
		
		pane1.add(result, 0, 7);
		return pane1;
	}
}
