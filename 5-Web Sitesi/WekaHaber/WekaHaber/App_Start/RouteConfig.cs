using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace WekaHaber
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }
            );
            routes.MapRoute("Detail", "", new { controller = "Home", action = "Detail" });
            routes.MapRoute("Kategoriler", "", new { controller = "Home", action = "Kategoriler" });
            routes.MapRoute("Ekonomi", "", new { controller = "Home", action = "Ekonomi" });
            routes.MapRoute("Egitim", "", new { controller = "Home", action = "Egitim" });
            routes.MapRoute("Siyaset", "", new { controller = "Home", action = "Siyaset" });
            routes.MapRoute("Yasam", "", new { controller = "Home", action = "Yasam" });
            routes.MapRoute("Spor", "", new { controller = "Home", action = "Spor" });
            routes.MapRoute("Saglik", "", new { controller = "Home", action = "Saglik" });
            routes.MapRoute("Yazarlar", "", new {controller="Home", action ="Yazarlar"});
            routes.MapRoute("Iletisim", "", new { controller = "Home", action = "Iletisim" });

        }
    }
}
