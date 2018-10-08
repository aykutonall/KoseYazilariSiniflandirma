using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using System.Collections;

namespace MakaleEtiketleme
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            StreamReader sr = new StreamReader(path:"C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/baslik.txt");
            string satir;

            while ((satir = sr.ReadLine()) != null)
            {
                lstMakaleBaslik.Items.Add(satir);
            }
            sr.Close();
        }

        private void lstMakaleBaslik_SelectedIndexChanged(object sender, EventArgs e)
        {
            StreamReader sr = new StreamReader(path: "C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/ModelTrainSetClear.txt");
            StreamReader sr1 = new StreamReader(path: "C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/gazeteadi.txt");
            StreamReader sr2 = new StreamReader(path: "C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/yazaradi.txt");
            int index = Convert.ToInt32(lstMakaleBaslik.SelectedIndex.ToString());
            index++;
            string satir;
            int i=0, j=0, z=0;
            while ((satir = sr.ReadLine()) != null)
            {
                i++;
                if (i == index)
                {
                    txtMakaleIcerik.Clear();
                    txtMakaleIcerik.Text = satir;
                }
            }
            while ((satir = sr1.ReadLine()) != null)
            {
                j++;
                if (j == index)
                {
                    txtGazete.Clear();
                    txtGazete.Text = satir;
                }
            }
            while ((satir = sr2.ReadLine()) != null)
            {
                z++;
                if (z == index)
                {
                    txtYazar.Clear();
                    txtYazar.Text = satir;
                }
            }
            sr.Close();
            sr1.Close();
            sr2.Close();
        }

        private void btnArffSablon_Click(object sender, EventArgs e)
        {
            string dosya = @"C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/ModelTrainSet.arff";
            FileStream fs = new FileStream(dosya, FileMode.OpenOrCreate, FileAccess.Write);
            StreamWriter sw = new StreamWriter(fs);
            sw.WriteLine("@relation makaleler");
            sw.WriteLine("@attribute baslik string");
            sw.WriteLine("@attribute gazete string");
            sw.WriteLine("@attribute yazar string");
            sw.WriteLine("@attribute icerik string");
            sw.WriteLine("@attribute tarih string");
            sw.WriteLine("@attribute class {Siyaset, Ekonomi, Spor, Sağlık, Eğitim, Yaşam}");
            sw.WriteLine("@data");
            sw.Flush();
            sw.Close();
            fs.Close();
        }

        private void btnEtiketle_Click(object sender, EventArgs e)
        {
            DateTime dt = DateTime.Now;
            String tarih = dt.ToString("dd.MM.yyyy");
            //string[] gazeteadi = File.ReadAllLines("C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/gazeteadi.txt", Encoding.GetEncoding("iso-8859-9"));
            //string[] yazaradi = File.ReadAllLines("C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/yazaradi.txt", Encoding.GetEncoding("iso-8859-9"));
            string dosya = @"C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/ModelTrainSet.arff";
            string x = "";
            FileStream fs = new FileStream(dosya, FileMode.Append, FileAccess.Write);
            StreamWriter sw = new StreamWriter(fs);
            if (radioButton1.Checked == true)
            {
                x = "'" + lstMakaleBaslik.SelectedItem.ToString().ToLower() + "'" + "," + "'" + txtGazete.Text.ToLower() + "'" + "," + "'" + txtYazar.Text.ToLower() + "'" + "," + "'" + txtMakaleIcerik.Text.ToLower() + "'" + "," + "'" + tarih.ToLower() + "'" + "," + radioButton1.Text;
                sw.WriteLine(x);
            }

            if (radioButton2.Checked == true)
            {
                x = "'" + lstMakaleBaslik.SelectedItem.ToString().ToLower() + "'" + "," + "'" + txtGazete.Text.ToLower() + "'" + "," + "'" + txtYazar.Text.ToLower() + "'" + "," + "'" + txtMakaleIcerik.Text.ToLower() + "'" + "," + "'" + tarih.ToLower() + "'" + "," + radioButton2.Text;
                sw.WriteLine(x);
            }
            if (radioButton3.Checked == true)
            {
                x = "'" + lstMakaleBaslik.SelectedItem.ToString().ToLower() + "'" + "," + "'" + txtGazete.Text.ToLower() + "'" + "," + "'" + txtYazar.Text.ToLower() + "'" + "," + "'" + txtMakaleIcerik.Text.ToLower() + "'" + "," + "'" + tarih.ToLower() + "'" + "," + radioButton3.Text;
                sw.WriteLine(x);
            }
            if (radioButton4.Checked == true)
            {
                x = "'" + lstMakaleBaslik.SelectedItem.ToString().ToLower() + "'" + "," + "'" + txtGazete.Text.ToLower() + "'" + "," + "'" + txtYazar.Text.ToLower() + "'" + "," + "'" + txtMakaleIcerik.Text.ToLower() + "'" + "," + "'" + tarih.ToLower() + "'" + "," + radioButton4.Text;
                sw.WriteLine(x);
            }
            if (radioButton5.Checked == true)
            {
                x = "'" + lstMakaleBaslik.SelectedItem.ToString().ToLower() + "'" + "," + "'" + txtGazete.Text.ToLower() + "'" + "," + "'" + txtYazar.Text.ToLower() + "'" + "," + "'" + txtMakaleIcerik.Text.ToLower() + "'" + "," + "'" + tarih.ToLower() + "'" + "," + radioButton5.Text;
                sw.WriteLine(x);
            }
            if (radioButton6.Checked == true)
            {
                x = "'" + lstMakaleBaslik.SelectedItem.ToString().ToLower() + "'" + "," + "'" + txtGazete.Text.ToLower() + "'" + "," + "'" + txtYazar.Text.ToLower() + "'" + "," + "'" + txtMakaleIcerik.Text.ToLower() + "'" + "," + "'" + tarih.ToLower() + "'" + "," + radioButton6.Text;
                sw.WriteLine(x);
            }
            
            sw.Flush();
            sw.Close();
            fs.Close();
            MessageBox.Show("Etiketleme Başarılı", "Bilgilendirme", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
    }
}
