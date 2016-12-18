package ws;
import model.Package;
import model.PackageToSend;
import model.ResponseArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface WS1{
	
	
	@WebMethod boolean isAdminAuthentificationOK(String username, String password) ;
	@WebMethod boolean isClientAuthentificationOK(String username, String password);
	@WebMethod String registerNewClient(String username, String password);
	@WebMethod ResponseArrayList<PackageToSend> getClientPackages(String clientUsername);
	@WebMethod PackageToSend getClientPackage(String clientUsername, int packageID);
	
}