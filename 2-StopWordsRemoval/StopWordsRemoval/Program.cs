using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace StopWordsRemoval
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("İşlem başladı...");

            string[] stopWords = File.ReadAllLines("C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/stop_words.txt", Encoding.GetEncoding("iso-8859-9"));
            StreamReader reader = new StreamReader("C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/makale.txt", Encoding.UTF8);
            TextWriter textWriter = new StreamWriter(@"C:/Users/Onal/Desktop/Programlar ve Veriler/Veriler/ModelTrainSetClear.txt");
            string currentLine;

            while ((currentLine = reader.ReadLine()) != null)
            {
                StringBuilder builder = new StringBuilder(currentLine);
                string[] parts = builder.ToString().Split(' ');

                foreach (string word in stopWords)
                {
                    string regex = @"(?i)\s?\b" + word + @"\b\s?";
                    currentLine = Regex.Replace(currentLine, regex, " ");
                }
                currentLine = Regex.Replace(currentLine, "[’']", "\\\'");
                textWriter.WriteLine(currentLine);
            }
            Console.WriteLine("İşlem Başarılı.");
        }
    }
}
