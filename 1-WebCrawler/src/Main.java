import java.io.IOException;

/**
 * Created by Onal on 22.10.2017.
 */
public class Main {
    public static void main(String args[]) throws IOException {

        Crawler crawler = new Crawler();

        crawler.MilliyetMakale("http://www.milliyet.com.tr/yazarlar/serpil-cevikcan/?PAGE=", 10); //Siyaset
        crawler.HurriyetMakale1("http://www.hurriyet.com.tr/yazarlar/ali-ece/?p=", 10); //Spor
        crawler.HurriyetMakale("http://www.hurriyet.com.tr/yazarlar/nuran-cakmakci/?p=", 10); //Eğitim
        crawler.SozcuMakale("http://www.sozcu.com.tr/kategori/yazarlar/aysegul-guven"); //Sağlık
        crawler.MilliGazeteMakale("http://www.milligazete.com.tr/yazar/mustafa-kaya/", 10); //Siyaset
        crawler.SabahMakale("https://www.sabah.com.tr/yazarlar/kerem-alkin/arsiv?getall=true&page=", 10); //EkonomiFinans
        crawler.SabahMakale("https://www.sabah.com.tr/yazarlar/gursoy/arsiv?getall=true&page=", 10); //Eğitim
        crawler.SabahMakale("https://www.sabah.com.tr/yazarlar/tuzemen/arsiv?getall=true&page=", 10); //Spor
        crawler.HurriyetMakale("http://www.hurriyet.com.tr/yazarlar/osman-muftuoglu/?p=", 10); //Sağlık
        crawler.MilliyetMakale("http://www.milliyet.com.tr/yazarlar/cagdas-ertuna/?PAGE=", 10); // Yaşam

        //Bi ekonomi birde yaşam ekleyelim.
    }
}

