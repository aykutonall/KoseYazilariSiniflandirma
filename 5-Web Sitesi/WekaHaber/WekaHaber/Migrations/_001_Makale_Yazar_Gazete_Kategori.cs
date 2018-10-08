using FluentMigrator;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WekaHaber.Migrations
{
    [Migration(1)]
    public class _001_Makale_Yazar_Gazete_Kategori : Migration
    {
        public override void Down()
        {
            Delete.Table("Makaleler");
            Delete.Table("Yazarlar");
            Delete.Table("Gazeteler");
            Delete.Table("Kategoriler");
        }

        public override void Up()
        {

        }
    }
}