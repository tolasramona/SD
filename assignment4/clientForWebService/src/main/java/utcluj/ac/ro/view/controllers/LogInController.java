package utcluj.ac.ro.view.controllers;

import ws.WS1;
import ws.WS1ImplService;

public class LogInController {

	private WS1 ws1;

	public LogInController() {
		WS1ImplService service = new WS1ImplService();
		ws1 = service.getWS1ImplPort();
	}

	public boolean adminAuthentificationOK(String username, String password) {
		return ws1.isAdminAuthentificationOK(username, password);
	}

	public boolean clientAuthentificationOK(String username, String password) {
		return ws1.isClientAuthentificationOK(username, password);
	}

}
