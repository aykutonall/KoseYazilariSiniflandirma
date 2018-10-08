using NHibernate.Criterion;
using NHibernate.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WekaHaber.Infrastructure;
using WekaHaber.Models;
using WekaHaber.ViewModels;
using Newtonsoft.Json;
using System.Collections;

namespace WekaHaber.Controllers
{
    public class HomeController : Controller
    {

        private const int HomePerPage = 5;
        private const int PerPage = 6;
        // GET: Home
        public ActionResult Index(int page = 1)
        {

            int totalPostCount = Database.Session.Query<Makale>().Count();

            var currentPostPage = Database.Session.Query<Makale>()
            .OrderByDescending(c => c.Tarih)
            .Skip((page - 1) * HomePerPage)
            .Take(HomePerPage)
            .ToList();

            return View(new HomeIndex
            {
                Makaleler = new PagedData<Makale>(currentPostPage, totalPostCount, page, HomePerPage)
            });
        }

        public ActionResult GetChartData()
        {
            int categoryEco = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Ekonomi").Count();
            int categoryEdu = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Eğitim").Count();
            int categoryPol = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Siyaset").Count();
            int categoryLife = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Yaşam").Count();
            int categorySport = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Spor").Count();
            int categoryHealth = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Sağlık").Count();

            var data = new List<Chart>()
            {
                new Chart(){Name="Ekonomi", Count=categoryEco},
                new Chart(){Name="Eğitim", Count=categoryEdu},
                new Chart(){Name="Siyaset", Count=categoryPol},
                new Chart(){Name="Yaşam", Count=categoryLife},
                new Chart(){Name="Spor", Count=categorySport},
                new Chart(){Name="Sağlık", Count=categoryHealth}
            };

            var dataforchart = data.Select(x => new { name = x.Name, y = x.Count });

            return Json(dataforchart, JsonRequestBehavior.AllowGet);
        }

        public ActionResult Detail(int id)
        {
            var makale = Database.Session.Load<Makale>(id);

            return View("Detail", new HomeDetail
            {
                mId = makale.Id,
                yIsim = makale.YazarId.Isim,
                gIsim = makale.GazeteId.Isim,
                kIsim = makale.KategoriId.Isim,
                b = makale.Baslik,
                i = makale.Icerik,
                t = makale.Tarih
            });
        }

        public ActionResult Kategoriler()
        {
            return View();
        }

        public ActionResult Ekonomi(int page = 1)
        {
            int totalPostCount = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Ekonomi").Count();
            var currentPostPage = Database.Session.Query<Makale>()
                .Where(x => x.KategoriId.Isim == "Ekonomi")
                .OrderByDescending(x => x.Tarih)
                .Skip((page - 1) * HomePerPage)
                .Take(HomePerPage)
                .ToList();



            return View(new HomeEkonomi
            {
                Makaleler = new PagedData<Makale>(currentPostPage, totalPostCount, page, HomePerPage)
            });
        }
        public ActionResult Egitim(int page = 1)
        {
            int totalPostCount = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Eğitim").Count();
            var currentPostPage = Database.Session.Query<Makale>()
                .Where(x => x.KategoriId.Isim == "Eğitim")
                .OrderByDescending(x => x.Tarih)
                .Skip((page - 1) * HomePerPage)
                .Take(HomePerPage)
                .ToList();



            return View(new HomeEgitim
            {
                Makaleler = new PagedData<Makale>(currentPostPage, totalPostCount, page, HomePerPage)
            });
        }
        public ActionResult Siyaset(int page = 1)
        {
            int totalPostCount = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Siyaset").Count();
            var currentPostPage = Database.Session.Query<Makale>()
                .Where(x => x.KategoriId.Isim == "Siyaset")
                .OrderByDescending(x => x.Tarih)
                .Skip((page - 1) * HomePerPage)
                .Take(HomePerPage)
                .ToList();



            return View(new HomeSiyaset
            {
                Makaleler = new PagedData<Makale>(currentPostPage, totalPostCount, page, HomePerPage)
            });
        }
        public ActionResult Yasam(int page = 1)
        {
            int totalPostCount = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Yaşam").Count();
            var currentPostPage = Database.Session.Query<Makale>()
                .Where(x => x.KategoriId.Isim == "Yaşam")
                .OrderByDescending(x => x.Tarih)
                .Skip((page - 1) * HomePerPage)
                .Take(HomePerPage)
                .ToList();



            return View(new HomeYasam
            {
                Makaleler = new PagedData<Makale>(currentPostPage, totalPostCount, page, HomePerPage)
            });
        }
        public ActionResult Spor(int page = 1)
        {
            int totalPostCount = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Spor").Count();
            var currentPostPage = Database.Session.Query<Makale>()
                .Where(x => x.KategoriId.Isim == "Spor")
                .OrderByDescending(x => x.Tarih)
                .Skip((page - 1) * HomePerPage)
                .Take(HomePerPage)
                .ToList();



            return View(new HomeSpor
            {
                Makaleler = new PagedData<Makale>(currentPostPage, totalPostCount, page, HomePerPage)
            });
        }
        public ActionResult Saglik(int page = 1)
        {
            int totalPostCount = Database.Session.Query<Makale>().Where(x => x.KategoriId.Isim == "Sağlık").Count();
            var currentPostPage = Database.Session.Query<Makale>()
                .Where(x => x.KategoriId.Isim == "Sağlık")
                .OrderByDescending(x => x.Tarih)
                .Skip((page - 1) * HomePerPage)
                .Take(HomePerPage)
                .ToList();



            return View(new HomeSaglik
            {
                Makaleler = new PagedData<Makale>(currentPostPage, totalPostCount, page, HomePerPage)
            });
        }

        public ActionResult Yazarlar(int page = 1)
        {
            int total = Database.Session.Query<Yazar>().Count();

            var current = Database.Session.Query<Yazar>()
            .OrderBy(c => c.Id)
            .Skip((page - 1) * PerPage)
            .Take(PerPage)
            .ToList();

            return View(new HomeYazarlar
            {
                Yazarlar = new PagedData<Yazar>(current, total, page, PerPage)
            });
        }

        public ActionResult YazarDetay(int id)
        {
            var makale = Database.Session.Load<Makale>(id);

            return View("YazarDetay", new HomeYazarlar
            {
                Id = makale.Id,
                yIsim = makale.YazarId.Isim,
                gIsim = makale.GazeteId.Isim,
                kIsim = makale.KategoriId.Isim,
                b = makale.Baslik,
                i = makale.Icerik,
                t = makale.Tarih
            });

        }

        public ActionResult Iletisim()
        {
            return View();
        }
    }
}