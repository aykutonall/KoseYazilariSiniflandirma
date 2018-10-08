using NHibernate.Mapping.ByCode;
using NHibernate.Mapping.ByCode.Conformist;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WekaHaber.Models
{
    public class Makale
    {
        public virtual int Id { get; set; }
        public virtual Gazete GazeteId { get; set; }
        public virtual Yazar YazarId { get; set; }
        public virtual Kategori KategoriId { get; set; }
        public virtual string Baslik { get; set; }
        public virtual string Icerik { get; set; }
        public virtual string Tarih { get; set; }
    }

    public class MakaleMap : ClassMapping<Makale>
    {
        public MakaleMap()
        {
            Table("makaleler");
            Id(x => x.Id, x => x.Generator(Generators.Identity));

            ManyToOne(x => x.GazeteId, x =>
            {
                x.Column("gazete_id");
                x.NotNullable(true);
            });

            ManyToOne(x => x.YazarId, x =>
            {
                x.Column("yazar_id");
                x.NotNullable(true);
            });

            ManyToOne(x => x.KategoriId, x =>
            {
                x.Column("kategori_id");
                x.NotNullable(true);
            });

            Property(x => x.Baslik, x => x.NotNullable(true));
            Property(x => x.Icerik, x => x.NotNullable(true));
            Property(x => x.Tarih, x => x.NotNullable(true));
        }
    }
}