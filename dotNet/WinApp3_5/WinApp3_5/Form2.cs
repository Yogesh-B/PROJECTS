using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace WinApp3_5
{
    public partial class Form2 : WinApp3_5.Form1
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void btn_AddStudent_Click(object sender, EventArgs e)
        {
            Form3 f = new Form3();
            f.Show();
        }

        private void btn_Remove_Click(object sender, EventArgs e)
        {
            Form4 f = new Form4();
            f.Show();
        }
    }
}
