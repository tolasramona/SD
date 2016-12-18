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

        public string insertPackage(int senderId, int receivedId, string name, string description, string senderCity, string receiverCity, bool tracked, int routeId)
        {
            AccessDB.PackageDao pckDao = new AccessDB.PackageDao();
            AccessDB.Model.Package pck;
            pck = new AccessDB.Model.Package(senderId, senderId, receivedId, name, description, senderCity, receiverCity, tracked, routeId);        
            return pckDao.AddPackage(pck);
            
        }

        public String updatePackage(int idPackage, bool tracked)
        {
            AccessDB.PackageDao pckDao = new AccessDB.PackageDao();
            return pckDao.UpdatePackage(idPackage, tracked);
        }

        public String deletePackage(int idPackage)
        {
            AccessDB.PackageDao pckDao = new AccessDB.PackageDao();
            return pckDao.DeletePackage(idPackage);
        }

        public String addRouteToPackage(int idPackage,string city,long time)
        {
            AccessDB.PackageDao pckDao = new AccessDB.PackageDao();
            return pckDao.AddRouteToPackage(idPackage, city, time);
        }

    }
