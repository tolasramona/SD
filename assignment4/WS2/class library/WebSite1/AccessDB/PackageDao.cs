using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web;
using System.Data;
using System.Configuration;
using MySql.Data.MySqlClient;
using System.Data.SqlClient;
using System.Collections;
using System.Collections.Generic;
namespace AccessDB
{
    public class PackageDao
    {
        ConnectionUtilities connUtilities = new ConnectionUtilities();
        MySql.Data.MySqlClient.MySqlConnection conn;
       
        public PackageDao()
        {}

       public string AddPackage(Model.Package pck)
        {
            string rsp = "ok";
            MySql.Data.MySqlClient.MySqlConnection conn;
            try
            {
                string myConnectionString;
                myConnectionString = "server=localhost;uid=root;" +
                    "pwd=;database=asig4;";
                conn = new MySql.Data.MySqlClient.MySqlConnection(myConnectionString);
                string query = "insert into `package`(senderId,receiverId,name,description,senderCity,destinationCity,tracked,routeId) values(@senderId,@receiverId,@name,@description,@senderCity,@receiverCity,@tracked,@routeId)";
                MySqlCommand insert = new MySqlCommand(query, conn);
                insert.Parameters.AddWithValue("@senderId",pck.senderID);
              // insert.Parameters.AddWithValue("@senderId", 1);
                insert.Parameters.AddWithValue("@receiverId", pck.receiverID);
                insert.Parameters.AddWithValue("@name",pck.name);
                insert.Parameters.AddWithValue("@description", pck.description );
                insert.Parameters.AddWithValue("@senderCity", pck.senderCity);
                insert.Parameters.AddWithValue("@receiverCity", pck.destinationCity);
                insert.Parameters.AddWithValue("@tracked", pck.tracked);
                insert.Parameters.AddWithValue("@routeId",pck.routeID);
                try
                {
                    conn.Open();
                    insert.ExecuteNonQuery();
                }
                catch (Exception ex)
                {
                    rsp = insert.CommandText;
                    conn.Close();
                    rsp = ex.Message;
                }
            }
            catch (MySql.Data.MySqlClient.MySqlException ex)
            {
                rsp = ex.Message;
            }
            return rsp;
        }

       public string UpdatePackage(int idPackage,bool tracked)
       {
           string rsp = "ok";
           MySql.Data.MySqlClient.MySqlConnection conn;
           try
           {
               string myConnectionString;
               myConnectionString = "server=localhost;uid=root;" +
                   "pwd=;database=asig4;";
               conn = new MySql.Data.MySqlClient.MySqlConnection(myConnectionString);
               string query = "update  `package` set tracked=@tracked where id=@id;";
               MySqlCommand insert = new MySqlCommand(query, conn);
               insert.Parameters.AddWithValue("@id", idPackage);
               insert.Parameters.AddWithValue("@tracked", tracked);              
               try
               {
                   conn.Open();
                   insert.ExecuteNonQuery();
               }
               catch (Exception ex)
               {
                   rsp = insert.CommandText;
                   conn.Close();
                   rsp = ex.Message;
               }
           }
           catch (MySql.Data.MySqlClient.MySqlException ex)
           {
               rsp = ex.Message;
           }
           return rsp;
       }

       public string DeletePackage(int idPackage)
       {
           string rsp = "ok";
           MySql.Data.MySqlClient.MySqlConnection conn;
           try
           {
               string myConnectionString;
               myConnectionString = "server=localhost;uid=root;" +
                   "pwd=;database=asig4;";
               conn = new MySql.Data.MySqlClient.MySqlConnection(myConnectionString);
               string query = "delete from `package` where id=@id;";
               MySqlCommand insert = new MySqlCommand(query, conn);
               insert.Parameters.AddWithValue("@id", idPackage);              
               try
               {
                   conn.Open();
                   insert.ExecuteNonQuery();
               }
               catch (Exception ex)
               {
                   rsp = insert.CommandText;
                   conn.Close();
                   rsp = ex.Message;
               }
           }
           catch (MySql.Data.MySqlClient.MySqlException ex)
           {
               rsp = ex.Message;
           }
           return rsp;
       }

       public string AddRouteToPackage(int idPackage,string city,long time)
       {
           string rsp="ok";
           int idRoute=this.getRouteId(idPackage);
           MySql.Data.MySqlClient.MySqlConnection conn;
           try
           {
               string myConnectionString;
               myConnectionString = "server=localhost;uid=root;" +
                   "pwd=;database=asig4;";
               conn = new MySql.Data.MySqlClient.MySqlConnection(myConnectionString);
               string query = "insert into `routes`(routeId,city,time) values(@routeID,@city,@time);";
               MySqlCommand insert = new MySqlCommand(query, conn);
               insert.Parameters.AddWithValue("@routeID", idRoute);
               insert.Parameters.AddWithValue("@city",city);
               insert.Parameters.AddWithValue("@time", time);
               try
               {
                   conn.Open();
                   insert.ExecuteNonQuery();
               }
               catch (Exception ex)
               {
                   rsp = insert.CommandText;
                   conn.Close();
                   rsp = ex.Message;
               }
           }
           catch (MySql.Data.MySqlClient.MySqlException ex)
           {
               rsp = ex.Message;
           }
           return rsp;
       }

       public int getRouteId(int packageID)
       {
          
           int routeID = 0;
           string myConnectionString = "server=localhost;uid=root;" +
                  "pwd=;database=asig4;";
           MySqlConnection conn = new MySqlConnection(myConnectionString);
           try
           {
               conn.Open();

               string sql = "select routeId from `package` where id=@id;";
               MySqlCommand cmd = new MySqlCommand(sql, conn);
               cmd.Parameters.AddWithValue("@id", packageID);
               MySqlDataReader rdr = cmd.ExecuteReader();
               if (rdr.HasRows)
               {
                   rdr.Read(); // read first row
                   routeID = rdr.GetInt32(0);
                  
               }
               
             
              
              
           }
           catch (Exception ex)
           {
               Console.WriteLine(ex.ToString());
              
           }

           return routeID;
       }
    }
}
