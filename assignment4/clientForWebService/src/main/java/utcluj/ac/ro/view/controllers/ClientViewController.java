package utcluj.ac.ro.view.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import ws.*;

import ws.WS1ImplService;

public class ClientViewController {

	private static final String WS_URL = "http://localhost:8080/sdnext/ws1?wsdl";
	private WS1 ws1;

	public ClientViewController() {
		WS1ImplService service = new WS1ImplService();
		ws1 = service.getWS1ImplPort();
	}

	public List getPackages(String username, String password) {

		securization(username, password);
		ResponseArrayList packages = ws1.getClientPackages(username);
		List packagesList = packages.getList();
		return packagesList;
	}

	public PackageToSend obtainPackage(String username, int id, String password) {
		securization(username, password);
		PackageToSend p = ws1.getClientPackage(username, id);
		return p;
	}

	public void securization(String username, String password) {
		Map<String, Object> req_ctx = ((BindingProvider) ws1).getRequestContext();
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList(username));
		headers.put("Password", Collections.singletonList(password));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
	}
}
