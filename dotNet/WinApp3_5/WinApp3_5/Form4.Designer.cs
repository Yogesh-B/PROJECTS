namespace WinApp3_5
{
    partial class Form4
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
            this.lbl_RemoveForm = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lbl_RemoveForm
            // 
            this.lbl_RemoveForm.AutoSize = true;
            this.lbl_RemoveForm.Font = new System.Drawing.Font("Microsoft Sans Serif", 30F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_RemoveForm.Location = new System.Drawing.Point(157, 191);
            this.lbl_RemoveForm.Name = "lbl_RemoveForm";
            this.lbl_RemoveForm.Size = new System.Drawing.Size(283, 46);
            this.lbl_RemoveForm.TabIndex = 5;
            this.lbl_RemoveForm.Text = "Remove Form";
            // 
            // Form4
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.ClientSize = new System.Drawing.Size(552, 411);
            this.Controls.Add(this.lbl_RemoveForm);
            this.Name = "Form4";
            this.Controls.SetChildIndex(this.lbl_RemoveForm, 0);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbl_RemoveForm;
    }
}
