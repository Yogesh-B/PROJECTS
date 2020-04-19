using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ASPpract3
{
    public partial class WebForm3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Button1_Click(object sender, EventArgs e)
        {
            Session.Add("uname", TextBox1.Text);
            Session["Name"] = TextBox1.Text;
            Session.Add("uemail", TextBox2.Text);
            Session["Email"] = TextBox2.Text;
            Response.Redirect("WebForm4.aspx");
        }
    }
}