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
    public partial class WebForm3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Button1_Click(object sender, EventArgs e)
        {
            string cs = @"Data Source=.\SQLEXPRESS; Initial Catalog=ASP; Integrated Security= True";
            SqlConnection cn = new SqlConnection(cs);
            cn.Open();
            Int64 a1 = Int64.Parse(TextBox1.Text);
            Int64 a2 = Int64.Parse(TextBox2.Text);
            String b1 = TextBox3.Text;
            double c2 = double.Parse(TextBox4.Text);
            string cq1 = "update student1 set Enrollment=" + a2 + ",Name='" + b1 + "',SPI=" + c2 + " where Enrollment=" + a1;
            SqlCommand cm1 = new SqlCommand(cq1, cn);
            cm1.ExecuteNonQuery();

            Label7.Text = "record edit successfully...";
            Label7.ForeColor = System.Drawing.Color.Green;
        }
    }
}