package utcluj.ac.ro.view.controllers;

import ws.WS1;
import ws.WS1ImplService;

public class RegisterController {

	private WS1 ws1;

	public RegisterController() {
		WS1ImplService service = new WS1ImplService();
		ws1 = service.getWS1ImplPort();
	}

	public String registerClient(String username, String password) {

		String result = ws1.registerNewClient(username, password);
		System.out.println("register" + username + password + result);
		return result;
	}

}
