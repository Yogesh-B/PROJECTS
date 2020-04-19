using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace ASPpract5
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Button1_Click(object sender, EventArgs e)
        {
            string cs = @"Data Source=.\SQLEXPRESS; Initial Catalog=ASP; Integrated Security= True";
            SqlConnection con = new SqlConnection(cs);
            con.Open();
            Int64 en = Int64.Parse(TextBox1.Text);
            string cq = "select Name,SPI from student1 where Enrollment=" + en;
            SqlCommand cmd = new SqlCommand(cq, con);
            SqlDataReader dr = cmd.ExecuteReader();
            dr.Read();
            Label3.Text = dr["SPI"].ToString();
            Label5.Text = dr["Name"].ToString();
        }
    }
}