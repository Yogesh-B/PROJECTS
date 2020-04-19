using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ASPpract6
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            ValidationSettings.UnobtrusiveValidationMode = UnobtrusiveValidationMode.None;
        }
        protected void lnkbtnInsert_Click(object sender, EventArgs e)
        {
            SqlDataSource1.InsertParameters["Id"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("txtId")).Text;
            SqlDataSource1.InsertParameters["Enrollment"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("txtEnrollmentNo")).Text;
            SqlDataSource1.InsertParameters["Name"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("txtName")).Text;
            SqlDataSource1.InsertParameters["BookName"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("txtBookName")).Text;
            SqlDataSource1.InsertParameters["IssueDate"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("txtIssueDate")).Text;
            SqlDataSource1.Insert();
        }
    }
}