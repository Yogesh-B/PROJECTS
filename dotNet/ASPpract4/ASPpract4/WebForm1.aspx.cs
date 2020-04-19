using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace ASPpract4
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            FindView();
            UpdateCounter();
        }

        private void FindView()
        {
            string cs = @"Data Source=.\SQLEXPRESS; Initial Catalog=ASP; Integrated Security= True";
            string cq = "select * from hit_counter";
            SqlConnection con = new SqlConnection(cs);
            SqlCommand cmd = new SqlCommand(cq, con);
           // cm.CommandText = cq;
           // cm.Connection = cn;
            SqlDataAdapter da = new SqlDataAdapter();
            da.SelectCommand = cmd;
            DataSet ds = new DataSet();
            da.Fill(ds);

            Label3.Text = "website view counter : " + ds.Tables[0].Rows[0]["view_counter"].ToString();
            con.Close();
        }

        private void UpdateCounter()
        {
            string cs = @"Data Source=.\SQLEXPRESS; Initial Catalog=ASP; Integrated Security= True";
            string cq = "update hit_counter set view_counter=view_counter+1";
            SqlConnection con = new SqlConnection(cs);
            con.Open();
            SqlCommand cmd = new SqlCommand(cq,con);
            //cmd.CommandText = cq;
            //cmd.Connection = con;
            cmd.ExecuteNonQuery();
        }
    }
}