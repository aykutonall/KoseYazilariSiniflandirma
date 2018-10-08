using NHibernate.Mapping.ByCode;
using NHibernate.Mapping.ByCode.Conformist;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WekaHaber.Models
{
    public class Yazar
    {
        public virtual int Id { get; set; }
        public virtual string Isim { get; set; }
        public virtual string resimLink { get; set; }
    }

    public class YazarMap : ClassMapping<Yazar>
    {
        public YazarMap()
        {
            Table("yazarlar");
            Id(x => x.Id, x => x.Generator(Generators.Identity));
            Property(x => x.Isim, x => x.NotNullable(true));
            Property(x => x.resimLink, x => x.NotNullable(true));
        }
    }
}