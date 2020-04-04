using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinApp3_6
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btn_CalculateTax_Click(object sender, EventArgs e)
        {
            //temp variables
            double income = double.Parse(txt_Income.Text);
            float rate = 0;
            double tax = 0;
            double remaining = double.Parse(txt_Income.Text);

            //calculate
            if (income <= 250000)
            {
                remaining = income - tax;
            }
            else if (income > 250000 && income <= 500000)
            {
                rate = 0.05F;
                tax = income * rate;
                remaining = income - tax;
            }
            else if (income > 500000 && income <= 750000)
            {
                rate = 0.1F;
                tax = income * rate;
                remaining = income - tax;
            }
            else if (income > 750000 && income <= 1000000)
            {
                rate = 0.15F;
                tax = income * rate;
                remaining = income - tax;
            }
            else if (income > 1000000 && income <= 1250000)
            {
                rate = 0.2F;
                tax = income * rate;
                remaining = income - tax;
            }
            else if (income > 1250000 && income <= 1500000)
            {
                rate = 0.25F;
                tax = income * rate;
                remaining = income - tax;
            }
            else if (income > 1500000)
            {
                rate = 0.3F;
                tax = income * rate;
                remaining = income - tax;
            }
            else { MessageBox.Show("Case not matched"); }
            




            //set output
            txt_Rate.Text = ((rate * 100).ToString()) + "%";
            txt_Tax.Text = tax.ToString();
            txt_Remaining.Text = remaining.ToString();


        }
    }
}
