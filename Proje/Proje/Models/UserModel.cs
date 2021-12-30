using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Proje.Models
{
    public class UserModel
    {
        public int userId { get; set; }

        [Required(AllowEmptyStrings = false, ErrorMessage = "Name is required")]
        [Display(Name = "Name: ")]
        public string name { get; set; }

        [Required(AllowEmptyStrings = false, ErrorMessage = "Surname is required")]
        [Display(Name = "Surname: ")]
        public string surname { get; set; }

        [Required(AllowEmptyStrings = false, ErrorMessage = "Email is required")]
        [Display(Name = "Email: ")]
        public string email { get; set; }

        [Required(AllowEmptyStrings = false, ErrorMessage = "Password is required")]
        [Display(Name = "Password: ")]
        [DataType(DataType.Password)]

        public string password { get; set; }

        [Required(AllowEmptyStrings = false, ErrorMessage = "Confirm-Password is required")]
        [DataType(DataType.Password)]
        [Display(Name = "Confirm Password: ")]
        [Compare("password", ErrorMessage = "Password and confirm-password should be same")]

        public string confirmPassword { get; set; }


        [Required(AllowEmptyStrings = false, ErrorMessage = "User role(admin,customer) is required")]
        [Display(Name = "User Role: ")]
        public string userRole { get; set; }

        [Required(AllowEmptyStrings = false, ErrorMessage = "Phone number is required")]
        [Display(Name = "Phone Number: ")]
        public string phoneNumber { get; set; }
        public DateTime createdOn { get; set; }

        public string SuccessMessage { get; set; }
    }
}