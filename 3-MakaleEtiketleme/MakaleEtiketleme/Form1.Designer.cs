namespace MakaleEtiketleme
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
            this.lstMakaleBaslik = new System.Windows.Forms.ListBox();
            this.txtMakaleIcerik = new System.Windows.Forms.RichTextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.radioButton5 = new System.Windows.Forms.RadioButton();
            this.radioButton4 = new System.Windows.Forms.RadioButton();
            this.radioButton3 = new System.Windows.Forms.RadioButton();
            this.radioButton2 = new System.Windows.Forms.RadioButton();
            this.radioButton1 = new System.Windows.Forms.RadioButton();
            this.btnEtiketle = new System.Windows.Forms.Button();
            this.btnArffSablon = new System.Windows.Forms.Button();
            this.radioButton6 = new System.Windows.Forms.RadioButton();
            this.txtGazete = new System.Windows.Forms.RichTextBox();
            this.txtYazar = new System.Windows.Forms.RichTextBox();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lstMakaleBaslik
            // 
            this.lstMakaleBaslik.FormattingEnabled = true;
            this.lstMakaleBaslik.Location = new System.Drawing.Point(12, 21);
            this.lstMakaleBaslik.Name = "lstMakaleBaslik";
            this.lstMakaleBaslik.Size = new System.Drawing.Size(367, 147);
            this.lstMakaleBaslik.TabIndex = 0;
            this.lstMakaleBaslik.SelectedIndexChanged += new System.EventHandler(this.lstMakaleBaslik_SelectedIndexChanged);
            // 
            // txtMakaleIcerik
            // 
            this.txtMakaleIcerik.Location = new System.Drawing.Point(12, 174);
            this.txtMakaleIcerik.Name = "txtMakaleIcerik";
            this.txtMakaleIcerik.Size = new System.Drawing.Size(367, 147);
            this.txtMakaleIcerik.TabIndex = 1;
            this.txtMakaleIcerik.Text = "";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radioButton6);
            this.groupBox1.Controls.Add(this.radioButton5);
            this.groupBox1.Controls.Add(this.radioButton4);
            this.groupBox1.Controls.Add(this.radioButton3);
            this.groupBox1.Controls.Add(this.radioButton2);
            this.groupBox1.Controls.Add(this.radioButton1);
            this.groupBox1.Location = new System.Drawing.Point(16, 387);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(363, 60);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Kategori Seç";
            // 
            // radioButton5
            // 
            this.radioButton5.AutoSize = true;
            this.radioButton5.Location = new System.Drawing.Point(247, 28);
            this.radioButton5.Name = "radioButton5";
            this.radioButton5.Size = new System.Drawing.Size(53, 17);
            this.radioButton5.TabIndex = 0;
            this.radioButton5.TabStop = true;
            this.radioButton5.Text = "Eğitim";
            this.radioButton5.UseVisualStyleBackColor = true;
            // 
            // radioButton4
            // 
            this.radioButton4.AutoSize = true;
            this.radioButton4.Location = new System.Drawing.Point(188, 28);
            this.radioButton4.Name = "radioButton4";
            this.radioButton4.Size = new System.Drawing.Size(54, 17);
            this.radioButton4.TabIndex = 0;
            this.radioButton4.TabStop = true;
            this.radioButton4.Text = "Sağlık";
            this.radioButton4.UseVisualStyleBackColor = true;
            // 
            // radioButton3
            // 
            this.radioButton3.AutoSize = true;
            this.radioButton3.Location = new System.Drawing.Point(136, 28);
            this.radioButton3.Name = "radioButton3";
            this.radioButton3.Size = new System.Drawing.Size(47, 17);
            this.radioButton3.TabIndex = 0;
            this.radioButton3.TabStop = true;
            this.radioButton3.Text = "Spor";
            this.radioButton3.UseVisualStyleBackColor = true;
            // 
            // radioButton2
            // 
            this.radioButton2.AutoSize = true;
            this.radioButton2.Location = new System.Drawing.Point(67, 28);
            this.radioButton2.Name = "radioButton2";
            this.radioButton2.Size = new System.Drawing.Size(66, 17);
            this.radioButton2.TabIndex = 0;
            this.radioButton2.TabStop = true;
            this.radioButton2.Text = "Ekonomi";
            this.radioButton2.UseVisualStyleBackColor = true;
            // 
            // radioButton1
            // 
            this.radioButton1.AutoSize = true;
            this.radioButton1.Location = new System.Drawing.Point(8, 28);
            this.radioButton1.Name = "radioButton1";
            this.radioButton1.Size = new System.Drawing.Size(59, 17);
            this.radioButton1.TabIndex = 0;
            this.radioButton1.TabStop = true;
            this.radioButton1.Text = "Siyaset";
            this.radioButton1.UseVisualStyleBackColor = true;
            // 
            // btnEtiketle
            // 
            this.btnEtiketle.Location = new System.Drawing.Point(236, 473);
            this.btnEtiketle.Name = "btnEtiketle";
            this.btnEtiketle.Size = new System.Drawing.Size(143, 23);
            this.btnEtiketle.TabIndex = 3;
            this.btnEtiketle.Text = "Makaleyi Etiketle";
            this.btnEtiketle.UseVisualStyleBackColor = true;
            this.btnEtiketle.Click += new System.EventHandler(this.btnEtiketle_Click);
            // 
            // btnArffSablon
            // 
            this.btnArffSablon.Location = new System.Drawing.Point(22, 473);
            this.btnArffSablon.Name = "btnArffSablon";
            this.btnArffSablon.Size = new System.Drawing.Size(136, 23);
            this.btnArffSablon.TabIndex = 3;
            this.btnArffSablon.Text = "ARFF Şablonu Oluştur";
            this.btnArffSablon.UseVisualStyleBackColor = true;
            this.btnArffSablon.Click += new System.EventHandler(this.btnArffSablon_Click);
            // 
            // radioButton6
            // 
            this.radioButton6.AutoSize = true;
            this.radioButton6.Location = new System.Drawing.Point(300, 28);
            this.radioButton6.Name = "radioButton6";
            this.radioButton6.Size = new System.Drawing.Size(57, 17);
            this.radioButton6.TabIndex = 1;
            this.radioButton6.TabStop = true;
            this.radioButton6.Text = "Yaşam";
            this.radioButton6.UseVisualStyleBackColor = true;
            // 
            // txtGazete
            // 
            this.txtGazete.Location = new System.Drawing.Point(12, 336);
            this.txtGazete.Name = "txtGazete";
            this.txtGazete.Size = new System.Drawing.Size(152, 23);
            this.txtGazete.TabIndex = 4;
            this.txtGazete.Text = "";
            // 
            // txtYazar
            // 
            this.txtYazar.Location = new System.Drawing.Point(227, 336);
            this.txtYazar.Name = "txtYazar";
            this.txtYazar.Size = new System.Drawing.Size(152, 23);
            this.txtYazar.TabIndex = 4;
            this.txtYazar.Text = "";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(397, 510);
            this.Controls.Add(this.txtYazar);
            this.Controls.Add(this.txtGazete);
            this.Controls.Add(this.btnArffSablon);
            this.Controls.Add(this.btnEtiketle);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.txtMakaleIcerik);
            this.Controls.Add(this.lstMakaleBaslik);
            this.Name = "Form1";
            this.Text = "Ana Form";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListBox lstMakaleBaslik;
        private System.Windows.Forms.RichTextBox txtMakaleIcerik;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton radioButton5;
        private System.Windows.Forms.RadioButton radioButton4;
        private System.Windows.Forms.RadioButton radioButton3;
        private System.Windows.Forms.RadioButton radioButton2;
        private System.Windows.Forms.RadioButton radioButton1;
        private System.Windows.Forms.Button btnEtiketle;
        private System.Windows.Forms.Button btnArffSablon;
        private System.Windows.Forms.RadioButton radioButton6;
        private System.Windows.Forms.RichTextBox txtGazete;
        private System.Windows.Forms.RichTextBox txtYazar;
    }
}

