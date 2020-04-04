using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace WinApp3_4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btn_Result_Click(object sender, EventArgs e)
        {
            string cs = @"Data Source=.\SQLEXPRESS; Initial Catalog=student; Integrated Security= True";
            SqlConnection cn = new SqlConnection(cs);
            cn.Open();
            Int64 enroll = Int64.Parse(txt_Enrollment.Text);
            string query = "select SPI from dbo.result where Enrollment=" + enroll;
            SqlCommand command= new SqlCommand(query, cn);
            
            SqlDataReader reader = command.ExecuteReader();
            reader.Read();
            txt_Result.Text = reader["SPI"].ToString();
            
            cn.Close();
        }
    }
}
