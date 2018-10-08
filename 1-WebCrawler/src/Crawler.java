import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;

/**
 * Created by Onal on 22.10.2017.
 */
public class Crawler {
    public void MilliyetMakale(String url, int page) throws IOException {
        System.out.println("Milliyetten makale alınıyor..");
        File file = new File("makale.txt");
        File file1 = new File("baslik.txt");
        File file2 = new File("yazaradi.txt");
        File file3 = new File("gazeteadi.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        FileWriter fileWriter1 = new FileWriter(file1, true);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        FileWriter fileWriter2 = new FileWriter(file2, true);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);

        FileWriter fileWriter3 = new FileWriter(file3, true);
        BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);

        for(int i = 1; i<=page; i++)
        {
            Document doc = Jsoup.connect(url + i).get();
            Elements href = doc.select("div > .yYazilar > ul > li > a[href]");
            for (Element link : href) {
                String links = "http://www.milliyet.com.tr" + link.attr("href");
                //System.out.println(links);
                Document document = Jsoup.connect(links).get();
                Elements veri1 = document.select("h1");
                Elements veri2 = document.select("div > #divAdnetKeyword3");
                Elements veri3 = document.select(".yName");

                Elements[][] elements = new Elements[1][3];
                elements[0][0] = veri1;
                elements[0][1] = veri2;
                elements[0][2] = veri3;

                //Elements veriler = (doc.select("p"));
                for (Elements[] veri : elements) {
                    if (Jsoup.parse(String.valueOf(veri[1])).text().equals("") && Jsoup.parse(String.valueOf(veri[0])).text().equals("")) {
                        break;
                    } else {
                        bufferedWriter1.write(Jsoup.parse(String.valueOf(veri[0])).text());
                        bufferedWriter1.newLine();

                        bufferedWriter3.write("Milliyet");
                        bufferedWriter3.newLine();

                        bufferedWriter2.write(Jsoup.parse(String.valueOf(veri[2])).text());
                        bufferedWriter2.newLine();

                        bufferedWriter.write(Jsoup.parse(String.valueOf(veri[1])).text());
                        bufferedWriter.newLine();
                    }
                }
            }
        }

        bufferedWriter.close();
        bufferedWriter1.close();
        bufferedWriter2.close();
        bufferedWriter3.close();
        System.out.println("Milliyetten makale alındı.");
    }

    public void HurriyetMakale(String url, int page) throws IOException {
        System.out.println("Hürriyetten makale alınıyor..");
        File file = new File("makale.txt");
        File file1 = new File("baslik.txt");
        File file2 = new File("yazaradi.txt");
        File file3 = new File("gazeteadi.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        FileWriter fileWriter1 = new FileWriter(file1, true);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        FileWriter fileWriter2 = new FileWriter(file2, true);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);

        FileWriter fileWriter3 = new FileWriter(file3, true);
        BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);

        for (int j = 1; j<=page; j++)
        {
            Document doc = Jsoup.connect(url + j).get();

            for (int i = 1; i <= 8; i++)
            {
                Elements href = doc.select("body > div.container > div:nth-child(4) > div.col-xs-8.col-md-8 > div:nth-child(" + i + ") > h2 > a[href]");
                for (Element l : href)
                {
                    String links = "http://www.hurriyet.com.tr" + l.attr("href");
                    //System.out.println(links);

                    Document document = Jsoup.connect(links).get();
                    Elements veri1 = document.select("h1");
                    Elements veri2 = document.select("p");
                    Elements veri3 = document.select(".name");

                    Elements[][] elements = new Elements[1][3];
                    elements[0][0] = veri1;
                    elements[0][1] = veri2;
                    elements[0][2] = veri3;

                    //Elements veriler = (doc.select("p"));
                    for (Elements[] veri : elements) {
                        if (Jsoup.parse(String.valueOf(veri[1])).text().equals("") && Jsoup.parse(String.valueOf(veri[0])).text().equals("")) {
                            break;
                        } else {
                            bufferedWriter1.write(Jsoup.parse(String.valueOf(veri[0])).text());
                            bufferedWriter1.newLine();

                            bufferedWriter3.write("Hürriyet");
                            bufferedWriter3.newLine();

                            bufferedWriter2.write(Jsoup.parse(String.valueOf(veri[2])).text());
                            bufferedWriter2.newLine();

                            bufferedWriter.write(Jsoup.parse(String.valueOf(veri[1])).text());
                            bufferedWriter.newLine();
                        }
                    }
                }
            }
        }

        bufferedWriter.close();
        bufferedWriter1.close();
        bufferedWriter2.close();
        bufferedWriter3.close();
        System.out.println("Hürriyetten makale alındı.");
    }

    public void HurriyetMakale1(String url, int page) throws IOException {
        System.out.println("Hürriyetten makale alınıyor..");
        File file = new File("makale.txt");
        File file1 = new File("baslik.txt");
        File file2 = new File("yazaradi.txt");
        File file3 = new File("gazeteadi.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        FileWriter fileWriter1 = new FileWriter(file1, true);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        FileWriter fileWriter2 = new FileWriter(file2, true);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);

        FileWriter fileWriter3 = new FileWriter(file3, true);
        BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);

        for (int j = 1; j<=page; j++)
        {
            Document doc = Jsoup.connect(url + j).get();

            for (int i = 1; i <= 8; i++)
            {
                Elements href = doc.select("body > div.container > div:nth-child(4) > div.col-xs-8.col-md-8 > div:nth-child(" + i + ") > h2 > a[href]");
                for (Element l : href)
                {
                    String links = "http://www.hurriyet.com.tr" + l.attr("href");
                    //System.out.println(links);

                    Document document = Jsoup.connect(links).get();
                    Elements veri1 = document.select("h1.article-title");
                    Elements veri2 = document.select("div > div.col-lg-8.col-md-12.author-news-content > div.news-detail > div.news-detail-text > p");
                    Elements veri3 = document.select(".name");
                    Elements veri4 = document.select("h2");

                    Elements[][] elements = new Elements[1][4];
                    elements[0][0] = veri1;
                    elements[0][1] = veri2;
                    elements[0][2] = veri3;
                    elements[0][3] = veri4;

                    //Elements veriler = (doc.select("p"));
                    for (Elements[] veri : elements) {
                        if (Jsoup.parse(String.valueOf(veri[1])).text().equals("") && Jsoup.parse(String.valueOf(veri[0])).text().equals("")) {
                            break;
                        } else {
                            bufferedWriter1.write(Jsoup.parse(String.valueOf(veri[0])).text());
                            bufferedWriter1.newLine();

                            bufferedWriter3.write("Hürriyet");
                            bufferedWriter3.newLine();

                            bufferedWriter.write(Jsoup.parse(String.valueOf(veri[3])).text());
                            bufferedWriter.write(Jsoup.parse(String.valueOf(veri[1])).text());
                            bufferedWriter.newLine();

                            bufferedWriter2.write(Jsoup.parse(String.valueOf(veri[2])).text());
                            bufferedWriter2.newLine();
                        }
                    }
                }
            }
        }
        bufferedWriter.close();
        bufferedWriter1.close();
        bufferedWriter2.close();
        bufferedWriter3.close();
        System.out.println("Hürriyetten makale alındı.");
    }

    public void SozcuMakale(String url) throws  IOException {
        System.out.println("Sözcüden makale alınıyor..");
        File file = new File("makale.txt");
        File file1 = new File("baslik.txt");
        File file2 = new File("yazaradi.txt");
        File file3 = new File("gazeteadi.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        FileWriter fileWriter1 = new FileWriter(file1, true);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        FileWriter fileWriter2 = new FileWriter(file2, true);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);

        FileWriter fileWriter3 = new FileWriter(file3, true);
        BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);

        Document doc = Jsoup.connect(url).get();

        for (int i = 1; i <= 31; i++)
        {
            Elements href = doc.select("body > div.full-container > div.container-wrapper > div.container > div > div.detail-content > div.detail-content-inner > div > div.news-body > ul > li:nth-child(" + i + ") > a[href]");
            for (Element l : href)
            {
                String links = l.attr("href");
                //System.out.println(links);

                Document document = Jsoup.connect(links).get();
                Elements veri1 = document.select("h1");
                Elements veri2 = document.select("p");
                Elements veri3 = document.select(".columnist-info-inner > .columnist-name");

                Elements[][] elements = new Elements[1][3];
                elements[0][0] = veri1;
                elements[0][1] = veri2;
                elements[0][2] = veri3;

                //Elements veriler = (doc.select("p"));
                for (Elements[] veri : elements) {
                    if (Jsoup.parse(String.valueOf(veri[1])).text().equals("") && Jsoup.parse(String.valueOf(veri[0])).text().equals("")) {
                        break;
                    } else {
                        bufferedWriter1.write(Jsoup.parse(String.valueOf(veri[0])).text());
                        bufferedWriter1.newLine();

                        bufferedWriter3.write("Sözcü");
                        bufferedWriter3.newLine();

                        bufferedWriter.write(Jsoup.parse(String.valueOf(veri[1])).text());
                        bufferedWriter.newLine();

                        bufferedWriter2.write(Jsoup.parse(String.valueOf(veri[2])).text());
                        bufferedWriter2.newLine();
                    }
                }
            }
        }
        bufferedWriter.close();
        bufferedWriter1.close();
        bufferedWriter2.close();
        bufferedWriter3.close();
        System.out.println("Sözcüden makale alındı.");
    }

    public void MilliGazeteMakale(String url, int page) throws  IOException {
        System.out.println("MilliGazeteden makale alınıyor..");
        File file = new File("makale.txt");
        File file1 = new File("baslik.txt");
        File file2 = new File("yazaradi.txt");
        File file3 = new File("gazeteadi.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        FileWriter fileWriter1 = new FileWriter(file1, true);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        FileWriter fileWriter2 = new FileWriter(file2, true);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);

        FileWriter fileWriter3 = new FileWriter(file3, true);
        BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);

        for (int j=1; j<=page; j++)
        {
            Document doc = Jsoup.connect(url + j).get();

            for (int i = 1; i <= 10; i++)
            {
                Elements href = doc.select("div > div.conbox.col.col-sm-12 > div > section > article:nth-child(" + i + ") > a[href]");
                for (Element l : href)
                {
                    String links = "http://www.milligazete.com.tr" + l.attr("href");
                    //System.out.println(links);

                    Document document = Jsoup.connect(links).get();
                    Elements veri1 = document.select("h1");
                    Elements veri2 = document.select("#main-text > p");
                    Elements veri3 = document.select("div > .us > a > h2");

                    Elements[][] elements = new Elements[1][3];
                    elements[0][0] = veri1;
                    elements[0][1] = veri2;
                    elements[0][2] = veri3;

                    //Elements veriler = (doc.select("p"));
                    for (Elements[] veri : elements) {
                        if (Jsoup.parse(String.valueOf(veri[1])).text().equals("") && Jsoup.parse(String.valueOf(veri[0])).text().equals("")) {
                            break;
                        } else {
                            bufferedWriter1.write(Jsoup.parse(String.valueOf(veri[0])).text());
                            bufferedWriter1.newLine();

                            bufferedWriter3.write("Milli Gazete");
                            bufferedWriter3.newLine();

                            bufferedWriter.write(Jsoup.parse(String.valueOf(veri[1])).text());
                            bufferedWriter.newLine();

                            bufferedWriter2.write(Jsoup.parse(String.valueOf(veri[2])).text());
                            bufferedWriter2.newLine();
                        }
                    }
                }
            }
        }

        bufferedWriter.close();
        bufferedWriter1.close();
        bufferedWriter2.close();
        bufferedWriter3.close();
        System.out.println("MillliGazeteden makale alındı..");
    }

    public void SabahMakale(String url, int page) throws IOException {
        System.out.println("Sabahtan makale alınıyor..");
        File file = new File("makale.txt");
        File file1 = new File("baslik.txt");
        File file2 = new File("yazaradi.txt");
        File file3 = new File("gazeteadi.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        FileWriter fileWriter1 = new FileWriter(file1, true);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        FileWriter fileWriter2 = new FileWriter(file2, true);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);

        FileWriter fileWriter3 = new FileWriter(file3, true);
        BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);

        for (int j=1; j<=page; j++)
        {
            Document doc = Jsoup.connect(url + j).get();

            for (int i = 1; i <= 20; i++)
            {
                Elements href = doc.select("body > section > div > div.row.section.frame > div.col-md-8.col-sm-12.column-left > div > div:nth-child(3) > div > div:nth-child(" + i + ") > figure > figcaption > a[href]");
                for (Element l : href)
                {
                    String links = "http://www.sabah.com.tr" + l.attr("href");
                    //System.out.println(links);

                    Document document = Jsoup.connect(links).get();
                    Elements veri1 = document.select("h1");
                    Elements veri2 = document.select("p");
                    Elements veri3 = document.select(".postTitle");

                    Elements[][] elements = new Elements[1][3];
                    elements[0][0] = veri1;
                    elements[0][1] = veri2;
                    elements[0][2] = veri3;

                    //Elements veriler = (doc.select("p"));
                    for (Elements[] veri : elements) {
                        if (Jsoup.parse(String.valueOf(veri[1])).text().equals("") && Jsoup.parse(String.valueOf(veri[0])).text().equals("")) {
                            break;
                        } else {
                            bufferedWriter1.write(Jsoup.parse(String.valueOf(veri[0])).text());
                            bufferedWriter1.newLine();

                            bufferedWriter3.write("Sabah");
                            bufferedWriter3.newLine();

                            bufferedWriter.write(Jsoup.parse(String.valueOf(veri[1])).text());
                            bufferedWriter.newLine();

                            bufferedWriter2.write(Jsoup.parse(String.valueOf(veri[2])).text());
                            bufferedWriter2.newLine();
                        }
                    }
                }
            }
        }

        bufferedWriter.close();
        bufferedWriter1.close();
        bufferedWriter2.close();
        bufferedWriter3.close();
        System.out.println("Sabahtan makale alındı.");
    }
}