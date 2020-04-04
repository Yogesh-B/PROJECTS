namespace WinApp3_4
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
            this.btn_Result = new System.Windows.Forms.Button();
            this.txt_Enrollment = new System.Windows.Forms.TextBox();
            this.lbl_Enrollment = new System.Windows.Forms.Label();
            this.txt_Result = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btn_Result
            // 
            this.btn_Result.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_Result.Location = new System.Drawing.Point(314, 203);
            this.btn_Result.Name = "btn_Result";
            this.btn_Result.Size = new System.Drawing.Size(94, 23);
            this.btn_Result.TabIndex = 0;
            this.btn_Result.Text = "Get Result";
            this.btn_Result.UseVisualStyleBackColor = true;
            this.btn_Result.Click += new System.EventHandler(this.btn_Result_Click);
            // 
            // txt_Enrollment
            // 
            this.txt_Enrollment.Location = new System.Drawing.Point(364, 94);
            this.txt_Enrollment.Name = "txt_Enrollment";
            this.txt_Enrollment.Size = new System.Drawing.Size(162, 20);
            this.txt_Enrollment.TabIndex = 1;
            // 
            // lbl_Enrollment
            // 
            this.lbl_Enrollment.AutoSize = true;
            this.lbl_Enrollment.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_Enrollment.Location = new System.Drawing.Point(186, 92);
            this.lbl_Enrollment.Name = "lbl_Enrollment";
            this.lbl_Enrollment.Size = new System.Drawing.Size(172, 20);
            this.lbl_Enrollment.TabIndex = 2;
            this.lbl_Enrollment.Text = "Enrollment Number :";
            // 
            // txt_Result
            // 
            this.txt_Result.Enabled = false;
            this.txt_Result.Location = new System.Drawing.Point(364, 148);
            this.txt_Result.Name = "txt_Result";
            this.txt_Result.Size = new System.Drawing.Size(100, 20);
            this.txt_Result.TabIndex = 3;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(310, 148);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(48, 20);
            this.label1.TabIndex = 4;
            this.label1.Text = "SPI :";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txt_Result);
            this.Controls.Add(this.lbl_Enrollment);
            this.Controls.Add(this.txt_Enrollment);
            this.Controls.Add(this.btn_Result);
            this.Name = "Form1";
            this.Text = "Student Result";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btn_Result;
        private System.Windows.Forms.TextBox txt_Enrollment;
        private System.Windows.Forms.Label lbl_Enrollment;
        private System.Windows.Forms.TextBox txt_Result;
        private System.Windows.Forms.Label label1;
    }
}

