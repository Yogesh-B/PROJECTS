using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ASPpract1
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
       

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                double no1 = double.Parse(TextBox1.Text);
                double no2 = double.Parse(TextBox2.Text);
                double answer = 0;
                String o = DropDownList1.Text;

                if (o == "+")
                    answer = no1 + no2;
                else if (o == "-")
                    answer = no1 - no2;
                else if (o == "*")
                    answer = no1 * no2;
                else if (o == "/")
                    answer = no1 / no2;
                else
                    answer = -1;

                Label_Answer.Text = answer.ToString();
            }
            catch (Exception ex)
            {
                Label1.Text = "Invalid entry....";
            }
        }
    }
}