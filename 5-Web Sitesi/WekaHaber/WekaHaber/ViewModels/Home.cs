using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WekaHaber.Infrastructure;
using WekaHaber.Models;
using System.Runtime.Serialization;

namespace WekaHaber.ViewModels
{
    public class HomeIndex
    {
        public PagedData<Makale> Makaleler { get; set; }

        public IEnumerable<Makale> k { get; set; }
    }

    public class HomeDetail
    {
        public int? mId { get; set; }
        public string yIsim { get; set; }
        public string gIsim { get; set; }
        public string kIsim { get; set; }
        public string b { get; set; }
        public string i { get; set; }
        public string t { get; set; }

    }

    public class HomeEkonomi
    {
        public PagedData<Makale> Makaleler { get; set; }
    }

    public class HomeEgitim
    {
        public PagedData<Makale> Makaleler { get; set; }
    }

    public class HomeSiyaset
    {
        public PagedData<Makale> Makaleler { get; set; }
    }

    public class HomeYasam
    {
        public PagedData<Makale> Makaleler { get; set; }
    }

    public class HomeSpor
    {
        public PagedData<Makale> Makaleler { get; set; }
    }

    public class HomeSaglik
    {
        public PagedData<Makale> Makaleler { get; set; }
    }
    public class HomeYazarlar
    {
        public PagedData<Yazar> Yazarlar { get; set; }
        public int? Id { get; set; }
        public string yIsim { get; set; }
        public string gIsim { get; set; }
        public string kIsim { get; set; }
        public string b { get; set; }
        public string i { get; set; }
        public string t { get; set; }
    }
}