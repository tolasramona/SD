package utcluj.ac.ro.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

@SuppressWarnings("restriction")
public class AdminLogInSceneMaker extends AbstractLogInSceneMaker {

	public void addActionHandlerForLogInButton() {
		btnLog.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				String username=textFieldUsername.getText();
				String password=textFieldPassword.getText();
				if(controller.adminAuthentificationOK(username, password)){
					AdminViewSceneMaker sceneMaker = new AdminViewSceneMaker();
					sceneMaker.setStage(stage);
					stage.setScene(sceneMaker.makeScene());
				}else{
					authnetificationMessage.setText("Authentification fail!");
				}
				
			}
		});

	}
}
