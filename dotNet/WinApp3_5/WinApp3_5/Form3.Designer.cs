namespace WinApp3_5
{
    partial class Form3
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
            this.lbl_AddForm = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lbl_AddForm
            // 
            this.lbl_AddForm.AutoSize = true;
            this.lbl_AddForm.Font = new System.Drawing.Font("Microsoft Sans Serif", 30F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_AddForm.Location = new System.Drawing.Point(160, 187);
            this.lbl_AddForm.Name = "lbl_AddForm";
            this.lbl_AddForm.Size = new System.Drawing.Size(203, 46);
            this.lbl_AddForm.TabIndex = 4;
            this.lbl_AddForm.Text = "Add Form";
            // 
            // Form3
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.ClientSize = new System.Drawing.Size(552, 411);
            this.Controls.Add(this.lbl_AddForm);
            this.Name = "Form3";
            this.Controls.SetChildIndex(this.lbl_AddForm, 0);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbl_AddForm;
    }
}
