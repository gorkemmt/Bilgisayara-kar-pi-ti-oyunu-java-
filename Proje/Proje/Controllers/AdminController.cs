using Proje.DBModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Proje.Controllers
{
    public class AdminController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Kullanıcı()
        {
            return View();
        }
        public ActionResult KullanıcıGoster(KullanıcıKayıt kullanici)
        {
            return View();
        }

        public ActionResult AlisVeris()
        {
            return View();
        }

        public ActionResult AlisVerisGoruntule(/*Alışveriş kaydı alısveris*/)
        {
            return View();
        }
    }       
        
}