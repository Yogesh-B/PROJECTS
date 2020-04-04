namespace WinApp3_6
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lbl_Main = new System.Windows.Forms.Label();
            this.lbl_Income = new System.Windows.Forms.Label();
            this.lbl_Tax = new System.Windows.Forms.Label();
            this.lbl_Remaining = new System.Windows.Forms.Label();
            this.lbl_Rate = new System.Windows.Forms.Label();
            this.txt_Income = new System.Windows.Forms.TextBox();
            this.txt_Rate = new System.Windows.Forms.TextBox();
            this.txt_Tax = new System.Windows.Forms.TextBox();
            this.txt_Remaining = new System.Windows.Forms.TextBox();
            this.btn_CalculateTax = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lbl_Main
            // 
            this.lbl_Main.AutoSize = true;
            this.lbl_Main.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_Main.Location = new System.Drawing.Point(115, 9);
            this.lbl_Main.Name = "lbl_Main";
            this.lbl_Main.Size = new System.Drawing.Size(347, 55);
            this.lbl_Main.TabIndex = 0;
            this.lbl_Main.Text = "Tax Calculator";
            // 
            // lbl_Income
            // 
            this.lbl_Income.AutoSize = true;
            this.lbl_Income.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_Income.Location = new System.Drawing.Point(136, 93);
            this.lbl_Income.Name = "lbl_Income";
            this.lbl_Income.Size = new System.Drawing.Size(69, 17);
            this.lbl_Income.TabIndex = 1;
            this.lbl_Income.Text = "Income :";
            // 
            // lbl_Tax
            // 
            this.lbl_Tax.AutoSize = true;
            this.lbl_Tax.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_Tax.Location = new System.Drawing.Point(102, 168);
            this.lbl_Tax.Name = "lbl_Tax";
            this.lbl_Tax.Size = new System.Drawing.Size(103, 17);
            this.lbl_Tax.TabIndex = 2;
            this.lbl_Tax.Text = "Tax Amount :";
            // 
            // lbl_Remaining
            // 
            this.lbl_Remaining.AutoSize = true;
            this.lbl_Remaining.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_Remaining.Location = new System.Drawing.Point(52, 201);
            this.lbl_Remaining.Name = "lbl_Remaining";
            this.lbl_Remaining.Size = new System.Drawing.Size(153, 17);
            this.lbl_Remaining.TabIndex = 3;
            this.lbl_Remaining.Text = "Remaining Amount :";
            // 
            // lbl_Rate
            // 
            this.lbl_Rate.AutoSize = true;
            this.lbl_Rate.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_Rate.Location = new System.Drawing.Point(94, 131);
            this.lbl_Rate.Name = "lbl_Rate";
            this.lbl_Rate.Size = new System.Drawing.Size(111, 17);
            this.lbl_Rate.TabIndex = 2;
            this.lbl_Rate.Text = "Applied Rate :";
            // 
            // txt_Income
            // 
            this.txt_Income.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txt_Income.Location = new System.Drawing.Point(211, 93);
            this.txt_Income.Name = "txt_Income";
            this.txt_Income.Size = new System.Drawing.Size(290, 23);
            this.txt_Income.TabIndex = 4;
            // 
            // txt_Rate
            // 
            this.txt_Rate.Enabled = false;
            this.txt_Rate.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txt_Rate.Location = new System.Drawing.Point(211, 131);
            this.txt_Rate.Name = "txt_Rate";
            this.txt_Rate.Size = new System.Drawing.Size(100, 23);
            this.txt_Rate.TabIndex = 5;
            // 
            // txt_Tax
            // 
            this.txt_Tax.Enabled = false;
            this.txt_Tax.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txt_Tax.Location = new System.Drawing.Point(211, 168);
            this.txt_Tax.Name = "txt_Tax";
            this.txt_Tax.Size = new System.Drawing.Size(290, 23);
            this.txt_Tax.TabIndex = 6;
            // 
            // txt_Remaining
            // 
            this.txt_Remaining.Enabled = false;
            this.txt_Remaining.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txt_Remaining.Location = new System.Drawing.Point(211, 201);
            this.txt_Remaining.Name = "txt_Remaining";
            this.txt_Remaining.Size = new System.Drawing.Size(290, 23);
            this.txt_Remaining.TabIndex = 7;
            // 
            // btn_CalculateTax
            // 
            this.btn_CalculateTax.Location = new System.Drawing.Point(218, 248);
            this.btn_CalculateTax.Name = "btn_CalculateTax";
            this.btn_CalculateTax.Size = new System.Drawing.Size(111, 23);
            this.btn_CalculateTax.TabIndex = 8;
            this.btn_CalculateTax.Text = "Calculate Tax";
            this.btn_CalculateTax.UseVisualStyleBackColor = true;
            this.btn_CalculateTax.Click += new System.EventHandler(this.btn_CalculateTax_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(580, 348);
            this.Controls.Add(this.btn_CalculateTax);
            this.Controls.Add(this.txt_Remaining);
            this.Controls.Add(this.txt_Tax);
            this.Controls.Add(this.txt_Rate);
            this.Controls.Add(this.txt_Income);
            this.Controls.Add(this.lbl_Remaining);
            this.Controls.Add(this.lbl_Rate);
            this.Controls.Add(this.lbl_Tax);
            this.Controls.Add(this.lbl_Income);
            this.Controls.Add(this.lbl_Main);
            this.Name = "Form1";
            this.Text = "Income Tax Calculator";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbl_Main;
        private System.Windows.Forms.Label lbl_Income;
        private System.Windows.Forms.Label lbl_Tax;
        private System.Windows.Forms.Label lbl_Remaining;
        private System.Windows.Forms.Label lbl_Rate;
        private System.Windows.Forms.TextBox txt_Income;
        private System.Windows.Forms.TextBox txt_Rate;
        private System.Windows.Forms.TextBox txt_Tax;
        private System.Windows.Forms.TextBox txt_Remaining;
        private System.Windows.Forms.Button btn_CalculateTax;
    }
}

