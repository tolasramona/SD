using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for PackageOperationController
/// </summary>

    public class PackageOperationController
    {
        public PackageOperationController()
        {

        }

        public bool insertPackage(int senderId, int receivedId, string name, string description, string senderCity, string receiverCity, bool tracked, int routeId) 
        {
            AccessDB.PackgeDao pckDao = new AccessDB.PackgeDao();
            Package pck = new Package();
           /* pck.senderId = senderId;
            pck.receiverId = receiverId;
            pck.name = name;
            pck.description = description;
            pck.senderCity = senderCity;
            pck.destinationCity = receiverCity;
            pck.tracked = tracked;
            pck.routeID = routeId;
           */
           // pck = new Package(0,senderId,receivedId,name,description,senderCity,receiverCity,tracked,routeId);
            pck = new Package(0, 1, 1, "Cname", "Cdescription", "senderCity", "receiverCity",true," routeId");
            return pckDao.AddPackage(pck);
        }

    }
