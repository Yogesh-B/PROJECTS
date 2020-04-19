using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ASPpract3
{
    public partial class WebForm4 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["uname"] != null)
            {
                Label3.Text = Session["Name"].ToString();
            }
            if (Session["uemail"] != null)
            {
                Label4.Text = Session["Email"].ToString();
            }
        }
    }
}