import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class guncelVeriCek {

    public void Milliyet(String url) throws IOException {
        try {
            File file = new File("koseYazilariTest.arff");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("@relation makaleler\n@attribute baslik string\n@attribute gazete string\n@attribute yazar string\n@attribute icerik string\n@attribute tarih string\n@attribute class {Siyaset, Ekonomi, Spor, Sağlık, Eğitim, Yaşam}\n@data\n");

            Date tarih = new Date();
            DateFormat tarihFormatı = new SimpleDateFormat("dd/MM/yyyy");


            File file1 = new File("rLink.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter1 = new FileWriter(file1,false);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

            String b,ic,y;
            Document document = Jsoup.connect(url).get();
            for (int i=2; i<=13; i++)
            {
                Elements href = document.select("#_Middle1 > div:nth-child(7) > div:nth-child(" + i + ") > div.yYazi > a[href]");
                //System.out.println(href);
                for (Element link: href) {
                    String links = "http://www.milliyet.com.tr" + link.attr("href");
                    Document doc = Jsoup.connect(links).get();

                    Elements baslik = doc.select("h1");
                    Elements yazar = doc.select(".yName , li.current , a.yadi");
                    Elements icerik = doc.select("div > #divAdnetKeyword3");
                    Elements resim = doc.select("#_MiddleLeft1 > div:nth-child(3) > div.ydtop > div > a > img , #_Middle1 > div:nth-child(5) > div.ybio > span > img , #_MiddleCenter2 > div:nth-child(5) > div.content > table > tbody > tr:nth-child(1) > td > div > img");

                    //System.out.println(resim.attr("src"));

                    Elements[][] elements = new Elements[1][4];
                    elements[0][0] = baslik;
                    elements[0][1] = yazar;
                    elements[0][2] = icerik;
                    elements[0][3] = resim;

                    for (Elements[] veri : elements) {
                        b = Jsoup.parse(String.valueOf(veri[0])).text().replaceAll("'", "’");
                        y = Jsoup.parse(String.valueOf(veri[1])).text().replaceAll("'", "’");
                        ic = Jsoup.parse(String.valueOf(veri[2])).text().replaceAll("'", "’");

                        if (b.equals("") || y.equals("") || ic.equals("") || ic.length()<300) {
                            break;
                        } else {
                            bufferedWriter.write("'" + b + "'" + ",");
                            bufferedWriter.write("'Milliyet'" + ",");
                            bufferedWriter.write("'" + y + "'" + ",");
                            bufferedWriter.write("'" + ic  + "'" + ",");
                            bufferedWriter.write("'" + tarihFormatı.format(tarih)+ "'" + ", ?");
                            bufferedWriter1.write(veri[3].attr("src"));
                            bufferedWriter1.newLine();
                            bufferedWriter.newLine();
                        }
                    }
                }
            }
            bufferedWriter.close();
            bufferedWriter1.close();
            Milliyets("http://www.milliyet.com.tr/yazarlar/");
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }

    }

    public void Milliyets(String url) throws  IOException {
        try {
            File file = new File("koseYazilariTest.arff");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Date tarih = new Date();
            DateFormat tarihFormatı = new SimpleDateFormat("dd/MM/yyyy");

            File file1 = new File("rLink.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter1 = new FileWriter(file1,true);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

            String b,ic,y;
            Document document = Jsoup.connect(url).get();
            for (int i=2; i<=8; i++) {
                Elements href = document.select("#_Middle1 > div:nth-child(8) > div:nth-child(" + i + ") > div.yYazi > a[href]");
                //System.out.println(href);
                for (Element link: href) {
                    String links = link.attr("href");
                    Document doc = Jsoup.connect(links).get();

                    Elements baslik = doc.select("h3");
                    Elements yazar = doc.select("span.wname , li.current , a.yadi");
                    Elements icerik = doc.select("div.text");
                    Elements resim = doc.select("#_MiddleCenter1 > div:nth-child(4) > div > div > div.text > div.wrtcon > div.writer > div > img");

                    Elements[][] elements = new Elements[1][4];
                    elements[0][0] = baslik;
                    elements[0][1] = yazar;
                    elements[0][2] = icerik;
                    elements[0][3] = resim;

                    for (Elements[] veri : elements) {
                        b = Jsoup.parse(String.valueOf(veri[0])).text().replaceAll("'", "’");
                        y = Jsoup.parse(String.valueOf(veri[1])).text().replaceAll("'", "’");
                        ic = Jsoup.parse(String.valueOf(veri[2])).text().replaceAll("'", "’");

                        if (b.equals("") || y.equals("") || ic.equals("") || ic.length()<300) {
                            break;
                        } else {
                            bufferedWriter.write("'" + b + "'" + ",");
                            bufferedWriter.write("'Milliyet'" + ",");
                            bufferedWriter.write("'" + y + "'" + ",");
                            bufferedWriter.write("'" + ic + "'" + ",");
                            bufferedWriter.write("'" + tarihFormatı.format(tarih) + "'" + ", ?");
                            bufferedWriter1.write(veri[3].attr("src"));
                            bufferedWriter1.newLine();
                            bufferedWriter.newLine();
                        }
                    }
                }
            }
            bufferedWriter1.close();
            bufferedWriter.close();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }

    }

    public void Hurriyet(String url) throws IOException {
        try {
            File file = new File("koseYazilariTest.arff");

            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Date tarih = new Date();
            DateFormat tarihFormatı = new SimpleDateFormat("dd/MM/yyyy");

            File file1 = new File("rLink.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter1 = new FileWriter(file1,true);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

            String b,ic,y;
            Document document = Jsoup.connect(url).get();
            for (int i=2; i<=24; i++)
            {
                Elements href = document.select("body > div.container > div:nth-child(3) > div:nth-child(1) > div.row > div > div > div:nth-child(" + i + ") > a[href]");
                //System.out.println(href);
                for (Element link: href) {
                    String links = "http://www.hurriyet.com.tr" + link.attr("href");
                    Document doc = Jsoup.connect(links).get();

                    Elements baslik = doc.select("h1 , h1.rhd-article-title");
                    Elements yazar = doc.select("body > div.container > div.author-info.mb20 > div > div.name > h2 > a.name , div > section:nth-child(1) > header > section.rhd-article-author-social-bar.cf.hidden-sm-down > div.rhd-author-box-wrapper.cf > div > div.rhd-author-info-wrapper > h6");
                    Elements icerik = doc.select("#all-article-wrapper > div.news-detail-wrapper.serial-news-wrapper > div > div.article-content.news-text , h2.rhd-article-spot , div.rhd-all-article-detail > p");
                    Elements resim = doc.select("body > div.container > div.author-info.mb20 > a > img , body > article > div:nth-child(5) > div > section:nth-child(1) > header > section.rhd-article-author-social-bar.cf.hidden-sm-down > div.rhd-author-box-wrapper.cf > div > div.rhd-author-img-wrapper > img");


                    Elements[][] elements = new Elements[1][4];
                    elements[0][0] = baslik;
                    elements[0][1] = yazar;
                    elements[0][2] = icerik;
                    elements[0][3] = resim;

                    for (Elements[] veri : elements) {
                        b = Jsoup.parse(String.valueOf(veri[0])).text().replaceAll("'", "’");
                        y = Jsoup.parse(String.valueOf(veri[1])).text().replaceAll("'", "’");
                        ic = Jsoup.parse(String.valueOf(veri[2])).text().replaceAll("'", "’");

                        if (b.equals("") || y.equals("") || ic.equals("") || ic.length()<300) {
                            break;
                        } else {
                            bufferedWriter.write("'" + b + "'" + ",");
                            bufferedWriter.write("'Hürriyet'" + ",");
                            bufferedWriter.write("'" + y + "'" + ",");
                            bufferedWriter.write("'" + ic + "'" + ",");
                            bufferedWriter.write("'" + tarihFormatı.format(tarih) + "'" + ", ?");
                            bufferedWriter1.write(veri[3].attr("src"));
                            bufferedWriter1.newLine();
                            bufferedWriter.newLine();
                        }
                    }
                }
            }
            bufferedWriter.close();
            bufferedWriter1.close();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }

    }

    public void Sabah(String url) throws IOException {
        try {
            File file = new File("koseYazilariTest.arff");

            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Date tarih = new Date();
            DateFormat tarihFormatı = new SimpleDateFormat("dd/MM/yyyy");

            File file1 = new File("rLink.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter1 = new FileWriter(file1,true);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

            String b,ic,y;

            Document document = Jsoup.connect(url).get();
            for (int i=1; i<=12; i++) {
                for (int j=3; j<=4; j++) {
                    Elements href = document.select("body > section > div > div > div.col-md-8.col-sm-12.column-left > div > div:nth-child(" + j + ") > div.row.writerReadList > div:nth-child(" + i + ") > figure > figcaption > a[href]");
                    //System.out.println(href);
                    for (Element link: href) {
                        String links = "https://www.sabah.com.tr" + link.attr("href");
                        Document doc = Jsoup.connect(links).get();

                        Elements baslik = doc.select("h1.postCaption");
                        Elements yazar = doc.select(".postTitle");
                        Elements icerik = doc.select("body > section > div > div > div.col-md-8.col-sm-12.column-left > div:nth-child(1) > div:nth-child(3) > div.newsDetailText");
                        Elements resim = doc.select("body > section > div > div > div.col-md-8.col-sm-12.column-left > div > div:nth-child(2) > div > figure > a > img");

                        Elements[][] elements = new Elements[1][4];
                        elements[0][0] = baslik;
                        elements[0][1] = yazar;
                        elements[0][2] = icerik;
                        elements[0][3] = resim;

                        for (Elements[] veri : elements) {
                            b = Jsoup.parse(String.valueOf(veri[0])).text().replaceAll("'", "’");
                            y = Jsoup.parse(String.valueOf(veri[1])).text().replaceAll("'", "’");
                            ic = Jsoup.parse(String.valueOf(veri[2])).text().replaceAll("'", "’");
                            if (b.equals("") || y.equals("") || ic.equals("") || ic.length()<300) {
                                break;
                            } else {
                                bufferedWriter.write("'" + b + "'" + ",");
                                bufferedWriter.write("'Sabah'" + ",");
                                bufferedWriter.write("'" + y + "'" + ",");
                                bufferedWriter.write("'" + ic + "'" + ",");
                                bufferedWriter.write("'" + tarihFormatı.format(tarih)+ "'" + ", ?");
                                bufferedWriter1.write(veri[3].attr("src"));
                                bufferedWriter1.newLine();
                                bufferedWriter.newLine();
                            }
                        }
                    }
                }
            }
            bufferedWriter.close();
            bufferedWriter1.close();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }

    }

    public void MilliGazete(String url) throws IOException {
        try {
            File file = new File("koseYazilariTest.arff");

            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Date tarih = new Date();
            DateFormat tarihFormatı = new SimpleDateFormat("dd/MM/yyyy");

            File file1 = new File("rLink.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter1 = new FileWriter(file1,true);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

            String b,ic,y;

            Document document = Jsoup.connect(url).get();
            for (int i=2; i<=17; i++) {
                Elements href = document.select("body > main > div.base.custom.pt25.pt0-sm.con > div > div > section:nth-child(2) > article:nth-child(" + i + ") > a[href]");
                //System.out.println(href);
                for (Element link: href) {
                    String links = "http://www.milligazete.com.tr" + link.attr("href");
                    Document doc = Jsoup.connect(links).get();

                    Elements baslik = doc.select("h1");
                    Elements yazar = doc.select("body > main > div.base.con.custom.pt30.pt25-sm > div.manbox.row.mt20.mt10-ms > div.conbox.col.col-sm-12 > div > div.post-yazar-top.mb20 > div.lt.row.ns.middle.tc-bottom.mt15.mb30 > div > h2 > a");
                    Elements icerik = doc.select("#main-text > p");
                    Elements resim = doc.select("body > main > div.base.con.custom.pt30.pt25-sm > div.manbox.row.mt20.mt10-ms > div.conbox.col.col-sm-12 > div > div.post-yazar-top.mb20 > div.lt.row.ns.middle.tc-bottom.mt15.mb30 > figure > a > img");

                    Elements[][] elements = new Elements[1][4];
                    elements[0][0] = baslik;
                    elements[0][1] = yazar;
                    elements[0][2] = icerik;
                    elements[0][3] = resim;

                    for (Elements[] veri : elements) {
                        b = Jsoup.parse(String.valueOf(veri[0])).text().replaceAll("'", "’");
                        y = Jsoup.parse(String.valueOf(veri[1])).text().replaceAll("'", "’");
                        ic = Jsoup.parse(String.valueOf(veri[2])).text().replaceAll("'", "’");

                        if (b.equals("") || y.equals("") || ic.equals("") || ic.length()<300) {
                            break;
                        } else {
                            bufferedWriter.write("'" + b + "'" + ",");
                            bufferedWriter.write("'Milli Gazete'" + ",");
                            bufferedWriter.write("'" + y + "'" + ",");
                            bufferedWriter.write("'" + ic + "'" + ",");
                            bufferedWriter.write("'" + tarihFormatı.format(tarih)+ "'" + ", ?");
                            bufferedWriter1.write("https://www.milligazete.com.tr" + veri[3].attr("src"));
                            bufferedWriter1.newLine();
                            bufferedWriter.newLine();
                        }
                    }
                }
            }
            bufferedWriter.close();
            bufferedWriter1.close();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }

    }

    public void Sozcu(String url) throws IOException {
        try {
            File file = new File("koseYazilariTest.arff");

            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Date tarih = new Date();
            DateFormat tarihFormatı = new SimpleDateFormat("dd/MM/yyyy");

            File file1 = new File("rLink.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter1 = new FileWriter(file1,true);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

            String b,ic,y;
            Document document = Jsoup.connect(url).get();
            for (int i=1; i<=20; i++)
            {
                Elements href = document.select("body > div.full-container > div.container-wrapper > div.container > div.container-inner > div > div:nth-child(2) > div:nth-child(" + i + ") > div > a[href]");
                //System.out.println(href);
                for (Element link: href) {
                    String links = link.attr("href");
                    Document doc = Jsoup.connect(links).get();

                    Elements baslik = doc.select("h1");
                    Elements yazar = doc.select(".columnist-info-inner > .columnist-name");
                    Elements icerik = doc.select("div.author-the-content.content-element > p");
                    Elements resim = doc.select("body > div.full-container > div.container-wrapper > div.container > div > div.sidebar > div > div.sidebox._ch.clearfix > div > div > div.columnist-img > img");


                    Elements[][] elements = new Elements[1][4];
                    elements[0][0] = baslik;
                    elements[0][1] = yazar;
                    elements[0][2] = icerik;
                    elements[0][3] = resim;

                    for (Elements[] veri : elements) {
                        b = Jsoup.parse(String.valueOf(veri[0])).text().replaceAll("'", "’");
                        y = Jsoup.parse(String.valueOf(veri[1])).text().replaceAll("'", "’");
                        ic = Jsoup.parse(String.valueOf(veri[2])).text().replaceAll("'", "’");

                        if (b.equals("") || y.equals("") || ic.equals("") || ic.length()<300) {
                            break;
                        } else {
                            bufferedWriter.write("'" + b + "'" + ",");
                            bufferedWriter.write("'Sözcü'" + ",");
                            bufferedWriter.write("'" + y + "'" + ",");
                            bufferedWriter.write("'" + ic + "'" + ",");
                            bufferedWriter.write("'" + tarihFormatı.format(tarih) + "'" + ", ?");
                            bufferedWriter1.write(veri[3].attr("src"));
                            bufferedWriter1.newLine();
                            bufferedWriter.newLine();
                        }
                    }
                }
            }
            bufferedWriter.close();
            bufferedWriter1.close();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }

    }

}

