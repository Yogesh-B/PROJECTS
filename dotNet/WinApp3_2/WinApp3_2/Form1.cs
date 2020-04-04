using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinApp3_2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        public int count = 0;
        public double total = 0;

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btn_AddItem_Click(object sender, EventArgs e)
        {
            try
            { 
                count++;
                double total2 = double.Parse(txt_Price.Text) * double.Parse(txt_Quantity.Text);
                DGV1.Rows.Add(count, txt_ItemName.Text, txt_Price.Text, txt_Quantity.Text, total2.ToString());

                txt_ItemName.Clear();
                txt_Price.Clear();
                txt_Quantity.Clear();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }

        }

        private void btn_Total_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < DGV1.Rows.Count; i++)
            {

              
                total+=double.Parse(this.DGV1.Rows[i].Cells["Total1"].Value.ToString());

            }
            txt_Total.Text = total.ToString();
        }

        

        private void lbl_Qauntity_Click(object sender, EventArgs e)
        {

        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        
    }
}
