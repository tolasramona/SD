using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Configuration;
using MySql.Data.MySqlClient;
using System.Data.SqlClient;
namespace AccessDB
{
   public  class ConnectionUtilities
    {
        MySql.Data.MySqlClient.MySqlConnection conn;

        public ConnectionUtilities()
        {

            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString = "server=localhost;uid=root;" +
                   "pwd=;database=asig4;";
            conn = new MySql.Data.MySqlClient.MySqlConnection(myConnectionString);
        }

        public MySqlConnection getConncetion()
        {
            try
            {
                conn.Open();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Can not open connection ! ");
            }
            return conn;
        }
    }
}
