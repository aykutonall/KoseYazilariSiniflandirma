using NHibernate;
using NHibernate.Cfg;
using NHibernate.Mapping.ByCode;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WekaHaber.Models;

namespace WekaHaber
{
    public static class Database
    {
        private static ISessionFactory _sessionFactory;
        private const string SessionKey = "WekaHaber.Database.SessionKey";

        public static ISession Session
        {
            get { return (ISession)HttpContext.Current.Items[SessionKey]; }
        }
        public static void Configure() //makes configuration. Config and Session Factory objects, add mappings //APP LEVEL
        {

            var config = new Configuration();
            config.Configure();

            //add mappings

            var mapper = new ModelMapper();
            mapper.AddMapping<GazeteMap>();
            mapper.AddMapping<YazarMap>();
            mapper.AddMapping<KategoriMap>();
            mapper.AddMapping<MakaleMap>();

            config.AddMapping(mapper.CompileMappingForAllExplicitlyAddedEntities());

            //
            _sessionFactory = config.BuildSessionFactory();


        }

        public static void OpenSession() //invoked per request for opening connection //REQEST LEVEL
        {
            HttpContext.Current.Items[SessionKey] = _sessionFactory.OpenSession();
        }

        public static void CloseSession()//invoked per request for closing connection //REQUEST LEVEL
        {
            var session = HttpContext.Current.Items[SessionKey] as ISession;
            if (session != null)
            {
                session.Close();
            }
            HttpContext.Current.Items.Remove(SessionKey);
        }
    }
}