using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AccessDB.Model
{
   public class Package
    {
        public Package()
        {
        }
        public Package(int id,int senderId,int receiverID,string name,string description,string senderCity,string receiverCity,bool tracked,int routeId)
        {
            this.id = id;
            this.senderID = senderId;
            this.receiverID = receiverID;
            this.name = name;
            this.description = description;
            this.senderCity = senderCity;
            this.destinationCity = receiverCity;
            this.tracked = tracked;
            this.routeID = routeId;
        }
         public int id { get; set; }
         public int senderID { get; set; }
         public int receiverID { get; set; }
         public string name { get; set; }
         public string description { get; set; }
         public string senderCity { get; set; }
         public string destinationCity { get; set; }
         public bool tracked { get; set; }
         public int routeID { get; set; }


    }
}
