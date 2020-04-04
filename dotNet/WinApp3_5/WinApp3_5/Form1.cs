using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinApp3_5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            lbl_Time.Text = DateTime.Now.ToString();
        }

        private void btn_Search_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Searching " + txt_Search.Text + "... ");
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
