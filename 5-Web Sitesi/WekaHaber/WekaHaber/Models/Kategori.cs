using NHibernate.Mapping.ByCode;
using NHibernate.Mapping.ByCode.Conformist;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WekaHaber.Models
{
    public class Kategori
    {
        public virtual int Id { get; set; }
        public virtual string Isim { get; set; }
    }

    public class KategoriMap : ClassMapping<Kategori>
    {
        public KategoriMap()
        {
            Table("kategoriler");
            Id(x => x.Id, x => x.Generator(Generators.Identity));
            Property(x => x.Isim, x => x.NotNullable(true));
        }
    }
}