//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Proje.DBModel
{
    using System;
    using System.Collections.Generic;
    
    public partial class BakiyeBilgi
    {
        public decimal BakiyeBilgi1 { get; set; }
        public Nullable<int> CoinMiktar { get; set; }
        public Nullable<int> ParaID { get; set; }
        public Nullable<int> KullaniciID { get; set; }
        public Nullable<int> YöneticiID { get; set; }
    
        public virtual KullanıcıKayıt KullanıcıKayıt { get; set; }
        public virtual ParaTürleri ParaTürleri { get; set; }
        public virtual YöneticiKayıt YöneticiKayıt { get; set; }
        public virtual BakiyeBilgi BakiyeBilgi11 { get; set; }
        public virtual BakiyeBilgi BakiyeBilgi2 { get; set; }
        public virtual BakiyeBilgi BakiyeBilgi12 { get; set; }
        public virtual BakiyeBilgi BakiyeBilgi3 { get; set; }
        public virtual BakiyeBilgi BakiyeBilgi13 { get; set; }
        public virtual BakiyeBilgi BakiyeBilgi4 { get; set; }
        public virtual YöneticiKayıt YöneticiKayıt1 { get; set; }
    }
}
