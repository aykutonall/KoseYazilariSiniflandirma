import java.io.*;
import java.nio.CharBuffer;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.core.*;

import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public final class WekaClassify {

    //Cross Validation ile eğitim seti testi.
    public void kategoriTestEt() throws Exception {

        BufferedReader denemeReader = new BufferedReader(new FileReader("ModelTrainSet.arff"));
        Instances deneme = new Instances(denemeReader);
        denemeReader.close();

        int sonIndex = deneme.numAttributes() - 1;
        deneme.setClassIndex(sonIndex);

        ArrayList gazeteAttr = new ArrayList();
        ArrayList yazarAttr = new ArrayList();
        ArrayList icerikAttr = new ArrayList();

        for (int i=0; i<deneme.numInstances(); i++)
        {
            gazeteAttr.add(deneme.instance(i).stringValue(0));
            yazarAttr.add(deneme.instance(i).stringValue(1));
            icerikAttr.add(deneme.instance(i).stringValue(2));
        }

        //Filtre (String to Word Vector)
        StringToWordVector filtre = new StringToWordVector();
        filtre.setInputFormat(deneme);

        deneme = Filter.useFilter(deneme, filtre);

        NaiveBayes bayes = new NaiveBayes();
        bayes.buildClassifier(deneme);

        //Cross-Validation
        Evaluation eval = new Evaluation(deneme);
        eval.crossValidateModel(bayes, deneme, 10, new Random(1));

        System.out.println(eval.toSummaryString("\nResults\n=====\n", false));
        System.out.println(eval.toMatrixString("\nConfusion Matrix\n=====\n"));

        for (int i=0; i<deneme.numInstances(); i++)
        {
            //Sınıflandırmadan önceki verilerin etiket değerleri
            double indeks = deneme.instance(i).classValue();
            String gercekSınıfAdı = deneme.attribute(0).value((int) indeks);
            //Weka'da bayes ile sınıflandırma yapıldıktan sonraki etiket değerleri
            double index = bayes.classifyInstance(deneme.instance(i));
            String wekaSınıfAdı = deneme.attribute(0).value((int) index);
            //System.out.println("Sınıflandırmadan Önce: " + gercekSınıfAdı + " ==> " + wekaSınıfAdı);
        }
    }

    //Train modeli kullanılarak günlük köşe yazıları test edildi.
    public void modelTest() throws Exception {
        günlükMakaleCek();

        System.out.println("Köşe yazıları kategorisine göre test ediliyor... \n");

        BufferedReader reader = new BufferedReader(
                new FileReader("ModelTrainSet.arff"));
        Instances train = new Instances(reader);
        reader.close();

        //Test datası okundu.
        BufferedReader testreader = new BufferedReader(
                new FileReader("koseYazilariTest.arff"));
        Instances test = new Instances(testreader);
        testreader.close();

        BufferedReader read = new BufferedReader(
                new FileReader("rLink.txt"));
        ArrayList link = new ArrayList();
        String currentLine;
        while ((currentLine = read.readLine()) != null){
            link.add(currentLine);
        }


        // setting class attribute for test data
        int lastIndex = train.numAttributes() - 1;
        test.setClassIndex(lastIndex);
        // setting class attribute
        train.setClassIndex(lastIndex);

        ArrayList baslikAttr = new ArrayList();
        ArrayList gazeteAttr = new ArrayList();
        ArrayList yazarAttr = new ArrayList();
        ArrayList icerikAttr = new ArrayList();
        ArrayList tarihAttr = new ArrayList();

        for (int i=0; i<test.numInstances(); i++)
        {
            baslikAttr.add(test.instance(i).stringValue(0));
            gazeteAttr.add(test.instance(i).stringValue(1));
            yazarAttr.add(test.instance(i).stringValue(2));
            icerikAttr.add(test.instance(i).stringValue(3));
            tarihAttr.add(test.instance(i).stringValue(4));
        }

        StringToWordVector stwv = new StringToWordVector();
        stwv.setInputFormat(train);


        NaiveBayes bayes = new NaiveBayes();

        // Filtre uygulanıyor
        train = Filter.useFilter(train, stwv);
        test = Filter.useFilter(test, stwv);

        bayes.buildClassifier(train);

        //Connection
        String url = "jdbc:mysql://localhost:3306/koseyazilari?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "root";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);


        for(int i = 0; i < test.numInstances(); i++) {
            double index = bayes.classifyInstance(test.instance(i));
            String className = train.attribute(0).value((int)index);
            System.out.println("Sınıflandırma Sonucu: " + className);

            CallableStatement cs = conn.prepareCall("{call spMakaleIlıskı}");
            cs.executeQuery();

            CallableStatement cs1 = conn.prepareCall("{call spMakaleKaydet(?, ?, ?, ?, ?, ?, ?, @kategori_id, @yazar_id, @gazete_id, @makale_id)}");
            cs1.setString(1,className);
            cs1.setString(2, (String) yazarAttr.get(i));
            cs1.setString(3, (String) gazeteAttr.get(i));
            cs1.setString(4, (String) baslikAttr.get(i));
            cs1.setString(5, (String) icerikAttr.get(i));
            cs1.setString(6, (String) tarihAttr.get(i));
            cs1.setString(7, (String) link.get(i));
            cs1.execute();
        }
        System.out.println("Test işlemi tamamlandı ve sonuçlar veritabanına başarıyla kaydedildi...");

    }

    //Günlük güncel köşe yazılarının çekilmesi.
    public void günlükMakaleCek() throws Exception {
        System.out.println("Günlük köşe yazıları çekiliyor..");
        guncelVeriCek cek = new guncelVeriCek();
        cek.Milliyet("http://www.milliyet.com.tr/yazarlar/");
        cek.Hurriyet("http://www.hurriyet.com.tr/yazarlar/");
        cek.Sabah("https://www.sabah.com.tr/yazarlar");
        cek.MilliGazete("http://www.milligazete.com.tr/yazarlar");
        cek.Sozcu("http://www.sozcu.com.tr/kategori/yazarlar/");
        System.out.println("Günlük köşe yazıları çekilip test için arff formatına dönüştürüldü.");
    }
}