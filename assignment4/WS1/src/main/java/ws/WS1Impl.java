package ws;

import java.util.ArrayList;

import model.*;
import model.Package;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import controller.AuthentificationController;
import controller.ClientOperationsController;
import controller.RegistrationController;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "ws.WS1")
public class WS1Impl implements WS1 {

	private AuthentificationController controller = new AuthentificationController();
	private RegistrationController regController = new RegistrationController();
	private ClientOperationsController operController = new ClientOperationsController();

	@Resource
	WebServiceContext wsctx;

	public boolean isAdminAuthentificationOK(String username, String password) {

		return controller.checkAdminAuthentification(username, password);
	}

	public boolean isClientAuthentificationOK(String username, String password) {
		return controller.checkClientAuthentification(username, password);
	}

	public String registerNewClient(String username, String password) {
		return regController.registerClient(username, password);
	}

	public ResponseArrayList<PackageToSend> getClientPackages(String clientUsername) {
		MessageContext mctx = wsctx.getMessageContext();
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");

		String username = "";
		String password = "";

		if (userList != null) {
			username = userList.get(0).toString();
		}

		if (passList != null) {
			password = passList.get(0).toString();
		}

		if (controller.checkClientAuthentification(username, password)) {
			ArrayList<Package> arrayPackages = operController.getClientPackages(clientUsername);
			List<PackageToSend> arrayPackagesToSend;
			ResponseArrayList<PackageToSend> packages = new ResponseArrayList<PackageToSend>();
			TransformerFromPackageToPackageToSend transformer = new TransformerFromPackageToPackageToSend();
			arrayPackagesToSend = transformer.transformPackages(arrayPackages);
			packages.setList(arrayPackagesToSend);
			return packages;
		} else {
			return null;
		}

	}

	public PackageToSend getClientPackage(String clientUsername, int packageID) {
		MessageContext mctx = wsctx.getMessageContext();
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");

		String username = "";
		String password = "";

		if (userList != null) {
			username = userList.get(0).toString();
		}

		if (passList != null) {
			password = passList.get(0).toString();
		}

		if (controller.checkClientAuthentification(username, password)) {
			Package p = operController.getClientPackage(clientUsername, packageID);
			TransformerFromPackageToPackageToSend transformer = new TransformerFromPackageToPackageToSend();
			return transformer.transform(p);
		} else {
			return null;
		}

		
	}

}