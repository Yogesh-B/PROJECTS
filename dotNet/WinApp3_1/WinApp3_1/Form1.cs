using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinApp3_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            textBox1.Text += "1";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            textBox1.Text += "2";
        }

        private void button3_Click(object sender, EventArgs e)
        {
            textBox1.Text += "3";
        }

        private void buttonAdd_Click(object sender, EventArgs e)
        {
            if (textBox1.Text.Length != 0)
            {
                char c = textBox1.Text[textBox1.Text.Length - 1];
                if (c != '+' && c != '-' && c != '*' && c != '/')
                    textBox1.Text += "+";
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            textBox1.Text += "4";
        }

        private void button5_Click(object sender, EventArgs e)
        {
            textBox1.Text += "5";
        }

        private void button6_Click(object sender, EventArgs e)
        {
            textBox1.Text += "6";
        }

        private void buttonSub_Click(object sender, EventArgs e)
        {
            if (textBox1.Text.Length != 0)
            {
                char c = textBox1.Text[textBox1.Text.Length - 1];
                if (c != '+' && c != '-' && c != '*' && c != '/')
                    textBox1.Text += "-";
            }
        }

        private void button7_Click(object sender, EventArgs e)
        {
            textBox1.Text += "7";
        }

        private void button8_Click(object sender, EventArgs e)
        {
            textBox1.Text += "8";
        }

        private void button9_Click(object sender, EventArgs e)
        {
            textBox1.Text += "9";
        }

        private void buttonMul_Click(object sender, EventArgs e)
        {
            if (textBox1.Text.Length != 0)
            {
                char c = textBox1.Text[textBox1.Text.Length - 1];
                if (c != '+' && c != '-' && c != '*' && c != '/')
                    textBox1.Text += "*";
            }
        }

        private void buttonC_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
        }

        private void button0_Click(object sender, EventArgs e)
        {
            textBox1.Text += "0";
        }

        private void buttonDiv_Click(object sender, EventArgs e)
        {
            if (textBox1.Text.Length != 0)
            {
                char c = textBox1.Text[textBox1.Text.Length - 1];
                if (c != '+' && c != '-' && c != '*' && c != '/')
                    textBox1.Text += "/";
            }
        }

        private void buttonEql_Click(object sender, EventArgs e)
        {
            try
            {
                DataTable dt = new DataTable();
                var v = dt.Compute(textBox1.Text, "");
                textBox1.Text = v.ToString();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }
    }
}
