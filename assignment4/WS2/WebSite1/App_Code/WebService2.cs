using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Summary description for WebService2
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class WebService2 : System.Web.Services.WebService {

    public WebService2 () {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    

    [WebMethod]
    public string insertPackage(int senderId, int receivedId, string name, string description, string senderCity, string receiverCity, bool tracked, int routeId) 
    {
        PackageOperationController controller = new PackageOperationController();
        return controller.insertPackage(senderId, receivedId, name, description, senderCity, receiverCity, tracked, routeId);
    }

    [WebMethod]
    public string updatePackage(int packageId,bool tracked){
        PackageOperationController controller = new PackageOperationController();
        return controller.updatePackage(packageId,tracked);
    }

    [WebMethod]
    public string deletePackage(int packageId)
    {
        PackageOperationController controller = new PackageOperationController();
        return controller.deletePackage(packageId);
    }

    [WebMethod]
    public string addRouteToPackage(int id, string city, long time)
    {
        PackageOperationController controller = new PackageOperationController();
        return controller.addRouteToPackage(id, city, time);
    }
    
}
