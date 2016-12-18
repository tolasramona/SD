package utcluj.ac.ro.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
@SuppressWarnings("restriction")
public class ClientLogInSceneMaker extends AbstractLogInSceneMaker {

	
	public void addActionHandlerForLogInButton() {
		btnLog.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				String username=textFieldUsername.getText();
				String password=textFieldPassword.getText();
				if (controller.clientAuthentificationOK(username, password)){
					ClientViewSceneMaker sceneMaker = new ClientViewSceneMaker();
					sceneMaker.setStage(stage);
					sceneMaker.setUsername(username);
					sceneMaker.setPassword(password);
					stage.setScene(sceneMaker.makeScene());
				}else{
					authnetificationMessage.setText("Authentification fail!");
				}
				
				
			}
		});

	}
}
