using Proje.DBModel;
using Proje.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Proje.Controllers
{
    public class AccountController : Controller
    {
        Blockchain objUserDBEntities = new Blockchain();
        // GET: Account
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult Register()
        {
            UserModel objUserModel = new UserModel();
            return View(objUserModel);
        }

        [HttpPost]
        public ActionResult Register(UserModel objUserModel)
        {
            if (ModelState.IsValid)
            {
                if (!objUserDBEntities.KullanıcıKayıt.Any(m => m.Eposta == objUserModel.email))
                {

                    KullanıcıKayıt objUser = new DBModel.KullanıcıKayıt();
                    objUser.Eposta = objUserModel.email;
                    objUser.KullaniciAd = objUserModel.name;
                    objUser.KullaniciSoyad = objUserModel.surname;
                    objUser.Sifre = Convert.ToInt32( objUserModel.password);
                    

                    objUserDBEntities.KullanıcıKayıt.Add(objUser);
                    objUserDBEntities.SaveChanges();
                    objUserModel = new UserModel();
                    objUserModel.SuccessMessage = "User is successfully added";
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    ModelState.AddModelError("Error", "Email is already exists!");
                    return View();
                }
            }
            return View();
        }
        public ActionResult Login()
        {
            LoginModel objLoginModel = new LoginModel();
            return View(objLoginModel);
        }

        [HttpPost]
        public ActionResult Login(LoginModel objLoginModel)
        {
            if (ModelState.IsValid)
            {
                if (objUserDBEntities.KullanıcıKayıt.Where(m => m.Eposta == objLoginModel.email && m.Sifre == Convert.ToInt32(objLoginModel.password)).FirstOrDefault() == null)
                {
                    ModelState.AddModelError("Error", "Invalid email and password!");
                    return View();
                }
                else
                {
                    Session["Email"] = objLoginModel.email;
                    return RedirectToAction("Index", "Home");
                }
            }
            return View();
        }

        public ActionResult Logout()
        {
            Session.Abandon();
            return RedirectToAction("Index", "Home");
        }
    }
}